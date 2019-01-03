package Helper;

import Models.GameObjectManager;
import Models.Peashooter;

public class Test {
    public static void setUp(){
        Peashooter p1 = new Peashooter(0,0);
        GameObjectManager.getInstance().addObject(p1);
    }
}
