package au.edu.rmit.sef.controller;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import au.edu.rmit.sef.game.PlayRule;
import au.edu.rmit.sef.model.Match;
import au.edu.rmit.sef.ulti.SEFConstant;
import au.edu.rmit.sef.ulti.UtilityFunction;
import au.edu.rmit.sef.view.MFrame;

public class Screen5ActionListener {
	private MFrame parentView;
	private Match cMatch;

	public Screen5ActionListener() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Screen5ActionListener(MFrame parentView, Match cMatch) {
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

	public Match getcMatch() {
		return cMatch;
	}

	public void setcMatch(Match cMatch) {
		this.cMatch = cMatch;
	}

	// action listeners
	public void quitActionPerformed(MouseEvent e) {
		UtilityFunction.setStatusCellCollection(parentView.getScreen5()
				.getSquareBoard().getShapePoints(),
				SEFConstant.CellStatus.UC_KEY, parentView);

		int dialogResult = JOptionPane
				.showConfirmDialog(null, "Would You Like to quit?", "Warning",
						JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
			parentView.dispose();
		}

	}

	public void newActionPerformed(MouseEvent e) {
		cMatch.renew();
		UtilityFunction.setStatusCellCollection(parentView.getScreen5()
				.getSquareBoard().getShapePoints(),
				SEFConstant.CellStatus.BLANK, parentView);
		parentView.setScreen(SEFConstant.GameState.SCREEN1);
	}

	public void traceActionPerformed(MouseEvent e) {
		if (cMatch.isTrace() == true) {
			UtilityFunction.setStatusCellCollection(cMatch.getTraceList(),
					SEFConstant.CellStatus.BLANK, parentView);
			cMatch.setTrace(false);
		} else {
			UtilityFunction.setStatusCellCollection(cMatch.getTraceList(),
					SEFConstant.CellStatus.ON_CLICK, parentView);
			cMatch.setTrace(true);
		}
	}

	public void guessActionPerformed(MouseEvent e) {
		if (cMatch.getPlayers().size() == 0) {
			JOptionPane.showMessageDialog(null, "no one can guess now!");
			cMatch.getGuessPoints().removeAll(
					UtilityFunction.getUncoveredKeyList(parentView.getScreen5()
							.getSquareBoard()));
			UtilityFunction.setStatusCellCollection(cMatch.getGuessPoints(),
					SEFConstant.CellStatus.BLANK, parentView);
		}
		if (cMatch.isPlaying() == false) {
			cMatch.getGuessPoints().removeAll(
					UtilityFunction.getUncoveredKeyList(parentView.getScreen5()
							.getSquareBoard()));
			UtilityFunction.setStatusCellCollection(cMatch.getGuessPoints(),
					SEFConstant.CellStatus.BLANK, parentView);
			return;
		}
		if (cMatch.isGuessOpt() == true) {
			cMatch.setGuessOpt(false);
			if (PlayRule.checkGuessOptionRule(parentView, cMatch) == true) {
				JOptionPane.showMessageDialog(null, "You win!");
			} else {
				JOptionPane.showMessageDialog(null, cMatch.getGuessPlayer()
						.getName() + " - You lose and you are terminated!");
				System.out.println(cMatch.getPlayers());
				cMatch.setNextTurn();
				cMatch.setNumTurns(cMatch.getNumTurns() - 1);
				setDisplay();
				cMatch.removePlayerFromPlayerList(cMatch.getGuessPlayer());
				System.out.println(cMatch.getPlayers());
				PlayRule.refreshMatch(parentView, cMatch);

				if (cMatch.getPlayers().size() == 0) {
					cMatch.setPlaying(false);
					cMatch.renew();
					return;
				}
			}
			cMatch.getGuessPoints().removeAll(
					UtilityFunction.getUncoveredKeyList(parentView.getScreen5()
							.getSquareBoard()));
			UtilityFunction.setStatusCellCollection(cMatch.getGuessPoints(),
					SEFConstant.CellStatus.BLANK, parentView);
			return;
		}
		int dialogResult = JOptionPane.showConfirmDialog(null,
				"Do you want to select \"guess option\"?", "Warning",
				JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
			cMatch.setGuessPlayer(cMatch.getPlayers().get(
					cMatch.getCurrPlayer()));
			cMatch.getGuessPoints().addAll(
					UtilityFunction.getUncoveredKeyList(parentView.getScreen5()
							.getSquareBoard()));
			cMatch.setGuessOpt(true);
		}

	}

	public void cellMouseReleased(MouseEvent e) {

		if (PlayRule.checkWin(parentView, cMatch) == true) {
			JOptionPane.showMessageDialog(null, "the game  finished");
			return;
		}
		if (cMatch.getPlayers().size() == 0
				|| (PlayRule.checkWin(parentView, cMatch) == false && cMatch
						.getNumTurns() > 10)) {
			cMatch.setPlaying(false);
			JOptionPane.showMessageDialog(null,
					"You guys lose and you are terminated!");
			return;
		}
		if (cMatch.isPlaying() == false) {
			return;
		}
		if (cMatch.isPlaying() == false
				&& PlayRule.checkWin(parentView, cMatch) == false) {
			JOptionPane.showMessageDialog(null, "you guys lose");
		}
		// int opt = parentView.getjComboBox2().getSelectedIndex();
		int opt = cMatch.getPlayers().get(cMatch.getCurrPlayer()).getType();
		List isList = null;
		List mList = null;
		// guess option
		if (cMatch.isGuessOpt() == true) {
			cMatch.getGuessPoints().add(
					UtilityFunction.convertIdToPoint(e.getSource().toString()));
			UtilityFunction.setColorForCell(parentView.getScreen5()
					.getSquareBoard(), UtilityFunction.convertIdToPoint(e
					.getSource().toString()), SEFConstant.CellColorInt.RED_BG);

			return;
		}
		// end
		switch (opt) {
		case SEFConstant.ModePlay.POINT_OPT:
			mList = PlayRule.getChosenPointCollection(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					SEFConstant.ModePlay.POINT_OPT);
			// khangcv add
			isList = UtilityFunction.getTwoPointCollectionIntersection(mList,
					parentView.getScreen5().getSquareBoard().getShapePoints());
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
			break;

		case SEFConstant.ModePlay.LINE_OPT:
			mList = PlayRule.getChosenPointCollection(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					SEFConstant.ModePlay.LINE_OPT);
			// khangcv add
			isList = UtilityFunction.getTwoPointCollectionIntersection(mList,
					parentView.getScreen5().getSquareBoard().getShapePoints());
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
					parentView.getScreen5().getSquareBoard().getShapePoints());
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

			break;

		}
		if (cMatch.isTrace()) {
			UtilityFunction.setStatusCellCollection(cMatch.getTraceList(),
					SEFConstant.CellStatus.ON_CLICK, parentView);
		}
		// set display and setup for next turn

		if (PlayRule.checkWin(parentView, cMatch) == true) {
			JOptionPane.showMessageDialog(null,
					cMatch.getPlayers().get(cMatch.getCurrPlayer()).getName()
							+ " - you win");
			cMatch.setPlaying(false);
			cMatch.renew();
			return;
		} else {
			setDisplay();
			cMatch.setNextTurn();
		}
		// end
	}

