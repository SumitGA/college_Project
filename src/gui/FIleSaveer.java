/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sumitg
 */
public class FIleSaveer {

    public static void main(String[] args) {

        JFileChooser fc = new JFileChooser("Open an image");
     
      
          fc.setAcceptAllFileFilterUsed(false);
        
      

        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Images( *.png)","png");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Images( *.bmp)","bmp");
        System.out.println(fc.getChoosableFileFilters());
        fc.setFileFilter(filter1);
        String ex = filter1.getDescription();
        System.out.println(fc.get);
        
       
        
        
        fc.setFileFilter(filter2);
        fc.showSaveDialog(fc);



    }

}
