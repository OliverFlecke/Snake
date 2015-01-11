package snakegame.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.UUID;

public class HighScore {
	public ArrayList<Player> highScorePlayers;

	public HighScore() {
		highScorePlayers = readHighScoreFromFile();

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
	 * Accepts ArrayList of Players and returns an ArrayList of the Players that are new on the high score
	 * @param players
	 * @return players
	 */
	private ArrayList<Player> checkForHighScore(ArrayList<Player> players) {
		ArrayList<Player> newHighScorePlayers = new ArrayList<Player>();
		for (Player current : players){
			if(highScorePlayers.contains(current)){
				newHighScorePlayers.add(current);
			}
		}
		return newHighScorePlayers;
	}

	private void writeHighScoreToFile() {
		//TODO

	}

	public ArrayList<Player> readHighScoreFromFile(){



		return null;

	}

	public ArrayList<Player> getHighScore(){
		return highScorePlayers;		
	}
	public void name() {
		File file = new File("highscore.txt");

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}     


	}
}