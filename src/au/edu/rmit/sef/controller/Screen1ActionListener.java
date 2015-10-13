package au.edu.rmit.sef.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import au.edu.rmit.sef.model.Match;
import au.edu.rmit.sef.ulti.SEFConstant;
import au.edu.rmit.sef.view.MFrame;

public class Screen1ActionListener {

	private MFrame parentView;
	private Match cMatch;

	public Screen1ActionListener() {

		// TODO Auto-generated constructor stub
	}

	public Screen1ActionListener(MFrame parentView, Match cMatch) {
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
	public void startLabelActionPerformed(MouseEvent e) {
		parentView.setScreen(SEFConstant.GameState.SCREEN2);

	}

	public void highscoreActionPerformed(MouseEvent e) {
		parentView.setVisible(false);
	}

	public void quitgameActionPerformed(MouseEvent e) {
		parentView.dispose();
	}
}
