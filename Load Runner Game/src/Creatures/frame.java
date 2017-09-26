/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creatures;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit;
import tilegame.Game;

/**
 *
 * @author laptop 1
 */
public class frame extends JFrame {

    private JButton btn1, btn2, btn3, btn4;
    private JLabel lb,lb1;
    private JPanel pn;
    private Font fn;
    private JFrame frame = new JFrame("Help");

    public frame() {
        setSize(1370, 720);
        setTitle("MY Game Menu");
        setResizable(false);int w=200;int h=150;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btn1 = new JButton("Start");
        btn2 = new JButton("Help");
        btn3 = new JButton("Contact Us");
        btn4 = new JButton("Exit");
       
        pn = new JPanel();
        lb = new JLabel();
       

        fn = new Font("Arial", Font.ITALIC, 25);
        pn.setLayout(null);
        pn.add(btn1);
        pn.add(btn2);
        pn.add(btn3);
        pn.add(btn4);
        
        btn1.setBounds(545, 200, 172, 75);
        

        btn2.setBounds(545, 300, 172, 75);
           //btn2.setIcon(new ImageI2con("help.jpg"));
        btn3.setBounds(545, 400, 172, 75);
        add(pn);
        btn4.setBounds(545, 500, 172, 75);
       
//           btn5.setBackground(Color.BLACK);
//           btn5.setForeground(Color.red);
btn1.setIcon(new ImageIcon("play.jpg"));
btn2.setIcon(new ImageIcon("hel.jpg"));
btn3.setIcon(new ImageIcon("like.jpg"));
btn4.setIcon(new ImageIcon("exite.jpg"));
        btn1.setFont(fn);
        btn2.setFont(fn);
        btn3.setFont(fn);
        btn4.setFont(fn);
        //  btn5.setFont(fn);
    
        lb.setBounds(600, 0, 1300, 720);
        pn.add(lb);
        //  lb.setBackground(Color.cyan);
        Image ime;
        File fi;
        fi = new File("133.png");
        try {
            ime = ImageIO.read(fi);
            Image newimage = ime.getScaledInstance(750, 666, Image.SCALE_AREA_AVERAGING);
            lb.setIcon((new ImageIcon(newimage)));
        } catch (IOException ex) {
            Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        lb1= new JLabel();
        lb1.setLayout(null);
      lb1.setBounds(0, 100, 500, 720);
          Image im;
        File f;
        f= new File("zo.png");
        try {
            im = ImageIO.read(f);
            Image newimage = im.getScaledInstance(600, 700, Image.SCALE_AREA_AVERAGING);
            lb1.setIcon((new ImageIcon(newimage)));
        } catch (IOException ex) {
            Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
        }
  
           pn.add(lb1); 
        pn.add(lb);
        pn.setBackground(Color.BLACK);
        
        setVisible(true);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
               
                 dispose();
              
                Game game = new Game("Title", 1366, 710);           
                game.start();
             
            

                // new Game(uri, WIDTH, HEIGHT);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFXPanel h = new JFXPanel();
                String uri;
                uri = new File("one.wav").toURI().toString();
                new MediaPlayer(new Media(uri)).play();
                
                Font font = new Font("serif", Font.BOLD, 100);
          
                frame.setSize(500, 720);

                JLabel label = new JLabel("you have to runaway from zombie  if they cath you you will die");

                JLabel a = new JLabel("move up               w");
                a.setBounds(5, 0, 500, 500);
                JLabel b = new JLabel("move down          s");
                b.setBounds(5, 20, 500, 500);
                JLabel c = new JLabel("move right            d");
                c.setBounds(5, 35, 500, 500);
                JLabel d = new JLabel("move left              a");
                d.setBounds(5, 55, 500, 500);
                JLabel ff = new JLabel();
                Image ime;
                File fi;
                fi = new File("122.png");
                try {
                    ime = ImageIO.read(fi);
                    Image newimage = ime.getScaledInstance(300, 720, Image.SCALE_AREA_AVERAGING);
                    ff.setIcon((new ImageIcon(newimage)));
                } catch (IOException ex) {
                    Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ff.setLayout(null);

                JPanel panel = new JPanel();
                panel.add(label);
                panel.setLayout(null);
                ff.setBounds(0, 0, 300, 720);
                panel.add(ff);
                a.setForeground(Color.red);
                b.setForeground(Color.red);
                c.setForeground(Color.red);
                d.setForeground(Color.red);
                ff.add(a);
                ff.add(b);
                ff.add(c);
                ff.add(d);
                panel.add(ff);
                panel.setLayout(null);
                panel.setBackground(Color.lightGray);
                panel.add(label);
                panel.setFont(font);

                frame.add(panel);
                frame.setLocation(1070, 0);
                // frame.setLocationRelativeTo(null);
                frame.setVisible(true);
              
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFXPanel h = new JFXPanel();
                String uri;
                // Font fo=new Font("Arial", Font.ITALIC, 100);
                uri = new File("one.wav").toURI().toString();
                new MediaPlayer(new Media(uri)).play();
                frame.setVisible(false);

                System.exit(0);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFXPanel h = new JFXPanel();
                frame.setVisible(false);
                String uri;
                uri = new File("one.wav").toURI().toString();
                new MediaPlayer(new Media(uri)).play();
                File html = new File("mohamed.html");
                try {
                    Desktop.getDesktop().browse(html.toURI());
                } catch (IOException ex) {
                    Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

}
