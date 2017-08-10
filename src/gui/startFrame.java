/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

<<<<<<< HEAD

=======
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 *
<<<<<<< HEAD
 * @author SumitG
=======
 * @author Dipen
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
 */
public class startFrame {

    JFrame f1;
    JButton b1, b2;

<<<<<<< HEAD
    public startFrame() {
=======
    startFrame() {
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
        f1 = new JFrame("Image Steganography");
        f1.setSize(350, 400);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(false);
        f1.setLayout(null);

        f1.setUndecorated(true);
<<<<<<< HEAD

        f1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        f1.setBackground(new Color(0.427f, 0.651f, 0.929f, 0.85f));
        f1.setLocationRelativeTo(null);
        
        MenuBar addMenu = new MenuBar();
        f1.setJMenuBar(addMenu.menubar);
=======
//    f1.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
        f1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
//    f1.setBackground(new Color(0.9f,0.9f,0.9f,0.85f));
        f1.setBackground(new Color(0.427f, 0.651f, 0.929f, 0.85f));
        f1.setLocationRelativeTo(null);
//        panel1.setOpaque(false);
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250

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
