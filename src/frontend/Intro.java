package frontend;

import javax.swing.*;
import java.awt.*;

public class Intro extends JPanel {

	/**
	 * Create the panel.
	 */
	public Intro() {
		setBackground(Color.ORANGE);
		setLayout(null);
		
//		Image img = new ImageIcon(this.getClass().getResource("/background.png")).getImage();
//		
//		JLabel wildCard = new JLabel("");
//		img = new ImageIcon(this.getClass().getResource("/wildcard.png")).getImage();
//		wildCard.setIcon(new ImageIcon(img));
//		wildCard.setBounds(87, 237, 82, 129);
//		add(wildCard);
		

		
		//show background
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		
		ImageIcon ic = new ImageIcon("/background.png");
		Image i = ic.getImage();
		
		g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
	}
}
