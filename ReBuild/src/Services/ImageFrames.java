package Services;



import java.awt.image.BufferedImage;

public class ImageFrames {
    
    // Peashooter
    private static BufferedImage   PeashooterBullet;
    
    private static BufferedImage[] PeashooterAct,
                                   PeashooterDie,
                                   PeashooterCandicate;
    
    // Betroot
    private static BufferedImage   BeetrootBullet;
    
    private static BufferedImage[] BeetrootAct,
                                   BeetrootDie,
                                   BeetrootCandicate;
    
    // Normal Zombie
    private static BufferedImage[] NormalZombieDie,
                                   NormalZombieMove;
    
    // Backgrounds
    private static BufferedImage GameBackground;
    
    public static void setUpAllFrames(){
        setUpPeashooterFrames();
        setUpBeetrootFrames();
        setUpBackground();
    
    }
    public static void setUpPeashooterFrames(){
        
        PeashooterCandicate = new BufferedImage[2];
        PeashooterCandicate[0] = ImageLoader.load("/Plants/Peashooter/candicate_on.png");
        PeashooterCandicate[1] = ImageLoader.load("/plants/peashooter/candicate_off.png");
        
        PeashooterAct = new BufferedImage[2];
        PeashooterAct[0] = ImageLoader.load("/plants/peashooter/act1.gif");
        PeashooterAct[1] = ImageLoader.load("/plants/peashooter/act2.gif");
        
    }
    public static void setUpBeetrootFrames(){
        
        BeetrootCandicate = new BufferedImage[2];
        BeetrootCandicate[0] = ImageLoader.load("/plants/beetroot/candicate_on.png");
        BeetrootCandicate[1] = ImageLoader.load("/plants/beetroot/candicate_off.png");
        
        BeetrootAct = new BufferedImage[2];
        BeetrootAct[0] = ImageLoader.load("/plants/beetroot/act1.gif");
        BeetrootAct[1] = ImageLoader.load("/plants/beetroot/act2.gif");
    }
    public static void setUpBackground(){
        GameBackground = ImageLoader.load("/plants/background/game.jpg");
    }
    
    // Image Peashooter
    public static BufferedImage[] getPeashooterAct(){ return PeashooterAct; }
    public static BufferedImage[] getPeashooterCandicate(){ return PeashooterCandicate; }
    
    // Image Beetroot
    public static BufferedImage[] getBeetrootAct(){ return BeetrootAct; }
    public static BufferedImage[] getBeetrootCandicate(){ return BeetrootCandicate; }
    
    public static BufferedImage getGameBackground(){ return GameBackground; }
}
