package Controllers;

import Services.GameLogic;
import Services.Timer;

public class Spawner implements GameLogic {
    private Timer timer;
    
    public Spawner(){
        timer = new Timer(3000);
    
    }
    
    public void createZombie(){
        
    }
    @Override
    public void tick() {
        
    }
    
    
}
