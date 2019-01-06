package Models.GameObject.Cards;

import Services.GameDraw;
import Services.GameLogic;
import java.awt.image.BufferedImage;

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
    
    
    public abstract void createObject(int x,int y);
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
