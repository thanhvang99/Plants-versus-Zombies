package Models.GameObject.Cards;

import Services.ImageFrames;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ShovelCard extends Card {
    public ShovelCard() {
        super(0);
    }

    @Override
    public void createObject(int x, int y) {
        // Nothing
    }

    @Override
    public BufferedImage getImageCard() {
        return ImageFrames.getShovel();
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(ImageFrames.getShovel(), ListCardComponent.START_X, ListCardComponent.START_Y + DEFAULT_HEIGHT_CARD * getIndex(),
                DEFAULT_WIDTH_CARD, DEFAULT_HEIGHT_CARD, null);
    }
    
}
