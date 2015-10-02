package au.edu.rmit.sef.model;

import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.sef.ulti.SEFConstant;

public class Match {

	private int result;
	private int numTurns = SEFConstant.TURN_NUM;
	private List players;

	public Match(int result, int numTurns) {
		super();
		this.result = result;
		this.numTurns = numTurns;
		players = new ArrayList<Player>();
	}
	
	public Match(int result, int numTurns, List players) {
		super();
		this.result = result;
		this.numTurns = numTurns;
		this.players = players;
	}

	public Match() {
		super();
		players = new ArrayList<Player>();
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getNumTurns() {
		return numTurns;
	}

	public List getPlayers() {
		return players;
	}

	public void setPlayers(List players) {
		this.players = players;
	}

	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}
	

}
