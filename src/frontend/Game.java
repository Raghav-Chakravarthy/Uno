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
    private Image bg = new ImageIcon("assets" + File.separator + "game" + File.separator + "game.png").getImage();
    private UnoGame game = new UnoGame(Uno.getNumPlayers());

    // (X, Y) Coordinates of last Mouseclick
    public int x;
    public int y;
    

    // Integer holding the index of the card clicked, and -1 while not clicked yet
    private int cardIndex = -1;
    private boolean deckClicked = false, cardClicked = false; // Status of what the user has clicked
    private boolean gameOver = false;

    //names of card files
    ArrayList<Card> playerHand = new ArrayList<Card>();

    //player
    int playerIndex = 0;

    // Color Picker
    private boolean clicked = false;

    // Repainting
    private boolean repainted = false;

    
    public Game() {
        addMouseMotionListener(this);
        addMouseListener(this);
        setFocusable(true);
        
        // Play the game while it is not finished
        
        

        //printing out hand with according file names for cards
        playerHand = game.getPlayer(0).getHand().getHand();
        // for(Card c : playerHand){
        // }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!gameOver){
            Graphics2D g2d = (Graphics2D) g;
            //drawing background image
            g2d.drawImage(bg, 0, 0, null);
            g2d.drawImage(new ImageIcon(path + game.getCardPile().getTopCard().toString() + ".png").getImage(), 550, 250, null);

            //drawing deck
            for (int i = 0; i < playerHand.size(); i++) {
                Image img = new ImageIcon(path+ playerHand.get(i).toString()+".png").getImage();
                //if mouse hovering
                g2d.drawImage(img, (i*90) + 4, 460, null);
            }
            g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
            g2d.setColor(Color.YELLOW);
            g2d.drawString("Player " + (playerIndex + 1) + " turn", 250, 300);
            if(game.getCardPile().getTopColor() == Card.BLUE){
                g2d.setColor(Color.BLUE);
                g2d.drawString("Color BLUE", 250, 350);
            } else if(game.getCardPile().getTopColor() == Card.GREEN){
                g2d.setColor(Color.GREEN);
                g2d.drawString("Color GREEN", 250, 350);
            } else if(game.getCardPile().getTopColor() == Card.YELLOW){
                g2d.setColor(Color.YELLOW);
                g2d.drawString("Color YELLOW", 250, 350);
            } else if(game.getCardPile().getTopColor() == Card.RED){
                g2d.setColor(Color.RED);
                g2d.drawString("Color RED", 250, 350);
            }
            g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawString("Player 1", 30, 450);
            g2d.drawString("Player 2", 30, 125);
            g2d.drawString("Player 3", 550, 100);
            g2d.drawString("Player 4", 700, 150);
            g2d.drawString("Count: " + game.getPlayer(0).getHand().getHand().size(), 150, 450);
            g2d.drawString("Count: " + game.getPlayer(1).getHand().getHand().size(), 150, 125);
            g2d.drawString("Count: " + game.getPlayer(2).getHand().getHand().size(), 700, 100);
            g2d.drawString("Count: " + game.getPlayer(3).getHand().getHand().size(), 800, 150);
            repainted = true;
        } else{
            Graphics2D g2d = (Graphics2D) g;
            //drawing background image
            if(playerIndex == 0){
                bg = new ImageIcon("assets" + File.separator + "outro" + File.separator + "outro_win.png").getImage();
            } else{
                bg = new ImageIcon("assets" + File.separator + "outro" + File.separator + "outro_loss.png").getImage();
            }
            g2d.drawImage(bg, 0, 0, null);
        }
        
    }

    @Override
    public void run() {
        while(!game.finished()){
            for(int i = 0; i < Uno.getNumPlayers(); i++){
                playerIndex = i;
                repaint();
                    while(!repainted){
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    repainted = false;
                playerHand = game.getPlayer(0).getHand().getHand();
                if(game.getCardPile().getSkip()){ // If previous person placed a skip
                    game.getCardPile().resetSkip();
                    repaint();
                    while(!repainted){
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    repainted = false;
                } else{
                    if(i == 0){
                        deckClicked = false;
                        cardClicked = false;
    
                        // Check to see if user can play on a plus four, if not, give cards
                        int countPlusFour = 0;
                        int countPlusTwo = 0;
                        if(game.getCardPile().getPlusFour() > 0){
                            for(int j = 0; j < playerHand.size(); j++){
                                if(playerHand.get(j).getNum() == Card.PLUS_FOUR){
                                    countPlusFour++;
                                }
                            }

                            if(countPlusFour == 0){ // If the player has no matching plus fours, draw cards
                                for(int k = 0; k < (game.getCardPile().getPlusFour()/2); k++){
                                    game.getPlayer(0).getHand().addCard();
                                }
                                game.getCardPile().resetPlusFour();
                                repaint(); // Display new Hand
                                while(!repainted){
                                    try {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                                repainted = false;
                            } else{ // If the player has matching cards
                                while(!cardClicked){ // Waiting for the user to make a move
                                    try {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
            
                                if(cardClicked){
                                    if(cardIndex >= 0 && cardIndex < playerHand.size() && game.getCardPile().canPlace(playerHand.get(cardIndex))){
                                        game.playCard(0, playerHand.get(cardIndex));
                                        game.getCardPile().plusFour();
                                        cardClicked = false;
                                    }
                                }
                            }
                        }
    
                        // Check to see if user can play on a plus two, if not, give cards
                        else if(game.getCardPile().getPlusTwo() > 0){
                            for(int j = 0; j < playerHand.size(); j++){
                                if(playerHand.get(j).getNum() == Card.PLUS_TWO){
                                    countPlusTwo++;
                                }
                            }

                            if(countPlusTwo == 0){ // If the player has no matching plus two cards, draw cards
                                for(int k = 0; k < (game.getCardPile().getPlusTwo()/2); k++){
                                    game.getPlayer(0).getHand().addCard();
                                }
                                game.getCardPile().resetPlusTwo();
                                repaint(); // Display new Hand
                                while(!repainted){
                                    try {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                                repainted = false;
                            } else { // Matching Plus Two
                                while(!cardClicked){ // Waiting for the user to make a move
                                    try {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
            
                                if(cardClicked){
                                    if(cardIndex >= 0 && cardIndex < playerHand.size() && game.getCardPile().canPlace(playerHand.get(cardIndex))){
                                        game.playCard(0, playerHand.get(cardIndex));
                                        game.getCardPile().plusTwo();
                                        cardClicked = false;
                                    }
                                }
                            }
                        }
                        else{ // Neither Plus four or Plus Two Stacking
                            while(!deckClicked && !cardClicked){ // Waiting for the user to make a move
                                try {
                                    TimeUnit.MILLISECONDS.sleep(100);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
        
                            if(deckClicked){ // If the deck is clicked by the user
                                game.getPlayer(0).getHand().addCard(); // Add a random card from the deck to the user's hand
                                deckClicked = false;
                                repaint(); // Display new Hand
                                while(!repainted){
                                    try {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                                repainted = false;
                            } else if(cardClicked){ // If user clicks a card
                                if(cardIndex >= 0 && cardIndex < playerHand.size() && game.getCardPile().canPlace(playerHand.get(cardIndex))){
                                    game.playCard(0, playerHand.get(cardIndex));
                                    cardClicked = false;
                                    if(game.getCardPile().getTopCard().getNum() == Card.WILD){
                                        // Create a JFRAME WITH FOUR BUTTONS
                                        // RED, GREEN, BLUE, YELLOW
                                        // BASED ON BUTTON CLICKED, SET TOP COLOR ACCORDINGLY USING CARDPILE
                                        // IMMEDIATELY DISPOSE JFRAME
                                        JFrame colorSelector = new JFrame("Color Selector");
                                        JButton red = new JButton("Red");
                                        JButton green = new JButton("Green");
                                        JButton blue = new JButton("Blue");
                                        JButton yellow = new JButton("Yellow");
                                        colorSelector.add(red);
                                        colorSelector.add(green);
                                        colorSelector.add(blue);
                                        colorSelector.add(yellow);
                                        colorSelector.setLayout(new FlowLayout());
                                        colorSelector.setResizable(false);
                                        colorSelector.setSize(200, 200);
                                        colorSelector.setDefaultCloseOperation(JFrame. DO_NOTHING_ON_CLOSE);
                                        colorSelector.setVisible(true);
                                        red.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.getCardPile().setTopColor(Card.RED);
                                                clicked = true;
                                            }
                                        });
                                        green.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.getCardPile().setTopColor(Card.GREEN);
                                                clicked = true;
                                            }
                                        });
                                        blue.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.getCardPile().setTopColor(Card.BLUE);
                                                clicked = true;
                                            }
                                        });
                                        yellow.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.getCardPile().setTopColor(Card.YELLOW);
                                                clicked = true;
                                            }
                                        });
                                        while(!clicked){

                                        }
                                        clicked = false;
                                        colorSelector.dispose();
                                    } else if(game.getCardPile().getTopCard().getNum() == Card.PLUS_FOUR){
                                        game.getCardPile().plusFour();
                                        JFrame colorSelector = new JFrame("Color Selector");
                                        JButton red = new JButton("Red");
                                        JButton green = new JButton("Green");
                                        JButton blue = new JButton("Blue");
                                        JButton yellow = new JButton("Yellow");
                                        colorSelector.add(red);
                                        colorSelector.add(green);
                                        colorSelector.add(blue);
                                        colorSelector.add(yellow);
                                        colorSelector.setLayout(new FlowLayout());
                                        colorSelector.setResizable(false);
                                        colorSelector.setSize(200, 200);
                                        colorSelector.setDefaultCloseOperation(JFrame. DO_NOTHING_ON_CLOSE);
                                        colorSelector.setVisible(true);
                                        red.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.getCardPile().setTopColor(Card.RED);
                                                clicked = true;
                                            }
                                        });
                                        green.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.getCardPile().setTopColor(Card.GREEN);
                                                clicked = true;
                                            }
                                        });
                                        blue.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.getCardPile().setTopColor(Card.BLUE);
                                                clicked = true;
                                            }
                                        });
                                        yellow.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.getCardPile().setTopColor(Card.YELLOW);
                                                clicked = true;
                                            }
                                        });
                                        while(!clicked){
    
                                        }
                                        clicked = false;
                                        colorSelector.dispose();
                                    } else if(game.getCardPile().getTopCard().getNum() == Card.PLUS_TWO){
                                        game.getCardPile().plusTwo();
                                        
                                    }
                                    else if(game.getCardPile().getTopCard().getNum() == Card.SKIP){
                                        game.getCardPile().skip();
                                    }
                                    repaint();
                                    while(!repainted){
                                        try {
                                            TimeUnit.MILLISECONDS.sleep(100);
                                        } catch (InterruptedException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                    repainted = false;
                                } 
                            }
                        }

                    } else {
                        int move = ((ComputerPlayer)(game.getPlayer(i))).placeCard(game.getCardPile().getTopCard(), game.getCardPile().getPlusTwo(), game.getCardPile().getPlusFour());
                        if(game.getCardPile().getPlusFour() > 0){
                            if(move == -1){
                                for(int k = 0; k < (game.getCardPile().getPlusFour()/2); k++){
                                    game.getPlayer(i).getHand().addCard();
                                }
                                game.getCardPile().resetPlusFour();
                                repaint(); // Display new Hand
                                while(!repainted){
                                    try {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                                repainted = false;
                            }
                        } else if(game.getCardPile().getPlusTwo() > 0){
                            if(move == -1){
                                for(int k = 0; k < (game.getCardPile().getPlusTwo()/2); k++){
                                    game.getPlayer(i).getHand().addCard();
                                }
                                game.getCardPile().resetPlusTwo();
                                repaint(); // Display new Hand
                                while(!repainted){
                                    try {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                                repainted = false;
                            }
                        } else{
                            if(move == -1){
                                game.getPlayer(i).getHand().addCard(); // Add a random card from the deck to the user's hand
                                repaint(); // Display new Hand
                                while(!repainted){
                                    try {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                                repainted = false;
                            } else{
                                game.playCard(i, game.getPlayer(i).getHand().getHand().get(move));
                                if(game.getCardPile().getTopCard().getNum() == Card.WILD){
                                    game.getCardPile().setTopColor((int)(Math.random()*4) + 1);
                                } else if(game.getCardPile().getTopCard().getNum() == Card.PLUS_FOUR){
                                    game.getCardPile().setTopColor((int)(Math.random()*4) + 1);
                                    game.getCardPile().plusFour();
                                } else if(game.getCardPile().getTopCard().getNum() == Card.PLUS_TWO){
                                    game.getCardPile().plusTwo();
                                } else if(game.getCardPile().getTopCard().getNum() == Card.SKIP){
                                    game.getCardPile().skip();
                                }
                                repaint();
                                while(!repainted){
                                    try {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                                repainted = false;
                            }  
                        }                    
                    }
                    repaint();
                    while(!repainted){
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    repainted = false;
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if(game.finished()){
                    /*if(i == 0){
                        Uno.win(true);
                    }else{
                        Uno.win(false);
                    }
                    Uno.changeView("end");
                    setFocusable(false);*/
                    gameOver = true;
                    break;
                }
            }
        }
        repaint();
    }

    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        int cardIndex = (x-4)/90;

        if(gameOver){
            if((e.getX() > 715 && e.getX() < 865) && (e.getY() > 520 && e.getY() < 580)){
                Uno.changeView("close");
            }
        }else{
            //if (playerIndex == 0) {
            // If y inbounds for cards, and cardindex clicked is inbounds, and playable
            if(y >= 460 && y < 580 && cardIndex < game.getPlayer(0).getHand().getHand().size() && game.getCardPile().canPlace(game.getPlayer(0).getHand().getHand().get(cardIndex))){
                cardClicked = true;
                this.cardIndex = cardIndex;
                /*if(cardIndex >= 0 && cardIndex < playerHand.size() && game.getCardPile().canPlace(playerHand.get(cardIndex))){
                    game.playCard(0, playerHand.get(cardIndex));
                }*/
                //cardClicked = false;

            } else if(x >= 270 && x <= 355 && y >= 185 && y <= 260){
                deckClicked = true;
               /*game.getPlayer(0).getHand().addCard();
                deckClicked = false;*/
            }     
        //}
        
        //playerHand = game.getPlayer(0).getHand().getHand();
        //repaint();
        }

        
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