package Models.GameObjects;

import Models.BackgroundComponents.Score;
import static Models.GameObjects.GameObject.PLANT;
import Services.AudioPlayer;
import Services.Timer;
import java.util.ArrayList;

public abstract class BasicZombie extends GameObject {

    protected final int DEFAULT_WIDTH = 96,
            DEFAULT_HEIGHT = 130;
    private float currentSpeed,
                  initialSpeed;
    protected static Score score;
    
    private int damage = 10;
    private Timer timer;
    private GameObject plantCollision = null;

    public BasicZombie(float x, float y, float speed) {
        super(x, y, ZOMBIE);
        this.currentSpeed = speed;
        this.initialSpeed = speed;

        setHealth(100);
        setAnimation();
        setSizeImage(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setXYPadding();
    }

    @Override
    public void tick() {
        animation[getState()].tick();
        checkCollision();
        act();
        checkDied();
    }
    
    
    public void checkCollision() {
        ArrayList<GameObject> listPlant = GameObjectManager.getInstance().getList(PLANT);
        for (GameObject object : listPlant) {
            if (getCurrentRect().intersects(object.getCurrentRect())) {
                plantCollision = object;
            }
        }
    }
    @Override
    public void act() {
        if (plantCollision == null) {
            setState(ACT);
            changeSpeedTo(getInitialSpeed());

        } else {
            changeSpeedTo(0);
            attack(plantCollision);

            if (plantCollision.getState() == GameObject.DIE ) {
                plantCollision = null;
            }
        }
        setX(getXCordinate() - getCurrentSpeed() / 1000);        //  x -= speed/1000;
    }

    public void attack(GameObject object) {
        if (timer.isTimeOut()) {
            object.setHealth(object.getHealth() - damage);
            AudioPlayer.loadSound("chomp").play();
        }
    }

    @Override
    public void checkDied() {
        if (getHealth() <= 0) {
            setState(DIE);
            if (animation[getState()].isNewLoop()) {
                increaseScoreAfterDied();
                GameObjectManager.getInstance().removeObject(this);
            }

        }
    }

    public void changeSpeedTo(float speed) {
        if (currentSpeed < speed) {
            increaseSpeedTo(speed);
        } else {
            decreaseSpeedTo(speed);
        }
    }

    public void decreaseSpeedTo(float speed) {
        if (currentSpeed <= speed) {
            currentSpeed = speed;
        } else {
            currentSpeed -= 0.15f;
        }
    }

    public void increaseSpeedTo(float speed) {
        if (currentSpeed >= speed) {
            currentSpeed = speed;
        } else {
            currentSpeed += 0.02f;
        }

    }

    public void increaseScoreAfterDied() {
        score.set(score.get() + 100);
    }
    
    public static void setRelationWithScore(Score scoreInput){
        score = scoreInput;
    }
    public void setCurrentSpeed(float speed){ this.currentSpeed = speed; }
    public float getCurrentSpeed(){ return currentSpeed; }
    public float getInitialSpeed(){ return initialSpeed; }
    public void setTimer(Timer timer){
        this.timer = timer;
    }
    public void setDamage(int damage){this.damage = damage;}
    @Override
    public boolean isSolid(){ return false; }
}
