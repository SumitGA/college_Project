/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Dipen
 */
public class startFrame {

    JFrame f1;
    JButton b1, b2;

    startFrame() {
        f1 = new JFrame("Image Steganography");
        f1.setSize(350, 400);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(false);
        f1.setLayout(null);

        f1.setUndecorated(true);
//    f1.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
        f1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
//    f1.setBackground(new Color(0.9f,0.9f,0.9f,0.85f));
        f1.setBackground(new Color(0.427f, 0.651f, 0.929f, 0.85f));
        f1.setLocationRelativeTo(null);
//        panel1.setOpaque(false);

        b1 = new JButton("Encode");
        b1.setBounds(100, 50, 150, 90);

        b2 = new JButton("Decode");
        b2.setBounds(100, 200, 150, 90);

        f1.add(b1);
        f1.add(b2);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new encodeFrame();
                f1.setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new decodeFrame();
                f1.setVisible(false);
            }
        });

        f1.setVisible(true);
    }

    public static void main(String[] args) {
        new startFrame();
    }
}
