package Views;

import Controllers.GameOverMouse;
import Controllers.Mouse;
import Helper.GUI;
import Models.BackgroundComponents.Score;
import Services.Animation;
import Services.ImageFrames;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameOverState extends State {
    private Animation animationBackground;
    private static Score score;
    private GameOverMouse mouse;
    private static Rectangle yesRect,noRect;
    
    
    
    public GameOverState(){
        animationBackground = new Animation(150,ImageFrames.getGameOverBackground());
        yesRect = new Rectangle(460,660,140,50);
        noRect = new Rectangle(680,660,140,50);
        mouse = new GameOverMouse(score);
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawImage(animationBackground.getCurrentFrame(), 0, 0, GUI.DEFAULT_WIDTH,GUI.DEFAULT_HEIGHT,null);
        g.setFont(new Font(Font.MONOSPACED,Font.BOLD + Font.ITALIC,100));
        g.drawString("Score:"+ Integer.toString(score.get()),430,250);
        
        g.drawRect(yesRect.x, yesRect.y, yesRect.width, yesRect.height);
        g.drawRect(noRect.x, noRect.y, noRect.width, noRect.height);
    }

    @Override
    public void tick() {
        animationBackground.tick();
        
    }
    public static void setRelationWithScore(Score scoreInput){
        score = scoreInput;
    }
    
    public static boolean isYes(float xPixel,float yPixel){
        return yesRect.contains(xPixel,yPixel) ? true : false;
    }
    public static boolean isNo(float xPixel,float yPixel){
        return noRect.contains(xPixel,yPixel) ? true : false;
    }

    @Override
    public Mouse getMouse() { return mouse; }    
}
