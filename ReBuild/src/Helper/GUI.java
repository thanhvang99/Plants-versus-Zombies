package Helper;

import Command.Command;
import Views.GameOverState;
import Views.GameState;
import Views.MenuState;
import Views.State;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class GUI extends Application {
    private static GUI gui = null;
    private JFrame frame ;
    private Canvas canvas;
    private int width,height;
    public static final int DEFAULT_WIDTH = 1375,
                            DEFAULT_HEIGHT = 765;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    
    private State menuState,gameState,gameOverState;
            
    private GUI(int width,int height){
        this.width = width;
        this.height = height;
    }
    public static GUI getInstance(){
        if( gui == null )
            gui = new GUI(GUI.DEFAULT_WIDTH,GUI.DEFAULT_HEIGHT);
        return gui;
    
    }
    public Graphics getGraphics(){ return graphics; }
    
    @Override
    public void tick() {
        State.getCurrentState().tick();
        if( Command.getCurrentCommand() != null ){
            Command.getCurrentCommand().excute();
        }
    }
    @Override
    public void render() {
        bufferStrategy = canvas.getBufferStrategy();
        if( bufferStrategy == null ){
            canvas.createBufferStrategy(3);
            return;
        }
        
        graphics = bufferStrategy.getDrawGraphics();
        
        // Clear Screen
        graphics.clearRect(0, 0, width, height);
        
        // Start Draw HERE
        State.getCurrentState().render(graphics);
        
        // End Draw HERE
        bufferStrategy.show();
        graphics.dispose();
        
    }
    
    public void setUp(){
        
        // Set up frame and canvas
        frame = new JFrame("Plants versus Zombies");
        canvas = new Canvas();
        
        
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.pack();
        
        // Set up STATE
        menuState = new MenuState();
        gameState = new GameState();
        gameOverState = new GameOverState();
        
        // Set up currentState
        State.setState(menuState);
        
    }
    
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
    public JFrame getFrame(){ return frame; }
    public Canvas getCanvas(){ return canvas; }
    public State getGameState(){ return gameState; }
    public State getMenuState(){ return menuState; }
    public State getGameOverState(){ return gameOverState; }
    public BufferStrategy getBuffer(){ return bufferStrategy; }
    
    
    
    
}
