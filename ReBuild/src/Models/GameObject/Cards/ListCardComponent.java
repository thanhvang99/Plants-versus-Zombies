package Models.GameObject.Cards;

import Models.BackgroundComponents.Money;
import Services.GameDraw;
import Services.GameLogic;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class ListCardComponent implements GameLogic,GameDraw {
    
    public static final int  START_X = 10,
                             START_Y = 80;
    private ArrayList<Card> cards;
    private Rectangle rect;
    private static Money money;
    
    public ListCardComponent(int x,int y){
        rect = new Rectangle();
        cards = new ArrayList<Card>();
    }
    
    public void addNewCard(Card card){
        cards.add(card);
        rect.setBounds(START_X, START_Y, Card.DEFAULT_WIDTH_CARD, Card.DEFAULT_HEIGHT_CARD * cards.size());
    }
    public Rectangle getRect(){ return rect; }

    @Override
    public void tick() {
        for( Card eachCard : cards ){
            eachCard.updateActive(money.get());
        }
    }

    @Override
    public void render(Graphics g) {
        for(Card eachCard : cards){
            eachCard.render(g);
        }
    }
    
    public boolean isInside(int xPixel,int yPixel){
        return rect.contains(xPixel,yPixel) ? true : false;
        
    }
    public int calculateIndexCard(int xPixel,int yPixel){
        
        int index = (yPixel - START_Y)/Card.DEFAULT_HEIGHT_CARD;
        
        return index;
    }
    public ArrayList<Card> getList(){ return cards; }
    public static void setRelationWithMoney(Money moneyInput){
        money = moneyInput;
    }
}
