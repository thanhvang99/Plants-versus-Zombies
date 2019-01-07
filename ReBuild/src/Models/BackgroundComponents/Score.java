package Models.BackgroundComponents;

import Services.GameDraw;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score implements GameDraw {
    private int number;
    public Score(){
        number = 0;
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 40));
        g.drawString(Integer.toString(number), 50 - ((int)Math.log10(number)-1)*10, 40);
        g.setColor(Color.RED);
    }

    public void set(int number){ this.number = number; }
    public int get(){ return number; }
}
