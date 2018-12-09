package project;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Window window;
    private Thread thread;
    private boolean isRunning;
    private BufferStrategy bs;
    private Graphics g;
    private static Game game = null;
    private KeyManager keyManager;
    
    // State
    private State gameState,menuState;
    private Game(){
        window = Window.getInstance();
        keyManager = new KeyManager();                  // Using ESC to exit program
        gameState = new GameState();
        menuState = new MenuState();
    }
    public void init(){
        window.getFrame().addKeyListener(keyManager);
        State.setState(gameState);
        Stuffs.init();
        
    }
    
    public void tick(){
        State.getState().tick();
    }
    public void render(){
        bs = window.getCanvas().getBufferStrategy();
        if( bs == null ){
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        
        // Clear Screen
        g.clearRect(0, 0, window.getWidth(), window.getHeight());
        
        // Start Draw HERE
        
        State.getState().render(g);
        
        // End Draw HERE
        bs.show();
        g.dispose();
    }
    
    
    @Override
    public void run(){
        init();
        int fps = 60;
        int tick = 0;
        long timer = 0;
        double delta = 0;
        double timePerTick = 1_000_000_000/fps;
        long lastTime;
        long now = System.nanoTime();
        
        while(isRunning){
            lastTime = System.nanoTime();
            delta += (lastTime - now)/timePerTick;
            timer += (lastTime - now);
            now = lastTime;
            if( delta>=1 ){
                tick++;
                delta = 0;
                tick();
                render();
            }
            if( timer>=1_000_000_000 ){
                System.out.println("Fps:"+tick);
                tick = 0;
                timer = 0;
            }
        }
        stop();
        
    }
    
    public synchronized void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        isRunning = false;
        try{
            thread.join();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public static Game getInstance(){
        if( game == null ){
            game = new Game();
            return game;
        }else
            return game;
    }
    
}
