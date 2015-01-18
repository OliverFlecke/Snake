package snakegame.models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Class for storing scores and data in a high score text file
 */
public final class HighScore {

	// File to store the data in
	private static File file = new File("highscore.txt");
	private static ArrayList<Player> highScorePlayers = readHighScoreFromFile();
	private static ArrayList<Player> newHighScorePlayers = new ArrayList<Player>();

	/**
	 * Private constructor, so no object can be created. 
	 * Call methods need is static. Insures only one item is writing to the file at one time
	 */
	private HighScore() {
	}

	/**
	 * Accepts ArrayList of players, and writes new top ten to high score
	 * @param players to be saved if has highest score
	 * @return ArrayList of Players who have set new high score
	 */
	public static void submitScore(ArrayList<Player> players){
		highScorePlayers.addAll(players);
		Collections.sort(highScorePlayers);
		int size = (highScorePlayers.size() < 10) ? highScorePlayers.size() : 10;
		highScorePlayers.subList(size, highScorePlayers.size()).clear();
		
		writeHighScoreToFile(highScorePlayers);
		refreshNewHighScorePlayers(players);
	}

	/**
	 * Accepts ArrayList of Players objects and returns an ArrayList 
	 * of the Player objects that are on the current high score
	 * @param players new players to be saved
	 */
	private static void refreshNewHighScorePlayers(ArrayList<Player> players) {
		newHighScorePlayers.clear();		
		for (Player current : players){
			if(highScorePlayers.contains(current)){
				newHighScorePlayers.add(current);
			}
		}
	}

	/**
	 * writes name, score and time to file from an 
	 * ArrayList of up to 10 players
	 */
	private static void writeHighScoreToFile(ArrayList<Player> highScoreToWrite) {
		try {
			Formatter fm = new Formatter(file);
			for(int i = 0; i < highScoreToWrite.size(); i++){
				fm.format(highScoreToWrite.get(i).getName() + " ");
				fm.format(highScoreToWrite.get(i).getScore() + " ");
				fm.format(Integer.toString(highScoreToWrite.get(i).getTime()));
				fm.format("%n");
			}
			fm.close();	
		} catch (IOException e) {
			//e.printStackTrace();		// DEBUG
		}
	}

	/**
	 * Reads name, score and time from file and creates an arrayList of 
	 * players using these parameters
	 * @return ArrayList of high score players
	 */
	private static ArrayList<Player> readHighScoreFromFile(){		
		ArrayList<Player> readResult = new ArrayList<Player>(); 	// Array of players to read data into
		try {  
			Scanner s = new Scanner(file);
			int i = 0; 
			while (s.hasNext() && i++ < 10) {
				String name = s.next();
				int score = s.nextInt();
				int time = s.nextInt();
				if(s.hasNextLine())
					s.nextLine();
				readResult.add(new Player(name, score, time));
			}
			s.close();
		} 
		catch(Exception e) {
			//e.printStackTrace();   
		}
		return readResult;
	}

	/**
	 * Getter for the list of players in the highscore array
	 * @return The highest scoring players from the file
	 */
	public static ArrayList<Player> getHighScore(){
		return highScorePlayers;		
	}
	
	/**
	 * Get the newest highscore array
	 * @return Array of new highscore players
	 */
	public static ArrayList<Player> getNewHighScorePlayers(){
		return newHighScorePlayers;
	}
}