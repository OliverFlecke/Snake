package snakegame.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

public class HighScore {
	private ArrayList<Player> highScorePlayers;
	private File f = new File ("highscore.txt");


	public HighScore() {
		highScorePlayers = readHighScoreFromFile();

	}

	/**
	 * Accepts ArrayList of players, and writes new top ten to high score
	 * @param players
	 * @return 
	 * @return ArrayList of Players who have set new high score
	 */
	public void submitScore(ArrayList<Player> players){
		highScorePlayers.addAll(players);
		System.out.println("print highScorePlayers");
		System.out.println(highScorePlayers);
		Collections.sort(highScorePlayers);
		System.out.println("print highScorePlayers after sort");
		System.out.println(highScorePlayers);
		System.out.println("do sublist action");
		highScorePlayers.subList(10,highScorePlayers.size()).clear();
		System.out.println("print highScorePlayers after sublist");
		System.out.println(highScorePlayers);
		writeHighScoreToFile(highScorePlayers);
	}

	/**
	 * Accepts ArrayList of Players and returns an ArrayList of the Players that are new on the high score
	 * @param players
	 * @return players
	 */
	public ArrayList<Player> checkForHighScore(ArrayList<Player> players) {
		ArrayList<Player> newHighScorePlayers = new ArrayList<Player>();
		for (Player current : players){
			if(highScorePlayers.contains(current)){
				newHighScorePlayers.add(current);
			}
		}
		return newHighScorePlayers;
	}

	/**
	 * writes name, score and time to file from an 
	 * ArrayList of 10 players
	 */
	private void writeHighScoreToFile(ArrayList<Player> highScoreToWrite) {
		try {
			
			Formatter fm = new Formatter(f);
			
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
	 * @return ArrayList og high score players
	 */
	private ArrayList<Player> readHighScoreFromFile(){

		ArrayList<Player> readResult = new ArrayList<Player>();

		try {  
			Scanner s = new Scanner(f);
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
		//catch the exception
		catch(FileNotFoundException e) {
			e.printStackTrace();   
		}
		return readResult;
	}

	public ArrayList<Player> getHighScore(){
		return highScorePlayers;		
	}
}