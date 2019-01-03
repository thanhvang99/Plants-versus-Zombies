package Models;

import java.awt.Graphics;
import java.awt.Rectangle;
import Helper.ID;
import Services.PlantInterface;
import Services.GameLogic;

public abstract class BasicPlant extends GameObject implements PlantInterface {
    protected final int HEALTH = 100;
    protected final int DEFAULT_WIDTH = 76,
                        DEFAULT_HEIGHT = 76;
    public BasicPlant(float x,float y){
        super(x,y,ID.PLANT);
    }
    
}
