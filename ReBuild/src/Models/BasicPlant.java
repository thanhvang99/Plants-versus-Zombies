package Models;

import java.awt.Graphics;
import java.awt.Rectangle;
import Helper.ID;
import Services.GameInterface;
import Services.PlantInterface;
import Views.GameObject;

public class BasicPlant extends GameObject implements PlantInterface {

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
