/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//projectwork.gui
package gui;

//import projectWork.encrypt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import lsb.encode;
import shiftCipher.encrypt;

/**
 *
 * @author Dipen
 */
public class encodeFrame implements ActionListener {

    JDesktopPane dp;
    JFrame f1;
    JInternalFrame fk;
    JLabel l1, l2, l3, imagePreview, lkey;
    JLabel jl;
    JButton b1, b2, browse, preview, keyOK, keyCancel, back;
    JButton bok, bcn;
    JPasswordField psw;
    JTextArea t1, tmp;
    JTextField tf1, tkey, tfk;
    JPanel panel1, mp, panelKey;
    JScrollPane scp;
    JDialog jd;
    File f;
    JPopupMenu jpop;

    public encodeFrame(String success) {
        JOptionPane.showMessageDialog(null, "Image Encrypted successfull");
    }

    encodeFrame() {
        f1 = new JFrame("Encode");
        f1.setSize(550, 625);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(false);
        dp = new JDesktopPane();
        //using null layout
        panel1 = new JPanel(null);

        fk = new JInternalFrame("Enter the key");
        fk.setPreferredSize(new Dimension(200, 100));//Size(400,200);
        fk.setBounds(50, 100, 200, 100);
//        fk.setUndecorated(true);

        f1.setUndecorated(true);
//    f1.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
        f1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        f1.setBackground(new Color(0.9f, 0.9f, 0.9f, 0.85f));
        f1.setBackground(new Color(0.427f, 0.651f, 0.929f, 0.85f));
        f1.setLocationRelativeTo(null);
        panel1.setOpaque(false);

        l1 = new JLabel("Image Preview");
        l1.setBounds(10, 5, 100, 25);

        scp = new JScrollPane();
        scp.setBounds(10, 35, 390, 280);
//        imagePreview.setBounds(10,35,390,280);

        browse = new JButton("Browse Image");
        browse.setBounds(360, 65, 121, 25);

        tf1 = new JTextField();
        tf1.setBounds(50, 65, 300, 25);
        tf1.setEditable(false);
        tf1.setText("Choose an Image File");

        JSeparator sp = new JSeparator(SwingConstants.HORIZONTAL);
        sp.setBounds(10, 265, 520, 25);

//        l2=new JLabel("Message");
//        l2.setBounds(10,305,80,25);
        t1 = new JTextArea();
        t1.setBorder(BorderFactory.createTitledBorder("Message to Embed"));
        t1.setBounds(10, 275, 520, 200);

        b1 = new JButton("Encrypt");
        b1.setBounds(150, 555, 80, 25);

        back = new JButton("Back");
        back.setBounds(250, 555, 80, 25);

        b2 = new JButton("Cancel");
        b2.setBounds(350, 555, 80, 25);

//        l3=new JLabel("Larger Preview",JLabel.CENTER);        
//        l3.setBounds(410,100,120,25);
        preview = new JButton("Image Preview");
        preview.setEnabled(false);
        preview.setBounds(200, 200, 121, 40);

//        lkey =new JLabel("Enter the Key");
//        lkey.setBounds(20,500,90,25);
//        
//        tkey = new JTextField();
//        tkey.setBounds(130,500,100,25);
        psw = new JPasswordField();

        // fk.add(lkey);
        //fk.add(tkey);
        //panel1.add(l1);
        //panel1.add(scp); 
        panel1.add(tf1);
        panel1.add(browse);

        panel1.add(sp); //panel1.add(l3);
        panel1.add(t1);
        panel1.add(preview);
        panel1.add(b1);
        panel1.add(b2);
        panel1.add(back);
//        panel1.add(lkey); 
//        panel1.add(tkey);

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

//        panelKey.add(tkey);
//        
//        jpop=new JPopupMenu();
//        jpop.add(panelKey);
//        panelKey.add(tkey);
        browse.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        back.addActionListener(this);
        bok.addActionListener(this);
        bcn.addActionListener(this);
        preview.addActionListener(this);
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
        f1.add(dp);
        f1.add(panel1);

        f1.setVisible(true);

    }

    public static void main(String[] args) {
        new encodeFrame();
    }

    public void actionPerformed(ActionEvent e) {

        String ppp = "";
        if (e.getSource() == browse) {
            JFileChooser fc = new JFileChooser("Open an image");

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(*.jpg , *.png)", "png", "jpg","bmp");
            fc.setFileFilter(filter);
            
            if (fc.showOpenDialog(f1) == fc.APPROVE_OPTION) {
//                preview=new JButton("Larger Preview");
//                preview.setBounds(410,100,120,25);  
                preview.setEnabled(true);

                // System.out.println(ppp);
                //f=new File(ppp);
                f = fc.getSelectedFile();

                imagePreview = new JLabel(new ImageIcon(f.getPath()));

                scp.getViewport().add(imagePreview);

                tf1.setText(f.toString());
//                preview.addActionListener(this);
                //panel1.add(preview);
            }

        } else if (e.getSource() == b1) {
//            fk.setVisible(true);
//            f1.setContentPane(fk);

//            f1.add(fk);
            jd = new JDialog(f1, "Key for Encryption process", true);
            jd.setSize(350, 130);
            jd.getContentPane().add(panelKey);
            jd.setLocationRelativeTo(f1);
//            jd.setUndecorated(true);
//    f1.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
//            jd.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
            //jd.setBackground(new Color(0.9f,0.9f,0.9f,0.85f));
//            jd.setBackground(new Color(0.427f, 0.651f, 0.929f,0.85f));
            jd.setResizable(false);
            jd.setVisible(true);
//            fk.setBounds(50, 200, 100, 100);
//            JOptionPane jp = new JOptionPane();
//            String kkk="key";
//            String k= JOptionPane.showInternalInputDialog(dp, "Enter key", kkk, 0);
//            int key = Integer.parseInt(tkey.getText());
//            new encrypt(f,t1.getText(),key);

            //then pop up the encryption progress
        } else if (e.getSource() == preview) {
            try {
                Desktop dt = Desktop.getDesktop();
                dt.open(f);
            } catch (Exception ex) {
            }

        } else if (e.getSource() == bok) {
            String keyString = tfk.getText();
            String messageToEncrypt = t1.getText();

            if (keyString.length() < 4 | keyString.equals("")) {
                JOptionPane.showMessageDialog(panelKey, "Key must be of min. size of 4 and max. size of 8");
            } else {
                int key = Integer.parseInt(keyString);
                new encrypt(f, messageToEncrypt, key);

            }

        } else if (e.getSource() == bcn) {
            jd.dispose();

        } else if (e.getSource() == back) {
            f1.dispose();
            new startFrame();
        } else {
            System.exit(0);
        }
    }

    public void success() {

    }
}
