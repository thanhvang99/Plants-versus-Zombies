package Services;



import java.awt.image.BufferedImage;

public class ImageFrames {
    
    // Peashooter
    private static BufferedImage   PeashooterBullet;
    
    private static BufferedImage[] PeashooterAct,
                                   PeashooterDie,
                                   PeashooterCandicate;
    private static BufferedImage[] NewPeashooterAct;
    
    // Betroot
    private static BufferedImage   BeetrootBullet;
    
    private static BufferedImage[] BeetrootAct,
                                   BeetrootDie,
                                   BeetrootCandicate;
    
    // sunflower
    private static BufferedImage[] SunflowerCandicate,
                                   SunflowerAct,
                                   SunflowerDie,
                                   Sun,
                                   NewSunflowerAct;
    
    
    // walnut
    private static BufferedImage[] WalnutCandicate, 
                                   WalnutFullHealth,
                                   WalnutHalfHealth,
                                   WalnutDie;
    
    // Football zombie
    private static BufferedImage[] FootBallZombieDie,
                                   FootBallZombieMove;
    
    // Normal Zombie
    private static BufferedImage[] NormalZombieDie,
                                   NormalZombieMove,
                                   NormalZombieAttack;
    // Fly Zombie
    private static BufferedImage[] FlyZombieMove,
                                   FlyZombieDie;
    
    // Lawn Mower
    private static BufferedImage[] LawnMowerFrames;
    
    
    // Backgrounds
    private static BufferedImage GameBackground,
                                 MenuBackground,
                                 HugeWaveHint,
                                 Shovel;
    private static BufferedImage[] GameOverBackground;
    
