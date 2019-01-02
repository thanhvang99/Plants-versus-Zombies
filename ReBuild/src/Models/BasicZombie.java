package Models;

import java.awt.Graphics;
import java.awt.Rectangle;
import Helper.ID;
import Services.ZombieInterface;

public abstract class BasicZombie extends GameObject implements ZombieInterface {
    
    public BasicZombie(float x,float y){
        super(x,y,ID.ZOMBIE);
    }

}
