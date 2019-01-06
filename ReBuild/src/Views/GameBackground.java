package Views;

import Models.BeetrootCard;
import Models.Score;
import Models.SunflowerCard;
import Models.WalnutCard;
import Models.Money;
import Models.PeashooterCard;
import Models.ListCardComponent;
import Helper.GUI;
import Models.BasicZombie;
import Models.Sun;
import Services.ImageFrames;
import java.awt.Color;
import java.awt.Graphics;

public class GameBackground extends Background {
    private ListCardComponent listCard;
    private Money money;
    private Score score;
    
    public GameBackground(){
        
        listCard = new ListCardComponent(ListCardComponent.START_X,ListCardComponent.START_Y);
        money = new Money(1000);
        score = new Score();
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageFrames.getGameBackground(), 0, 0, GUI.DEFAULT_WIDTH, GUI.DEFAULT_HEIGHT, null);

        listCard.render(g);
        money.render(g);
        score.render(g);
        
//        drawRect(g);
        

          
    }

    @Override
    public void tick() {
        listCard.tick();
        
    }
    
    
    @Override
    public void setUp(){
        setUpCardComponent();
        ListCardComponent.setRelationWithMoney(money);
        Sun.setAssociationWithMoney(money);
        BasicZombie.setRelationWithScore(score);
    }
    
    public void setUpCardComponent(){
        listCard.addNewCard(new PeashooterCard(100));
        listCard.addNewCard(new BeetrootCard(125));
        listCard.addNewCard(new SunflowerCard(50));
        listCard.addNewCard(new WalnutCard(25));
        
    }   
    
    public ListCardComponent getCardComponent(){ return listCard; }
    public Money getMoney(){ return money; }
    
    public void drawRect(Graphics g){
        // This is for testingg.drawLine(360, 50, 360, Window.getInstance().getHeight());
           
        
          g.setColor(Color.BLACK);
          g.drawLine(360, 50, 360, GUI.getInstance().getHeight());
          g.drawLine(465, 50, 465, GUI.getInstance().getHeight());
          g.drawLine(570, 50, 570, GUI.getInstance().getHeight());
          g.drawLine(675, 50, 675, GUI.getInstance().getHeight());
          g.drawLine(780, 50, 780, GUI.getInstance().getHeight());
          g.drawLine(885, 50, 885, GUI.getInstance().getHeight());
          g.drawLine(990, 50, 990, GUI.getInstance().getHeight());
          g.drawLine(1095, 50, 1095, GUI.getInstance().getHeight());
          g.drawLine(1200, 50, 1200, GUI.getInstance().getHeight());
  //        g.drawLine(1305, 50, 1305, Window.getInstance().getHeight());
 
          g.drawLine(360, 40, GUI.getInstance().getWidth(), 40);
          g.drawLine(360, 180, GUI.getInstance().getWidth(), 180);
          g.drawLine(360, 320, GUI.getInstance().getWidth(), 320);
          g.drawLine(360, 460, GUI.getInstance().getWidth(), 460);
          g.drawLine(360, 600, GUI.getInstance().getWidth(), 600);
          g.setColor(Color.RED);
    }
    
}
