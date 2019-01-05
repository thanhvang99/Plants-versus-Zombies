package Helper;

import Models.GameObjectManager;
import Models.NormalZombie;

public class Test {
    public static void setUp(){
        NormalZombie z1 = new NormalZombie(5,0,1);
        NormalZombie z2 = new NormalZombie(5,1,2);
        NormalZombie z3 = new NormalZombie(5,2,2);
        NormalZombie z4 = new NormalZombie(5,3,1);
        NormalZombie z5 = new NormalZombie(5,4,0);
        GameObjectManager.getInstance().addObject(z1);
        GameObjectManager.getInstance().addObject(z2);
        GameObjectManager.getInstance().addObject(z3);
        GameObjectManager.getInstance().addObject(z4);
        GameObjectManager.getInstance().addObject(z5);
    }
}
