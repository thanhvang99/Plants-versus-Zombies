package Views;

import Services.GameDraw;
import java.awt.Graphics;
import Services.GameLogic;

// Option Column to obtain the candicate....

public class ColumnComponent implements GameDraw,GameLogic {
    private SetCardsComponent setCardsComponent;
    
    
    
    public ColumnComponent(){
        setCardsComponent = new SetCardsComponent(SetCardsComponent.START_X,SetCardsComponent.START_Y);
        
        
    }
       
    public void setUpCardsComponent(){
        setCardsComponent.addNewCard(new PeashooterCard(100));
        setCardsComponent.addNewCard(new BeetrootCard(200));
    }
    
    
    @Override
    public void render(Graphics g) {
        
        setCardsComponent.render(g);
        

    }

    @Override
    public void tick() {
    }
    public SetCardsComponent getCardsComponent(){ return setCardsComponent; }
    
    
}
