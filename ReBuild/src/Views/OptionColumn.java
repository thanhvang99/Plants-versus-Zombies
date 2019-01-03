package Views;

import Services.GameDraw;
import java.awt.Graphics;
import Services.GameLogic;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// Option Column to obtain the candicate....

public class OptionColumn implements GameDraw,GameLogic {
    public static final int START_X_CARD = 10,
                            START_Y_CARD = 80;
    
    private ArrayList<Card> cards;
    
    
    
    public OptionColumn(){
        cards = new ArrayList<Card>();
    }
    
    public void addNewCard(Card card){
        cards.add(card);
    }
    
    @Override
    public void render(Graphics g) {
        
        for(Card eachCard : cards){
            eachCard.render(g);
        }
        

    }

    @Override
    public void tick() {
    }
    
    
}
