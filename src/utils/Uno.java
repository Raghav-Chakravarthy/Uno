package utils;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import frontend.*;

public class Uno {
    private static JFrame frame;
    private static JPanel intro, gamePanel, endPanel;
    private static String gameView;
    private static int numPlayers;
    

    public Uno(){
        frame = new JFrame();
        intro = new Game();
        gameView = "intro";
        frame.setSize(new Dimension(975,635));
        frame.setContentPane(intro);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public String getGameView(){
        return gameView;
    }

    public static void setPlayers(int x){
        numPlayers = x;
    }

    public static void changeView(String view){
        if(gameView.equals("intro")){
            if(view.equals("game")){
                gamePanel = new UnoView();
                frame.remove(intro);
                frame.setContentPane(gamePanel);
            }
        }
        // "intro"
        // "game"
        // "end"
        // "close"

    }

    public static void main(String[] args){
        Uno uno = new Uno();
    }
}
