package au.edu.rmit.sef.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import au.edu.rmit.sef.ulti.SEFConstant;

public class Match {

	private boolean playing;
	private int numTurns = 1;
	private int numPlayer;
	private List<Player> players;
	private List traceList;
	private boolean trace;
	private int currPlayer = 0;
	// guess option
	private Player guessPlayer;
	private boolean guessOpt;
	private List<Point> guessPoints;

	public Match(int numTurns) {
		super();
		playing = true;
		this.numTurns = numTurns;
		players = new ArrayList<Player>();
		traceList = new ArrayList<Point>();

		guessPlayer = new Player();
		guessPlayer.setType(SEFConstant.ModePlay.POINT_OPT);
		guessPoints = new ArrayList<Point>();
	}

	public Match(int numTurns, List players) {
		super();
		playing = true;
		this.numTurns = numTurns;
		this.players = players;
		traceList = new ArrayList<Point>();

		guessPlayer = new Player();
		guessPlayer.setType(SEFConstant.ModePlay.POINT_OPT);
		guessPoints = new ArrayList<Point>();

	}

	public Match() {
		super();
		
		playing = true;
		players = new ArrayList<Player>();
		traceList = new ArrayList<Point>();

		guessPlayer = new Player();
		guessPlayer.setType(SEFConstant.ModePlay.POINT_OPT);
		guessPoints = new ArrayList<Point>();
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
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
		// if(currPlayer >= players.size()){
		// if(players.size() == 1)
		// return currPlayer = 0;
		// else {
		// if(players.size() == 2)
		// return currPlayer = 0;
		// else
		// return currPlayer = 1;
		// }
		//
		// }
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

	public List<Point> getGuessPoints() {
		return guessPoints;
	}

	public void setGuessPoints(List<Point> guessPoints) {
		this.guessPoints = guessPoints;
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

	public Player getGuessPlayer() {
		return guessPlayer;
	}

	public void setGuessPlayer(Player player) {
		this.guessPlayer.setName(player.getName());
	}

	public boolean isGuessOpt() {
		return guessOpt;
	}

	public void setGuessOpt(boolean guessOpt) {
		this.guessOpt = guessOpt;
	}

	public void removePlayerFromPlayerList(Player player) {

		
		for (Iterator<Player> iter = players.listIterator(); iter.hasNext(); ) {
			Player a = iter.next();
		    if (a.getName().trim().compareTo(player.getName().trim()) == 0) {
		        iter.remove();
		    }
		}
	}

	public void setNextTurn() {
		if(playing == false)
			return;
		if (currPlayer >= players.size() - 1) {
			currPlayer = 0;
		} else {
			currPlayer++;
		}
		numTurns++;
		if(numTurns > 10)
			playing = false;
	}

	public void renew() {
		playing = true;
		numTurns = 1;
		numPlayer = 0;
		players = new ArrayList<Player>();
		traceList = new ArrayList<Point>();
		trace = false;
		currPlayer = 0;
	}

}
