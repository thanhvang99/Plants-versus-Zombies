package project;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.event.MouseInputListener;

public class MouseManager implements MouseInputListener {
    private BufferedImage currentImage;
    private boolean isPressed;
    private int xDragged,yDragged;
    
    
    
    public boolean isPressedOnFrame(int x,int y, int xOrigin,int yOrigin,int width,int height) {
        if( (x > xOrigin && x < xOrigin+width) && (y > yOrigin && y < yOrigin+height) ) {
            return true;
        } else {
            return false;
        }

    }
    
    public void render(Graphics g) {
        if( isPressed ) {
            g.drawImage(currentImage, xDragged-50, yDragged-50, null);      // -50 means mouse at center
        }
    }
   

    @Override
    public void mousePressed(MouseEvent e) {
        
        // For active pea shooter
        if( isPressedOnFrame(e.getX(),e.getY(),10,110, GameBackground.getWidth(), GameBackground.getHeight()) ) {
            isPressed = true;
            currentImage = Stuffs.getActivePeaShooter();
//            System.out.println(isPressed);
        }
        // For active sunflower
        else if( isPressedOnFrame(e.getX(),e.getY(),10,210,GameBackground.getWidth(),GameBackground.getHeight()) ) {
            isPressed = true;
            currentImage = Stuffs.getActiveSunflower();
//            System.out.println(isPressed);
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        xDragged = e.getX();
        yDragged = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
}
