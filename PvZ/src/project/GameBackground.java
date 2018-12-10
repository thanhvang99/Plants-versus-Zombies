package project;

import java.awt.Graphics;

public class GameBackground extends Background {
<<<<<<< HEAD

    private static final int DEFAULT_WIDTH_CARD = 110,
=======
    public static final int DEFAULT_WIDTH_CARD = 110,
>>>>>>> d14b494b012f9bac650ffc9e850cfe36fb9e1cd5
                             DEFAULT_HEIGHT_CARD = 100;
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Stuffs.getGameBackground(), 0, 0, Window.getInstance().getWidth(),Window.getInstance().getHeight(),null);
        g.drawImage(Stuffs.getActivePeaShooter(), 10, 110,DEFAULT_WIDTH_CARD,DEFAULT_HEIGHT_CARD, null);
        g.drawImage(Stuffs.getActiveSunflower(),10,210,DEFAULT_WIDTH_CARD,DEFAULT_HEIGHT_CARD,null);
    }
<<<<<<< HEAD

    public static int getWidth() { return DEFAULT_WIDTH_CARD; }
    public static int getHeight() { return DEFAULT_HEIGHT_CARD; }
=======
    
>>>>>>> d14b494b012f9bac650ffc9e850cfe36fb9e1cd5
    
}
