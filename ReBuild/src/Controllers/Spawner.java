package Controllers;

import Models.GameObjectManager;
import Models.NormalZombie;
import Services.GameLogic;
import Services.Timer;
import java.util.Random;

public class Spawner implements GameLogic {
    private Random r = new Random();
    private Timer timer;
    
    public Spawner(){
        timer = new Timer(3000);
    
    }
    
    
    @Override
    public void tick() {
        if( timer.isTimeOut() ){
            int xRandom = r.nextInt(1) + 10;
            int yRandom = r.nextInt(5);
            int speedRandom = r.nextInt(3)+1;
//            System.out.println(xRandom+ " " + yRandom + " " + speedRandom);
            GameObjectManager.getInstance().addObject(new NormalZombie(xRandom,yRandom,speedRandom));
        }
    }
    
    
    
}
