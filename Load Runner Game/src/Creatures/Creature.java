package Creatures;

import Entities.*;
import java.awt.Rectangle;
import javax.swing.Timer;
import tilegame.Handler;

public abstract class Creature extends Entity {

    private boolean activate;

    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_HEIGHT = 64,
            DEFAULT_CREATURE_WIDTH = 64;

    protected float speed,speedZomby;
    protected float xMove, yMove, xMoveZomby, yMoveZomby;

    public int sensorXup, sensorYup, sensorXdown, sensorYdown, sensorXleft, sensorYleft, sensorXright, sensorYright;
    public int sensorXupZ, sensorYupZ, sensorXdownZ, sensorYdownZ, sensorXleftZ, sensorYleftZ, sensorXrightZ, sensorYrightZ;
    Timer timer;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        speed = DEFAULT_SPEED;
        speedZomby = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        xMoveZomby = 0;
        yMoveZomby = 0;

    }
/**************************************  MOVE THE PLAYER  ****************************************/
    public void move() {
        if (!checkEntityCollision(xMove, 0f)) {
            moveX();
        }
        if (!checkEntityCollision(0f, yMove)) {
            moveY();
        }
    }

    public void moveX() {  // to permision to move in x axis
        if (xMove > 0) {//move right
            if (!(collisionWithTile(sensorXright, sensorYright))) {
                x += xMove;
            }
        } else if (xMove < 0) {//move left
            if (!collisionWithTile(sensorXleft, sensorYleft)) {
                x += xMove;
            }
        }

    }

    public void moveY() {// to permision to move in y axis
        if (yMove < 0) {//move up
            if (!(isSpace(sensorXdown, sensorYdown))&&!(collisionWithTile(sensorXup, sensorYup))) {
                y += yMove;
            } 
        } else if (yMove > 0) {//move down
            if (isStair(sensorXdown, sensorYdown)) {
                y += yMove;
            } 
        }
    }

    protected boolean collisionWithTile(int x, int y) { //to ensure that is  rock or not
        return handler.getWorld().getTile(x, y).isSolid();
    }

    protected boolean isStair(int x, int y) {
        return handler.getWorld().getTile(x, y).isStair();
    }

    protected boolean isSpace(int x, int y) {
        return handler.getWorld().getTile(x, y).isSpace();
    }
/****************************************************************************************************/
/*********************************  ZOMBY MOVEMENT  *************************************************/
    
    public void moveZomby() {
        moveX_Zomby();
        moveY_Zomby();
        
    }

    public void moveX_Zomby() {  // to permision to move in x axis
        if (xMoveZomby > 0) {//move right
            if (!(collisionWithTile(sensorXrightZ, sensorYrightZ))) {
                x += xMoveZomby;
            }
        } else if (xMoveZomby < 0) {//move left
            if (!collisionWithTile(sensorXleftZ, sensorYleftZ)) {
                x += xMoveZomby;
            }
        }

    }

    public void moveY_Zomby() {// to permision to move in y axis
        if (yMoveZomby < 0&&!isSpace(sensorXupZ, sensorYupZ)) {//move up
            if (!(isSpace(sensorXdownZ, sensorYdownZ))&&!(collisionWithTile(sensorXupZ, sensorYupZ))) {
                y += yMoveZomby;
            } 
        } else if (yMoveZomby > 0) {//move down
            if (isStair(sensorXdownZ, sensorYdownZ)) {
                y += yMoveZomby;
            } 
        }
    }
/***************************************************************************************************/
//Setters

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }
//Getters

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public float getSpeed() {
        return speed;
    }

    @Override
    public int getHealth() {
        return health;
    }
 

}
