package Helper;

import Models.GameObjects.GameObjectManager;
import Models.GameObjects.NormalBullet;
import Models.GameObjects.NormalZombie;
import Services.ImageFrames;

public class Test {
    public static void setUp(){
        NormalZombie z1 = new NormalZombie(5,0,2);
        NormalZombie z2 = new NormalZombie(5,1,2);
        NormalZombie z3 = new NormalZombie(5,2,2);
        NormalZombie z4 = new NormalZombie(5,3,2);
        NormalZombie z5 = new NormalZombie(5,4,2);
        GameObjectManager.getInstance().addObject(z1);
        GameObjectManager.getInstance().addObject(z2);
        GameObjectManager.getInstance().addObject(z3);
        GameObjectManager.getInstance().addObject(z4);
        GameObjectManager.getInstance().addObject(z5);
        
        NormalBullet b1= new NormalBullet(1,1,1,ImageFrames.getPeashooterBullet(), 0, 0);
        GameObjectManager.getInstance().addObject(b1);
    }
}
