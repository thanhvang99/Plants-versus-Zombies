package project;

import java.awt.Graphics;

public class GameState extends State {
    
    private Animation plantAmt;
    
    public GameState(){
        plantAmt = new Animation(Stuffs.getPlant(),500);
    }
    
    @Override
    public void tick(){
        plantAmt.tick();
    
    }
    @Override
    public void render(Graphics g){
        g.drawImage(Stuffs.getGameBackground(), 0, 0, Window.getInstance().getWidth(),Window.getInstance().getHeight(),null);
        g.drawImage(plantAmt.getCurrentFrame(), 360, 180,80,80, null);
    }
    
    
}