	public void cellMousePressed(MouseEvent e) {
		if (cMatch.getPlayers().size() == 0)
			return;
		if (cMatch.isPlaying() == false) {
			return;
		}
		if (cMatch.isGuessOpt() == true) {
			return;
		}
		// int opt = parentView.getjComboBox2().getSelectedIndex();
		int opt = cMatch.getPlayers().get(cMatch.getCurrPlayer()).getType();
		List isList;
		List mList = null;// =

		// guess option
		if (cMatch.isGuessOpt() == true)
			return;
		switch (opt) {
		case SEFConstant.ModePlay.POINT_OPT:
			mList = PlayRule.getChosenPointCollection(
					UtilityFunction.convertIdToPoint(e.getSource().toString()),
					SEFConstant.ModePlay.POINT_OPT);
			isList = UtilityFunction.getTwoPointCollectionIntersection(mList,
					parentView.getScreen5().getSquareBoard().getShapePoints());
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
					parentView.getScreen5().getSquareBoard().getShapePoints());
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
					parentView.getScreen5().getSquareBoard().getShapePoints());
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
		cMatch.getTraceList().removeAll(mList);
		cMatch.getTraceList().removeAll(
				parentView.getScreen5().getSquareBoard().getShapePoints());
		cMatch.getTraceList().addAll(mList);
	}

	private void setDisplay() {
		parentView
				.getScreen5()
				.getPlayernameLabel()
				.setText(
						cMatch.getPlayers().get(cMatch.getCurrPlayer())
								.getName());
		parentView.getScreen5().getNoroundLabel()
				.setText(cMatch.getNumTurns() + "");

	}
}
