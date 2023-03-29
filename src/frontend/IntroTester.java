package frontend;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class IntroTester {

    private JFrame frm = new JFrame();
    private Intro pnl = new Intro();

    public IntroTester() {
        frm.setSize(960, 600);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.add(pnl, BorderLayout.CENTER);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                IntroTester ft = new IntroTester();
            }
        });
    }
}

