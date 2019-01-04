package Views;

import Models.Beetroot;
import Models.GameObjectManager;
import Services.ImageFrames;
import static Views.Card.DEFAULT_HEIGHT_CARD;
import static Views.Card.DEFAULT_WIDTH_CARD;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BeetrootCard extends Card{
    private BufferedImage[] frames = ImageFrames.getBeetrootCandicate();
    

    public BeetrootCard(int cost){
        super(cost);
    }
    
    
    @Override
    public void createObject(int x,int y) {
        GameObjectManager.getInstance().addObject(new Beetroot(x,y));
    }
    
    @Override
    public void render(Graphics g) {
        if( isActive() ){
            g.drawImage(frames[0], ListCardComponent.START_X, ListCardComponent.START_Y + DEFAULT_HEIGHT_CARD*getIndex(),
                        DEFAULT_WIDTH_CARD,DEFAULT_HEIGHT_CARD,null);
        }else
            g.drawImage(frames[1], ListCardComponent.START_X, ListCardComponent.START_Y + DEFAULT_HEIGHT_CARD*getIndex(),
                        DEFAULT_WIDTH_CARD,DEFAULT_HEIGHT_CARD,null);
    }

    @Override
    public BufferedImage getImageCard() {
        return frames[0];
    }
    
}
