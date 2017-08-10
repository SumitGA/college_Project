/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsb;

import gui.decodeFrame;
<<<<<<< HEAD
import gui.startFrame;
=======
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
<<<<<<< HEAD
import javax.swing.JDialog;
import javax.swing.JOptionPane;
=======
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
import shiftCipher.decrypt;

/**
 *
 * @author SumitG
 */
<<<<<<< HEAD
//this code is for decode the message.. to retrieve the message from the image
public class decode {

    BufferedImage p = null;
    String message = "", ml = "";
    String lmessage = "";
    int width;
    int height;
    File f;
    int key;

    JDialog dialog = new JDialog();
    public static String orgMessage = "";
    String sPath = "";

    public decode() {
    }

    public decode(File f, int key) throws IOException {
        dialog.setSize(650, 40);
        dialog.setTitle("Performing the retrieving and decryption process... Please wait for a while!");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        dialog.setVisible(true);

        sPath = f.toString();

        long t = System.nanoTime(); //start of processing time

//main processing part
        this.f = f;
        this.key = key;
        // File f = fi;//new File("F:/testDgui.png"); //image file path
=======

//this code is for decode the message.. to retrieve the message from the image

public class decode {
    BufferedImage p = null;
    String message="",ml="";
    String lmessage="";
       int width;
       int height;
    File f;
    int key;
       
    decode(){}
    public decode(File f,int key) throws IOException{
          this.f=f;
          this.key=key;
         // File f = fi;//new File("F:/testDgui.png"); //image file path
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
        p = ImageIO.read(f);
        //newImage = image;
        width = p.getWidth();
        height = p.getHeight();
<<<<<<< HEAD

        for (int i = 0; i < 8; i++) {
            int j = 0;
            Color c = new Color(p.getRGB(j, i));
            if (c.getRed() % 2 == 1) {
                lmessage += "1";
            } else {
                lmessage += "0";
            }
            if (c.getGreen() % 2 == 1) {
                lmessage += "1";
            } else {
                lmessage += "0";
            }
            if (c.getBlue() % 2 == 1) {
                lmessage += "1";
            } else {
                lmessage += "0";
            }
            if (lmessage.length() > 7) {
                char lpc = convertBinary(lmessage.substring(0, 7));
                if (lpc <= 31 || lpc >= 127) {
                    lpc = '*';
                }
                ml += lpc;

                lmessage = lmessage.substring(7, lmessage.length());

            }

        }
        int len = Integer.parseInt(ml);

        String newm = "";
        int checker, count = 0;
        checker = (len * 7) + 24;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(p.getRGB(i, j));
                if (count >= checker) {
                    break;
                }
                if (c.getRed() % 2 == 1) {
                    message += "1";
                    count++;
                } else {
                    message += "0";
                    count++;
                }
                if (c.getGreen() % 2 == 1) {
                    message += "1";
                    count++;
                } else {
                    message += "0";
                    count++;
                }
                if (c.getBlue() % 2 == 1) {
                    message += "1";
                    count++;
                } else {
                    message += "0";
                    count++;
                }
                if (message.length() > 7) {
                    char pc = convertBinary(message.substring(0, 7));
                    if (pc <= 31 || pc >= 127) {
                        pc = '*';
                    }
                    newm += pc;
                    message = message.substring(7, message.length());

                }
                if (count >= checker) {
                    break;
                }
            }
        }
        newm = newm.substring(3);
//        System.out.println(" message " + newm);

        new decrypt(newm, key);

        //main processing part end
        long et = System.nanoTime(); //end of processing time of main part

        long stime = System.currentTimeMillis();
        long etime = stime + 2000; //to check 2 second
        if ((et - t) < 2000000000) {
            //dekhauni
            for (long i = stime; i < (etime); i = System.currentTimeMillis()) {
                System.out.println("Processing...");
            }
            endProcess();
        } else {
            endProcess();
        }

    }

