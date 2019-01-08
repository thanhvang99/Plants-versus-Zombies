package Models.GameObject.Cards;

import Models.GameObject.Cards.Card;
import Models.GameObject.Cards.ListCardComponent;
import Models.GameObjects.Beetroot;
import Models.GameObject.Cards.Card;
import Models.GameObjects.Beetroot;
import Models.GameObjects.GameObjectManager;
import Models.GameObjects.GameObjectManager;
import Models.GameObject.Cards.ListCardComponent;
import Services.ImageFrames;
import static Models.GameObject.Cards.Card.DEFAULT_HEIGHT_CARD;
import static Models.GameObject.Cards.Card.DEFAULT_WIDTH_CARD;
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
        g.drawImage(frames[getActive()], ListCardComponent.START_X, ListCardComponent.START_Y + DEFAULT_HEIGHT_CARD * getIndex(),
                DEFAULT_WIDTH_CARD, DEFAULT_HEIGHT_CARD, null);
    }

    @Override
    public BufferedImage getImageCard() {
        return frames[0];
    }
    
    
    
}
