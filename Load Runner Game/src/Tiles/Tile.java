package Tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {

    
//  Static Stuff Here
    
    public static Tile[] tiles=new Tile[256];
    public static Tile spaceTile = new SpaceTile(0);   // 0 is the keyWord to the space
    public static Tile rockTile = new RockTile(2);     // 2 is the keyWord to the rock
    public static Tile stairTile = new StairTile(4);   // 4 is the keyWord to the stair
    
    
    
//    CLASS
    protected BufferedImage texture;
    protected final  int id;
    public static final int TILEWIDTH = 64,
            TILEHEIGHT = 64;
    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    
    public boolean isSolid(){
        return false;
    }
    
    public boolean isStair(){
    return false;
    }
    
    public boolean isSpace(){
    return false;
    }
    
// getter

    public int getId() {
        return id;
    }




}
