package gfx;

import Worlds.World;
import java.awt.image.BufferedImage;
import tilegame.Handler;

public class Assets {

    private static final int width = 64, height = 64;
    public static BufferedImage space_run,space, tree, dirt,rock,stair;
    
    public static BufferedImage[] player_down, player_up, player_right, player_left,player_stand_up;
    public static BufferedImage[] zompy_down, zompy_up, zompy_right, zompy_left,zompy_stand_up;
    public static BufferedImage[] zombie_down, zombie_up, zombie_right, zombie_left;
    
    public static BufferedImage[] coin;
    public static BufferedImage[] btn_start;
    public static int w;
public static BufferedImage stone;
    public static void init() {
            double x=Math.random()*3;
             w=(int)x;
            
        //  SPACE 
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/texture/space.jpg"));
        space = sheet.crop(0, 0, width, height);
        //  SPACE CAN'T RUN ON
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/space.jpg"));
        space_run = sheet.crop(0, 0, width, height);
        //  STONE FOR THE WALL THAT CAN'T BE BROCKEN
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/stone-"+(w)+".png"));
        stone = sheet.crop(0, 0, width, height);

        //STAIRS
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/stairs/stair.png"));
        stair = sheet.crop(0, 0, width, height);
        
        //COINS
        coin = new BufferedImage[8];
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/coins/coin1.png"));
        coin[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/coins/coin2.png"));
        coin[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/coins/coin3.png"));
        coin[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/coins/coin4.png"));
        coin[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/coins/coin5.png"));
        coin[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/coins/coin6.png"));
        coin[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/coins/coin7.png"));
        coin[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/coins/coin8.png"));
        coin[7] = sheet.crop(0, 0, width, height);
        // PLAYER
        player_stand_up = new BufferedImage[13];
        player_down = new BufferedImage[8];
        player_up = new BufferedImage[8];
        player_right = new BufferedImage[8];
        player_left = new BufferedImage[8];
                                                                                        // PLAYER STAND UP 
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p1.png"));
        player_stand_up[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p2.png"));
        player_stand_up[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p3.png"));
        player_stand_up[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p4.png"));
        player_stand_up[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p5.png"));
        player_stand_up[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p6.png"));
        player_stand_up[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p7.png"));
        player_stand_up[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p8.png"));
        player_stand_up[7] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p9.png"));
        player_stand_up[8] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p10.png"));
        player_stand_up[9] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p11.png"));
        player_stand_up[10] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p12.png"));
        player_stand_up[11] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_stand_up/p13.png"));
        player_stand_up[12] = sheet.crop(0, 0, width, height);

                                                                                                //PLAYER UP
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_up/p1.png"));
        player_up[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_up/p2.png"));
        player_up[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_up/p3.png"));
        player_up[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_up/p4.png"));
        player_up[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_up/p5.png"));
        player_up[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_up/p6.png"));
        player_up[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_up/p7.png"));
        player_up[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_up/p8.png"));
        player_up[7] = sheet.crop(0, 0, width, height);
        
                                                                                                 //PLAYER DOWN
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_down/p1.png"));
        player_down[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_down/p2.png"));
        player_down[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_down/p3.png"));
        player_down[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_down/p4.png"));
        player_down[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_down/p5.png"));
        player_down[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_down/p6.png"));
        player_down[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_down/p7.png"));
        player_down[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_down/p8.png"));
        player_down[7] = sheet.crop(0, 0, width, height);
                                                                                                //PLAYER RUNNING RIGHT
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_right/P1.png"));
        player_right[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_right/P2.png"));
        player_right[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_right/P3.png"));
        player_right[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_right/P4.png"));
        player_right[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_right/P5.png"));
        player_right[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_right/P6.png"));
        player_right[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_right/P7.png"));
        player_right[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_right/P8.png"));
        player_right[7] = sheet.crop(0, 0, width, height);
                                                                                                //PLAYER RUNNING LEFT
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_left/p1.png"));
        player_left[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_left/p2.png"));
        player_left[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_left/p3.png"));
        player_left[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_left/p4.png"));
        player_left[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_left/p5.png"));
        player_left[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_left/p6.png"));
        player_left[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_left/p7.png"));
        player_left[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/player_running_left/p8.png"));
        player_left[7] = sheet.crop(0, 0, width, height);
 
        /*##########################################################################################################*/
        
        zompy_stand_up = new BufferedImage[12];
        zompy_down = new BufferedImage[8];
        zompy_up = new BufferedImage[8];
        zompy_right = new BufferedImage[8];
        zompy_left = new BufferedImage[8];
                                                                                        // PLAYER STAND UP 
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p1.png"));
        zompy_stand_up[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p2.png"));
        zompy_stand_up[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p3.png"));
        zompy_stand_up[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p4.png"));
        zompy_stand_up[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p5.png"));
        zompy_stand_up[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p6.png"));
        zompy_stand_up[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p7.png"));
        zompy_stand_up[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p8.png"));
        zompy_stand_up[7] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p9.png"));
        zompy_stand_up[8] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p10.png"));
        zompy_stand_up[9] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p11.png"));
        zompy_stand_up[10] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_stand_up/p12.png"));
        zompy_stand_up[11] = sheet.crop(0, 0, width, height);

                                                                                                //PLAYER UP
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_up/p1.png"));
        zompy_up[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_up/p2.png"));
        zompy_up[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_up/p3.png"));
        zompy_up[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_up/p4.png"));
        zompy_up[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_up/p5.png"));
        zompy_up[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_up/p6.png"));
        zompy_up[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_up/p7.png"));
        zompy_up[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_up/p8.png"));
        zompy_up[7] = sheet.crop(0, 0, width, height);
        
                                                                                                 //PLAYER DOWN
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_down/p1.png"));
        zompy_down[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_down/p2.png"));
        zompy_down[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_down/p3.png"));
        zompy_down[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_down/p4.png"));
        zompy_down[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_down/p5.png"));
        zompy_down[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_down/p6.png"));
        zompy_down[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_down/p7.png"));
        zompy_down[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_down/p8.png"));
        zompy_down[7] = sheet.crop(0, 0, width, height);
                                                                                                //PLAYER RUNNING RIGHT
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_right/P1.png"));
        zompy_right[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_right/P2.png"));
        zompy_right[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_right/P3.png"));
        zompy_right[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_right/P4.png"));
        zompy_right[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_right/P5.png"));
        zompy_right[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_right/P6.png"));
        zompy_right[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_right/P7.png"));
        zompy_right[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_right/P8.png"));
        zompy_right[7] = sheet.crop(0, 0, width, height);
                                                                                                //PLAYER RUNNING LEFT
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_left/p1.png"));
        zompy_left[0] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_left/p2.png"));
        zompy_left[1] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_left/p3.png"));
        zompy_left[2] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_left/p4.png"));
        zompy_left[3] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_left/p5.png"));
        zompy_left[4] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_left/p6.png"));
        zompy_left[5] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_left/p7.png"));
        zompy_left[6] = sheet.crop(0, 0, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage("/texture/zompy_running_left/p8.png"));
        zompy_left[7] = sheet.crop(0, 0, width, height);
 
    }

    
}
