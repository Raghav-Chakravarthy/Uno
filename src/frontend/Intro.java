package frontend;

import utils.Uno;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class Intro extends JPanel implements MouseListener, MouseMotionListener {
    private Image myImage;
    private final String path = "assets" + File.separator + "intro" + File.separator;
    private boolean tutorial = false;
    public int x;
    public int y;

    public Intro() {
        myImage = loadImage();
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(myImage, 0, 0, null);
        // System.out.println("Repainted!");
    }

    private Image loadImage() {
        Image img = null;
        //test case
        if ((x > 75 && x < 225) && (y > 520 && y < 580)) {
            img = new ImageIcon(path+"intro_green.png").getImage();
        }else if ((x > 715 && x < 865) && (y > 520 && y < 580)) {
            img = new ImageIcon(path+"intro_yellow.png").getImage();
        }else {
            img = new ImageIcon(path+"intro.png").getImage();
        }
        return img;
    }

    public void mouseMoved(MouseEvent e) {
        if(!tutorial){
            x = e.getX();
            y = e.getY();
            
            //for finding bounds
            // System.out.println("Mouse At: (" + x + ", " + y + ")");

            //reloads the image and repaints
            myImage = loadImage();
        }
        
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!tutorial){
            if ((e.getX() > 75 && e.getX() < 225) && (e.getY() > 520 && e.getY() < 580)) {
                Uno.setPlayers(4);
                Uno.changeView("game");
            }else if ((e.getX() > 715 && e.getX() < 865) && (e.getY() > 520 && e.getY() < 580)) {
                tutorial = true;
                myImage = new ImageIcon("assets" + File.separator + "intro" + File.separator +"tutorial.png").getImage();
                repaint();
            }
        } else{
            if ((e.getX() > 715 && e.getX() < 865) && (e.getY() > 520 && e.getY() < 580)) {
                tutorial = false;
                myImage = new ImageIcon(path+"intro.png").getImage();
                repaint();
            }
        }        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    // public static void main(String[] args) {
    //     JFrame frame = new JFrame("Intro");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(975, 635);

    //     Intro intro = new Intro();
    //     frame.add(intro);

    //     frame.setVisible(true);
    // }
}