    public static void setUpAllFrames(){
        setUpPlantFrames();
        setUpZombieFrames();
        setUpBackground();
        setUpLawnMower();
        
    }
    public static void setUpPlantFrames(){
        setUpPeashooterFrames();
        setUpBeetrootFrames();
        setUpSunflowerFrames();
        setUpWalnutFrames();
    }
    public static void setUpZombieFrames(){
        setUpNormalZombieFrames();
        setUpFootBallZombieFrames();
        setUpFlyZombie();
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
        
        NewPeashooterAct = new BufferedImage[15];
        
        NewPeashooterAct[0] = ImageLoader.load("/plants/newPeashooter/act0.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[1] = ImageLoader.load("/plants/newPeashooter/act1.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[2] = ImageLoader.load("/plants/newPeashooter/act2.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[3] = ImageLoader.load("/plants/newPeashooter/act3.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[4] = ImageLoader.load("/plants/newPeashooter/act4.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[5] = ImageLoader.load("/plants/newPeashooter/act5.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[6] = ImageLoader.load("/plants/newPeashooter/act6.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[7] = ImageLoader.load("/plants/newPeashooter/act7.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[8] = ImageLoader.load("/plants/newPeashooter/act8.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[9] = ImageLoader.load("/plants/newPeashooter/act9.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[10] = ImageLoader.load("/plants/newPeashooter/act10.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[11] = ImageLoader.load("/plants/newPeashooter/act11.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[12] = ImageLoader.load("/plants/newPeashooter/act12.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[13] = ImageLoader.load("/plants/newPeashooter/act13.gif").getSubimage(100, 110, 480, 400);
        NewPeashooterAct[14] = ImageLoader.load("/plants/newPeashooter/act14.gif").getSubimage(100, 110, 480, 400);
        
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
    public static void setUpNormalZombieFrames(){
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
        
        NormalZombieAttack = new BufferedImage[20];
        NormalZombieAttack[0] = ImageLoader.load("/zombies/normalZombie/act0.gif");
        NormalZombieAttack[1] = ImageLoader.load("/zombies/normalZombie/act1.gif");
        NormalZombieAttack[2] = ImageLoader.load("/zombies/normalZombie/act2.gif");
        NormalZombieAttack[3] = ImageLoader.load("/zombies/normalZombie/act3.gif");
        NormalZombieAttack[4] = ImageLoader.load("/zombies/normalZombie/act4.gif");
        NormalZombieAttack[5] = ImageLoader.load("/zombies/normalZombie/act5.gif");
        NormalZombieAttack[6] = ImageLoader.load("/zombies/normalZombie/act6.gif");
        NormalZombieAttack[7] = ImageLoader.load("/zombies/normalZombie/act7.gif");
        NormalZombieAttack[7] = ImageLoader.load("/zombies/normalZombie/act7.gif");
        NormalZombieAttack[8] = ImageLoader.load("/zombies/normalZombie/act8.gif");
        NormalZombieAttack[9] = ImageLoader.load("/zombies/normalZombie/act9.gif");
        NormalZombieAttack[10] = ImageLoader.load("/zombies/normalZombie/act10.gif");
        NormalZombieAttack[11] = ImageLoader.load("/zombies/normalZombie/act11.gif");
        NormalZombieAttack[12] = ImageLoader.load("/zombies/normalZombie/act12.gif");
        NormalZombieAttack[13] = ImageLoader.load("/zombies/normalZombie/act13.gif");
        NormalZombieAttack[14] = ImageLoader.load("/zombies/normalZombie/act14.gif");
        NormalZombieAttack[15] = ImageLoader.load("/zombies/normalZombie/act15.gif");
        NormalZombieAttack[16] = ImageLoader.load("/zombies/normalZombie/act16.gif");
        NormalZombieAttack[17] = ImageLoader.load("/zombies/normalZombie/act17.gif");
        NormalZombieAttack[18] = ImageLoader.load("/zombies/normalZombie/act18.gif");
        NormalZombieAttack[19] = ImageLoader.load("/zombies/normalZombie/act19.gif");
        
        
    }
    public static void setUpFootBallZombieFrames(){
        FootBallZombieMove = new BufferedImage[2];
        FootBallZombieMove[0] = ImageLoader.load("/zombies/footballZombie/move1.gif");
        FootBallZombieMove[1] = ImageLoader.load("/zombies/footballZombie/move2.gif");
        
        FootBallZombieDie = new BufferedImage[6];
        FootBallZombieDie[0] = ImageLoader.load("/zombies/footballZombie/die0.gif");
        FootBallZombieDie[1] = ImageLoader.load("/zombies/footballZombie/die1.gif");
        FootBallZombieDie[2] = ImageLoader.load("/zombies/footballZombie/die2.gif");
        FootBallZombieDie[3] = ImageLoader.load("/zombies/footballZombie/die3.gif");
        FootBallZombieDie[4] = ImageLoader.load("/zombies/footballZombie/die4.gif");    
        FootBallZombieDie[5] = ImageLoader.load("/zombies/footballZombie/die5.gif");
    
    }
    public static void setUpFlyZombie(){
        FlyZombieMove = new BufferedImage[6];
        FlyZombieMove[0] = ImageLoader.load("/zombies/flyZombie/fly0.gif");
        FlyZombieMove[1] = ImageLoader.load("/zombies/flyZombie/fly1.gif");
        FlyZombieMove[2] = ImageLoader.load("/zombies/flyZombie/fly2.gif");
        FlyZombieMove[3] = ImageLoader.load("/zombies/flyZombie/fly3.gif");
        FlyZombieMove[4] = ImageLoader.load("/zombies/flyZombie/fly4.gif");
        FlyZombieMove[5] = ImageLoader.load("/zombies/flyZombie/fly5.gif");
        
        NewSunflowerAct = new BufferedImage[15];
        
        NewSunflowerAct[0] = ImageLoader.load("/plants/newSunflower/act0.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[1] = ImageLoader.load("/plants/newSunflower/act1.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[2] = ImageLoader.load("/plants/newSunflower/act2.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[3] = ImageLoader.load("/plants/newSunflower/act3.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[4] = ImageLoader.load("/plants/newSunflower/act4.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[5] = ImageLoader.load("/plants/newSunflower/act5.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[6] = ImageLoader.load("/plants/newSunflower/act6.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[7] = ImageLoader.load("/plants/newSunflower/act7.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[8] = ImageLoader.load("/plants/newSunflower/act8.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[9] = ImageLoader.load("/plants/newSunflower/act9.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[10] = ImageLoader.load("/plants/newSunflower/act10.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[11] = ImageLoader.load("/plants/newSunflower/act11.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[12] = ImageLoader.load("/plants/newSunflower/act12.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[13] = ImageLoader.load("/plants/newSunflower/act13.gif").getSubimage(100, 100, 450, 500);
        NewSunflowerAct[14] = ImageLoader.load("/plants/newSunflower/act14.gif").getSubimage(100, 100, 450, 500);
        
    
    }
    
    public static void setUpSunflowerFrames() {
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
    
    public static void setUpWalnutFrames() {
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
    
    public static void setUpLawnMower(){
        LawnMowerFrames = new BufferedImage[2];
        LawnMowerFrames[0] = ImageLoader.load("/lawn_mower1.gif");
        LawnMowerFrames[1] = ImageLoader.load("/lawn_mower2.gif");
    }
    public static void setUpBackground(){
        GameBackground = ImageLoader.load("/background/game.jpg");
        MenuBackground = ImageLoader.load("/background/menu2.png");
        
        GameOverBackground = new BufferedImage[10];
        
        GameOverBackground[0] = ImageLoader.load("/background/gameover1.gif");
        GameOverBackground[1] = ImageLoader.load("/background/gameover2.gif");
        GameOverBackground[2] = ImageLoader.load("/background/gameover3.gif");
        GameOverBackground[3] = ImageLoader.load("/background/gameover4.gif");
        GameOverBackground[4] = ImageLoader.load("/background/gameover5.gif");
        GameOverBackground[5] = ImageLoader.load("/background/gameover6.gif");
        GameOverBackground[6] = ImageLoader.load("/background/gameover7.gif");
        GameOverBackground[7] = ImageLoader.load("/background/gameover8.gif");
        GameOverBackground[8] = ImageLoader.load("/background/gameover9.gif");
        GameOverBackground[9] = ImageLoader.load("/background/gameover10.gif");
        
        HugeWaveHint = ImageLoader.load("/background/huge_wave.png");
        Shovel = ImageLoader.load("/background/shovel.png");
        
        

    }
    
    // Image Peashooter
    public static BufferedImage[] getPeashooterAct(){ return PeashooterAct; }
    public static BufferedImage[] getNewPeashooterAct(){ return NewPeashooterAct; }
    public static BufferedImage[] getPeashooterCandicate(){ return PeashooterCandicate; }
    public static BufferedImage[] getPeashooterDie(){ return PeashooterDie; }
    public static BufferedImage getPeashooterBullet(){ return PeashooterBullet; }
    
    // Image Beetroot
    public static BufferedImage[] getBeetrootAct(){ return BeetrootAct; }
    public static BufferedImage[] getBeetrootCandicate(){ return BeetrootCandicate; }
    public static BufferedImage getBeetrootBullet(){ return BeetrootBullet; }
    public static BufferedImage[] getBeetrootDie() { return BeetrootDie; }
    
    // Image Sunflower
    public static BufferedImage[] getSunflowerCandicate() { return SunflowerCandicate; }
    public static BufferedImage[] getSunflowerAct() { return SunflowerAct; }
    public static BufferedImage[] getSunflowerDie() { return SunflowerDie; }
    public static BufferedImage[] getSun(){ return Sun; }
    public static BufferedImage[] getNewSunflowerAct(){ return NewSunflowerAct; }
    
    
    // Image Walnut
    public static BufferedImage[] getWalnutCandicate() { return WalnutCandicate; }
    public static BufferedImage[] getWalnutFullHealth() { return WalnutFullHealth; }
    public static BufferedImage[] getWalnutHalfHealth() { return WalnutHalfHealth; }
    public static BufferedImage[] getWalnutDie() { return WalnutDie; }
    
    
    // Image Normal Zombie
    public static BufferedImage[] getNormalZombieMove(){ return NormalZombieMove; }
    public static BufferedImage[] getNormalZombieDie(){ return NormalZombieDie; }
    public static BufferedImage[] getNormalZombieAttack(){ return NormalZombieAttack; }
    
    // Image Football Zombie
    public static BufferedImage[] getFootBallZombieMove(){ return FootBallZombieMove; }
    public static BufferedImage[] getFootBallZombieDie(){ return FootBallZombieDie; }
    
    // Image Fly Zombie
    public static BufferedImage[] getFlyZombieMove(){ return FlyZombieMove; }
    
    // Image Lawn Mower
    public static BufferedImage[] getLawnMower(){ return LawnMowerFrames; }
            
    // Image Background
    public static BufferedImage getGameBackground(){ return GameBackground; }
    public static BufferedImage getMenuBackground(){ return MenuBackground; }
    public static BufferedImage[] getGameOverBackground(){ return GameOverBackground; }
    public static BufferedImage getHugeWaveHint(){ return HugeWaveHint; }
    public static BufferedImage getShovel(){ return Shovel; }
}
