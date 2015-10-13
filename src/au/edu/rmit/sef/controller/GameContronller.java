package au.edu.rmit.sef.controller;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import au.edu.rmit.sef.game.PlayRule;
import au.edu.rmit.sef.model.Match;
import au.edu.rmit.sef.model.Player;
import au.edu.rmit.sef.model.Point;
import au.edu.rmit.sef.model.Shape;
import au.edu.rmit.sef.ulti.SEFConstant;
import au.edu.rmit.sef.ulti.UtilityFunction;
import au.edu.rmit.sef.view.CellLabel;
import au.edu.rmit.sef.view.MFrame;
import au.edu.rmit.sef.view.Screen1;
import au.edu.rmit.sef.view.Screen2;
import au.edu.rmit.sef.view.Screen3;
import au.edu.rmit.sef.view.Screen4;

public class GameContronller {

	private final MFrame mFrame = new MFrame();
	// private List players;
	private Match mMatch;
	// listener for click on squares
	private MouseAdapter listenerClickCell;

	// 20151011 khangcv
	private Screen1ActionListener screen1Listeners;
	private Screen2ActionListener screen2Listeners;
	private Screen3ActionListener screen3Listeners;
	private Screen4ActionListener screen4Listeners;
	private Screen5ActionListener screen5Listeners;

	/*
	 * 20151011
	 */
	// private void setGameState(int state) {
	//
	//
	//
	//
	// switch (state) {
	// case SEFConstant.GameState.SCREEN1:
	// mFrame.setScreen(SEFConstant.GameState.SCREEN1);
	// registerActionListenerForScreen1();
	// break;
	// case SEFConstant.GameState.SCREEN2:
	// mFrame.setScreen(SEFConstant.GameState.SCREEN2);
	// registerActionListenerForScreen2();
	// break;
	// case SEFConstant.GameState.SCREEN3:
	// mFrame.setScreen(SEFConstant.GameState.SCREEN2);
	// registerActionListenerForScreen3();
	// break;
	// case SEFConstant.GameState.SCREEN4:
	// mFrame.setScreen(SEFConstant.GameState.SCREEN3);
	// registerActionListenerForScreen4();
	// break;
	// }
	//
	// }

	public void registerActionListenerForScreen1() {
		mFrame.getScreen1().getStartButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen1Listeners.startLabelActionPerformed(e);
					}
				});
		mFrame.getScreen1().getQuitButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen1Listeners.quitgameActionPerformed(e);
					}
				});

	}

	public void registerActionListenerForScreen2() {
		mFrame.getScreen2().getPlayer2Button()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen2Listeners.player2ActionPerformed(e);
					}
				});
		mFrame.getScreen2().getPlayer3Button()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen2Listeners.player3ActionPerformed(e);
					}
				});
		mFrame.getScreen2().getBackButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen2Listeners.backActionPerformed(e);
					}
				});
	}

	public void registerActionListenerForScreen3() {
		mFrame.getScreen3().getBackButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen3Listeners.backActionPerformed(e);
					}
				});

		mFrame.getScreen3().getStartButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen3Listeners.startActionPerformed(e);
					}
				});
	}

	public void registerActionListenerForScreen4() {
		mFrame.getScreen4().getBackButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen4Listeners.backActionPerformed(e);
					}
				});

		mFrame.getScreen4().getStartButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen4Listeners.startActionPerformed(e);
					}
				});
	}

	public void registerActionListenerForScreen5() {

		// cell
		for (int i = 0; i < mFrame.getScreen5().getSquareBoard().getNumRow(); i++) {
			for (int j = 0; j < mFrame.getScreen5().getSquareBoard()
					.getNumCol(); j++) {
				mFrame.getScreen5().getSquareBoard().getCellSquares()[i][j]
						.addMouseListener(new MouseListener() {

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								screen5Listeners.cellMouseReleased(e);
							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								screen5Listeners.cellMousePressed(e);
							}

							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub

							}
						});
			}
		}
		// trace buttom
		mFrame.getScreen5().getTraceButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen5Listeners.traceActionPerformed(e);
					}
				});
		// quit button
		mFrame.getScreen5().getQuitButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen5Listeners.quitActionPerformed(e);
					}
				});
		// guess button
		mFrame.getScreen5().getGuessButton()
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {

						screen5Listeners.guessActionPerformed(e);
					}
				});
		// new button
		mFrame.getScreen5().getNewButton().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				screen5Listeners.newActionPerformed(e);
			}
		});
	}

	public GameContronller() {
		super();
		// players = new ArrayList<Player>();
		mMatch = new Match();

		screen1Listeners = new Screen1ActionListener(mFrame, mMatch);
		screen2Listeners = new Screen2ActionListener(mFrame, mMatch);
		screen3Listeners = new Screen3ActionListener(mFrame, mMatch);
		screen4Listeners = new Screen4ActionListener(mFrame, mMatch);
		screen5Listeners = new Screen5ActionListener(mFrame, mMatch);
		registerActionListenerForScreen1();
		registerActionListenerForScreen2();
		registerActionListenerForScreen3();
		registerActionListenerForScreen4();
		registerActionListenerForScreen5();
		// mFrame.add(new Screen1());
	}

}
