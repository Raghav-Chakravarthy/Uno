package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.awt.Point;

public class Game extends JPanel implements MouseMotionListener{
    private final String path = "assets" + File.separator + "cards" + File.separator;
    private Image bg = new ImageIcon("assets" + File.separator + "game" + File.separator + "gamescr.png").getImage();
    public int x;
    public int y;


    //names of card files
    private String[] cards = {"1_blue.png", "1_green.png", "1_red.png"};
    //list of coordinates to draw the cards, corrsponds to the cards array
    private Point[] coordinates = {new Point(4, 460), new Point(24, 460), new Point(44, 460)};

    
    public Game() {
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //drawing background image
        g2d.drawImage(bg, 0, 0, null);

        //drawing deck
        for (int i = 0; i < cards.length; i++) {
            Image img = new ImageIcon(path+ cards[i]).getImage();
            //if mouse hovering
            if ((x > 4 && x < 4 + 20) && (y > 460)) {
                g2d.drawImage(img, coordinates[i].x, coordinates[i].y -20, null);
            } else {
                g2d.drawImage(img, coordinates[i].x, coordinates[i].y, null);
            }
        }
        
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        //for finding bounds
        System.out.println("Mouse At: (" + x + ", " + y + ")");
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
