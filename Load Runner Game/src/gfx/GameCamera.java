package gfx;

import Entities.Entity;
import Tiles.Tile;
import tilegame.Game;
import tilegame.Handler;

public class GameCamera {

    private Handler handler;
    private float xOffset, yOffset;         // to move the camera 
                                            // makes the square for an example move

    public GameCamera(Handler handler,float xOffset, float yOffset) {

        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    public void checkBlankSpace(){
        if(xOffset<0)                           //this method is to avoid the Camera from the white Space around the screen
            xOffset=0;
        else if(xOffset>handler.getWorld().getWidth()* Tile.TILEWIDTH-handler.getWidth()){
            xOffset=handler.getWorld().getWidth()* Tile.TILEWIDTH-handler.getWidth();
        }
        if(yOffset<0)
            yOffset=0;
        else if(yOffset>handler.getWorld().getHeight()* Tile.TILEHEIGHT-handler.getHeight()){
            yOffset=handler.getWorld().getHeight()* Tile.TILEHEIGHT-handler.getHeight();
        }
    }
    
    public void centerOnEntity (Entity e){
        xOffset = e.getX()-handler.getWidth() / 2 + e.getWidth()/2;           // to make x offset = the place of the entity(player) - the Screen width divided by 2 to be at the center of the width of the Screen
        yOffset = e.getY()-handler.getHeight() / 2 + e.getHeight() /2;          // to make y offset = the place of the entity(player) - the Screen height divided by 2 to be at the center of the height of the Screen
        checkBlankSpace();
    }

    public void move(Game game, float xAmount, float yAmount) {            // there are here game object to make the camera with th entity (player) all time
        xOffset += xAmount;
        yOffset += yAmount;
        checkBlankSpace();
    }

// setters
    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
// getters

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

}
