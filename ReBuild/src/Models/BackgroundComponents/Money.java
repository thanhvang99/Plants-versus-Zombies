package Models.BackgroundComponents;

import Services.GameDraw;
import Services.GameLogic;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Money implements GameDraw {
    public static final int START_X = 10,
                            START_Y = 710;
    
    private int currentMoney;
    private boolean increasable = false;
    private boolean decreasable = false;
    private Rectangle NumberRect;
    
    
    public Money(int number){
        this.currentMoney = number;
        NumberRect = new Rectangle(START_X,START_Y,100,20);
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 30));
//        g.drawRect(NumberRect.x, NumberRect.y, NumberRect.width, NumberRect.height);
        g.drawString(Integer.toString(currentMoney), NumberRect.x+NumberRect.width/5, NumberRect.y+NumberRect.height);
    }
    public int get(){ return currentMoney; }
    public void set(int number){ currentMoney = number; }
    
    
    
}
