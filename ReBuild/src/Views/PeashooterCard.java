package Views;

import Models.GameObjectManager;
import Models.Peashooter;
import Services.ImageFrames;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PeashooterCard extends Card{
    private BufferedImage[] frames = ImageFrames.getPeashooterCandicate();
    

    public PeashooterCard(int cost){
        super(cost);
    }
    
    
    @Override
    public void createObject(int x,int y) {
        GameObjectManager.getInstance().addObject(new Peashooter(x,y));
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(frames[getActive()], ListCardComponent.START_X, ListCardComponent.START_Y + DEFAULT_HEIGHT_CARD * getIndex(),
                DEFAULT_WIDTH_CARD, DEFAULT_HEIGHT_CARD, null);
    }

    @Override
    public BufferedImage getImageCard() {
        return frames[0];
    }

    

    
}
