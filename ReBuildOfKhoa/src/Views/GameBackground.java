package Views;

import Helper.GUI;
import Services.ImageFrames;
import java.awt.Graphics;

public class GameBackground extends Background {
    private ColumnComponent column;
    
    
    public GameBackground(){
        
        column = new ColumnComponent();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageFrames.getGameBackground(), 0, 0, GUI.DEFAULT_WIDTH,GUI.DEFAULT_HEIGHT,null);
        
        // This is for testingg.drawLine(360, 50, 360, Window.getInstance().getHeight());
//          g.drawLine(465, 50, 465, GUI.getInstance().getHeight());
//          g.drawLine(570, 50, 570, GUI.getInstance().getHeight());
//          g.drawLine(675, 50, 675, GUI.getInstance().getHeight());
//          g.drawLine(780, 50, 780, GUI.getInstance().getHeight());
//          g.drawLine(885, 50, 885, GUI.getInstance().getHeight());
//          g.drawLine(990, 50, 990, GUI.getInstance().getHeight());
//          g.drawLine(1095, 50, 1095, GUI.getInstance().getHeight());
//          g.drawLine(1200, 50, 1200, GUI.getInstance().getHeight());
//  //        g.drawLine(1305, 50, 1305, Window.getInstance().getHeight());
// 
//          g.drawLine(360, 40, GUI.getInstance().getWidth(), 40);
//          g.drawLine(360, 180, GUI.getInstance().getWidth(), 180);
//          g.drawLine(360, 320, GUI.getInstance().getWidth(), 320);
//          g.drawLine(360, 460, GUI.getInstance().getWidth(), 460);
//          g.drawLine(360, 600, GUI.getInstance().getWidth(), 600);
          
          column.render(g);
          
          
    }

    @Override
    public void tick() {
        // Nothing
    }
    
    @Override
    public void setUp(){
        setUpColumnComponent();
    }
    
    public void setUpColumnComponent(){
        column.setUpCardsComponent();;
    }   
    
    public ColumnComponent getColumnComponent(){ return column; }
    
}
