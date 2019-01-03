package Views;

import Models.GameObject;
import Models.Peashooter;
import Resources.ImageFrames;
import Resources.ImageLoader;
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
        
        cards[0] = ImageFrames.getPeashooterCandicateOn() ;
        cards[1] = ImageLoader.load("/plants/peashooter/candicate_on.png");
        
        System.out.println(cards[0]);
        System.out.println(cards[1]);
    }
    
    @Override
    public void render(Graphics g) {
//        renderAllCard(g);
        g.drawImage(cards[0], 100, 100, null);
        g.drawImage(cards[1], 200, 200, null);
//         System.out.println(cards[0]);

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
