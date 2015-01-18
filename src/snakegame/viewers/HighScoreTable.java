package snakegame.viewers;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;

import snakegame.models.HighScore;
import snakegame.models.Player;

/**
 * Displays the highscore read from the highscore class in a table
 */
public class HighScoreTable extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4126008237857482618L;
	// Column names
	private String[] columnNames = {"#", 
			"Name",
			"Score",
			"Time"};
	
	// List of the player
	private ArrayList<Player> highScorePlayers;

	/**
	 * Constructor to create a highscore panel 
	 */
	public HighScoreTable(){
		// Get the highscore from the highscore class
		highScorePlayers = HighScore.getHighScore();
		
		// Read the data in to a object array 
		Object[][] data = new Object[10][4]; 
		for(int i = 0; i < highScorePlayers.size() - 1; i++){
			data[i][0] = i + 1;
			data[i][1] = highScorePlayers.get(i).getName();
			data[i][2] = highScorePlayers.get(i).getScore();
			data[i][3] = highScorePlayers.get(i).getTime();
		}
		
		// Add it all to the frame
		JTable table = new JTable(data, columnNames);
		table.setEnabled(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		this.setOpaque(false);
		this.add(table);    
		this.setBorder(BorderFactory.createEmptyBorder(70, 20, 10, 20));
		
		this.setLayout(new BorderLayout());
		this.add(table.getTableHeader(), BorderLayout.PAGE_START);
		this.add(table, BorderLayout.CENTER);
		
		//System.out.println(HighScore.getNewHighScorePlayers());
	}
}