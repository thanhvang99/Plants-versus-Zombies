/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Card;
import Models.ListCardComponent;
import Models.GameObjectManager;
import Models.Walnut;
import Services.ImageFrames;
import static Models.Card.DEFAULT_HEIGHT_CARD;
import static Models.Card.DEFAULT_WIDTH_CARD;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author ldakhoa
 */
public class WalnutCard extends Card {
    private BufferedImage[] frames = ImageFrames.getWalnutCandicate();
    

    public WalnutCard(int cost){
        super(cost);
    }
    
    
    @Override
    public void createObject(int x,int y) {
        GameObjectManager.getInstance().addObject(new Walnut(x,y));
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(frames[getActive()], ListCardComponent.START_X, ListCardComponent.START_Y + DEFAULT_HEIGHT_CARD * getIndex(),
                DEFAULT_WIDTH_CARD, DEFAULT_HEIGHT_CARD, null);
    }

    @Override
    public BufferedImage getImageCard() {
        return frames[0];
    }

}
