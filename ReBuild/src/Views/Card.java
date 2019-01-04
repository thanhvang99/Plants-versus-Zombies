package Views;

import Services.GameDraw;
import java.awt.image.BufferedImage;

public abstract class Card implements GameDraw{
    public static final int DEFAULT_WIDTH_CARD = 110,
                            DEFAULT_HEIGHT_CARD = 100;
    
    
    private static int currentIndex = 0;
    
    
    private int cost;
    private int index;
    
    public Card(int cost){
        this.cost = cost;
        this.index = Card.currentIndex++;
    }
    
    
    public abstract void createObject(int x,int y);
    public int getIndex(){ return index; }
    public boolean isActive(){
        return true;
    }
    public abstract BufferedImage getImageCard();
    public int getCost(){ return cost; }
    

}
