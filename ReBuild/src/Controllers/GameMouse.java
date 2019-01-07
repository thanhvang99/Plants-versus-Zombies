package Controllers;

import Models.GameObjects.GameObject;
import Models.GameObjects.GameObjectManager;
import Models.GameObject.Cards.Card;
import Views.GameBackground;
import Models.BackgroundComponents.Playground;
import Models.GameObject.Cards.ListCardComponent;
import Models.BackgroundComponents.Money;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameMouse extends Mouse {
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
        
        ClickMouse(x,y);
        checkBuySuccess();
        checkCollectSun(x,y);
        
            
    }
    public void ClickMouse(int x,int y){
        ListCardComponent cardsComponent = background.getCardComponent();
        if( cardsComponent.isInside(x, y) ){
            tempCard = cardsComponent.getList().get(cardsComponent.calculateIndexCard(x, y));
            if( tempCard.getActive() == Card.ON ){
                tempImage = tempCard.getImageCard();
            }else
                tempCard = null;
            
        }else if( playground.isInSide(x, y) && tempCard != null ){
            
            tempCard.act(x, y,playground);
            tempImage = null;
        }else{
            tempImage = null;
            tempCard = null;
        }
    }
    
    public void checkBuySuccess(){
        if( isBuySuccess ){
            Money money = background.getMoney();
            money.set(money.get() - tempCard.getCost());        // money = money - costOfCard;
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
    public void mouseMoved(MouseEvent e) {
        xCurrent = e.getX();
        yCurrent = e.getY();
    }
    public int getCurrentX(){ return xCurrent; }
    public int getCurrnetY(){ return yCurrent; }

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
