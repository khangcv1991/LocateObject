package au.edu.rmit.sef.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import au.edu.rmit.sef.ulti.SEFConstant;

public class BoardPanel extends JScrollPane {
	// private Broad broad;
	Board board;

	public BoardPanel(Board panel) {
		super(panel);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setBounds(0, 0, 720, 425);
	}
	
	public BoardPanel(int numRow, int numCol) {
		super();
		board = new Board( numRow,  numCol);

	}

	public Board getBroad() {
		return board;
	}

	public void setBroad(Board broad) {
		this.board = broad;
	}

}
