package Controllers;

import Models.BackgroundComponents.Playground;
import Models.BackgroundComponents.Score;
import Models.GameObjects.FlyZombie;
import Models.GameObjects.FootBallZombie;
import Models.GameObjects.GameObjectManager;
import Models.GameObjects.NormalZombie;
import Services.AudioPlayer;
import Services.GameDraw;
import Services.GameLogic;
import Services.ImageFrames;
import Services.Timer;
import java.awt.Graphics;
import java.util.Random;

public class Spawner implements GameLogic,GameDraw {
    private static float speedInitial = 5;
    private int currentNumberHugeWave = 0;
    
    private Random r = new Random();
    private static  Timer timerForRandomZombie,
                    timerForMakingHugeWaveZombie,
                    timerOfHugeWaveZombie,
                    timerForShowingHint;
    private static Score score;
    private boolean isHugeWave = false,
                    isShowing = false;
    
    public Spawner(){
        timerForShowingHint = new Timer(3000);
        timerForRandomZombie = new Timer(5000);
        timerOfHugeWaveZombie = new Timer(15_000);
        timerForMakingHugeWaveZombie = new Timer(30_000);
        
    }
    
    
    @Override
    public void tick() {
        controlHugeWaveZombie();
        randomZombie();
    }
    public void randomZombie(){
        if( timerForRandomZombie.isTimeOut() ){
            int xRandom = r.nextInt(1) + 10;
            int yRandom = r.nextInt(5);
            float speedRandom = r.nextInt(3) + speedInitial;
            switch (r.nextInt(5)) {
                case 1:
                    GameObjectManager.getInstance().addObject(new FootBallZombie(xRandom, yRandom, speedRandom));
                    break;
                case 2:
                    GameObjectManager.getInstance().addObject(new FlyZombie(xRandom, yRandom, speedRandom));
                    break;
                default:
                    GameObjectManager.getInstance().addObject(new NormalZombie(xRandom, yRandom, speedRandom));
                    break;
            }
        }
    }
    public void controlHugeWaveZombie(){
        if (timerForShowingHint.isTimeOut()) {
            isShowing = false;
            if (timerOfHugeWaveZombie.isTimeOut()) {
                timerForRandomZombie.setTimeOut(5000);
                isHugeWave = false;
                speedInitial = 5;
                if (timerForMakingHugeWaveZombie.isTimeOut()) {
                    currentNumberHugeWave++;
                    timerForRandomZombie.setTimeOut(3000 - 200*currentNumberHugeWave);
                    speedInitial = currentNumberHugeWave*0.5f + 6;
                    isShowing = true;
                    isHugeWave = true;
                    
                    AudioPlayer.loadSound("zombies_coming").play();
                }
            }
        }
        
        
    }

    @Override
    public void render(Graphics g) {
        if( isShowing ){
            g.drawImage(ImageFrames.getHugeWaveHint(), (int)Playground.convert_CordinateX_to_Pixel(1), (int)Playground.convert_CordinateY_to_Pixel(2), null);
        }
    }
    public static void reClock(){
        timerForRandomZombie.reClock();
        timerForMakingHugeWaveZombie.reClock();
        timerOfHugeWaveZombie.reClock();
        timerForShowingHint.reClock();

    }
}
