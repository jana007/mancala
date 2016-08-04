package mancala;

import java.io.Serializable;

public class HighScore implements Serializable {
	
	private String playerName;
	private int turns;
	private int score;
	
	public HighScore() {
		playerName = "";
		score = 0;
		turns = 0;
	}
	public HighScore( String name, int turnAmount, int winnerScore ) {
		
		playerName = name;
		turns = turnAmount;
		score = winnerScore;
	}
	
	public String toString() {

		String scoreString = getPlayerName() + "\t" + getTurns()  + "\t" + getScore();
		
		return scoreString;
	}
	public String getPlayerName() { return playerName; }
	public int getTurns() { return turns; }
	public int getScore() { return score; }
	//public static int scoreCount() { return scoreCount; }
	
}
