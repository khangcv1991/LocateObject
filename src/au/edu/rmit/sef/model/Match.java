package au.edu.rmit.sef.model;

import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.sef.ulti.SEFConstant;

public class Match {

	private int result;
	private int numTurns = 1;
	private int numPlayer;
	private List<Player> players;
	private List traceList;
	private boolean trace;
	private int currPlayer = 0;
	
	public Match(int result, int numTurns) {
		super();
		this.result = result;
		this.numTurns = numTurns;
		players = new ArrayList<Player>();
		traceList = new ArrayList<Point>();
	}

	public Match(int result, int numTurns, List players) {
		super();
		this.result = result;
		this.numTurns = numTurns;
		this.players = players;
		traceList = new ArrayList<Point>();
	}

	public Match() {
		super();
		players = new ArrayList<Player>();
		traceList = new ArrayList<Point>();
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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}

	public int getNumPlayer() {
		return numPlayer;
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

	public int getCurrPlayer() {
		return currPlayer;
	}

	public void setCurrPlayer(int currPlayer) {
		this.currPlayer = currPlayer;
	}
	
	public List getTraceList() {
		return traceList;
	}

	public void setTraceList(List traceList) {
		this.traceList = traceList;
	}
	
	public boolean isTrace() {
		return trace;
	}

	public void setTrace(boolean trace) {
		this.trace = trace;
	}

	public void setPlayerType() {
		if (players.size() == 2) {
			players.get(0).setType(SEFConstant.ModePlay.POINT_OPT);
			players.get(1).setType(SEFConstant.ModePlay.LINE_OPT);
		}
		if (players.size() == 3) {
			players.get(0).setType(SEFConstant.ModePlay.POINT_OPT);
			players.get(1).setType(SEFConstant.ModePlay.LINE_OPT);
			players.get(2).setType(SEFConstant.ModePlay.GRID_OPT);
		}
	}

	public void setNextTurn() {
		if (currPlayer == players.size() - 1) {
			currPlayer = 0;
		} else {
			currPlayer++;
		}
		numTurns++;
	}

	public void refresh(){
		  result = 0;
		  numTurns = 1;
		  numPlayer = 0;
		  players = new ArrayList<Player>();
		  traceList = new ArrayList<Point>();
		  trace = false;
		  currPlayer = 0;
	}
	public boolean checkWin() {

		return false;
	}
}