    public char convertBinary(String bin) {
=======
        
    for (int i = 0; i < 8; i++)  {
           int j=0;
        Color c = new Color(p.getRGB(j, i));              
                if (c.getRed() % 2 == 1) {
                        lmessage += "1";
                    } else {
                        lmessage += "0";
                    }                    
                    if (c.getGreen() % 2 == 1) {
                        lmessage += "1";
                    } else {
                        lmessage += "0";
                    }
                    if (c.getBlue() % 2 == 1) {
                        lmessage += "1";
                    } else {
                        lmessage += "0";
                    }
                    if (lmessage.length() > 7) {
                       // System.out.println("m "+message);
                       // System.out.println("mss "+message.substring(0,7));
                        char lpc = convertBinary(lmessage.substring(0, 7));
                        if (lpc <= 31 || lpc >= 127)  {
                            lpc = '*';
                        }
                        ml+=lpc;
//                        System.out.println(" m l "+ml);
//                        System.out.print(lpc);
                        lmessage = lmessage.substring(7, lmessage.length());
//                        System.out.println(" meb "+message);
                        
                    }
                   
    }   
        int len = Integer.parseInt(ml);
//        System.out.println("\n\n\n");
        String newm="";
        int checker,count=0;
        checker=(len*7)+24;
    for (int i = 0; i < width ; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(p.getRGB(i, j)); 
                if(count>=checker){ 
                        //System.out.println("_______________________________________________");
                        break; 
                    }
                if (c.getRed() % 2 == 1) {
                        message += "1";
                        count++;
//                        if(checker==count) break;
                    } else {
                        message += "0";
                        count++;
//                        if(checker==count) break;
                    }                    
                    if (c.getGreen() % 2 == 1) {
                        message += "1";
                        count++;
//                        if(checker==count) break;
                    } else {
                        message += "0";
                        count++;
//                        if(checker==count) break;
                    }
                    if (c.getBlue() % 2 == 1) {
                        message += "1";
                        count++;
//                        if(checker==count) break;
                    } else {
                        message += "0";
                        count++;
//                        if(checker==count) break;
                    }
                    if (message.length() > 7) {
//                        System.out.println("m "+message);
//                        System.out.println("mss "+message.substring(0,7));
                        char pc = convertBinary(message.substring(0, 7));
                        if (pc <= 31 || pc >= 127)  {
                            pc = '*';
                        }
//                        if()
                        newm+=pc;
//                        System.out.print(count + " cpc "+pc);
                        message = message.substring(7, message.length());
//                        System.out.println(" meb "+message);
                        
                    }
                    if(count>=checker){ 
                        //System.out.println("_______________________________________________");
                        break; 
                    }
//                    System.out.println(" check "+checker+" count "+count);
            }
    }
        newm=newm.substring(3);
        System.out.println(" message " +newm); 
        
        new decrypt(newm,key);
    }
    
     public char convertBinary(String bin) {
>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
        int num = 0;
        for (int i = 0; i < 7; i++) {
            num += Math.pow(2, 6 - i) * Integer.parseInt("" + bin.charAt(i));
        }
        //System.out.println("Convert to Binary " +num+" char : "+ (char) num);
<<<<<<< HEAD
        return (char) num;
    }

    private void endProcess() throws IOException {
        dialog.dispose();
        
        JOptionPane.showMessageDialog(null, orgMessage, "Original Message", JOptionPane.INFORMATION_MESSAGE);
        int option1 = JOptionPane.showConfirmDialog(null, "Do you want to open the saved stego-image folder?", "Process complete!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
        int option2 = -1;
        if (option1 == 0) {
            if (Desktop.isDesktopSupported()) {
                String fpath = sPath.substring(0, sPath.lastIndexOf('\\'));
                Desktop.getDesktop().open(new File(fpath));
                option2 = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Process complete!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
            } else {
                JOptionPane.showMessageDialog(null, "Awt Desktop is not supported!");
                option2 = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Process complete!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
            }

        } else if (option1 == 1) {
            option2 = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Process complete!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
        }

        if (option2 == 0) {
            System.exit(0);
        } else if (option2 == 1) {
            new startFrame();
        }
    }

}
=======
        return (char)num;
    }
     
     public static void main(String[] args) throws IOException {
//        new decode();
/*String bin="0110000";
    int num=0;
for(int i=0; i<7;i++){
    num += Math.pow(2, 6 - i) * Integer.parseInt("" + bin.charAt(i));
    System.out.println(" pow "+Math.pow(2,7-i));
         System.out.println("num "+num+" and bin char at "+i+" = "+Integer.parseInt(""+bin.charAt(i)));
}
         System.out.println(" char "+(char) num);
  */  }
}

>>>>>>> 526bf91e031cade1495973d8df837ebaab7cd250
