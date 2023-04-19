package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.awt.Point;

public class Game extends JPanel implements MouseMotionListener {
    private Image myImage;
    private final String path = "assets" + File.separator + "cards" + File.separator;
    public int x;
    public int y;
    //names of card files
    private string[] cards = {"1_blue.png", "1_green.png", "1_red.png"};
    //list of coordinates to draw the cards, corrsponds to the cards array
    private location[] coordinates = {new Point(4, 13), new Point(24, 13), new Point(44, 13)};

    
    public Game() {
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        looping through all the cards
        for (int i = 0; i < cards.length(); i++) {
            Image img = new ImageIcon(path+ cards[i]).getImage();
            g2d.drawImage(img, coordinates[i].getX, coordinates[i].getY, null);
        }
        
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        //for finding bounds
        System.out.println("Mouse At: (" + x + ", " + y + ")");

        //reloads the image and repaints
        myImage = loadImage();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    // public static void main(String[] args) {
    //     JFrame frame = new JFrame("Intro");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(975, 635);
        
    //     Intro intro = new Intro();
    //     frame.add(intro);
        
    //     frame.setVisible(true);
    // }
}
