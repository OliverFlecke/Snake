package snakegame.models;

import java.util.ArrayList;
import java.util.UUID;

public class HighScore {
	private String fileName = "highscore.txt";
	private ArrayList<Player> highScore;

	/**
	 * Accepts ArrayList of players, and writes them to highscore.txt file if applicable
	 * @param players
	 */
	public void submitScore(ArrayList<Player> players){
		this.players=players;

	}
	/**
	 * checks if supplied player UUID matches any UUID on the high score list
	 * @param player
	 * @return
	 */
	public boolean checkForHighScore(Player player){
		for (Player current : this.players){
			if(current.getId().equals(player.getId())){
				return true;
			}
			return false;
		}

		public ArrayList<Player> getHighScore(){
			
			return highScore;

		}


		// The name of the file to open.


		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}    

			// Always close files.
			bufferedReader.close();            
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName + "'");                   
			// Or we could just do this: 
			// ex.printStackTrace();
		}
	}

}