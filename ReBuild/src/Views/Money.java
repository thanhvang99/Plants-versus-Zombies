package Views;

import Services.GameDraw;
import Services.GameLogic;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Money implements GameLogic,GameDraw {
    public static final int START_X = 10,
                            START_Y = 710;
    
    private int currentMoney,decreasedMoney,increasedMoney;
    private boolean increasable = false;
    private boolean decreasable = false;
    private Rectangle NumberRect;
    
    
    public Money(int number){
        this.currentMoney = number;
        NumberRect = new Rectangle(START_X,START_Y,100,20);
    }
    
    @Override
    public void tick() {
        if( increasable  ){
            currentMoney += increasedMoney;
            increasable = false;
        }
        if( decreasable ){
            currentMoney -= decreasedMoney;
            decreasable = false;
        }
            
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 30));
        g.drawRect(NumberRect.x, NumberRect.y, NumberRect.width, NumberRect.height);
        g.drawString(Integer.toString(currentMoney), NumberRect.x+NumberRect.width/5, NumberRect.y+NumberRect.height);
    }
    public void setIncreasable(int cost) {
        increasable = true;
        increasedMoney = cost;
    }
    public void setDecreasable(int cost) {
        decreasable = true;
        decreasedMoney = cost;
    }
    public int getMoney(){ return currentMoney; }
    
    
    
}
