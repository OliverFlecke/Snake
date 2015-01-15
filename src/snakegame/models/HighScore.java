package snakegame.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

public final class HighScore {

	private static File file = new File ("highscore.txt");
	private static ArrayList<Player> highScorePlayers = readHighScoreFromFile();
	private static ArrayList<Player> newHighScorePlayers = new ArrayList<Player>();


	private HighScore() {
	}

	/**
	 * Accepts ArrayList of players, and writes new top ten to high score
	 * @param players
	 * @return 
	 * @return ArrayList of Players who have set new high score
	 */
	public static void submitScore(ArrayList<Player> players){
		highScorePlayers.addAll(players);
		Collections.sort(highScorePlayers);
		highScorePlayers.subList(10,highScorePlayers.size()).clear();
		writeHighScoreToFile(highScorePlayers);
		refreshNewHighScorePlayers(players);
	}

	/**
	 * Accepts ArrayList of Players objects and returns an ArrayList 
	 * of the Player objects that are on the current high score
	 * @param players
	 * @return 
	 * @return players
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
	 * ArrayList of 10 players
	 */
	private static void writeHighScoreToFile(ArrayList<Player> highScoreToWrite) {
		try {
			Formatter fm = new Formatter(file);
			for(int i=0; i<10; i++){
				fm.format(highScoreToWrite.get(i).getName() + " ");
				fm.format(highScoreToWrite.get(i).getScore() + " ");
				fm.format(Integer.toString(highScoreToWrite.get(i).getScore()));
				fm.format("%n");
			}
			fm.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads name, score and time from file and creates an arrayList of 
	 * players using these parameters
	 * @return ArrayList of high score players
	 */
	private static ArrayList<Player> readHighScoreFromFile(){

		ArrayList<Player> readResult = new ArrayList<Player>();

		try {  
			Scanner s = new Scanner(file);
			for(int i=0; i<10; i++){
				String name = s.next();
				int score = s.nextInt();
				int time = s.nextInt();
				if(s.hasNextLine()){
					s.nextLine();}
				readResult.add(new Player(name,score,time));
			}
			s.close();
		} 
		catch(FileNotFoundException e) {
			e.printStackTrace();   
		}
		return readResult;
	}

	public static ArrayList<Player> getHighScore(){
		return highScorePlayers;		
	}
	
	public static ArrayList<Player>getNewHighScorePlayers(){
		return newHighScorePlayers;
	}
}