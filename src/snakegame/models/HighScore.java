package snakegame.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class HighScore {
	private ArrayList<Player> highScorePlayers;

	public HighScore() {
		this.highScorePlayers = readHighScoreFromFile();
	}

	/**
	 * Accepts ArrayList of players, and writes new top ten to high score
	 * @param players
	 * @return ArrayList of Players who have set new high score
	 */
	public ArrayList<Player> submitScore(ArrayList<Player> players){
		highScorePlayers.addAll(players);
		Collections.sort(highScorePlayers);
		highScorePlayers.subList(9, highScorePlayers.size()-1).clear();
		writeHighScoreToFile();
		return checkForHighScore(players);

	}
	
	/**
	 * Accepts ArrayList of Players and returns an ArrayList of the Players that are on the high score
	 * @param players
	 * @return players
	 */
	private ArrayList<Player> checkForHighScore(ArrayList<Player> players) {
		for (Player current : this.currentPlayers){
			if(current.getId().equals(currentPlayers.getId())){
				return true;
			}
		}


		return players;
		// TODO Auto-generated method stub

	}

	private void writeHighScoreToFile() {

	}

	public ArrayList<Player> readHighScoreFromFile(){

		return highScorePlayers;

	}

	public ArrayList<Player> getHighScore(){
		return highScorePlayers;		
	}
}