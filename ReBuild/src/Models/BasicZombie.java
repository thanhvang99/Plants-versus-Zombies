package Models;

import java.awt.Graphics;
import java.awt.Rectangle;
import Helper.ID;
import Services.ZombieInterface;
import Views.GameObject;

public class BasicZombie extends GameObject implements ZombieInterface {
    
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
