package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrontEndTest {

    private JFrame frm = new JFrame();
    private Intro pnl = new Intro();
    private JButton btn = new JButton("Get ScreenSize for JComponents");

    public FrontEndTest() {
        pnl.setPreferredSize(new Dimension(960, 600));
        pnl.add(btn, BorderLayout.SOUTH);
        frm.add(pnl, BorderLayout.CENTER);
        frm.setLocation(150, 100);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
        frm.setResizable(false);
        frm.pack();
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                FrontEndTest fS = new FrontEndTest();
            }
        });
    }
}