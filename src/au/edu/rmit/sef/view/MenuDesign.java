/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.rmit.sef.view;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Khang
 */
public class MenuDesign {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame gui = new JFrame();
		gui.setTitle("test");
		gui.setSize(400,400);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      Container con = gui.getContentPane();
                      con.setLayout(new GridLayout(1,1));
                   con.add(new Screen3());
		gui.setVisible(true);
    }
    
}
