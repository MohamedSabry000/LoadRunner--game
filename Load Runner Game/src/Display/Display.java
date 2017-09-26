package Display;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Display extends JFrame {

    private JFrame frame;
    private String title;
    private int width, height;
    private Canvas canvas;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        
        createDisplay();
    }

    public void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        frame.add(canvas);
        frame.pack();
        
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;
        AudioPlayer MGP = AudioPlayer.player;
        try
        {
            BGM = new AudioStream(new FileInputStream("123.wav"));
           AudioPlayer.player.start(BGM);
            MD = BGM.getData();
           loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
        }
        catch(IOException error)
        {
        }
        MGP.start(loop);
   
        
    
        
        
    }
    public Canvas getCanvas(){
        return this.canvas;
    }
    
    public JFrame getFrame(){
        return frame;
    }

    public void setGameframe(boolean  x) {
        this.frame.setVisible(x);
    }
    
}
