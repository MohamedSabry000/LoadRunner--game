package Worlds;

import Creatures.Player;
import Tiles.Tile;
import Utils.Utils;
import java.awt.Graphics;
import tilegame.Handler;
import Entities.EntitiyManager;
import Entities.Statics.Coin;
import Creatures.Zomby;
import gfx.Assets;

public final class World {

    private final Handler handler;
    private int width, height;
    private int[][] tiles;
    private int spawnX, spawnY;
    private int level, score;
    String[] toakens;
    //ENTITIES
    private EntitiyManager entitiyManager;

    public World(Handler handler, String path) {
        level = 1;
        score = 0;
        this.handler = handler;

        // POSITION OF COINS & PLAYER & ZOMBIES
        coins_players_zomby_position(level, path);

        entitiyManager.getPlayer().setX(spawnX);   // position of the player
        entitiyManager.getPlayer().setY(spawnY);
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);      // all of come code as i can draw my grphics from a file content 
        // from class World , Worlds1.txt file , Utils
        toakens = file.split("\\s+");
        width = Utils.parseInt(toakens[0]);
        height = Utils.parseInt(toakens[1]);
        spawnX = Utils.parseInt(toakens[2]);
        spawnY = Utils.parseInt(toakens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (bricks[x][y] == 0) {
                    tiles[x][y] = Utils.parseInt(toakens[(x + y * width) + 4]);
                }
            }
        }
    }
    int bricks[][] = new int[30][19];

    public void actionleft() {

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {                  // draw bricks and stairs
            for (int x = 0; x < width; x++) {
                if (bricks[x][y] == 0) {
                    tiles[x][y] = Utils.parseInt(toakens[(x + y * width) + 4]);
                    int i = (int) (handler.getWorld().getEntitiyManager().getPlayer().getY() + handler.getWorld().getEntitiyManager().getPlayer().getBoundsHeight());
                    int j = (int) (handler.getWorld().getEntitiyManager().getPlayer().getX() + handler.getWorld().getEntitiyManager().getPlayer().getBoundsWidth());
                    i++;
                    j++;
                    bricks[(j / Tile.TILEWIDTH) + 1][(i / Tile.TILEHEIGHT)] = 1;
                    tiles[(j / Tile.TILEWIDTH) + 1][(i / Tile.TILEHEIGHT)] = 0;
                }
                bricks[x][y] = 0;
            }
        }
    }

    public void actionright() {

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {                  // draw bricks and stairs
            for (int x = 0; x < width; x++) {
                if (bricks[x][y] == 0) {
                    tiles[x][y] = Utils.parseInt(toakens[(x + y * width) + 4]);
                    int i = (int) (handler.getWorld().getEntitiyManager().getPlayer().getY() + handler.getWorld().getEntitiyManager().getPlayer().getBoundsHeight());
                    int j = (int) (handler.getWorld().getEntitiyManager().getPlayer().getX() + handler.getWorld().getEntitiyManager().getPlayer().getBoundsWidth());
                    i++;
                    j++;
                    bricks[(j / Tile.TILEWIDTH) - 1][(i / Tile.TILEHEIGHT)] = 1;
                    tiles[(j / Tile.TILEWIDTH) - 1][(i / Tile.TILEHEIGHT)] = 0;
                }
                bricks[x][y] = 0;
            }
        }
    }
