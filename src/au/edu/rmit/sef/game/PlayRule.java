package au.edu.rmit.sef.game;

import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.sef.model.Match;
import au.edu.rmit.sef.model.Player;
import au.edu.rmit.sef.model.Point;
import au.edu.rmit.sef.ulti.SEFConstant;
import au.edu.rmit.sef.ulti.UtilityFunction;
import au.edu.rmit.sef.view.MFrame;

public class PlayRule {
	/**
	 * the method return a list of points when mouse click on the board
	 * 
	 * @param point
	 * @param choiceOpt
	 * @return
	 */

	public static List getChosenPointCollection(Point point, int choiceOpt) {
		List mList = new ArrayList<Point>();
		switch (choiceOpt) {
		case SEFConstant.ModePlay.POINT_OPT:
			mList.add(new Point(point.getX(), point.getY()));
			break;
		case SEFConstant.ModePlay.LINE_OPT:
			for (int i = 0; i < SEFConstant.NUM_COL; i++) {
				mList.add(new Point(point.getX(), i));
			}
			break;
		case SEFConstant.ModePlay.GRID_OPT:
			mList.add(point);
			if (point.getX() - 1 >= 0 && point.getY() - 1 >= 0)
				mList.add(new Point(point.getX() - 1, point.getY() - 1));

			if (point.getY() - 1 >= 0)
				mList.add(new Point(point.getX() - 0, point.getY() - 1));

			if (point.getX() + 1 <= SEFConstant.NUM_ROW - 1
					&& point.getY() + 1 <= SEFConstant.NUM_COL - 1)
				mList.add(new Point(point.getX() + 1, point.getY() + 1));

			if (point.getX() - 1 >= 0)
				mList.add(new Point(point.getX() - 1, point.getY() - 0));

			if (point.getX() + 1 <= SEFConstant.NUM_ROW - 1)
				mList.add(new Point(point.getX() + 1, point.getY() - 0));

			if (point.getX() - 1 >= 0
					&& point.getY() + 1 <= SEFConstant.NUM_COL - 1)
				mList.add(new Point(point.getX() - 1, point.getY() + 1));

			if (point.getY() + 1 <= SEFConstant.NUM_COL - 1)
				mList.add(new Point(point.getX() - 0, point.getY() + 1));

			if (point.getX() + 1 <= SEFConstant.NUM_ROW - 1
					&& point.getY() - 1 >= 0)
				mList.add(new Point(point.getX() + 1, point.getY() - 1));
			break;

		}

		return mList;
	}

	/**
	 * Display information on status bar
	 * 
	 * @param point
	 * @param choiceOpt
	 * @return status string
	 */
	public static int getStatusLabel(Point point, int choiceOpt,
			MFrame parentView) {

		List mList = getChosenPointCollection(point, choiceOpt);
		List tmp = UtilityFunction.getTwoPointCollectionIntersection(mList,
				parentView.getScreen5().getSquareBoard().getShapePoints());
		int flag = 0;
		switch (choiceOpt) {
		case SEFConstant.ModePlay.POINT_OPT:

			if (tmp.size() > 0) {
				// parentView.getjLabel1().setText(
				// SEFConstant.StatusLabel.MSG_GOT_IT);
				// khangcv add for change cell color
				UtilityFunction.setStatusCellCollection(tmp, 1, parentView);
				// end
				flag = 1;
			} else {
				int min = 1000;
				for (Object object : parentView.getScreen5().getSquareBoard()
						.getShapePoints()) {
					Point tmpPoint = (Point) object;
					if (min > UtilityFunction.getDistanceBetweenTwoPoints(
							tmpPoint, point))
						min = UtilityFunction.getDistanceBetweenTwoPoints(
								tmpPoint, point);
				}
				parentView
						.getScreen5()
						.getUnitLabel()
						.setText(
								SEFConstant.StatusLabel.MSG_FAR_TO + min
										+ " units");
				flag = 0;
			}
			break;
		case SEFConstant.ModePlay.LINE_OPT:
			if (tmp.size() > 0) {
				// parentView.getjLabel1().setText(
				// SEFConstant.StatusLabel.MSG_GOT_IT);
				flag = 1;
			} else {
				// parentView.getjLabel1().setText(
				// SEFConstant.StatusLabel.MSG_AGAIN);
				flag = 0;
			}

			break;
		case SEFConstant.ModePlay.GRID_OPT:
			if (tmp.size() > 0) {
				// parentView.getjLabel1().setText(
				// SEFConstant.StatusLabel.MSG_GOT_IT);

				flag = 1;
			} else {
				// parentView.getjLabel1().setText(
				// SEFConstant.StatusLabel.MSG_AGAIN);
				flag = 0;
			}

			break;

		}
		return flag;
	}

