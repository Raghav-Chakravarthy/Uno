package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import backend.*;

import utils.Uno;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.awt.Point;

public class Game extends JPanel implements MouseListener, MouseMotionListener, Runnable{
    private final String path = "assets" + File.separator + "cards" + File.separator;
    private Image bg = new ImageIcon("assets" + File.separator + "game" + File.separator + "gamescr.png").getImage();
    private UnoGame game = new UnoGame(Uno.getNumPlayers());

    // (X, Y) Coordinates of last Mouseclick
    public int x;
    public int y;
    private boolean clicked = false;

    // Integer holding the index of the card clicked, and -1 while not clicked yet
    private int cardIndex = -1;
    private boolean deckClicked = false, cardClicked = false; // Status of what the user has clicked


    //names of card files
    ArrayList<Card> playerHand = new ArrayList<Card>();

    //player
    int playerIndex = 0;

    
    public Game() {
        addMouseMotionListener(this);
        addMouseListener(this);
        setFocusable(true);
        
        // Play the game while it is not finished
        
        

        //printing out hand with according file names for cards
        playerHand = game.getPlayer(0).getHand().getHand();
        // for(Card c : playerHand){
        //     System.out.println(c);
        // }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("repainting");
        Graphics2D g2d = (Graphics2D) g;
        //drawing background image
        g2d.drawImage(bg, 0, 0, null);

        //drawing deck
        for (int i = 0; i < playerHand.size(); i++) {
            Image img = new ImageIcon(path+ playerHand.get(i).toString()+".png").getImage();
            //if mouse hovering
            g2d.drawImage(img, (i*90) + 4, 460, null);
        }  
    }

    @Override
    public void run() {
        System.out.println("Running");
        while(!game.finished()){
            for(int i = 0; i < Uno.getNumPlayers(); i++){
                playerHand = game.getPlayer(0).getHand().getHand();
                if(i == 0){
                    while(!deckClicked && !cardClicked){ // Waiting for the user to make a move
                        try {
                            TimeUnit.MILLISECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                    if(deckClicked){ // If the deck is clicked by the user
                        System.out.println("The deck is adding");
                        game.getPlayer(0).getHand().addCard(); // Add a random card from the deck to the user's hand
                        deckClicked = false;
                        repaint(); // Display new Hand
                    } else if(cardClicked){
                        if(cardIndex >= 0 && cardIndex < playerHand.size() && game.getCardPile().canPlace(playerHand.get(cardIndex))){
                            game.playCard(0, playerHand.get(cardIndex));
                            cardClicked = false;
                        }
                    }

                } else {

                }
            }
        }
    }

    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        int cardIndex = (x-4)/90;


        //if (playerIndex == 0) {
            // If y inbounds for cards, and cardindex clicked is inbounds, and playable
            if(y >= 460 && y < 580 && cardIndex < game.getPlayer(0).getHand().getHand().size() && game.getCardPile().canPlace(game.getPlayer(0).getHand().getHand().get(cardIndex))){
                cardClicked = true;
                this.cardIndex = cardIndex;
                /*if(cardIndex >= 0 && cardIndex < playerHand.size() && game.getCardPile().canPlace(playerHand.get(cardIndex))){
                    System.out.println("Played Card");
                    game.playCard(0, playerHand.get(cardIndex));
                }*/
                //cardClicked = false;

            } else if(x >= 270 && x <= 355 && y >= 185 && y <= 260){
                deckClicked = true;
                System.out.println("Drew Card");
               /*game.getPlayer(0).getHand().addCard();
                deckClicked = false;*/
            }     
        //}
        
        //playerHand = game.getPlayer(0).getHand().getHand();
        //repaint();
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