package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class Outro extends JPanel implements MouseMotionListener {
    private Image myImage;
    private final String path = "assets" + File.separator + "outro" + File.separator;
    public int x;
    public int y;
    
    public Outro() {
        myImage = loadImage();
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(myImage, 0, 0, null);
    }
    
    private Image loadImage() {
        Image img = null;
        //test case
        if ((x > 735 && x < 885) && (y > 520 && y < 580)) {
            img = new ImageIcon(path+"outro_green.png").getImage();
        }else {
            img = new ImageIcon(path+"outro.png").getImage();
        }
        return img;
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
