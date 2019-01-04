/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Helper.GUI;
import Services.GameDraw;
import Services.GameLogic;
import Views.State;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author ldakhoa
 */
public class ClickToStart implements MouseListener,GameLogic,GameDraw {

    private State menu;
    private boolean isClick = false;
    @Override
    public void mouseClicked(MouseEvent e) {
        
        isClick = true;
        
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
    public void render(Graphics g) {
        
    }

    @Override
    public void tick() {
        if( isClick ){
            menu = GUI.getInstance().getMenuState();
            
            menu.setupState();
            GUI.getInstance().getGameState().setupState();
            State.setState(GUI.getInstance().getGameState());
            isClick = false;
        }
    }
    
}
