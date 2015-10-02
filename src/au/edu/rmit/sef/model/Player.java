package au.edu.rmit.sef.model;

import au.edu.rmit.sef.ulti.SEFConstant;

public class Player {

	private int id;
	private String name;
	private boolean inTurn = false;
	private int numLTurns = SEFConstant.TURN_NUM;
	private int score;
	public boolean isInTurn() {
		return inTurn;
	}
	public void setInTurn(boolean inTurn) {
		this.inTurn = inTurn;
	}
	public int getNumLTurns() {
		return numLTurns;
	}
	public void setNumLTurns(int numLTurns) {
		this.numLTurns = numLTurns;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Player " + id + " *** " + numLTurns + " turns ";
	}
	
}
