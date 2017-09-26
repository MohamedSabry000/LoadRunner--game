package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class KeyManager implements KeyListener{

    private boolean[] keys;
    public boolean up , down , left , right,deleteleft,deleteright;
    public boolean aUp , aDown , aLeft , aRight ;
    
    public KeyManager(){
        keys = new boolean[256];  
       
    }
    
    public void tick(){
        up = keys[KeyEvent.VK_W];                 
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        //DELETE BRICKS
        deleteleft = keys[KeyEvent.VK_Q];
        deleteright = keys[KeyEvent.VK_E];
        
        aUp = keys[KeyEvent.VK_UP];
        aDown = keys[KeyEvent.VK_DOWN];
        aLeft = keys[KeyEvent.VK_LEFT];
        aRight = keys[KeyEvent.VK_RIGHT];
//       
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    
    
    
        
}
