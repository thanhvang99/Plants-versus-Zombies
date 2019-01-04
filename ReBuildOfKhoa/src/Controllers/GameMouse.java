package Controllers;

import Services.MouseInterface;
import Views.Card;
import Views.GameBackground;
import Views.Playground;
import Views.SetCardsComponent;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GameMouse implements MouseInterface {
    private GameBackground background;
    private Playground playground;
    private Card tempCard = null;
    private BufferedImage tempImage = null;
    
    public GameMouse(GameBackground background,Playground playground){
        this.background = background;
        this.playground = playground;
    }
    
    private int xCurrent,
                yCurrent;
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
        clickAndReleaseCard(x,y);
        
            
    }
    public void clickAndReleaseCard(int x,int y){
        SetCardsComponent cardsComponent = background.getColumnComponent().getCardsComponent();
        if( cardsComponent.isInside(x, y) ){
            tempCard = cardsComponent.getList().get(cardsComponent.calculateIndexCard(x, y));
            tempImage = tempCard.getImageCard();
            
        }else if( playground.isInSide(x, y) ){
            int xPosition = playground.calculateXPosition(x);
            int yPostion = playground.calculateYPosition(y);
            
            if( !playground.isExistCreature(xPosition, yPostion) )
                tempCard.createObject(xPosition, yPostion);
            
            tempImage = null;
        }else
            tempImage = null;
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(tempImage, xCurrent, yCurrent, null);
    }

    @Override
    public void tick() {
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        xCurrent = e.getX();
        yCurrent = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    

    
}
