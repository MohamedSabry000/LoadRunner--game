package Entities;

import Creatures.Zomby;
import Creatures.Player;
import Entities.Statics.Coin;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import tilegame.Handler;

public class EntitiyManager { //To Manage every tree in a game ,every rock in a game , every thing in a game , and the player in the game 

    private Handler handler;
    private Player player;
    private Zomby zomby;
    private Coin coin;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if (a.getY() + a.getHeight() < b.getY()) {
                return -1;
            }
            return 1;
        }

    };

    public EntitiyManager(Handler handler, Player player, Zomby zomby) {
        this.handler = handler;
        this.player = player;
        this.zomby = zomby;
        entities = new ArrayList<Entity>();
        addEntity(player);

    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
            if (!e.isActive()) {
                entities.remove(e);
            }
        }
        player.tick();
    }

    public void render(Graphics g) {
        for (Entity e : entities) {   // this statement is  more efficient "it is like ordinary for loop " like in tick method
            e.render(g);
        }
        player.render(g);
    }

    public void addEntity(Entity e) {
        entities.add(e);

    }
//setter

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void setZomby(Zomby zomby) {
        this.zomby = zomby;
    }

// getter
    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Zomby getZomby() {
        return zomby;
    }
public Coin getCoin(){
    return coin;
}
}
