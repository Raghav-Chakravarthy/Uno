package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Game extends JPanel {

    private Image image;

    public Game() {
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
        
        JLabel player2Cards = new JLabel("Cards: 02");
        player2Cards.setForeground(Color.ORANGE);
        player2Cards.setFont(new Font("Calibri", Font.BOLD, 25));
        player2Cards.setBounds(806, 87, 106, 31);
        add(player2Cards);
        
        JLabel player3Cards = new JLabel("Cards: 12");
        player3Cards.setForeground(Color.ORANGE);
        player3Cards.setFont(new Font("Calibri", Font.BOLD, 25));
        player3Cards.setBounds(23, 87, 106, 31);
        add(player3Cards);
        
        JLabel player4Cards = new JLabel("Cards: 09");
        player4Cards.setForeground(Color.ORANGE);
        player4Cards.setFont(new Font("Calibri", Font.BOLD, 25));
        player4Cards.setBounds(394, 87, 106, 31);
        add(player4Cards);
        
        JLabel deck = new JLabel("");
		try {
			img = ImageIO.read(getClass().getResource("/deck.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		icon = new ImageIcon(img);
		deck.setIcon(icon);
		deck.setBounds(23, 249, 129, 124);
        add(deck);
        
        JLabel card0 = new JLabel("");
        card0.setBounds(23, 465, 80, 124);
        add(card0);
        
        JLabel card1 = new JLabel("");
        card1.setBounds(108, 465, 80, 124);
        add(card1);
        
        JLabel card2 = new JLabel("");
        card2.setBounds(198, 465, 80, 124);
        add(card2);
        
        JLabel card3 = new JLabel("");
        card3.setBounds(288, 465, 80, 124);
        add(card3);
        
        JLabel card4 = new JLabel("");
        card4.setBounds(378, 465, 80, 124);
        add(card4);
        
        JLabel card5 = new JLabel("");
        card5.setBounds(468, 465, 80, 124);
        add(card5);
        
        JLabel card6 = new JLabel("");
        card6.setBounds(558, 465, 80, 124);
        add(card6);
        
        JLabel card7 = new JLabel("");
        card7.setBounds(648, 465, 80, 124);
        add(card7);
        
        JLabel card8 = new JLabel("");
        card8.setBounds(738, 465, 80, 124);
        add(card8);
        
        JLabel card9 = new JLabel("");
        card9.setBounds(834, 465, 80, 124);
        add(card9);
        
        JLabel PCard0_1 = new JLabel("");
        PCard0_1.setBounds(468, 291, 80, 124);
        add(PCard0_1);
        
        JLabel pile = new JLabel("");
		try {
			img = ImageIO.read(getClass().getResource("/pile.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		icon = new ImageIcon(img);
		pile.setIcon(icon);
        pile.setBounds(431, 272, 207, 165);
        add(pile);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the image on the panel
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}

