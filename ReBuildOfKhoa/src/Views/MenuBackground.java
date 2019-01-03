package Views;

import Helper.GUI;
import Services.ImageFrames;
import com.sun.javafx.iio.ImageFrame;
import java.awt.Graphics;

public class MenuBackground extends Background {

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageFrames.getMenuBackground(), 0, 0, GUI.DEFAULT_WIDTH, GUI.DEFAULT_HEIGHT, null);
        g.drawImage(ImageFrames.getMenuButton(), 550, 600, 450, 170, null);
    }

    @Override
    public void tick() {
    }

    @Override
    public void setUp() {
    }
    
}
