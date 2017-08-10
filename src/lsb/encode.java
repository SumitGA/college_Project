/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsb;

import gui.encodeFrame;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author SumitG
 */
public final class encode {
    public encode(){}
    public encode(File fi, String message) {
        try {
            BufferedImage image = null;
            // BufferedImage newImage = null;
            int width;
            int height;
            //File f = null;
            Color newC;
            int newRGB;
            //read image
            int messageLength;
            String ml, messageE;
           // File f = new File("E:/New folder/dipen/DSCF3833.jpg"); //image file path
            image = ImageIO.read(fi);
            width = image.getWidth();
            height = image.getHeight();
            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);;

//            String message;

            // get the message from the user  
//            message = "This is test for embedding";
            messageLength = message.length();
            ml = Integer.toString(messageLength);

            int count = 0;
            int sn = 0;
            // Turn message into bits if we're encoding
            if (true) {
                if (message.length() != 3) {
                    ml = String.format("%03d", messageLength);
                }
                message = ml + message;
//                System.out.println("message " + message);
                //ml = convertToBinary(ml);
                messageE = convertToBinary(message);

//            System.out.println("length "+ml+"\n");
                // System.out.println("lngth int "+ Integer.parseInt(ml));
            }

            // analyze the image accordingly
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {

                    Color c = new Color(image.getRGB(i, j));
                    sn++;

                    int newRed = c.getRed();
                    if (count < messageE.length()
                            && c.getRed() % 2 != Integer.parseInt("" + messageE.charAt(count))) {
                        if (c.getRed() % 2 == 0) {
                            newRed += 1;
                        } else {
                            newRed -= 1;
                        }
                    }
                    count++;

                    int newGreen = c.getGreen();
                    if (count < messageE.length()
                            && c.getGreen() % 2 != Integer.parseInt("" + messageE.charAt(count))) {
                        if (c.getGreen() % 2 == 0) {
                            newGreen += 1;
                        } else {
                            newGreen -= 1;
                        }
                    }
                    count++;

                    int newBlue = c.getBlue();
                    if (count < messageE.length()
                            && c.getBlue() % 2 != Integer.parseInt("" + messageE.charAt(count))) {
                        if (c.getBlue() % 2 == 0) {
                            newBlue += 1;
                        } else {
                            newBlue -= 1;
                        }
                    }
                    count++;
                    newC = new Color(newRed, newGreen, newBlue);

                    newImage.setRGB(i, j, newC.getRGB());
                }

            }

            ImageIO.write(newImage, "png", new File("F:/testDgui.png"));
            System.out.println("File saved succesfully");
            String s="success";
            new encodeFrame(s);//.success();

        } catch (Exception ex) {

        }

    }//end of contructor

    public String convertToBinary(String message) {
        String bin = "";
        for (int i = 0; i < message.length(); i++) {
            bin += convertLetter(message.charAt(i));
        }

        return bin;
    }

    /**
     * ***********
     * Brings in an ASCII character, and return a binary representation of that
     * number ***********
     */
    public String convertLetter(char c) {
        int x = (int) (c);
        String bin = "";
        for (int i = 0; i < 7; i++) {
            bin = "" + (x % 2) + bin;
            x = x / 2;
        }
        return bin;
    }

    /**
     * ***********
     * Brings in a String representation of a binary number, and returns the int
     * representation for that number ***********
     */
    public char convertBinary(String bin) {
        int num = 0;
        for (int i = 0; i < 7; i++) {
            num += Math.pow(2, 7 - i) * Integer.parseInt("" + bin.charAt(i));
        }
        //. System.out.println("Convert to Binary " +num+" char : "+ (char) num);
        return (char) num;
    }

    private String filename;

    public void save(File file, Image image) {

        this.filename = file.getName();
        //if (frame != null) { frame.setTitle(filename); }
        String suffix = filename.substring(filename.lastIndexOf('.') + 1);
        suffix = suffix.toLowerCase();
        if (suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png")) {
            try {
                ImageIO.write((RenderedImage) image, suffix, file);
            } catch (IOException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("" + ex);
            }

        } else {
            System.out.println("Error: filename must end in .jpg or .png");
        }
    }

    public static void main(String[] args) {
//        new encode();
    }
}