	public static boolean checkWin(MFrame parentView) {
		List mList = parentView.getScreen5().getSquareBoard().getShapePoints();
		for (Object object : mList) {
			Point point = (Point) object;
			if (parentView.getScreen5().getSquareBoard().getCellSquares()[point
					.getX()][point.getY()].getStatus() == SEFConstant.CellStatus.C_KEY)
				return false;
		}
		return true;
	}

	public static void generatePlayerList(List players, int num) {
		if (players == null)
			players = new ArrayList<Player>();
		for (int i = 0; i < num; i++) {
			Player tmpPlayer = new Player();
			tmpPlayer.setId(i + 1);
			players.add(tmpPlayer);
		}
	}

	public static Player getPlayerForTurn(Match cMatch, MFrame parentView) {

		int numPlayer = cMatch.getPlayers().size();
		// check if finishing match, return null if the match ends
		if (((Player) (cMatch.getPlayers().get(0))).getNumLTurns() == 0)
			return null;

		switch (numPlayer) {
		case 2:
			if (((Player) cMatch.getPlayers().get(0)).isInTurn() == false
					&& ((Player) cMatch.getPlayers().get(1)).isInTurn() == false) {
				((Player) cMatch.getPlayers().get(0)).setInTurn(true);
				return ((Player) cMatch.getPlayers().get(0));
			}
			if (((Player) cMatch.getPlayers().get(0)).isInTurn() == true
					&& ((Player) cMatch.getPlayers().get(1)).isInTurn() == false) {
				((Player) cMatch.getPlayers().get(0)).setInTurn(false);
				((Player) cMatch.getPlayers().get(0))
						.setNumLTurns(((Player) cMatch.getPlayers().get(0))
								.getNumLTurns() - 1);
				((Player) cMatch.getPlayers().get(1)).setInTurn(true);
				return ((Player) cMatch.getPlayers().get(1));
			}
			if (((Player) cMatch.getPlayers().get(0)).isInTurn() == false
					&& ((Player) cMatch.getPlayers().get(1)).isInTurn() == true) {
				((Player) cMatch.getPlayers().get(0)).setInTurn(true);
				((Player) cMatch.getPlayers().get(1))
						.setNumLTurns(((Player) cMatch.getPlayers().get(1))
								.getNumLTurns() - 1);
				((Player) cMatch.getPlayers().get(1)).setInTurn(false);
				return ((Player) cMatch.getPlayers().get(0));
			}
			break;
		case 3:
			if (((Player) cMatch.getPlayers().get(0)).isInTurn() == false
					&& ((Player) cMatch.getPlayers().get(1)).isInTurn() == false
					&& ((Player) cMatch.getPlayers().get(2)).isInTurn() == false) {
				((Player) cMatch.getPlayers().get(0)).setInTurn(true);
				return ((Player) cMatch.getPlayers().get(0));
			}

			if (((Player) cMatch.getPlayers().get(0)).isInTurn() == true
					&& ((Player) cMatch.getPlayers().get(1)).isInTurn() == false
					&& ((Player) cMatch.getPlayers().get(2)).isInTurn() == false) {
				((Player) cMatch.getPlayers().get(0)).setInTurn(false);
				((Player) cMatch.getPlayers().get(0))
						.setNumLTurns(((Player) cMatch.getPlayers().get(0))
								.getNumLTurns() - 1);
				((Player) cMatch.getPlayers().get(1)).setInTurn(true);
				return ((Player) cMatch.getPlayers().get(1));
			}

			if (((Player) cMatch.getPlayers().get(0)).isInTurn() == false
					&& ((Player) cMatch.getPlayers().get(1)).isInTurn() == true
					&& ((Player) cMatch.getPlayers().get(2)).isInTurn() == false) {
				((Player) cMatch.getPlayers().get(1)).setInTurn(false);
				((Player) cMatch.getPlayers().get(1))
						.setNumLTurns(((Player) cMatch.getPlayers().get(1))
								.getNumLTurns() - 1);
				((Player) cMatch.getPlayers().get(2)).setInTurn(true);
				return ((Player) cMatch.getPlayers().get(2));
			}

			if (((Player) cMatch.getPlayers().get(0)).isInTurn() == false
					&& ((Player) cMatch.getPlayers().get(1)).isInTurn() == false
					&& ((Player) cMatch.getPlayers().get(2)).isInTurn() == true) {
				((Player) cMatch.getPlayers().get(2)).setInTurn(false);
				((Player) cMatch.getPlayers().get(2))
						.setNumLTurns(((Player) cMatch.getPlayers().get(2))
								.getNumLTurns() - 1);
				((Player) cMatch.getPlayers().get(0)).setInTurn(true);
				return ((Player) cMatch.getPlayers().get(2));
			}
			break;

		}

		return null;
	}

	// public static void display
}
