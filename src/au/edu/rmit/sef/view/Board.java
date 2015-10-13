package au.edu.rmit.sef.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

import au.edu.rmit.sef.model.Point;
import au.edu.rmit.sef.ulti.SEFConstant;

public class Board extends JPanel {

	private int numRow = SEFConstant.NUM_ROW;
	private int numCol = SEFConstant.NUM_COL;
	private CellLabel[][] cellSquares;
	private List shapePoints;

	public Board() {
		super(new GridLayout(0, SEFConstant.NUM_COL));
		initBroad();
	}

	public Board(int numRow, int numCol) {
		super(new GridLayout(0, SEFConstant.NUM_COL));
		initBroad();
	}

	public int getNumRow() {
		return numRow;
	}

	public void setNumRow(int numRow) {
		this.numRow = numRow;
	}

	public int getNumCol() {
		return numCol;
	}

	public void setNumCol(int numCol) {
		this.numCol = numCol;
	}

	public CellLabel[][] getCellSquares() {
		return cellSquares;
	}

	public void setCellSquares(CellLabel[][] cellSquares) {
		this.cellSquares = cellSquares;
	}

	private void initBroad() {
		// scrollPane = new JScrollPane();
		cellSquares = new CellLabel[numRow][numCol];
		// broad = new javax.swing.JPanel(new GridLayout(0, numRowCol));
		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j < numCol; j++) {
				CellLabel lab = new CellLabel(i + "-" + j);
				Border blackline = BorderFactory.createLineBorder(Color.black);
				lab.setSize(SEFConstant.CELL_SIZE, SEFConstant.CELL_SIZE);
				lab.setBorder(blackline);
				lab.setBackground(Color.WHITE);
				lab.setIcon(new ImageIcon(SEFConstant.CellColor.WHITE_BG));
				lab.setStatus(SEFConstant.CellStatus.BLANK);
				//lab.setEnabled(false);
				cellSquares[i][j] = lab;
				this.add(cellSquares[i][j]);
			}
		}
		// cellSquares[0][0].setIcon(new
		// ImageIcon(SEFConstant.CellColor.RED_BG));
	}

	public List getShapePoints() {
		return shapePoints;
	}

	public void setShapePoints(List shapePoints) {

		if (this.shapePoints != null && shapePoints == null) {
			for (Object point : this.shapePoints) {
				Point tmp = (Point) point;
				if (shapePoints == null)
					cellSquares[tmp.getX()][tmp.getY()]
							.setStatus(SEFConstant.CellStatus.BLANK);
			}

		}

		this.shapePoints = shapePoints;

		if (this.shapePoints != null) {
			for (Object point : this.shapePoints) {
				Point tmp = (Point) point;
				if (shapePoints == null)
					cellSquares[tmp.getX()][tmp.getY()]
							.setStatus(SEFConstant.CellStatus.C_KEY);
			}

		}
	}
}
