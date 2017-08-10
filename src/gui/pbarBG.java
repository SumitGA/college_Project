/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author SumitG
 */
public class pbarBG extends SwingWorker<Void, Void>{
    JLabel l1;
    JFrame f1;
    JPanel p1;
    static boolean success=false;
    Timer timer2;
    public pbarBG(){
        System.out.println("in pbartry");
       
/*        
        long t= System.currentTimeMillis();
        long end = t+2000;
         timer2=new Timer(100,new ActionListener(){
            int value=0;
            int i=1;
            
            public void actionPerformed(ActionEvent e){
                
            if((System.currentTimeMillis() < end) ){
                System.out.println("if insisde ");
                 setVisible(true);
                 
// progress dekhauni
                System.out.println("if inside");
            }else if((System.currentTimeMillis() >= end) && success==false ){ //&&uta bata success aako xaina vaye
                System.out.println(" suc in pb uta bata success aako xaina "+success);
                setVisible(true);
                
// progress visible
            }
            else if((System.currentTimeMillis() >= end) && success==true){  //uta bata success aako xa vaye
                System.out.println(" suc in pb uta bata success aako "+success);
                timer2.stop();
                setVisible(false);
                dispose();
// progress hide other kaam
            
            }
            
                value+=5;
//                if(value>100){
                if(false){
                   // timer2.stop();
                    
                }
                if(value>=100){
                    value=0;
                    
                }
                if(i==1){
                    setTitle("Working.\t");
                    i++;                   
                }
                else if(i==2){
                    setTitle("Working..\t");
                    i++;
                }
                else if(i==3){
                    setTitle("Working...\t");
                    i=1;
                }
                
            }
        });
        timer2.start();
        
  */      
       // setVisible(true);
    }
    
    public static void check(boolean value){
        System.out.println(" inside check suc "+success);
        success = value;
    }
    
    public static void main(String[] args) {
//        new pbarTry();
    }

    @Override
    protected Void doInBackground() throws Exception {
        f1= new JFrame("Working"); 
//        BufferedImage bimg ;
//        File input1 = new File("e:/pbar/f.gif");
//         bimg= ImageIO.read(input1);
         
        f1.setSize(550,250);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(false);
        f1.setUndecorated(true);
        f1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        f1.setBackground(new Color(0.902f, 0.918f, 0.949f,0.85f));
        
        f1.setLocationRelativeTo(new JFrame());
        
        p1=new JPanel();
       
        l1=new JLabel();
        //l1.setOpaque(false);
        l1.setText("Work is bein done.");
//        l1.setIcon(new ImageIcon(bimg));
        
        JProgressBar pbar=new JProgressBar();
//        pbar.setIgnoreRepaint(false);
//        System.out.println(pbar.getUI());
        pbar.setIndeterminate(true);
        pbar.setForeground(Color.BLUE);
        pbar.setBorder(BorderFactory.createEmptyBorder());
        
        f1.add(pbar);

//        p1.setOpaque(false);
//        p1.add(l1);
//        f1.add(new JLabel(new ImageIcon("e:/pbar/f.gif")));
//        f1.add(l1);
        f1.setVisible(true);
        
        if( success==false ){ //&&uta bata success aako xaina vaye
                System.out.println(" suc in pb uta bata success aako xaina "+success);
                
        
                pbar.setVisible(true);
                //setVisible(true);
                
// progress visible
            }
            else if(success==true){  //uta bata success aako xa vaye
                System.out.println(" suc in pb uta bata success aako "+success);
                //timer2.stop();
                f1.setVisible(false);
                
                f1.dispose();
// progress hide other kaam
            
            }
        
        return null;
    
    }
    
    public void done(){
        Toolkit.getDefaultToolkit().beep();
        f1.dispose();
        JOptionPane.showMessageDialog(null, "Done done");
    }

 
}

