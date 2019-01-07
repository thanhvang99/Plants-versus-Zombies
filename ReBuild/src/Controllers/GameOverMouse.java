package Controllers;

import Helper.GUI;
import Models.BackgroundComponents.Score;
import Services.AudioPlayer;
import Views.GameOverState;
import Views.State;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class GameOverMouse extends Mouse {
    private Score score;
    public GameOverMouse(Score score){
        this.score = score;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int xPixel = e.getX();
        int yPixel = e.getY();
        if( GameOverState.isYes(xPixel, yPixel) ){
            score.set(0);
            switchToGame();
        } else if (GameOverState.isNo(xPixel, yPixel)) {
            switchToMenu();
            score.set(0);
        }
        
    }
    public void switchToGame() {
        GUI gui = GUI.getInstance();
        State.setState(gui.getGameState());
        Mouse.removeCurrentMouseFrom(gui);
        Mouse.setCurrentMouse(gui.getGameState().getMouse());
        Mouse.addCurrentMouseTo(gui);
        Spawner.reClock();
        
        AudioPlayer.loadMusic("background").loop();
    }
    public void switchToMenu() {
        GUI gui = GUI.getInstance();
        Mouse.removeCurrentMouseFrom(gui);
        State.setState(gui.getMenuState());
        
        AudioPlayer.loadMusic("menu").loop();

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void render(Graphics g) {
    }
    
}
