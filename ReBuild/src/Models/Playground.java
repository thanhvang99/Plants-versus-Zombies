package Models;

import Models.GameObjectManager;
import Models.GameObject;
import java.util.ArrayList;
import Services.GameLogic;
import java.awt.Rectangle;

public class Playground implements GameLogic {
    public static final int DELTA_WIDTH_CELL = 105,
                            DELTA_HEIGHT_CELL = 140,
                            START_X = 360,
                            START_Y = 40;
    
    private int x,y;
    private boolean[][] ground;
    private Rectangle rect;
    
    public Playground(int x,int y){
        this.x = x;
        this.y = y;
        
        ground = new boolean[y][x];
        
        rect = new Rectangle(START_X,START_Y,x*DELTA_WIDTH_CELL,y*DELTA_HEIGHT_CELL);
        
    }
    public static int convert_Pixel_to_CordinateX(int xPixel){
        return ( xPixel - START_X )/ DELTA_WIDTH_CELL;
    }
    public static int convert_Pixel_to_CordinateY(int yPixel){
        return ( yPixel - START_Y )/ DELTA_HEIGHT_CELL;
    }
    public static float convert_CordinateX_to_Pixel(float xCordinate){
        return ( START_X + xCordinate*DELTA_WIDTH_CELL );
    }
    public static float convert_CordinateY_to_Pixel(float yCordinate){
        return ( START_Y + yCordinate*DELTA_HEIGHT_CELL );
    }
    
    public boolean isInSide(int xPixel,int yPixel){
        return rect.contains(xPixel, yPixel) ? true : false;
    }
    
    @Override
    public void tick() {
        initializeGround();
        updateNewIDPosition();
    }
    
    public void updateNewIDPosition(){
        ArrayList<GameObject> listObject = GameObjectManager.getInstance().getList();
        for(GameObject object : listObject){
//            int XCeil = (int)Math.ceil(object.getXCordinate());
//            int YCeil = (int)Math.ceil(object.getYCordinate());
//            
//            int XFloor = (int)Math.floor(object.getXCordinate());
//            int YFloor = (int)Math.floor(object.getYCordinate());
//            
//            if( XFloor >= 0 && XCeil< x && object.isSolid() ){
//                ground[YCeil][XCeil] = true;
//                ground[YFloor][XFloor] = true;
//            }
            int XCeil = (int)object.getXCordinate();
            int YCeil = (int)object.getYCordinate();
            if( XCeil >= 0 && XCeil <= x && object.isSolid()) {
                ground[YCeil][XCeil] = true;
            }
        }
    }
    public void initializeGround(){
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                ground[j][i] = false;
            }
        }
    }
    public boolean isExistCreature(int xPosition,int yPosition){
        return ground[yPosition][xPosition];
    }
    
}
