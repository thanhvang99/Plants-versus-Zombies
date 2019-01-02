package Views;

import Models.GameObject;
import Models.Peashooter;
import Resources.ImageFrames;
import Services.GameInterface;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;

// Option Column to obtain the candicate....

public class OptionColumn implements GameView,GameInterface {
    public static final int DEFAULT_WIDTH_CARD = 110,
                            DEFAULT_HEIGHT_CARD = 100,
                            START_X_CARD = 10,
                            START_Y_CARD = 110;
    private static int currentIndexCard = 0;
    private BufferedImage[] cards;
    
    
    
    public OptionColumn(){
        cards = new BufferedImage[10];
    }
    
    @Override
    public void render(Graphics g) {
        renderAllCard(g);

    }

    @Override
    public void tick() {
    }
    public void addCard(BufferedImage card){
        cards[currentIndexCard] = card;
        currentIndexCard++;
    }
    public void renderAllCard(Graphics g){
        for(int i=0;i<currentIndexCard;i++){
            g.drawImage(cards[i], 100, 100, null);
        }
    }
    public void initialCards(){
        
    }
    
    
}
