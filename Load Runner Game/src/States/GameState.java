package States;

import java.awt.Graphics;
import Creatures.*;
import Tiles.Tile;
import Worlds.World;
import tilegame.*;

public class GameState extends State {

    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/worlds/Worlds1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

}
