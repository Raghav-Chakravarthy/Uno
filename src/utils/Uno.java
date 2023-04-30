package utils;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import frontend.*;

public class Uno {
    private static JFrame frame;
    private static JPanel intro, endPanel;
    private static Game gamePanel;
    private static String gameView;
    private static int numPlayers;
    

    public Uno(){
        frame = new JFrame();
        intro = new Intro();
        gameView = "intro";
        frame.setSize(new Dimension(975,635));
        frame.setContentPane(intro);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getGameView(){
        return gameView;
    }

    public static void setPlayers(int x){
        numPlayers = x;
    }

    public static int getNumPlayers(){
        return numPlayers;
    }

    public static void changeView(String view){
        if(gameView.equals("intro")){
            if(view.equals("game")){
                gamePanel = new Game();
                System.out.println("Changing Views");
                frame.remove(intro);
                System.out.println("Removed Intro Panel");
                frame.setContentPane(gamePanel);
                gamePanel.revalidate();
                gamePanel.repaint();
                gamePanel.play();
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
