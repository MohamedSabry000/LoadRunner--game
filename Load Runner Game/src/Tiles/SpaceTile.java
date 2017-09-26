package Tiles;

import gfx.Assets;
import java.awt.image.BufferedImage;

public class SpaceTile extends Tile {


    public SpaceTile(int id) {
        super(Assets.space, id);
    }

    
    
    @Override
   public boolean isSpace(){
    return true;
    }
}
