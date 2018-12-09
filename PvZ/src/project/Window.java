package project;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window  {
    private static final int DEFAULT_WIDTH = 1375,
                             DEFAULT_HEIGHT = 765;
    
    private JFrame frame;
    private Canvas canvas;
    private int height,width;
    private static Window window = null;
    
    private Window(int width,int height){
        this.width = width;
        this.height = height;
        
        frame = new JFrame("Testing!");
        canvas = new Canvas();
        
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();
        
    }
    
    public static Window getInstance(){
        if( window == null ){
            window = new Window(DEFAULT_WIDTH,DEFAULT_HEIGHT);
            return window;
        }else
            return window;
    }
    
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
    public JFrame getFrame(){ return frame; }
    public Canvas getCanvas(){ return canvas; }
}
