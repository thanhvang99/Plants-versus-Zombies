package GameObject;

import GameInterface.ZombieController;
import PvZ.ID;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicZombie extends GameObject implements ZombieController {
    
    public BasicZombie(float x,float y){
        super(x,y,ID.ZOMBIE);
    }

    @Override
    public void render(Graphics g) {
        
    }

    @Override
    public void move() {
    }

    @Override
    public void isDied() {
    }

    @Override
    public void meetPlant() {
    }

    @Override
    public Rectangle getRect() {
        return null;
    }
}
