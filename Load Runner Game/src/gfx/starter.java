/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import Creatures.frame;
import Display.Display;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tilegame.Game;
import tilegame.Handler;

/**
 *
 * @author moham
 */
public class starter extends JFrame {

    private Handler handler;
private Display display;
    public starter() {
        try {
            setSize(500, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("PAUSE");
            setResizable(false);
            setLocationRelativeTo(null);
            
            JPanel pan = new JPanel();
            JButton again = new JButton();
            JButton main_menu = new JButton();
            pan.setBackground(new Color(38, 36, 75));
            again.setBounds(300, 200, 190, 200);
            main_menu.setBounds(400, 400, 312, 450);
            again.setIcon(new ImageIcon("again.png"));
            pan.add(again);
            pan.add(main_menu);
            main_menu.setIcon(new ImageIcon("mainm.png"));
            
            again.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();

                    Game game = new Game("Title", 1366, 710);
                    
                    game.start();
                }
            });
            
            main_menu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    frame frame = new frame();
                    
                }
            });
            
            this.add(pan);
            this.setVisible(true);
            handler.getGame().wait((long)15000);
        } catch (InterruptedException ex) {
            Logger.getLogger(starter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
