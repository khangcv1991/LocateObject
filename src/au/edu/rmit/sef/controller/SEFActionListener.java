package au.edu.rmit.sef.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.sef.game.PlayRule;
import au.edu.rmit.sef.model.CellLabel;
import au.edu.rmit.sef.model.Match;
import au.edu.rmit.sef.model.Player;
import au.edu.rmit.sef.model.Point;
import au.edu.rmit.sef.ulti.SEFConstant;
import au.edu.rmit.sef.ulti.UtilityFunction;
import au.edu.rmit.sef.view.MFrame;

public class SEFActionListener {

	private MFrame parentView;
	private Match cMatch;

	public SEFActionListener(Match cMatch, MFrame parentView) {
		super();
		this.parentView = parentView;
		this.cMatch = cMatch;
	}

	public MFrame getParentView() {
		return parentView;
	}

	public void setParentView(MFrame parentView) {
		this.parentView = parentView;
	}

	public void jButton1ActionPerformed(ActionEvent e) {
		UtilityFunction.displayShapeOnBoard(parentView);
		setEnableJButton3(false);
		setEnableJButton2(true);

		setEnableJComboBox1(false);
		setEnableJComboBox2(false);
		setEnableJComboBox3(false);
		// setEnabelCellLabels(false);
	}

	public void jButton2ActionPerformed(ActionEvent e) {

		// khangcv 20150811 change
		parentView.getSquareBoard().setShapePoints(null);
		// end
		setEnableJButton3(true);
		setEnableJButton2(false);
		setEnableJButton1(false);
		setEnableJComboBox1(true);
		setEnableJComboBox2(true);
		setEnableJComboBox3(true);
		// setEnabelCellLabels(false);
	}

	public void jButton3ActionPerformed(ActionEvent e) {
		// initiate a match
		this.cMatch = new Match();

		List<Point> mList = null;
		// khangcv comment
		// switch (parentView.getjComboBox1().getSelectedIndex()) {
		// case SEFConstant.ShapeType.L_TYPE:
		// mList = UtilityFunction
		// .getShapePointCollection(SEFConstant.ShapeType.L_TYPE);
		// parentView.getSquareBoard().setShapePoints(mList);
		// break;
		// case SEFConstant.ShapeType.V_TYPE:
		// mList = UtilityFunction
		// .getShapePointCollection(SEFConstant.ShapeType.V_TYPE);
		// parentView.getSquareBoard().setShapePoints(mList);
		// break;
		// }
		// end
		// khangcv add try new function
		String tmpOpt = (String) parentView.getjComboBox1().getSelectedItem();
		mList = UtilityFunction.getShapePointCollection(tmpOpt);
		parentView.getSquareBoard().setShapePoints(mList);
		// end
		for (Point point : mList) {
			CellLabel tmp = parentView.getSquareBoard().getCellSquares()[point
					.getX()][point.getY()];

			tmp.setStatus(SEFConstant.CellStatus.C_KEY);
			// end
		}
		// khangcv create playerlist
		PlayRule.generatePlayerList(cMatch.getPlayers(), parentView
				.getjComboBox3().getSelectedIndex() + 2);

		// end
		// setEnabelCellLabels(true);
		setEnableJButton3(false);
		setEnableJButton2(true);
		setEnableJButton1(true);
		setEnableJComboBox1(false);
		setEnableJComboBox2(false);
		setEnableJComboBox3(false);

	}

	public void cellMouseReleased(MouseEvent e) {
		int opt = parentView.getjComboBox2().getSelectedIndex();
		List isList;
		List mList;// =
					// PlayRule.getChosenPointCollection(UtilityFunction.convertIdToPoint(e.getSource().toString()),
					// choiceOpt)
		switch (opt) {
		case SEFConstant.ModePlay.POINT_OPT:
			mList = PlayRule.getChosenPointCollection(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					SEFConstant.ModePlay.POINT_OPT);
			// khangcv add
			isList = UtilityFunction.getTwoPointCollectionIntersection(mList,
					parentView.getSquareBoard().getShapePoints());
			if (isList.size() == 0) {
				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.BLANK, parentView);
			} else {
				UtilityFunction.setStatusCellCollection(isList,
						SEFConstant.CellStatus.UC_KEY, parentView);
				mList.removeAll(isList);
				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.UC_KEY, parentView);

			}

			// end
			// UtilityFunction.setColorForPointCollection(mList,
			// SEFConstant.CellColorInt.WHITE_BG, parentView);
			break;

