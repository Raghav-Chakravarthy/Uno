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

public class Outro extends JPanel {

    private Image image;

    public Outro() {
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

        JButton button4 = new JButton(icon);
        button4.setBounds(740, 482, 195, 75);
        button4.addActionListener(new ButtonListener("Home"));
        add(button4);
        
        JLabel scoreText = new JLabel("");
		try {
			img = ImageIO.read(getClass().getResource("/yourScoreLabel.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		icon = new ImageIcon(img);
		scoreText.setIcon(icon);
        scoreText.setBounds(150, 49, 364, 50);
        add(scoreText);
        
        JLabel score = new JLabel("##");
        score.setForeground(Color.ORANGE);
        score.setFont(new Font("Calibri", Font.BOLD, 60));
        score.setBounds(524, 49, 122, 63);
        add(score);
        
        JLabel leaderboard = new JLabel("");
		try {
			img = ImageIO.read(getClass().getResource("/leaderboard.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		icon = new ImageIcon(img);
		leaderboard.setIcon(icon);
        leaderboard.setBounds(32, 123, 667, 438);
        add(leaderboard);
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
        }
    }
}

