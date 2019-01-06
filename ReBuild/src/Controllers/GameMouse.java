package Controllers;

import Models.GameObject;
import Models.GameObjectManager;
import Services.MouseInterface;
import Views.Card;
import Views.GameBackground;
import Views.Playground;
import Views.ListCardComponent;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameMouse implements MouseInterface {
    private GameBackground background;
    private Playground playground;
    private Card tempCard = null;
    private BufferedImage tempImage = null;
    private boolean isBuySuccess = false;
    private boolean isCollectSuccess = false;
    
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
        checkBuySuccess();
        checkCollectSun(x,y);
        
            
    }
    public void clickAndReleaseCard(int x,int y){
        ListCardComponent cardsComponent = background.getCardComponent();
        if( cardsComponent.isInside(x, y) ){
            tempCard = cardsComponent.getList().get(cardsComponent.calculateIndexCard(x, y));
            if( tempCard.getActive() == Card.ON ){
                tempImage = tempCard.getImageCard();
            }else
                tempCard = null;
            
        }else if( playground.isInSide(x, y) && tempCard != null ){
            int xPosition = Playground.convert_Pixel_to_CordinateX(x);
            int yPostion = Playground.convert_Pixel_to_CordinateY(y);
            
            
            if( !playground.isExistCreature(xPosition, yPostion) ){
                tempCard.createObject(xPosition, yPostion);
                isBuySuccess = true;
            }else{
                tempCard = null;
            }
            
            tempImage = null;
        }else{
            tempImage = null;
            tempCard = null;
        }
    }
    
    public void checkBuySuccess(){
        if( isBuySuccess ){
            background.getMoney().setDecreasable(tempCard.getCost());
            isBuySuccess = false;
            tempCard = null;
        }
    }
    public void checkCollectSun(int xPixel,int yPixel){
        ArrayList<GameObject> list = GameObjectManager.getInstance().getList(GameObject.STUFF_WITH_MOUSE);
        for(GameObject object : list){
            object.checkMouseClick(xPixel, yPixel);
        }
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
