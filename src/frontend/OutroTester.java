package frontend;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class OutroTester {

    private JFrame frm = new JFrame();
    //**
    private Outro pnl = new Outro();
    //**
    public OutroTester() {
        frm.setSize(975, 635);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.add(pnl, BorderLayout.CENTER);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //**
                OutroTester ft = new OutroTester();
                //**
            }
        });
    }
}