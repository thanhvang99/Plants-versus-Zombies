package Views;

import Models.GameObject.Cards.BeetrootCard;
import Models.BackgroundComponents.Score;
import Models.GameObject.Cards.SunflowerCard;
import Models.GameObject.Cards.WalnutCard;
import Models.BackgroundComponents.Money;
import Models.GameObject.Cards.PeashooterCard;
import Models.GameObject.Cards.ListCardComponent;
import Helper.GUI;
import Models.GameObject.Cards.ShovelCard;
import Models.GameObjects.BasicZombie;
import Models.GameObjects.GameObjectManager;
import Models.GameObjects.LawnMower;
import Models.GameObjects.Sun;
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
        setUpLawnMower();
        
        ListCardComponent.setRelationWithMoney(money);
        Sun.setRelationWithMoney(money);
        BasicZombie.setRelationWithScore(score);
        GameOverState.setRelationWithScore(score);
        
    }
    
    public void setUpCardComponent(){
        listCard.addNewCard(new PeashooterCard(100));
        listCard.addNewCard(new BeetrootCard(125));
        listCard.addNewCard(new SunflowerCard(50));
        listCard.addNewCard(new WalnutCard(25));
        listCard.addNewCard(new ShovelCard());
        
    }   
    public static void setUpLawnMower(){
        GameObjectManager.getInstance().addObject(new LawnMower(-1,0));
        GameObjectManager.getInstance().addObject(new LawnMower(-1,1));
        GameObjectManager.getInstance().addObject(new LawnMower(-1,2));
        GameObjectManager.getInstance().addObject(new LawnMower(-1,3));
        GameObjectManager.getInstance().addObject(new LawnMower(-1,4));
    }
    
    public ListCardComponent getCardComponent(){ return listCard; }
    public Money getMoney(){ return money; }
    public Score getScore(){ return score; }
    
    public void drawRect(Graphics g){
        // This is for testingg.drawLine(150, 50, 150, Window.getInstance().getHeight());
           
        
          g.setColor(Color.BLACK);
          
          g.drawLine(150, 50, 150, GUI.getInstance().getHeight());
          g.drawLine(255, 50, 255, GUI.getInstance().getHeight());
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
 
          g.drawLine(150, 40, GUI.getInstance().getWidth(), 40);
          g.drawLine(150, 180, GUI.getInstance().getWidth(), 180);
          g.drawLine(150, 320, GUI.getInstance().getWidth(), 320);
          g.drawLine(150, 460, GUI.getInstance().getWidth(), 460);
          g.drawLine(150, 600, GUI.getInstance().getWidth(), 600);
          g.setColor(Color.RED);
    }
    
}
