package project;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.event.MouseInputListener;

public class MouseManager implements MouseInputListener {
    private Map map;
    private BufferedImage currentImage;
    private boolean isPressed;
    private int xDragged,yDragged;
    private ID identifier;
    
    public MouseManager(Map map){
        this.map = map;
    }
    
    
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
        if( isPressedOnFrame(e.getX(),e.getY(),10,110,GameBackground.DEFAULT_WIDTH_CARD,GameBackground.DEFAULT_HEIGHT_CARD) ){
            isPressed = true;
            currentImage = Stuffs.getActivePeaShooter();
            identifier = ID.BASIC_PLANT;
            
        }
        // For active sunflower
        else if( isPressedOnFrame(e.getX(),e.getY(),10,210,GameBackground.DEFAULT_WIDTH_CARD,GameBackground.DEFAULT_HEIGHT_CARD) ){
            isPressed = true;
            currentImage = Stuffs.getActiveSunflower();
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
        
        if( Map.isInMap(e.getX(), e.getY()) ){
            int x = (int)( (e.getX()-Map.START_X)/(Map.DELTA_X) );
            int y = (int)( (e.getY()-Map.START_Y)/(Map.DELTA_Y) );
            
            // Debug ArrayIndexOutOfBounds
            if( x>8 )   x=8;
        /*   
            if( !map.isExist(x, y) ){
                if( identifier == ID.BASIC_PLANT ){
                    GameObjectManager.getInstance().addObject(new BasicPlant(x,y,ID.BASIC_PLANT));
                }
            }
        */
            // Test for new_map
            
            if( map.getMap()[x][y] == null || map.getMap()[x][y] == ID.BASIC_BULLET){
                if( identifier == ID.BASIC_PLANT ){
                    GameObjectManager.getInstance().addObject(new BasicPlant(x,y,ID.BASIC_PLANT));
                } 
            } 
            
            
            
        }
        
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        xDragged = e.getX();
        yDragged = e.getY();
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
}