		case SEFConstant.ModePlay.LINE_OPT:
			mList = PlayRule.getChosenPointCollection(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					SEFConstant.ModePlay.LINE_OPT);
			// khangcv add
			isList = UtilityFunction.getTwoPointCollectionIntersection(mList,
					parentView.getSquareBoard().getShapePoints());
			if (isList.size() == 0) {
				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.BLANK, parentView);
			} else {
				UtilityFunction.setStatusCellCollection(isList,
						SEFConstant.CellStatus.UC_KEY, parentView);
				mList.removeAll(isList);
				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.BLANK, parentView);

			}

			// end
			// UtilityFunction.setColorForPointCollection(mList,
			// SEFConstant.CellColorInt.WHITE_BG, parentView);
			break;
		case SEFConstant.ModePlay.GRID_OPT:
			mList = PlayRule.getChosenPointCollection(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					SEFConstant.ModePlay.GRID_OPT);
			// khangcv add
			isList = UtilityFunction.getTwoPointCollectionIntersection(mList,
					parentView.getSquareBoard().getShapePoints());
			if (isList.size() == 0) {
				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.BLANK, parentView);
			} else {
				UtilityFunction.setStatusCellCollection(isList,
						SEFConstant.CellStatus.UC_KEY, parentView);
				mList.removeAll(isList);
				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.BLANK, parentView);

			}

			// end
			// UtilityFunction.setColorForPointCollection(mList,
			// SEFConstant.CellColorInt.WHITE_BG, parentView);
			break;

		}
		// khangcv add temporarily
		// System.out.println(PlayRule.checkWin(parentView));;
		System.out.println(PlayRule.getPlayerForTurn(cMatch, parentView));
		// end
	}

	public void cellMousePressed(MouseEvent e) {
		int opt = parentView.getjComboBox2().getSelectedIndex();
		List isList;
		List mList;// =
					// PlayRule.getChosenPointCollection(UtilityFunction.convertIdToPoint(e.getSource().toString()),
					// choiceOpt)

		switch (opt) {
		case SEFConstant.ModePlay.POINT_OPT:
			mList = PlayRule.getChosenPointCollection(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					SEFConstant.ModePlay.POINT_OPT);
			isList = UtilityFunction.getTwoPointCollectionIntersection(mList,
					parentView.getSquareBoard().getShapePoints());
			if (isList.size() != 0) {

				UtilityFunction.setStatusCellCollection(isList,
						SEFConstant.CellStatus.UC_KEY, parentView);
			} else {

				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.ON_CLICK, parentView);
			}

			PlayRule.getStatusLabel(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					opt, parentView);
			// end
			break;

		case SEFConstant.ModePlay.LINE_OPT:
			mList = PlayRule.getChosenPointCollection(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					SEFConstant.ModePlay.LINE_OPT);
			isList = UtilityFunction.getTwoPointCollectionIntersection(mList,
					parentView.getSquareBoard().getShapePoints());
			if (isList.size() != 0) {

				UtilityFunction.setStatusCellCollection(isList,
						SEFConstant.CellStatus.UC_KEY, parentView);
				mList.removeAll(isList);
				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.ON_CLICK, parentView);
			} else {

				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.ON_CLICK, parentView);
			}

			// UtilityFunction.setColorForPointCollection(mList,
			// SEFConstant.CellColorInt.GRAY_BG, parentView);
			// khangcv add display
			PlayRule.getStatusLabel(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					opt, parentView);
			// end
			break;
		case SEFConstant.ModePlay.GRID_OPT:
			mList = PlayRule.getChosenPointCollection(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					SEFConstant.ModePlay.GRID_OPT);
			isList = UtilityFunction.getTwoPointCollectionIntersection(mList,
					parentView.getSquareBoard().getShapePoints());
			if (isList.size() != 0) {

				UtilityFunction.setStatusCellCollection(isList,
						SEFConstant.CellStatus.UC_KEY, parentView);
				mList.removeAll(isList);
				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.ON_CLICK, parentView);
			} else {

				UtilityFunction.setStatusCellCollection(mList,
						SEFConstant.CellStatus.ON_CLICK, parentView);
			}
			// UtilityFunction.setColorForPointCollection(mList,
			// SEFConstant.CellColorInt.GRAY_BG, parentView);
			// khangcv add display
			PlayRule.getStatusLabel(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					opt, parentView);
			// end
			break;

		}
	}

	// disable or enable controller
	private void setEnableJButton1(boolean opt) {
		parentView.getjButton1().setEnabled(opt);
	}

	private void setEnableJButton2(boolean opt) {
		parentView.getjButton2().setEnabled(opt);
	}

	private void setEnableJButton3(boolean opt) {
		parentView.getjButton3().setEnabled(opt);
	}

	private void setEnableJComboBox1(boolean opt) {
		parentView.getjComboBox1().setEnabled(opt);
	}

	private void setEnableJComboBox2(boolean opt) {
		parentView.getjComboBox2().setEnabled(opt);
	}

	private void setEnableJComboBox3(boolean opt) {
		parentView.getjComboBox3().setEnabled(opt);
	}

	private void setEnabelCellLabels(boolean opt) {
		for (int i = 0; i < SEFConstant.NUM_ROW; i++) {
			for (int j = 0; j < SEFConstant.NUM_COL; j++)
				parentView.getSquareBoard().getCellSquares()[i][j]
						.setEnabled(opt);
		}
	}
}
