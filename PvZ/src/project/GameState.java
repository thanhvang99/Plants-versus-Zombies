package project;

import java.awt.Graphics;

public class GameState extends State {
    
    private Animation plantAmt;
    private MouseManager mouseManager;
    
    public GameState(){
        mouseManager = new MouseManager();
        
        Window.getInstance().getCanvas().addMouseListener(mouseManager);
        Window.getInstance().getFrame().addMouseListener(mouseManager);
        
    }
    
    @Override
    public void tick(){
    
    }
    @Override
    public void render(Graphics g){
        g.drawImage(Stuffs.getGameBackground(), 0, 0, Window.getInstance().getWidth(),Window.getInstance().getHeight(),null);
        
        /*
        
        deltaX = 105
        deltaY = 120
        
        g.drawLine(360, 50, 360, Window.getInstance().getHeight());
        g.drawLine(465, 50, 465, Window.getInstance().getHeight());
        g.drawLine(570, 50, 570, Window.getInstance().getHeight());
        g.drawLine(675, 50, 675, Window.getInstance().getHeight());
        g.drawLine(780, 50, 780, Window.getInstance().getHeight());
        g.drawLine(885, 50, 885, Window.getInstance().getHeight());
        g.drawLine(990, 50, 990, Window.getInstance().getHeight());
        g.drawLine(1095, 50, 1095, Window.getInstance().getHeight());
        g.drawLine(1200, 50, 1200, Window.getInstance().getHeight());
//        g.drawLine(1305, 50, 1305, Window.getInstance().getHeight());
        
        g.drawLine(360, 40, Window.getInstance().getWidth(), 40);
        g.drawLine(360, 180, Window.getInstance().getWidth(), 180);
        g.drawLine(360, 320, Window.getInstance().getWidth(), 320);
        g.drawLine(360, 460, Window.getInstance().getWidth(), 460);
        g.drawLine(360, 600, Window.getInstance().getWidth(), 600);

        */
        
    }
    
    
}
