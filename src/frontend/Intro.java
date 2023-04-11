package frontend;


import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Intro extends JPanel {

    private Image image;

    public Intro() {
        // Load the image from the file path
//         ImageIcon imageIcon = new ImageIcon(getClass().getResource("/red_button.png"));
//         image = imageIcon.getImage();
    	Image img = null;
		try {
			img = ImageIO.read(getClass().getResource("/green_button.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ImageIcon icon = new ImageIcon(img);

        setBackground(Color.RED);
        setLayout(null);

//        ImageIcon icon = new ImageIcon(getClass().getResource("/red_button.png"));
        JButton button1 = new JButton(icon);
        button1.setBounds(10, 482, 195, 75);
        button1.addActionListener(new ButtonListener("2"));
        add(button1);

//        icon = new ImageIcon(getClass().getResource("/red_button.png"));
        JButton button2 = new JButton(icon);
        button2.setBounds(257, 482, 195, 75);
        button2.addActionListener(new ButtonListener("3"));
        add(button2);

//        icon = new ImageIcon(getClass().getResource("/red_button.png"));
        JButton button3 = new JButton(icon);
        button3.setBounds(490, 482, 195, 75);
        button3.addActionListener(new ButtonListener("4"));
        add(button3);

//        icon = new ImageIcon(getClass().getResource("/path/to/image4.png"));
        JButton button4 = new JButton(icon);
        button4.setBounds(740, 482, 195, 75);
        button4.addActionListener(new ButtonListener("Tutorial"));
        add(button4);
        
        JLabel logo = new JLabel("");
		try {
			img = ImageIO.read(getClass().getResource("/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		icon = new ImageIcon(img);
		logo.setIcon(icon);
        logo.setBounds(0, 11, 960, 460);
        add(logo);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the image on the panel
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    private class ButtonListener implements ActionListener {

        private String buttonName;

        public ButtonListener(String buttonName) {
            this.buttonName = buttonName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button " + buttonName + " clicked");

            if (buttonName != "Tutorial") {
                setPlayers(Integer.parseInt(buttonName));
                changeView("game");
            } else {
                //slide show of all images
            }

        }
    }
}
