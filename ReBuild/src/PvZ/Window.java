package PvZ;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
    private JFrame frame;
    private Canvas canvas;
    private static Window window = null;
    private int width;
    private int height;
    
    
    
    public static final int DEFAULT_WIDTH = 1375,
                            DEFAULT_HEIGHT = 765;
    
    
    // Singleton patterm
    private Window(){
        setUp(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
    public static Window getInstance(){
        if( window == null )
            window = new Window();
        return window;
    }
    
    public JFrame getFrame(){ return frame; }
    public Canvas getCanvas(){ return canvas; }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
        
    
    public void setUp(int width,int height){
        this.width = width;
        this.height = height;
        
        frame = new JFrame("Plants versus Zombies");
        canvas = new Canvas();
        
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.add(canvas);
        frame.setVisible(true);
        frame.pack();
    }
    
}
