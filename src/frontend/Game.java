package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import backend.*;

import utils.Uno;

import java.io.File;
import java.util.ArrayList;
import java.awt.Point;

public class Game extends JPanel implements MouseListener, MouseMotionListener{
    private final String path = "assets" + File.separator + "cards" + File.separator;
    private Image bg = new ImageIcon("assets" + File.separator + "game" + File.separator + "gamescr.png").getImage();
    private UnoGame game = new UnoGame(Uno.getNumPlayers());

    public int x;
    public int y;


    //names of card files
    ArrayList<Card> playerHand = new ArrayList<Card>();

    
    public Game() {
        addMouseMotionListener(this);
        addMouseListener(this);
        
        // Play the game while it is not finished
        /*while(!game.finished()){
            for(int i = 0; i < Uno.getNumPlayers(); i++){
                playerHand = game.getPlayer(0).getHand().getHand();
                if(i == 0){

                } else{

                }
            }
        }*/

        //printing out hand with according file names for cards
        playerHand = game.getPlayer(0).getHand().getHand();
        for(Card c : playerHand){
            System.out.println(c);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("In gameview paintcomponent");
        Graphics2D g2d = (Graphics2D) g;
        //drawing background image
        g2d.drawImage(bg, 0, 0, null);

        //drawing deck
        for (int i = 0; i < playerHand.size(); i++) {
            Image img = new ImageIcon(path+ playerHand.get(i).toString()+".png").getImage();
            //if mouse hovering
            g2d.drawImage(img, (i*90) + 4, 460, null);
        }
        //getting card index and checking for valid cards
        int cardIndex = (x-4)/90;
        if (!(cardIndex >= playerHand.size())) {
            System.out.println(playerHand.get(cardIndex));
        }
        
        
    }

    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


    // public static void main(String[] args) {
    //     JFrame frame = new JFrame("Intro");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(975, 635);
        
    //     Intro intro = new Intro();
    //     frame.add(intro);
        
    //     frame.setVisible(true);
    // }
}