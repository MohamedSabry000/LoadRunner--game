package Entities;

import Tiles.Tile;
import java.awt.Graphics;
import java.awt.Rectangle;
import tilegame.Game;
import tilegame.Handler;

public abstract class Entity {

    public static final int DEFAULT_HEALTH = 10;
    protected int health;
    protected boolean active;
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;

    public Entity(Handler handler, float x, float y, int width, int height) {

        health = DEFAULT_HEALTH;
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        active = true;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void die();

    public void hurt(int amt) {  // amt refer to the amount
        health -= amt;
        System.out.println("health     " +health);
        if (health <= 0) {
            
            active = false;
            die();
        }
    }

    public boolean checkEntityCollision(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntitiyManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

   
// Setters
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//getters
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHealth() {
        return health;
    }

    public boolean isActive() {
        return active;

    }

}
