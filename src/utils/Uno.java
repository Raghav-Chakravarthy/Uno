package utils;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import frontend.*;

public class Uno {
    private JFrame frame;
    private JPanel intro, gamePanel, endPanel;
    private String gameView;
    private int numPlayers;
    

    public Uno(){
        frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(960,600));
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Uno uno = new Uno();
    }
}
