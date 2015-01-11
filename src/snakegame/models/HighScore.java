package snakegame.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HighScore {
	private ArrayList<Player> highScorePlayers;
	private File f = new File ("highscore.txt");


	public HighScore() {
		//highScorePlayers = readHighScoreFromFile();

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
		writeHighScoreToFile(highScorePlayers);
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

	/**
	 * writes name, score and time to file from an 
	 * arrayList of players
	 * @return 
	 * @return
	 */
	public void writeHighScoreToFile(ArrayList<Player> highScoreToWrite) {
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			
			for(int i=0; i<10; i++){
				bw.write(highScoreToWrite.get(i).getName() + " ");
				bw.write(highScoreToWrite.get(i).getScore() + " ");
				bw.write(highScoreToWrite.get(i).getTime());
				bw.newLine();
				System.out.println(highScoreToWrite.get(i).getTime());
			}
			bw.close();
			System.out.println("done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads name, score and time from file and creates an arrayList of 
	 * players using these parameters
	 * @return ArrayList og high score players
	 */
	public ArrayList<Player> readHighScoreFromFile(){

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