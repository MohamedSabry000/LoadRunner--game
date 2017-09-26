package tilegame;

import gfx.SpriteSheet;
import gfx.Assets;
import Display.Display;
import Input.KeyManager;
import Input.MouseManager;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import States.*;
import States.GameState;
import gfx.GameCamera;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;


public class Game implements Runnable {
private boolean  sound=true;
private int counter=0;
    private Display display;  // main frame
    private int width, height;
    private String title;

    private Thread thread;
    private boolean running = false;

    public BufferStrategy bs;
    private BufferedImage testImage;
    private SpriteSheet sheet;
    private Graphics g;
    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    //States
    public State gameState;
    public MenuState menuState;
    //Camera
    private GameCamera gameCamera;
    //Handler
    private Handler handler;
    
    
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);
        
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);
    }
    public MediaPlayer md;
    private void tick() {
        
        keyManager.tick();
        
        if(State.getState() != null)
            State.getState().tick();
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear Screen
        
        g.clearRect(0, 0, width, height);
        //Draw Here
        
        
        if(State.getState() != null)
            State.getState().render(g);
        
        
        //End Drawing
        bs.show();
        g.dispose();

    }

    @Override
    public void run() {                     // THIS FUNCTION AS GAME CLASS IMPLEMENTS RUNNABLE    //THE FIRST STEP
        init();
        //fps ==>> frames per second
        int fps = 60;
        double timePerSecond = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerSecond;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;

            }

        }
        stop();
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }
    
    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
    
//--------------------------------------------Start & Stop----------------------//
// THRED CLASS MUST HAVE THESE FUNCTIONS  " I DON,T KNOW WHY "

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();   
            
   
        //IT IS ACTUALLY CALL FOE RUN METHOD
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
}
