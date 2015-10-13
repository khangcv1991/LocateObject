package au.edu.rmit.sef.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import au.edu.rmit.sef.ulti.SEFConstant;

public class CellLabel extends JLabel {
	private String id;
	private int status;

	/**
	 * Constructor initiate the id value for the Cell
	 * 
	 * @param id
	 */
	public CellLabel(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return status of cell with 0 - nothing 1 - cover key 2 - uncover key
	 */
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
		switch (status) {
		case SEFConstant.CellStatus.BLANK:
			this.setIcon(new ImageIcon(SEFConstant.CellColor.WHITE_BG));
			break;
		case SEFConstant.CellStatus.UC_KEY:
			this.setIcon(new ImageIcon(SEFConstant.CellColor.RED_BG));
			break;
		case SEFConstant.CellStatus.C_KEY:
			this.setIcon(new ImageIcon(SEFConstant.CellColor.WHITE_BG));
			break;
		case SEFConstant.CellStatus.ON_CLICK:
			this.setIcon(new ImageIcon(SEFConstant.CellColor.GRAY_BG));
			break;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id;
	}

}
