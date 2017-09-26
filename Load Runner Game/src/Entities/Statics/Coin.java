package Entities.Statics;

import Tiles.Tile;
import gfx.Animation;
import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import tilegame.Handler;

public class Coin extends StaticEntity {
private Animation coin;

    public Coin(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);
        
        coin=new Animation(125, Assets.coin);
    }

    @Override
    public void tick() {
        coin.tick();
        if(this.x/64==handler.getWorld().getEntitiyManager().getPlayer().getX()/64&&
               ( this.y/64)==(int)((handler.getWorld().getEntitiyManager().getPlayer().getY())/64)){
        
          
            handler.getWorld().getEntitiyManager().getEntities().remove(this);
            handler.getWorld().setScore(handler.getWorld().getScore() +100);
        }
       if((int)this.x/64-(int)handler.getWorld().getEntitiyManager().getPlayer().getX()/64>-2&&
               (int)this.x/64-(int)handler.getWorld().getEntitiyManager().getPlayer().getX()/64<2&&
               (int)( (int)this.y/64)==(int)(((int)handler.getWorld().getEntitiyManager().getPlayer().getY())/64)){
        
          
            handler.getWorld().getEntitiyManager().getEntities().remove(this);
            handler.getWorld().setScore(handler.getWorld().getScore() +100);
        }
        
    }

    @Override
    public void render(Graphics g) {
        
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    g.setColor(Color.red);
    g.drawString(String.valueOf((int)this.x/64), 100, 30);
        g.drawString(String.valueOf((int)( (int)this.y/64)), 800, 30);

     g.drawString(String.valueOf((int)handler.getWorld().getEntitiyManager().getPlayer().getX()/64), 150, 30);
         g.drawString(String.valueOf((int)(((int)handler.getWorld().getEntitiyManager().getPlayer().getY())/64)), 850, 30);

    }

    @Override
    public void die() {
    }

    private BufferedImage getCurrentAnimationFrame() {
        return coin.getCurrentFrame();
    }
 




    
}
