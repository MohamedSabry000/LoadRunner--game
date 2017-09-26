
package Tiles;
import gfx.Assets;
import java.awt.image.BufferedImage;

public class StairTile extends Tile{
    
    public StairTile( int id) {
        super(Assets.stair, id);
    }
@Override
    public boolean isStair() {
        return true;
    }
    
}
