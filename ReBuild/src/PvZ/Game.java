package PvZ;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Window window;
    private static Game game = null;
    private Thread thread;
    private boolean isRunning = false;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    
    
    private Game(){
        window = Window.getInstance();
    }
    public static Game getInstance(){
        if( game == null )
            game = new Game();
        return game;
        
    }   
    public void initialize(){
        
    
    }
    public void tick(){
    
    }
    public void render(){
        bufferStrategy = window.getCanvas().getBufferStrategy();
        if( bufferStrategy == null ){
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        
        // Clear Screen
        graphics.clearRect(0, 0, window.getWidth(), window.getHeight());
        
        // Start draw HERE
        
        graphics.fillRect(0, 0, window.getWidth(), window.getHeight());
        
        // End draw HERE
        bufferStrategy.show();
        graphics.dispose();
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }
    public synchronized void stop(){
        try{
            thread.join();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        int fps = 60;           // Frames per second
        double timePerTick = 1_000_000_000/fps;
        double delta = 0;
        long startTime = System.nanoTime();
        long endTime;
        
        initialize();
        while( isRunning ){
            endTime = System.nanoTime();
            delta += (endTime - startTime)/timePerTick;
            startTime = endTime;
            if( delta >= 1 ){
                delta = 0;
                tick();
                render();
            }
            
        }
        stop();
    }
    
}
