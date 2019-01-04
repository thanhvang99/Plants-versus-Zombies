package Views;

import Services.GameDraw;
import Services.GameLogic;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Money implements GameLogic,GameDraw {
    public static final int START_X = 30,
                            START_Y = 735;
    private int currentMoney,decreasedMoney,increasedMoney;
    private boolean increasable = false;
    private boolean decreasable = false;
    
    public Money(int number){
        this.currentMoney = number;
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
        g.drawString( Integer.toString(currentMoney), START_X, START_Y);
    }
    public void setIncreasable(boolean bool, int cost) {
        increasable = bool;
        increasedMoney = cost;
    }
    public void setDecreasable(boolean bool, int cost) {
        decreasable = bool;
        decreasedMoney = cost;
    }
    public int getMoney(){ return currentMoney; }
    
    
    
}
