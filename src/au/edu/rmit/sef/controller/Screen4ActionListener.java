package au.edu.rmit.sef.controller;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import au.edu.rmit.sef.model.Match;
import au.edu.rmit.sef.model.Player;
import au.edu.rmit.sef.ulti.SEFConstant;
import au.edu.rmit.sef.ulti.UtilityFunction;
import au.edu.rmit.sef.view.MFrame;

public class Screen4ActionListener {
	private MFrame parentView;
	private Match cMatch;

	public Screen4ActionListener() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Screen4ActionListener(MFrame parentView, Match cMatch) {
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

	// action listener
	public void startActionPerformed(MouseEvent e) {
		// parentView.setScreen(SEFConstant.GameState.SCREEN3);
		try {
			if (parentView.getScreen4().getPlayer1Text().getText().trim()
					.equals(""))
				throw new Exception();
			if (parentView.getScreen4().getPlayer2Text().getText().trim()
					.equals(""))
				throw new Exception();
			cMatch.setPlayers(new ArrayList<Player>());
			Player player = new Player();
			player.setName(parentView.getScreen4().getPlayer1Text().getText()
					.trim());
			cMatch.getPlayers().add(player);

			player = new Player();
			player.setName(parentView.getScreen4().getPlayer2Text().getText()
					.trim());
			cMatch.getPlayers().add(player);
			cMatch.setPlayerType();

			String tmp = "";
			int flag = 0;

			for (Player p : cMatch.getPlayers()) {
				// if(UtilityFunction.isPlayerExist(p) == false){
				tmp += p.getName() + " ";
				// UtilityFunction.addPlayerToList(p);
				flag = 1;
				// }
			}
			if (flag == 1) {
				JOptionPane.showMessageDialog(null, tmp + "is/are new player!",
						"InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
			}

			parentView.setScreen(SEFConstant.GameState.SCREEN5);
			parentView.getScreen5().getSquareBoard().setShapePoints(UtilityFunction.getShapePointCollection());
			parentView.getScreen5().getNoplayerLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/no_player2.PNG")));
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "you need to fill your name",
					"InfoBox: " + "input error",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void backActionPerformed(MouseEvent e) {
		parentView.setScreen(SEFConstant.GameState.SCREEN2);
	}
}
