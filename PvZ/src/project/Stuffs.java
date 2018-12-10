package project;

import java.awt.image.BufferedImage;


// Contain images for plants, zombies, background,... and other stuff use to Game
// Only load 1 time and using everywhere...

public class Stuffs {
    private static BufferedImage gameBackground,
                                 activePeaShooter,
                                 activeSunflower,
                                 test;
    
<<<<<<< HEAD
    public static void init() {
=======
    public static void init(){
        // Initialize Frame Combination
        FrameCombination.init();
        
>>>>>>> d14b494b012f9bac650ffc9e850cfe36fb9e1cd5
        gameBackground = ImageLoader.load("/images/backgrounds/game_background.jpg");
        
        // Card
        activePeaShooter = ImageLoader.load("/images/plants/active_peashooter.png");
        activeSunflower = ImageLoader.load("/images/plants/active_sunflower.png");
        
        
        // Test
//        test = ImageLoader.load("/images/zombies/frames/BasicZombie/newZombie.gif");
        
    }
    
    // Get stuffs
<<<<<<< HEAD
    public static BufferedImage getGameBackground() {
        return gameBackground;
    }

    public static BufferedImage[] getPlant() {
        return plant;
    }

    public static BufferedImage getActivePeaShooter() {
        return activePeaShooter;
    }

    public static BufferedImage getActiveSunflower() {
        return activeSunflower;
    }

=======
    public static BufferedImage getGameBackground(){ return gameBackground; }
    public static BufferedImage[] getBasicPlant(){ return FrameCombination.BASIC_PLANT; }
    public static BufferedImage[] getBasicZombie(){ return FrameCombination.BASIC_ZOMBIE; }
    public static BufferedImage getActivePeaShooter(){ return activePeaShooter; }
    public static BufferedImage getActiveSunflower(){ return activeSunflower; }
>>>>>>> d14b494b012f9bac650ffc9e850cfe36fb9e1cd5
}
