/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;

/**
 *
 * @author SumitG
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;

public class MenuBar {

    public JMenuBar menubar;
    public JMenu fileMenu, helpMenu;
    public JMenuItem exit, help, about;

    public MenuBar() {

        menubar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");

        exit = new JMenuItem("Exit");
        help = new JMenuItem("Help");
        about = new JMenuItem("About");

        fileMenu.add(exit);
        helpMenu.add(help);
        helpMenu.add(about);

        menubar.add(fileMenu);
        menubar.add(helpMenu);
        // this.add(menubar);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );

        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    URL url = getClass().getResource("/resource/test.txt");
                    File pdfFile = new File(url.getPath());

                    if (pdfFile.exists()) {

                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().open(pdfFile);
                        } else {
                            System.out.println("Awt Desktop is not supported!");
                        }
                    }

                } catch (IOException ex) {
                    Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextPane s = new JTextPane();
                s.setPreferredSize(new Dimension(400, 400));
                //s.setLineWrap(true);
                s.setEditable(false);
                s.setBackground(new Color(0.9f, 0.9f, 0.9f, 0.85f));
                s.setOpaque(false);
                //s.setMargin( new Insets(0, 5, 0, 4) );
                URL aboutUrl = getClass().getResource(
                        "/resource/about.html");

                if (aboutUrl != null) {
                    try {
                        s.setPage(aboutUrl);
                    } catch (IOException x) {
                        System.err.println("Attempted to read a bad URL: " + aboutUrl);
                    }
                }
                JOptionPane.showMessageDialog(null, s, "About Us", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        );
    }
}
