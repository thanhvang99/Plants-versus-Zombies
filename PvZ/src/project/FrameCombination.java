package project;

import java.awt.image.BufferedImage;

public class FrameCombination {
    public static final BufferedImage[] BASIC_PLANT = new BufferedImage[2],
                                        BASIC_ZOMBIE = new BufferedImage[2];
    public static void init(){
        
        // For plant
        BASIC_PLANT[0] = ImageLoader.load("/images/plants/frames/BasicPlant/basic_plant1.gif");
        BASIC_PLANT[1] = ImageLoader.load("/images/plants/frames/BasicPlant/basic_plant2.gif");
        
        // For Zombie
        BASIC_ZOMBIE[0] = ImageLoader.load("/images/zombies/frames/BasicZombie/basic_zombie1.gif");
        BASIC_ZOMBIE[1] = ImageLoader.load("/images/zombies/frames/BasicZombie/basic_zombie2.gif");
    }
                                  
    
    
    
}   
