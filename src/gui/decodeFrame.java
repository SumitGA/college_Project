/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import lsb.decode;
import shiftCipher.encrypt;

/**
 *
 * @author SumitG
 */
public class decodeFrame implements ActionListener {

    JFrame f1;
    JTextArea ta1;
    JTextField tfk;
    JButton bok, bcn;
    JButton browse, b1, b2, b3, preview, back;
    JPanel p1, p2, p3, panelKey;
    JLabel l1, l2, jl;
    JScrollPane scp;
    JLabel imagePreview;
    JOptionPane jop = new JOptionPane();
    File f;
    JDialog jd;
    String encMessage;

    decodeFrame(String encMessage) {
        this.encMessage = encMessage;
    }

    decodeFrame() {
        f1 = new JFrame("Decode");
        f1.setSize(550, 440);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(false);

        MenuBar addMenu = new MenuBar();
        f1.setJMenuBar(addMenu.menubar);

        p1 = new JPanel();
        p1.setLayout(null);

        f1.setUndecorated(true);
        f1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        f1.setBackground(new Color(0.427f, 0.651f, 0.929f, 0.85f));
        f1.setLocationRelativeTo(null);
        p1.setOpaque(false);

        l1 = new JLabel("Image Preview");
        l1.setBounds(10, 5, 100, 25);

        scp = new JScrollPane();
        scp.setBounds(10, 35, 390, 280);
        p2 = new JPanel();
        p2.setBounds(10, 35, 390, 280);

        imagePreview = new JLabel();

        preview = new JButton("Larger Preview");
        preview.setBounds(410, 100, 121, 25);
        preview.setEnabled(false);

        browse = new JButton("Browse Image");
        browse.setBounds(410, 65, 121, 25);

        b1 = new JButton("Decode Image");
        b1.setBounds(110, 340, 125, 25);

        back = new JButton("Back");
        back.setBounds(255, 340, 80, 25);

        b2 = new JButton("Cancel");
        b2.setBounds(355, 340, 80, 25);

        p1.add(l1);
        p1.add(preview);
        p1.add(b1);
        p1.add(b2);
        p1.add(back);
        p1.add(scp);
        p1.add(browse);

        b3 = new JButton("Process");

        panelKey = new JPanel(null);
//        panelKey.setOpaque(false);
        panelKey.setBackground(new Color(0.427f, 0.651f, 0.929f, 0.85f));
        jl = new JLabel("Enter the key");
        tfk = new JTextField();
        bok = new JButton("Okay");
        bcn = new JButton("Cancel");

        jl.setBounds(50, 10, 90, 25);
        panelKey.add(jl);

        tfk.setBounds(150, 10, 110, 25);
        panelKey.add(tfk);

        bok.setBounds(100, 50, 70, 25);
        panelKey.add(bok);

        bcn.setBounds(180, 50, 80, 25);
        panelKey.add(bcn);

        browse.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        back.addActionListener(this);
        preview.addActionListener(this);

        bok.addActionListener(this);
        bcn.addActionListener(this);
        tfk.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                String key = tfk.getText();

                if (!(Character.isDigit(input))) {
                    e.consume();
                }

                if (key.length() > 7) {
                    e.consume();
                }
            }
        });

        f1.add(p1);
        f1.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        if (e.getSource() == browse) {
            fc.setAcceptAllFileFilterUsed(false);

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(*.png , *.bmp)", "png", "bmp");
            fc.setFileFilter(filter);
            if (fc.showOpenDialog(f1) == fc.APPROVE_OPTION) {

                preview.setEnabled(true);

                f = fc.getSelectedFile();
                System.out.println(" f " + f);

                BufferedImage bimg = null;
                try {
                    bimg = ImageIO.read(f);
                } catch (IOException ex) {
                    Logger.getLogger(decodeFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                Image scaled = bimg.getScaledInstance(350, 350, Image.SCALE_AREA_AVERAGING);
                ImageIcon icon = new ImageIcon(scaled);
                imagePreview.setIcon(icon);

                scp.getViewport().add(imagePreview);
            }

        }

        if (e.getSource() == b1) {
            if (f == null) {
                JOptionPane.showMessageDialog(p1, "You must select an image!");
            } else {
                jd = new JDialog(f1, "Key for Decryption process", true);
                jd.setSize(350, 130);
                jd.getContentPane().add(panelKey);
                jd.setLocationRelativeTo(f1);

                jd.setResizable(false);
                jd.setVisible(true);
            }
        }

        if (e.getSource() == preview) {
            try {
                Desktop dt = Desktop.getDesktop();
                dt.open(f);
            } catch (Exception ex) {
            }
        }
        if (e.getSource() == b2) {
            System.exit(0);
        }

        if (e.getSource() == bok) {
            f1.setVisible(false);
            String keyString = tfk.getText();

            if (keyString.length() < 4 | keyString.equals("")) {
                JOptionPane.showMessageDialog(panelKey, "Key must be of min. size of 4 and max. size of 8");
            } else {
                int key = Integer.parseInt(keyString);

                try {
                    jd.setVisible(false);
                    new decode(f, key);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        }
        if (e.getSource() == bcn) {
            jd.dispose();
        }
        if (e.getSource() == back) {
            f1.dispose();
            new startFrame();
        }
    }

}
