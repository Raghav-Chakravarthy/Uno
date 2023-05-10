package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import utils.Uno;

public class Outro extends JPanel implements MouseMotionListener, MouseListener, Runnable{
    private Image myImage;
    private final String path = "assets" + File.separator + "outro" + File.separator;
    public int x;
    public int y;
    private boolean win;

    public Outro() {
        //win = Uno.getWin();
        myImage = loadImage();
        addMouseMotionListener(this);
        setFocusable(true);
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
        if (!Uno.getWin()) {
            img = new ImageIcon(path+"outro_loss.png").getImage();
        }else {
            img = new ImageIcon(path+"outro_win.png").getImage();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if((e.getX() > 715 && e.getX() < 865) && (e.getY() > 520 && e.getY() < 580)){
            Uno.changeView("close");
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

    @Override
    public void run() {
        // TODO Auto-generated method stub
        repaint();
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