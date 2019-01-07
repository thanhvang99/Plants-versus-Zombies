package Controllers;

import Helper.GUI;
import Services.GameDraw;
import java.awt.Canvas;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public abstract class Mouse implements MouseInputListener,GameDraw {
    private static Mouse currentMouse = null;
    
    public static void setCurrentMouse(Mouse mouse){
        currentMouse = mouse;
    }
    public static Mouse getCurrentMouse(){
        return currentMouse;
    }
    public static void addCurrentMouseTo(GUI gui){
        JFrame frame = gui.getFrame();
        Canvas canvas = gui.getCanvas();
        try {
            frame.addMouseListener(currentMouse);
            canvas.addMouseListener(currentMouse);

            frame.addMouseMotionListener(currentMouse);
            canvas.addMouseMotionListener(currentMouse);
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
    }
    public static void removeCurrentMouseFrom(GUI gui){
        JFrame frame = gui.getFrame();
        Canvas canvas = gui.getCanvas();
        
        try{
            frame.removeMouseListener(currentMouse);
            canvas.removeMouseListener(currentMouse);

            frame.removeMouseMotionListener(currentMouse);
            canvas.removeMouseMotionListener(currentMouse);
            
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
    }
}
