package Creatures;

import Entities.Entity;
import Tiles.Tile;
import gfx.Animation;
import gfx.Assets;
import gfx.NextWorld;
import gfx.starter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import tilegame.Game;
import tilegame.Handler;

public class Player extends Creature {

    //Animation
    private Animation animDown, animUp, animRight, animLeft, anim_stand_up;
    private int boundsWidth,boundsHeight;

    //ATTACK TIMER
    private long lastAttackTimer, attackCoolDown = 800, attackTimer = attackCoolDown;     //800 mili Second
    
    //SCORE
    
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 0;
        bounds.width = 32;
        bounds.height = 63;
        boundsWidth=bounds.width;
        boundsHeight = bounds.height;
        //Animation
        anim_stand_up=new Animation(125, Assets.player_stand_up);
        animDown = new Animation(50, Assets.player_down);
        animUp = new Animation(50, Assets.player_up);
        animRight = new Animation(50, Assets.player_right);
        animLeft = new Animation(50, Assets.player_left);
        
    }
@Override
    public void die() {
       
        starter st=new starter(); 
                                   
    }
    @Override
    public void tick() {
        //Aniation
        anim_stand_up.tick();
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();
        
        sensorXdown= (int) (handler.getWorld().getEntitiyManager().getPlayer().getX()+Tile.TILEWIDTH/2)/Tile.TILEWIDTH;
        sensorYdown = (int) (handler.getWorld().getEntitiyManager().getPlayer().getY() + Tile.TILEHEIGHT)/Tile.TILEHEIGHT;
        
        sensorXup= (int) (handler.getWorld().getEntitiyManager().getPlayer().getX()+Tile.TILEWIDTH/2)/Tile.TILEWIDTH;
        sensorYup = (int) (handler.getWorld().getEntitiyManager().getPlayer().getY())/Tile.TILEHEIGHT;
        
        sensorXleft= (int) (handler.getWorld().getEntitiyManager().getPlayer().getX())/Tile.TILEWIDTH;
        sensorYleft = (int) (handler.getWorld().getEntitiyManager().getPlayer().getY() + Tile.TILEHEIGHT/2)/Tile.TILEHEIGHT;
        
        sensorXright= (int) (handler.getWorld().getEntitiyManager().getPlayer().getX()+Tile.TILEWIDTH)/Tile.TILEWIDTH;
        sensorYright = (int) (handler.getWorld().getEntitiyManager().getPlayer().getY() + Tile.TILEHEIGHT/2)/Tile.TILEHEIGHT;
        NO_WAY_TO_LIFE();
        if (isSpace(sensorXdown, sensorYdown)) {

                y += speed;
        }
        if(handler.getWorld().getEntitiyManager().getZomby().getX()==this.x&&handler.getWorld().getEntitiyManager().getZomby().getY()==this.y){
            this.die();
            
        }
        
        //movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);     // to make the camera zoom to the player and his place only 
        //ATTACK
        checkAttacks();
    }

    private void checkAttacks() {
     


        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCoolDown) {
            return;
        }
        Rectangle cb = getCollisionBounds(0, 0);    // cb refer to collision bounds according to the player   // 0,0 at the top of the player
        Rectangle ar = new Rectangle();             // ar refer to attack rectangle
        int arSize = 30;                                       // to make a hidden rectangle in the side of the player 
        ar.width = arSize;                                       // when this rectangle intersect with any entity
        ar.height = arSize;                                    // will call to a function to do the reaction

        if (handler.getKeyManager().aUp) {                    //in case of pressing on up button make a rectangle that 
            ar.x = cb.x + cb.width / 2 - arSize / 2;            // x axis = ar.x
            ar.y = cb.y - arSize / 2;                         // y axis = ar.y
        } else if (handler.getKeyManager().aDown) {            //in case of pressing on down button make a rectangle that   etc........ 
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (handler.getKeyManager().aLeft) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().aRight) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else {
            return;
        }

        attackTimer = 0;
        for (Entity e : handler.getWorld().getEntitiyManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(10);
                handler.getWorld().setScore(handler.getWorld().getScore()+100);
                
                return;
            }

        }   
    }

    

    protected void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
        if (handler.getKeyManager().deleteleft) {
            handler.getWorld().actionright();
        }
        if (handler.getKeyManager().deleteright) {
            handler.getWorld().actionleft();
        }
    }
 public void NO_WAY_TO_LIFE(){
        if((int)(((int)this.y)/width)>=17  ){
            die();
            
        }
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (this.x - handler.getGameCamera().getxOffset()), (int) (this.y - handler.getGameCamera().getyOffset()), width, height, null);
        g.setColor(Color.gray);
        g.fillRect(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, 40);
        g.setColor(Color.GREEN);
        Font font = new Font("serif", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("YOUR SCORE : " + handler.getWorld().getScore(), 600, 30);
        
        switch ( handler.getWorld().getScore()) {
            case 1500:
                handler.getWorld().setLevel(2);
                handler.getWorld().coins_players_zomby_position(2, "res/worlds/Worlds2.txt");
                handler.getWorld().setScore(1600) ;
                break;
            case 3000:
                handler.getWorld().setLevel(3);
                handler.getWorld().coins_players_zomby_position(3, "res/worlds/Worlds3.txt");
                handler.getWorld().setScore(3100) ;
                break;
            case 4500:
                handler.getWorld().setLevel(4);
                handler.getWorld().coins_players_zomby_position(4, "res/worlds/Worlds4.txt");
                handler.getWorld().setScore(4600) ;
                break;
        }

        // this will help me in collision detiction proplem with the player
//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),
//                (int)(y+bounds.y-handler.getGameCamera().getyOffset())
//                ,bounds.width,bounds.height);
        }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else if (yMove > 0) {
            return animDown.getCurrentFrame();
        }
        return anim_stand_up.getCurrentFrame();
    }
    
    //GETTER

    public int getBoundsWidth() {
        return boundsWidth;
    }

    public int getBoundsHeight() {
        return boundsHeight;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }


    
   

}
