package Creatures;

import Tiles.Tile;
import gfx.Animation;
import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Random;
import tilegame.Handler;

public class Zomby extends Creature {

    private int id;
    private Animation animDown, animUp, animRight, animLeft, anim_stand_up;
    private int sign;
    private int randoming;
    private float Altx, Alty;
    Random r = new Random();
    private long timing;

    public Zomby(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 8;
        bounds.y = 7;
        bounds.width = 40;
        bounds.height = 64;
        this.id = 1;
        //Animation
        anim_stand_up = new Animation(125, Assets.zompy_stand_up);
        animDown = new Animation(50, Assets.zompy_down);
        animUp = new Animation(50, Assets.zompy_up);
        animRight = new Animation(50, Assets.zompy_right);
        animLeft = new Animation(50, Assets.zompy_left);
        Altx = x;
        Alty = y;
        this.sign = 0;
        this.timing = 0;

    }

    @Override
    public void tick() {
        Altx = this.x;
        Alty = this.y;
        anim_stand_up.tick();
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();

        sensorXdownZ = (int) (this.x + Tile.TILEWIDTH / 2) / Tile.TILEWIDTH;
        sensorYdownZ = (int) (this.y + Tile.TILEHEIGHT) / Tile.TILEHEIGHT;

        sensorXupZ = (int) (this.x + Tile.TILEWIDTH / 2) / Tile.TILEWIDTH;
        sensorYupZ = (int) (this.y) / Tile.TILEHEIGHT;

        sensorXleftZ = (int) (this.x) / Tile.TILEWIDTH;
        sensorYleftZ = (int) (this.y + Tile.TILEHEIGHT / 2) / Tile.TILEHEIGHT;

        sensorXrightZ = (int) (this.x + Tile.TILEWIDTH) / Tile.TILEWIDTH;
        sensorYrightZ = (int) (this.y + Tile.TILEHEIGHT / 2) / Tile.TILEHEIGHT;
        if (handler.getWorld().getEntitiyManager().getPlayer().getX() == this.x && handler.getWorld().getEntitiyManager().getPlayer().getY() == this.y) {
            handler.getWorld().getEntitiyManager().getPlayer().die();
        }
        if (isSpace(sensorXdownZ, sensorYdownZ) && this.id != 0) {
            y += speedZomby;
            die();
        }
        if(sensorXleftZ==handler.getWorld().getEntitiyManager().getPlayer().sensorXleft&&sensorYrightZ==handler.getWorld().getEntitiyManager().getPlayer().sensorYright)
        {
            handler.getWorld().getEntitiyManager().getPlayer().die();
        }
        //movement
        System.err.println(sign);
        if (this.id != 0) {
            direction(sign);
        }
        handler.getGameCamera().centerOnEntity(this);     // to make the camera zoom to the player and his place only 
        if (this.timing < 300 && this.id == 0) {
            timing++;
        } else if (this.id == 0 && this.timing >= 300) {
            back_place();
        }
    }

    protected void direction(int sign) {
        if (this.id != 0) {
            switch (sign) {
                case 0:
                    getInput();
                    moveZomby();
                    break;
                case 1:
                    if (collisionWithTile(sensorXleftZ, sensorYleftZ) || (isStair(sensorXleftZ, sensorYleftZ)) || isSpace(sensorXdownZ, sensorYdownZ)) {
                        this.sign = 0;
                    } else if (!(isStair(sensorXleftZ, sensorYleftZ))) {
                        animRight.getCurrentFrame();
                        x -= 3;
                    } else if (!(collisionWithTile(sensorXleftZ, sensorYleftZ))) {
                        animRight.getCurrentFrame();
                        x -= 3;
                    }
                    break;
                case 2:
                    if (collisionWithTile(sensorXrightZ, sensorYrightZ) || (isStair(sensorXleftZ, sensorYleftZ)) || isSpace(sensorXdownZ, sensorYdownZ)) {
                        this.sign = 0;
                    } else if (!(isStair(sensorXrightZ, sensorYrightZ))) {
                        animLeft.getCurrentFrame();
                        x += 3;
                    } else if (!(collisionWithTile(sensorXrightZ, sensorYrightZ))) {
                        animLeft.getCurrentFrame();
                        x += 3;
                    }
                    break;
            }
            if ((int) Altx == (int) this.x && (int) Alty == (int) y && handler.getWorld().getTile(sensorXdownZ, sensorYdownZ).getId() == 2 && !isStair(sensorXdownZ, sensorYdownZ) && !isStair((int) this.x, (int) this.y) && !isStair(sensorXupZ, sensorYupZ) && !isStair(sensorXrightZ, sensorYrightZ) && !isStair(sensorXleftZ, sensorYleftZ)) {
                stop_place();
            }
        }
    }

