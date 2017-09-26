package Entities.Statics;

import Entities.Entity;
import tilegame.Handler;

public abstract class StaticEntity extends Entity {   // this class Static that is mean can't movw like rocks & trees unlike creature entity which does move like player

    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }
     

}
