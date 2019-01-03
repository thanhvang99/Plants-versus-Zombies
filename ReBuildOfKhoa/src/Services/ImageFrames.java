package Services;

import Helper.ImageLoader;
import Views.MenuBackground;
import java.awt.image.BufferedImage;

public class ImageFrames {
    
    // Cards
    private static BufferedImage[] cards = new BufferedImage[10];
    
    // Peashooter
    private static BufferedImage PeashooterCandicateOn,
                                 PeashooterCandicateOff,
                                 PeashooterBullet;
    
    private static BufferedImage[] PeashooterAct,
                                   PeashooterDie;
    
    // Betroot
    private static BufferedImage BeetrootCandicateOn,
                                 BeetrootCandicateOff,
                                 BeetrootBullet;
    
    private static BufferedImage[] BeetrootAct,
                                   BeetrootDie;
    
    // Normal Zombie
    private static BufferedImage[] NormalZombieDie,
                                   NormalZombieMove;
    
    // Backgrounds
    private static BufferedImage GameBackground;
    private static BufferedImage menuBackground;
    
    private static BufferedImage clickToStart;
    
    public static void setUp(){
        setUpPeashooterFrames();
        setUpBeetrootFrames();
        setUpBackground();
        setupMenuBackground();
    }
    public static void setUpPeashooterFrames(){
        PeashooterCandicateOn = ImageLoader.load("/Plants/Peashooter/candicate_on.png");
        PeashooterCandicateOff = ImageLoader.load("/plants/peashooter/candicate_off.png");
        
        PeashooterAct = new BufferedImage[2];
        PeashooterAct[0] = ImageLoader.load("/plants/peashooter/act1.gif");
        PeashooterAct[1] = ImageLoader.load("/plants/peashooter/act2.gif");
        
    }
    public static void setUpBeetrootFrames(){
        BeetrootCandicateOn = ImageLoader.load("/plants/beetroot/candicate_on.png");
        BeetrootCandicateOff = ImageLoader.load("/plants/beetroot/candicate_off.png");
        
        BeetrootAct = new BufferedImage[2];
        BeetrootAct[0] = ImageLoader.load("/plants/beetroot/act1.gif");
        BeetrootAct[1] = ImageLoader.load("/plants/beetroot/act2.gif");
    }
    public static void setUpBackground(){
        GameBackground = ImageLoader.load("/plants/background/game.jpg");
    }
    
    public static void setupMenuBackground() {
        menuBackground = ImageLoader.load("/MenuBackground/menuBackground.png");   
    }
    
    public static void clickToStart() {
        clickToStart = ImageLoader.load("/MenuBackground/click_to_start.gif");
    }
    
    public static BufferedImage[] getPeashooterAct(){ return PeashooterAct; }
    public static BufferedImage getPeashooterCandicateOn(){ return PeashooterCandicateOn; }
    public static BufferedImage getBeetrootCandicateOn(){ return BeetrootCandicateOn; }
    public static BufferedImage getGameBackground(){ return GameBackground; }
    public static BufferedImage getMenuBackground() { return menuBackground; }
    public static BufferedImage getClickToStart() { return clickToStart; }
}