    protected void getInput() {
        if (this.id != 0) {
            if ((int) this.y / 64 >= 17) {
                stop_place();
                return;
            }
            if (handler.getWorld().getEntitiyManager().getPlayer().getX() == this.x) {
                if (handler.getWorld().getEntitiyManager().getPlayer().getY() == this.y) {
                    handler.getWorld().getEntitiyManager().getPlayer().die();
                } else if (r.nextInt(2) % 2 == 0) {

                    this.sign = 1;
                } else {
                    this.sign = 2;
                }
            } else if (handler.getWorld().getTile(sensorXrightZ, sensorYrightZ).getId() == 2 && !isStair((int) x, (int) y) && !isStair(sensorXleftZ, sensorYleftZ) && !isStair(sensorXdownZ, sensorYdownZ) && !isStair(sensorXupZ, sensorYupZ) && handler.getWorld().getTile(sensorXdownZ, sensorYdownZ).getId() != 2) {
                stop_place();
                return;
            } else if (isSpace(sensorXupZ, sensorYupZ) && isSpace(sensorXdownZ, sensorYdownZ) && handler.getWorld().getTile(sensorXleftZ, sensorYleftZ).getId() == 2 && handler.getWorld().getTile(sensorXrightZ, sensorYrightZ).getId() == 2) {
                stop_place();
                return;
            } else if (collisionWithTile(sensorXdownZ, sensorYdownZ) && collisionWithTile(sensorXleftZ, sensorYleftZ) && collisionWithTile(sensorXrightZ, sensorYrightZ) && !isSpace(sensorXdownZ, sensorYdownZ) && !isSpace(sensorXleftZ, sensorYleftZ) && !isSpace(sensorXrightZ, sensorYrightZ)) {
                stop_place();
                return;

            } else if (handler.getWorld().getTile(sensorXdownZ, sensorYdownZ).getId() == 2 && handler.getWorld().getTile(sensorXleftZ, sensorYleftZ).getId() == 2 && handler.getWorld().getTile(sensorXrightZ, sensorYrightZ).getId() == 2) {
                stop_place();
                return;
            }
            if (isStair(sensorXrightZ, sensorYleftZ) || (isStair((int) this.x, (int) this.y) && isSpace(sensorXupZ, sensorYupZ))) {
                this.yMoveZomby = -speed;
                for (int i = 0; i < 8; i++) {
                    this.y += yMoveZomby;
                    for (int o = 0; o < 2; o++) {
                        this.y += 1;
                    }
                }
            }
            if (isStair((int) this.x, (int) this.y) && isSpace(sensorXleftZ, sensorYleftZ) && this.x > handler.getWorld().getEntitiyManager().getPlayer().getX()) {
                yMoveZomby = -speed;
                this.y += yMoveZomby;
            }
            if (isStair((int) this.x, (int) this.y) && isSpace(sensorXrightZ, sensorYrightZ) && this.x < handler.getWorld().getEntitiyManager().getPlayer().getX()) {
                yMoveZomby = speed;
                this.y += yMoveZomby;
            }
            if (handler.getWorld().getEntitiyManager().getPlayer().getY() < this.y) {
                this.yMoveZomby = -speed;
            }
            if (handler.getWorld().getEntitiyManager().getPlayer().getY() > this.y) {
                this.yMoveZomby = speed;
            }
            if (handler.getWorld().getEntitiyManager().getPlayer().getX() < this.x) {
                this.xMoveZomby = -speed;
            }
            if (handler.getWorld().getEntitiyManager().getPlayer().getX() > this.x) {
                this.xMoveZomby = speed;
            }

            if (handler.getWorld().getEntitiyManager().getPlayer().getX() >= Toolkit.getDefaultToolkit().getScreenSize().height - 2 * Tile.TILEHEIGHT) {
                anim_stand_up.getCurrentFrame();
            }
            if (handler.getWorld().getEntitiyManager().getPlayer().getX() == this.x && handler.getWorld().getEntitiyManager().getPlayer().getY() == this.y) {
                this.sign = 0;
                this.xMoveZomby = 0;
                this.yMoveZomby = 0;
            }
        } else {
            yMoveZomby = 0;
            xMoveZomby = 0;
        }

    }

    private void stop_place() {

        this.yMoveZomby = 0;
        this.xMoveZomby = 0;
        this.bounds.width = 80;
        this.bounds.height = 60;

        this.id = 0;

        this.y += 22;
        this.yMoveZomby = 0;
        anim_stand_up.getCurrentFrame();
        this.xMoveZomby = 0;

    }

    private void back_place() {

        this.bounds.width = 40;
        this.bounds.height = 63;
        this.timing = 0;
        this.id = 1;
        if (this.x > handler.getWorld().getEntitiyManager().getPlayer().getX()) {
            this.x -= 90;
            this.y -= 64;
        } else if (this.x < handler.getWorld().getEntitiyManager().getPlayer().getX()) {
            this.x += 90;
            this.y -= 64;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    public int getId() {
        return this.id;
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMoveZomby < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMoveZomby > 0) {
            return animRight.getCurrentFrame();
        } else if (yMoveZomby < 0) {
            return animUp.getCurrentFrame();
        } else if (yMoveZomby > 0) {
            return animDown.getCurrentFrame();
        } else {
            return anim_stand_up.getCurrentFrame();
        }
    }

    @Override
    public void die() {
//        System.err.println("Zomby die");
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

}
