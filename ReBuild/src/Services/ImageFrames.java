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
    
    // sunflower
    private static BufferedImage[] SunflowerCandicate,
                                   SunflowerAct,
                                   SunflowerDie,
                                   Sun;
    
    // walnut
    private static BufferedImage[] WalnutCandicate, 
                                   WalnutFullHealth,
                                   WalnutHalfHealth,
                                   WalnutDie;
    
    // Normal Zombie
    private static BufferedImage[] NormalZombieDie,
                                   NormalZombieMove;
    
    
    // Backgrounds
    private static BufferedImage GameBackground;
    
    public static void setUpAllFrames(){
        setUpPeashooterFrames();
        setUpBeetrootFrames();
        setUpZombieFrames();
        setUpBackground();
    
        setupSunflowerFrames();
        setupWalnutFrames();
        
    }
    public static void setUpPeashooterFrames(){
        
        PeashooterCandicate = new BufferedImage[2];
        PeashooterCandicate[0] = ImageLoader.load("/Plants/Peashooter/candicate_on.png");
        PeashooterCandicate[1] = ImageLoader.load("/plants/peashooter/candicate_off.png");
        
        PeashooterAct = new BufferedImage[2];
        PeashooterAct[0] = ImageLoader.load("/plants/peashooter/act1.gif");
        PeashooterAct[1] = ImageLoader.load("/plants/peashooter/act2.gif");
        
        PeashooterDie = new BufferedImage[3];
        PeashooterDie[0] = ImageLoader.load("/plants/peashooter/die1.gif");
        PeashooterDie[1] = ImageLoader.load("/plants/peashooter/die2.gif");
        PeashooterDie[2] = ImageLoader.load("/plants/peashooter/die3.gif");
        
        PeashooterBullet = ImageLoader.load("/plants/peashooter/bullet.png");
        
    }
    public static void setUpBeetrootFrames(){
        
        BeetrootCandicate = new BufferedImage[2];
        BeetrootCandicate[0] = ImageLoader.load("/plants/beetroot/candicate_on.png");
        BeetrootCandicate[1] = ImageLoader.load("/plants/beetroot/candicate_off.png");
        
        BeetrootAct = new BufferedImage[2];
        BeetrootAct[0] = ImageLoader.load("/plants/beetroot/act1.gif");
        BeetrootAct[1] = ImageLoader.load("/plants/beetroot/act2.gif");
        
        BeetrootDie = new BufferedImage[3];
        BeetrootDie[0] = ImageLoader.load("/plants/beetroot/die1.gif");
        BeetrootDie[1] = ImageLoader.load("/plants/beetroot/die2.gif");
        BeetrootDie[2] = ImageLoader.load("/plants/beetroot/die3.gif");
        
        BeetrootBullet = ImageLoader.load("/plants/beetroot/bullet.png");
    }
    public static void setUpZombieFrames(){
        
        NormalZombieMove = new BufferedImage[2];
        NormalZombieMove[0] = ImageLoader.load("/zombies/normalZombie/move1.gif");
        NormalZombieMove[1] = ImageLoader.load("/zombies/normalZombie/move2.gif");
        
        NormalZombieDie = new BufferedImage[6];
        NormalZombieDie[0] = ImageLoader.load("/zombies/normalZombie/die1.gif");
        NormalZombieDie[1] = ImageLoader.load("/zombies/normalZombie/die2.gif");
        NormalZombieDie[2] = ImageLoader.load("/zombies/normalZombie/die3.gif");
        NormalZombieDie[3] = ImageLoader.load("/zombies/normalZombie/die4.gif");
        NormalZombieDie[4] = ImageLoader.load("/zombies/normalZombie/die5.gif");    
        NormalZombieDie[5] = ImageLoader.load("/zombies/normalZombie/die6.gif");
        
    }
    
    public static void setupSunflowerFrames() {
        SunflowerCandicate = new BufferedImage[2];
        SunflowerCandicate[0] = ImageLoader.load("/plants/sunflower/candicate_on.png");
        SunflowerCandicate[1] = ImageLoader.load("/plants/sunflower/candicate_off.png");
        
        SunflowerAct = new BufferedImage[2];
        SunflowerAct[0] = ImageLoader.load("/plants/sunflower/act1.gif");
        SunflowerAct[1] = ImageLoader.load("/plants/sunflower/act2.gif");
        
        SunflowerDie = new BufferedImage[5];
        SunflowerDie[0] = ImageLoader.load("/plants/sunflower/die1.gif");
        SunflowerDie[1] = ImageLoader.load("/plants/sunflower/die2.gif");
        SunflowerDie[2] = ImageLoader.load("/plants/sunflower/die3.gif");
        SunflowerDie[3] = ImageLoader.load("/plants/sunflower/die4.gif");
        SunflowerDie[4] = ImageLoader.load("/plants/sunflower/die5.gif");

        Sun = new BufferedImage[3];
        Sun[0] = ImageLoader.load("/plants/sunflower/sun1.gif");
        Sun[1] = ImageLoader.load("/plants/sunflower/sun2.gif");
        Sun[2] = ImageLoader.load("/plants/sunflower/sun3.gif");
    }
    
    public static void setupWalnutFrames() {
        WalnutCandicate = new BufferedImage[2];
        WalnutCandicate[0] = ImageLoader.load("/plants/walnut/candicate_on.png");
        WalnutCandicate[1] = ImageLoader.load("/plants/walnut/candicate_off.png");
        
        WalnutFullHealth = new BufferedImage[4];
        WalnutFullHealth[0] = ImageLoader.load("/plants/walnut/full1.gif");
        WalnutFullHealth[1] = ImageLoader.load("/plants/walnut/full2.gif");
        WalnutFullHealth[2] = ImageLoader.load("/plants/walnut/full3.gif");
        WalnutFullHealth[3] = ImageLoader.load("/plants/walnut/full4.gif");
        
        WalnutHalfHealth = new BufferedImage[4];
        WalnutHalfHealth[0] = ImageLoader.load("/plants/walnut/half1.gif");
        WalnutHalfHealth[1] = ImageLoader.load("/plants/walnut/half2.gif");
        WalnutHalfHealth[2] = ImageLoader.load("/plants/walnut/half3.gif");
        WalnutHalfHealth[3] = ImageLoader.load("/plants/walnut/half4.gif");
        
        WalnutDie = new BufferedImage[4];
        WalnutDie[0] = ImageLoader.load("/plants/walnut/die1.gif");
        WalnutDie[1] = ImageLoader.load("/plants/walnut/die2.gif");
        WalnutDie[2] = ImageLoader.load("/plants/walnut/die3.gif");
        WalnutDie[3] = ImageLoader.load("/plants/walnut/die4.gif");
    }
    
    public static void setUpBackground(){
        GameBackground = ImageLoader.load("/plants/background/game.jpg");
    }
    
    // Image Peashooter
    public static BufferedImage[] getPeashooterAct(){ return PeashooterAct; }
    public static BufferedImage[] getPeashooterCandicate(){ return PeashooterCandicate; }
    public static BufferedImage[] getPeashooterDie(){ return PeashooterDie; }
    public static BufferedImage getPeashooterBullet(){ return PeashooterBullet; }
    
    // Image Beetroot
    public static BufferedImage[] getBeetrootAct(){ return BeetrootAct; }
    public static BufferedImage[] getBeetrootCandicate(){ return BeetrootCandicate; }
    public static BufferedImage getBeetrootBullet(){ return BeetrootBullet; }
    public static BufferedImage[] getBeetrootDie() { return BeetrootDie; }
    
    // Image NormalZombie
    public static BufferedImage[] getNormalZombieMove(){ return NormalZombieMove; }
    public static BufferedImage[] getNormalZombieDie(){ return NormalZombieDie; }
    
    // Image Sunflower
    public static BufferedImage[] getSunflowerCandicate() { return SunflowerCandicate; }
    public static BufferedImage[] getSunflowerAct() { return SunflowerAct; }
    public static BufferedImage[] getSunflowerDie() { return SunflowerDie; }
    public static BufferedImage[] getSun(){ return Sun; }
    
    // Image Walnut
    public static BufferedImage[] getWalnutCandicate() { return WalnutCandicate; }
    public static BufferedImage[] getWalnutFullHealth() { return WalnutFullHealth; }
    public static BufferedImage[] getWalnutHalfHealth() { return WalnutHalfHealth; }
    public static BufferedImage[] getWalnutDie() { return WalnutDie; }
    
            
    // Image Background
    public static BufferedImage getGameBackground(){ return GameBackground; }
}
