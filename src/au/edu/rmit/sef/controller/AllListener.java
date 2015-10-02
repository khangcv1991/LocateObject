package au.edu.rmit.sef.controller;

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
import au.edu.rmit.sef.model.CellLabel;
import au.edu.rmit.sef.model.Match;
import au.edu.rmit.sef.model.Player;
import au.edu.rmit.sef.model.Point;
import au.edu.rmit.sef.model.Shape;
import au.edu.rmit.sef.ulti.SEFConstant;
import au.edu.rmit.sef.ulti.UtilityFunction;
import au.edu.rmit.sef.view.MFrame;

public class AllListener {

	private final MFrame mFrame = new MFrame();
	// private List players;
	private Match mMatch;
	// listener for click on squares
	private MouseAdapter listenerClickCell;
	private SEFActionListener actionListenners;

	public AllListener() {
		super();
		// players = new ArrayList<Player>();
		actionListenners = new SEFActionListener(mMatch, mFrame);
	}

	public void registerAllActionListener() {

		mFrame.getjButton1().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionListenners.jButton1ActionPerformed(e);
			}
		});
		displayMainWindow();
		mFrame.getjButton2().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// jButton2ActionPerformed(e);
				actionListenners.jButton2ActionPerformed(e);

			}
		});

		mFrame.getjButton3().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// jButton3ActionPerformed(e);
				actionListenners.jButton3ActionPerformed(e);

			}
		});
		// add Listener for each cell
		for (int i = 0; i < SEFConstant.NUM_ROW; i++)
			for (int j = 0; j < SEFConstant.NUM_COL; j++) {
				mFrame.getSquareBoard().getCellSquares()[i][j]
						.addMouseListener(new MouseListener() {

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								// cellMouseReleased(e);
								actionListenners.cellMouseReleased(e);
								System.out.println("release "
										+ ((CellLabel) e.getSource()).getId());
							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								// cellMousePressed(e);
								actionListenners.cellMousePressed(e);
								System.out.println("pressse"
										+ ((CellLabel) e.getSource()).getId());

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

	// end
	private void displayMainWindow() {
		//set text for shape type dropbox
		mFrame.getjComboBox1().removeAllItems();
		for (Shape s : UtilityFunction.getShapeCollection()) {
			mFrame.getjComboBox1().addItem(new String(s.getName()));
		}
		
		Runnable run = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException ex) {
					
				} catch (InstantiationException ex) {
					
				} catch (IllegalAccessException ex) {
					
				} catch (UnsupportedLookAndFeelException ex) {
					
				}
				
				SwingUtilities.updateComponentTreeUI(mFrame);
				mFrame.setVisible(true);

			}
		};
		SwingUtilities.invokeLater(run);
	}

}
