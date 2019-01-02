package GameObject;

import GameInterface.PlantController;
import PvZ.ID;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicPlant extends GameObject implements PlantController {

    public BasicPlant(float x,float y){
        super(x,y,ID.PLANT);
    }
        
    @Override
    public void render(Graphics g) {
    }

    @Override
    public void act() {
    }

    @Override
    public void isDied() {
    }

    @Override
    public Rectangle getRect() {
        return null;
    }
    
}
