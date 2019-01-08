package Models.GameObject.Cards;

import Models.BackgroundComponents.Playground;
import Models.GameObjects.GameObject;
import Models.GameObjects.GameObjectManager;
import Services.GameDraw;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Card implements GameDraw{
    public static final int DEFAULT_WIDTH_CARD = 110,
                            DEFAULT_HEIGHT_CARD = 100;

    public static final int ON = 0,
                            OFF = 1;    
    private int active = ON;
    
    private static int currentIndex = 0;
    
    
    
    private int cost;
    private int index;
    
    public Card(int cost){
        this.cost = cost;
        this.index = Card.currentIndex++;
    }
    
    
    public abstract void createObject(int xCordinate,int yCordinate);
    
    public void act(int xPixel,int yPixel,Playground playground){
        int xCordinate = Playground.convert_Pixel_to_CordinateX(xPixel);
        int yCordinate = Playground.convert_Pixel_to_CordinateY(yPixel);
        
        if( !playground.isExistCreature(xCordinate, yCordinate) ){
            createObject(xCordinate,yCordinate);
        }else{
            ArrayList<GameObject> listPlant = GameObjectManager.getInstance().getList(GameObject.PLANT);
            for( GameObject object : listPlant ){
                object.checkMouseClick(xPixel,yPixel);
            }
        }
    }
    
    public int getIndex(){ return index; }
    public abstract BufferedImage getImageCard();
    public int getCost(){ return cost; }

    public void updateActive(int money){
        if( cost > money ){
            active = OFF;
        }else
            active = ON;
    }
    public int getActive(){ return active; }
}
