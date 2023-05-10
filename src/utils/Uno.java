package utils;

import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import frontend.*;

public class Uno {
    private static JFrame frame;
    private static JPanel intro;
    private static Game gamePanel;
    private static Outro endPanel;
    private static String gameView;
    private static int numPlayers;
    private static boolean winStatus;
    private static Thread t;
    

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

    public static void win(boolean b){
        winStatus = b;
    }

    public static boolean getWin(){
        return winStatus;
    }

    public static void changeView(String view){
        if(view.equals("game")){
            gamePanel = new Game();
            frame.remove(intro);
            frame.setContentPane(gamePanel);
            gamePanel.revalidate();
            gamePanel.repaint();
            t = new Thread(gamePanel);
            t.start();
        }
        else if(view.equals("end")){
            frame.remove(gamePanel);
            gamePanel.removeAll();
            gamePanel.hide();
            endPanel = new Outro();
            endPanel.setPreferredSize(new Dimension(960, 620));
            System.out.println("Changing Views");
            System.out.println("Removed Game Panel");
            frame.add(endPanel);
            /*frame.revalidate();
            frame.repaint();*/
            endPanel.revalidate();
            endPanel.repaint();
            /*t = new Thread(endPanel);
            t.start();*/
            System.out.println("Done");
        } else if(view.equals("close")){
            frame.dispose();
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