//SETTER

    public void setScore(int score) {
        this.score = score;
    }

    //GETTER
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntitiyManager getEntitiyManager() {
        return entitiyManager;
    }

    public int getScore() {
        return score;
    }

    public void tick() {
        entitiyManager.tick();
    }

    public void render(Graphics g) {
        
        //to more perfect "this program you can't guss which device can play in "its screen width , its screen height etc..""
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH),
                xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT),
                yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        //  ENTITIES
        entitiyManager.render(g);
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.spaceTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];

        if (t == null) {
            return Tile.spaceTile;
        }

        return t;
    }

    //SETTERS
    public void setLevel(int level) {
        this.level = level;
    }

    //*************&&&&&&&&&&&&&&&&***************** LEVELS ********************&&&&&&&&&&&&&&&&&&&********************//
    public void coins_players_zomby_position(int x, String path) {

        loadWorld(path);
        switch (x) {
            case 1:
                //*************************LEVEL 1 **************************//
                //PLAYER POSITION
                entitiyManager = new EntitiyManager(handler, new Player(handler, 0, 0), new Zomby(handler, 64, 256));
                entitiyManager.addEntity(new Zomby(handler, 128, 640));
                entitiyManager.addEntity(new Zomby(handler, 1668, 1024));
                entitiyManager.addEntity(new Zomby(handler, 64, 64));
                entitiyManager.addEntity(new Zomby(handler, 1412, 448));

                //COINS POSITION
                entitiyManager.addEntity(new Coin(handler, 310, 1024));
                entitiyManager.addEntity(new Coin(handler, 512, 64));
                entitiyManager.addEntity(new Coin(handler, 900, 1024));
                entitiyManager.addEntity(new Coin(handler, 1092, 832));
                entitiyManager.addEntity(new Coin(handler, 128, 640));
                entitiyManager.addEntity(new Coin(handler, 1668, 1024));
                entitiyManager.addEntity(new Coin(handler, 1156, 192));
                entitiyManager.addEntity(new Coin(handler, 836, 64));
                entitiyManager.addEntity(new Coin(handler, 64, 448));
                entitiyManager.addEntity(new Coin(handler, 1092, 640));
                entitiyManager.addEntity(new Coin(handler, 1732, 832));
                entitiyManager.addEntity(new Coin(handler, 1412, 448));
                entitiyManager.addEntity(new Coin(handler, 1540, 256));
                entitiyManager.addEntity(new Coin(handler, 1348, 640));
                entitiyManager.addEntity(new Coin(handler, 644, 768));
                /*--------------------------------------------------------------*/
                //ZOMBY POSITION///////////////////////////////////////
//                entitiyManager.addEntity(new Zomby(handler, 64, 64));

                break;
            case 2:
                //*************************LEVEL 2 **************************//
                //PLAYER POSITION
                entitiyManager = new EntitiyManager(handler, new Player(handler, 256, 64), new Zomby(handler, 64, 256));
                //COINS POSITION
                entitiyManager.addEntity(new Coin(handler, (5 * 64), 64));
                entitiyManager.addEntity(new Coin(handler, (20 * 64), 64));
                entitiyManager.addEntity(new Coin(handler, (1 * 64), (4 * 64)));
                entitiyManager.addEntity(new Coin(handler, (5 * 64), (4 * 64)));
                entitiyManager.addEntity(new Coin(handler, (11 * 64), (4 * 64)));
                entitiyManager.addEntity(new Coin(handler, (28 * 64), (4 * 64)));
                entitiyManager.addEntity(new Coin(handler, (5 * 64), (7 * 64)));
                entitiyManager.addEntity(new Coin(handler, (18 * 64), (7 * 64)));
                entitiyManager.addEntity(new Coin(handler, (9 * 64), (9 * 64)));
                entitiyManager.addEntity(new Coin(handler, (19 * 64), (10 * 64)));
                entitiyManager.addEntity(new Coin(handler, (1 * 64), (13 * 64)));
                entitiyManager.addEntity(new Coin(handler, (28 * 64), (13 * 64)));
                entitiyManager.addEntity(new Coin(handler, (18 * 64), (12 * 64)));
                entitiyManager.addEntity(new Coin(handler, (1 * 64), (15 * 64)));
                entitiyManager.addEntity(new Coin(handler, (28 * 64), (16 * 64)));

                //ZOMBY POSITION
                entitiyManager.addEntity(new Zomby(handler, 128, 640));
                entitiyManager.addEntity(new Zomby(handler, 1668, 1024));
                entitiyManager.addEntity(new Zomby(handler, 64, 64));
                entitiyManager.addEntity(new Zomby(handler, 1412, 448));

                break;
            case 3:
                //*************************LEVEL 2 **************************//
                //PLAYER POSITION
                entitiyManager = new EntitiyManager(handler, new Player(handler, 256, 64), new Zomby(handler, 64, 256));
                //COINS POSITION
                entitiyManager.addEntity(new Coin(handler, 310, 1024));
                entitiyManager.addEntity(new Coin(handler, 64, 64));
                entitiyManager.addEntity(new Coin(handler, 900, 1024));
                entitiyManager.addEntity(new Coin(handler, 1092, 832));
                entitiyManager.addEntity(new Coin(handler, 128, 640));
                entitiyManager.addEntity(new Coin(handler, 1668, 1024));
                entitiyManager.addEntity(new Coin(handler, 1156, 192));
                entitiyManager.addEntity(new Coin(handler, 836, 64));
                entitiyManager.addEntity(new Coin(handler, 64, 448));
                entitiyManager.addEntity(new Coin(handler, 1092, 640));
                entitiyManager.addEntity(new Coin(handler, 1732, 832));
                entitiyManager.addEntity(new Coin(handler, 1412, 448));
                entitiyManager.addEntity(new Coin(handler, 1540, 256));
                entitiyManager.addEntity(new Coin(handler, 1348, 640));
                entitiyManager.addEntity(new Coin(handler, 644, 768));

                //ZOMBY POSITION
                entitiyManager.addEntity(new Zomby(handler, 64, 630));
                entitiyManager.addEntity(new Zomby(handler, 300, 630));

                entitiyManager.addEntity(new Zomby(handler, 64, 256));
                entitiyManager.addEntity(new Zomby(handler, 300, 630));

                break;
            case 4:
                //*************************LEVEL 2 **************************//
                //PLAYER POSITION
                entitiyManager = new EntitiyManager(handler, new Player(handler, 256, 64), new Zomby(handler, 64, 256));
                //COINS POSITION
                entitiyManager.addEntity(new Coin(handler, 310, 1024));
                entitiyManager.addEntity(new Coin(handler, 64, 64));
                entitiyManager.addEntity(new Coin(handler, 900, 1024));
                entitiyManager.addEntity(new Coin(handler, 1092, 832));
                entitiyManager.addEntity(new Coin(handler, 128, 640));
                entitiyManager.addEntity(new Coin(handler, 1668, 1024));
                entitiyManager.addEntity(new Coin(handler, 1156, 192));
                entitiyManager.addEntity(new Coin(handler, 836, 64));
                entitiyManager.addEntity(new Coin(handler, 64, 448));
                entitiyManager.addEntity(new Coin(handler, 1092, 640));
                entitiyManager.addEntity(new Coin(handler, 1732, 832));
                entitiyManager.addEntity(new Coin(handler, 1412, 448));
                entitiyManager.addEntity(new Coin(handler, 1540, 256));
                entitiyManager.addEntity(new Coin(handler, 1348, 640));
                entitiyManager.addEntity(new Coin(handler, 644, 768));

                //ZOMBY POSITION
                entitiyManager.addEntity(new Zomby(handler, 64, 630));
                entitiyManager.addEntity(new Zomby(handler, 300, 630));

                entitiyManager.addEntity(new Zomby(handler, 64, 256));
                entitiyManager.addEntity(new Zomby(handler, 300, 630));

                break;

        }
    }

}
