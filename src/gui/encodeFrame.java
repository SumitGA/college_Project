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
<<<<<<< HEAD
import javax.swing.filechooser.FileFilter;
=======
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
import javax.swing.filechooser.FileNameExtensionFilter;
import lsb.encode;
import shiftCipher.encrypt;

/**
 *
<<<<<<< HEAD
 * @author SumitG
=======
 * @author Dipen
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
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
<<<<<<< HEAD

    JTextField tf1, tkey;
    JTextField tfk;
    JPanel panel1, mp, panelKey;
    JScrollPane scp, scArea;
=======
    JTextField tf1, tkey, tfk;
    JPanel panel1, mp, panelKey;
    JScrollPane scp;
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
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
<<<<<<< HEAD

        f1.setUndecorated(true);

=======
//        fk.setUndecorated(true);

        f1.setUndecorated(true);
//    f1.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
        f1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        f1.setBackground(new Color(0.9f, 0.9f, 0.9f, 0.85f));
        f1.setBackground(new Color(0.427f, 0.651f, 0.929f, 0.85f));
        f1.setLocationRelativeTo(null);
<<<<<<< HEAD

        MenuBar addMenu = new MenuBar();
        f1.setJMenuBar(addMenu.menubar);
        
=======
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
        panel1.setOpaque(false);

        l1 = new JLabel("Image Preview");
        l1.setBounds(10, 5, 100, 25);

        scp = new JScrollPane();
        scp.setBounds(10, 35, 390, 280);
<<<<<<< HEAD
=======
//        imagePreview.setBounds(10,35,390,280);
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250

        browse = new JButton("Browse Image");
        browse.setBounds(360, 65, 121, 25);

        tf1 = new JTextField();
        tf1.setBounds(50, 65, 300, 25);
        tf1.setEditable(false);
        tf1.setText("Choose an Image File");

        JSeparator sp = new JSeparator(SwingConstants.HORIZONTAL);
        sp.setBounds(10, 265, 520, 25);

<<<<<<< HEAD
        t1 = new JTextArea();
        t1.setOpaque(false);
        t1.setLineWrap(true);
        scArea = new JScrollPane(t1);

        scArea.setBorder(BorderFactory.createTitledBorder("Message to Embed"));

        scArea.setBounds(10, 275, 520, 200);

        b1 = new JButton("Encrypt");
        b1.setBounds(150, 520, 80, 25);

        back = new JButton("Back");
        back.setBounds(250, 520, 80, 25);

        b2 = new JButton("Cancel");
        b2.setBounds(350, 520, 80, 25);

=======
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
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
        preview = new JButton("Image Preview");
        preview.setEnabled(false);
        preview.setBounds(200, 200, 121, 40);

<<<<<<< HEAD
        psw = new JPasswordField();

        panel1.add(tf1);
        panel1.add(browse);

        panel1.add(sp);
        panel1.add(scArea);
=======
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
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
        panel1.add(preview);
        panel1.add(b1);
        panel1.add(b2);
        panel1.add(back);
<<<<<<< HEAD

        panelKey = new JPanel(null);

=======
//        panel1.add(lkey); 
//        panel1.add(tkey);

        panelKey = new JPanel(null);
//        panelKey.setOpaque(false);
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
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

<<<<<<< HEAD
=======
//        panelKey.add(tkey);
//        
//        jpop=new JPopupMenu();
//        jpop.add(panelKey);
//        panelKey.add(tkey);
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
        browse.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        back.addActionListener(this);
        bok.addActionListener(this);
        bcn.addActionListener(this);
        preview.addActionListener(this);
<<<<<<< HEAD

        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
//                char msg = e.getKeyChar();
                String msg = t1.getText();
                if (msg.length() >= 250) {
                    e.consume();
                }
            }
        });

=======
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
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

<<<<<<< HEAD
    
=======
    public static void main(String[] args) {
        new encodeFrame();
    }
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250

    public void actionPerformed(ActionEvent e) {

        String ppp = "";
        if (e.getSource() == browse) {
            JFileChooser fc = new JFileChooser("Open an image");

<<<<<<< HEAD
            fc.setAcceptAllFileFilterUsed(false);

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(*.jpg , *.png)", "png", "jpg", "bmp");
            fc.setFileFilter(filter);

            if (fc.showOpenDialog(f1) == fc.APPROVE_OPTION) {

                preview.setEnabled(true);

                f = fc.getSelectedFile();

                File openFile = new File(f.getPath());

                long fileSize = openFile.length();

                System.out.println(openFile);
                try {
                    BufferedImage image = ImageIO.read(openFile);

                    int imgHeight = image.getHeight();
                    int imgWidth = image.getWidth();
                    int imageSize = imgHeight * imgWidth;

                    //file size minimum of 500 KB
                    if ((imgHeight < 320 && imgWidth < 320) && (fileSize == 512000)) {
                        JOptionPane.showMessageDialog(fc, "Invalid Image. Please select image with greater height and width ");
                    }

                    //file size minimum of 8 MB
                    if ((imgHeight > 2500 && imgWidth > 2500) && (fileSize == 8500000)) {
                        JOptionPane.showMessageDialog(fc, "Invalid Image. Please select image with smaller height and width");
                    }

                } catch (IOException ex) {
                    Logger.getLogger(encodeFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

=======
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(*.jpg , *.png)", "png", "jpg","bmp");
            fc.setFileFilter(filter);
            
            if (fc.showOpenDialog(f1) == fc.APPROVE_OPTION) {
//                preview=new JButton("Larger Preview");
//                preview.setBounds(410,100,120,25);  
                preview.setEnabled(true);

                // System.out.println(ppp);
                //f=new File(ppp);
                f = fc.getSelectedFile();

>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
                imagePreview = new JLabel(new ImageIcon(f.getPath()));

                scp.getViewport().add(imagePreview);

                tf1.setText(f.toString());
<<<<<<< HEAD

            }

        } else if (e.getSource() == b1) {

            if (f == null) {
                JOptionPane.showMessageDialog(panel1, "You must select an image!");
            }
            if (t1.getText().length() == 0 || t1.getText().length() > 250) {
                JOptionPane.showMessageDialog(panel1, "Message must not be empty or have only 250 character!");
            } else {
                jd = new JDialog(f1, "Key for Encryption process", true);
                jd.setSize(350, 130);
                jd.getContentPane().add(panelKey);
                jd.setLocationRelativeTo(f1);

                jd.setResizable(false);
                jd.setVisible(true);
            }
=======
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
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
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
<<<<<<< HEAD
                jd.dispose();
                String fileSavePath = fileSaver();
                try {
                    new encrypt(f, messageToEncrypt, key, fileSavePath);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
=======
                new encrypt(f, messageToEncrypt, key);
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250

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

<<<<<<< HEAD
   

    public String fileSaver() {

        JFileChooser fc = new JFileChooser("Open an image");

        fc.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Images( *.png)", "png");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Images( *.bmp)", "bmp");

        System.out.println(fc.getChoosableFileFilters());

        fc.addChoosableFileFilter(filter1);
        fc.addChoosableFileFilter(filter2);

        fc.showSaveDialog(fc);

        FileFilter currentFilter = fc.getFileFilter();
        String getFilter = currentFilter.getDescription();
        System.out.println(getFilter);
        String getExtension = getFilter.substring(getFilter.lastIndexOf(".") + 1, getFilter.indexOf(")"));

        String filePath = fc.getSelectedFile().toString();

//        System.out.println(fc.getSelectedFile());
        f1.dispose();
        if (getExtension.equalsIgnoreCase("png") == true) {
//            System.out.println("You saved image in png format");
            filePath = filePath + ".png";
            System.out.println("fpath " + filePath);
        }

        if (getExtension.equalsIgnoreCase("bmp") == true) {
//            System.out.println("You saved image in bmp format");
            filePath = filePath + ".bmp";
            System.out.println("fpath " + filePath);
        }

        return filePath;
=======
    public void success() {
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250

    }
}
