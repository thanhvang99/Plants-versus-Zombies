package project;

import java.awt.image.BufferedImage;


// Contain images for plants, zombies, background,... and other stuff use to Game
// Only load 1 time and using everywhere...

public class Stuffs {
    private static BufferedImage gameBackground,
                                 activePeaShooter,
                                 activeSunflower;
    
    
    private static BufferedImage[] plant = new BufferedImage[2];
    
    public static void init(){
        gameBackground = ImageLoader.load("/images/backgrounds/game_background.jpg");
        
        // Card
        activePeaShooter = ImageLoader.load("/images/plants/active_peashooter.png");
        activeSunflower = ImageLoader.load("/images/plants/active_sunflower.png");
        
        // Plant
        plant[0] = ImageLoader.load("/images/plants/frame0.gif");
        plant[1] = ImageLoader.load("/images/plants/frame1.gif");
    }
    
    // Get stuffs
    public static BufferedImage getGameBackground(){ return gameBackground; }
    public static BufferedImage[] getPlant(){ return plant; }
    public static BufferedImage getActivePeaShooter(){ return activePeaShooter; }
    public static BufferedImage getActiveSunflower(){ return activeSunflower; }
}
