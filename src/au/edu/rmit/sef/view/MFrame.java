/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.rmit.sef.view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import au.edu.rmit.sef.ulti.SEFConstant;

/**
 *
 * @author Khang
 */
public class MFrame extends javax.swing.JFrame {

	
	// 20151011 khangcv add
	private Screen1 screen1;
	private Screen2 screen2;
	private Screen3 screen3;
	private Screen4 screen4;
	private Screen5 screen5;
	// end
	/**
	 * Creates new form MFrame
	 */
	public MFrame() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		 screen1 = new Screen1();
		 screen2 = new Screen2();
		 screen3 = new Screen3();
		 screen4 = new Screen4();
		 screen5 = new Screen5();
		 setScreen(SEFConstant.GameState.SCREEN1);
		 this.setSize(800,600);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);
	}

	/*
	 * 20151011 khangcv
	 */
	public void setScreen(int state) {
		this.getContentPane().removeAll();
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(1, 1));
		
		switch (state) {
		case SEFConstant.GameState.SCREEN1:
			con.add(screen1);
			break;
		case SEFConstant.GameState.SCREEN2:
			con.add(screen2);
			break;
		case SEFConstant.GameState.SCREEN3:
			con.add(screen3);
			break;
		case SEFConstant.GameState.SCREEN4:
			con.add(screen4);
			break;
		case SEFConstant.GameState.SCREEN5:
			con.add(screen5);
			this.setSize(1200,700);
			break;
		}
		SwingUtilities.updateComponentTreeUI(this);
	}

	public Screen1 getScreen1() {
		return screen1;
	}

	public void setScreen1(Screen1 screen1) {
		this.screen1 = screen1;
	}

	public Screen2 getScreen2() {
		return screen2;
	}

	public void setScreen2(Screen2 screen2) {
		this.screen2 = screen2;
	}

	public Screen3 getScreen3() {
		return screen3;
	}

	public void setScreen3(Screen3 screen3) {
		this.screen3 = screen3;
	}

	public Screen4 getScreen4() {
		return screen4;
	}

	public void setScreen4(Screen4 screen4) {
		this.screen4 = screen4;
	}

	public Screen5 getScreen5() {
		return screen5;
	}

	public void setScreen5(Screen5 screen5) {
		this.screen5 = screen5;
	}

	
	

	// end
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	
	
}
