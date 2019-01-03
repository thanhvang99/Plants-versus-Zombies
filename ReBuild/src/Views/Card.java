package Views;

import Services.GameDraw;
import Services.GameLogic;
import Services.ImageFrames;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Card implements GameDraw,GameLogic{
    public static final int DEFAULT_WIDTH_CARD = 110,
                            DEFAULT_HEIGHT_CARD = 100;
    
    private static int currentIndex = 0;
    
    private BufferedImage[] frames;                 // Frames[0] active, Frames[1] inactive
    private int cost;
    private int index;
    private boolean isActive = true;
    
    public Card(BufferedImage[] frames,int cost){
        this.frames = frames;
        this.cost = cost;
        this.index = Card.currentIndex++;
    }

    @Override
    public void render(Graphics g) {
        if( isActive ){
            g.drawImage(frames[0],OptionColumn.START_X_CARD, OptionColumn.START_Y_CARD + DEFAULT_HEIGHT_CARD*index,
                        DEFAULT_WIDTH_CARD,DEFAULT_HEIGHT_CARD,null);
        }else
            g.drawImage(frames[1], OptionColumn.START_X_CARD, OptionColumn.START_Y_CARD + DEFAULT_HEIGHT_CARD*index,
                        DEFAULT_WIDTH_CARD,DEFAULT_HEIGHT_CARD,null);
            
    }

    @Override
    public void tick() {
    }
    
    
    
    
}
