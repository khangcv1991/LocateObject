package au.edu.rmit.sef.controller;

import java.awt.event.MouseEvent;

import au.edu.rmit.sef.model.Match;
import au.edu.rmit.sef.ulti.SEFConstant;
import au.edu.rmit.sef.view.MFrame;

public class Screen2ActionListener {
	private MFrame parentView;
	private Match cMatch;

	public Screen2ActionListener() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Screen2ActionListener(MFrame parentView, Match cMatch) {
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
	public void player2ActionPerformed(MouseEvent e) {
		parentView.setScreen(SEFConstant.GameState.SCREEN4);
		cMatch.setNumPlayer(2);
	}

	public void player3ActionPerformed(MouseEvent e) {
		parentView.setScreen(SEFConstant.GameState.SCREEN3);
		cMatch.setNumPlayer(3);
	}
	
	public void addshapeActionPerformed(MouseEvent e) {
		// parentView.setScreen(SEFConstant.GameState.SCREEN3);
		// cMatch.setNumPlayer(3);
	}

	public void backActionPerformed(MouseEvent e) {
		parentView.setScreen(SEFConstant.GameState.SCREEN1);
	}
}
