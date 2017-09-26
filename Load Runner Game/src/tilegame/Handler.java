package tilegame;

import Worlds.World;
import gfx.GameCamera;
import Input.KeyManager;
import Input.MouseManager;

public class Handler {

    private Game game ;
    private World world;
    
    public Handler(Game game) {
        this.game = game;
        
    }
//////////////    
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }
/////////////    
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    
    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }
//////////// 
    public int getWidth(){
        return game.getWidth();
    }
    
    public int getHeight(){
        return game.getHeight();
    }
// setter
    public void setGame(Game game) {
        this.game = game;
    }

    public void setWorld(World world) {
        this.world = world;
    }
// getter
    public Game getGame() {
        return game;
    }

    public World getWorld() {
        return world;
    }
    

    
    
}
