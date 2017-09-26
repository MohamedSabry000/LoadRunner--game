package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import tilegame.UserInterface.UIManager;

public class MouseManager implements MouseMotionListener, MouseListener {

    private boolean mouseLeft,mouseRight;
    private int mouseX,mouseY;
    private UIManager uiManager;
    public MouseManager() {
    }
    

    //GETTERS

    public boolean isMouseLeft() {
        return mouseLeft;
    }

    public boolean isMouseRight() {
        return mouseRight;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }
    
    
    
    //IMPLEMINTED METHODS
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
            mouseLeft=true;
        else if(e.getButton()==MouseEvent.BUTTON3)
            mouseRight=true;
        
            
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
            mouseLeft=false;
        else if(e.getButton()==MouseEvent.BUTTON3)
            mouseRight=false;
        if(uiManager !=null)
            uiManager.onMouseRelease(e);
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        if(uiManager !=null)
            uiManager.onMouseMove(e);
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
