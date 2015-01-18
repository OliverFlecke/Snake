package snakegame.viewers;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 * Dialog to show the highscore in a table 
 */
public class StandAloneHighScore extends GenericDialog{

	private static final long serialVersionUID = 5036302346854160772L;
	
	/**
	 * Constructor for the highscore table
	 */
	public StandAloneHighScore() {
		super("High Score");
		
		// Create a table with the highscore data
		HighScoreTable table = new HighScoreTable();
		background.setLayout(new GridLayout(0,1));
		background.add(table);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		table.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		this.pack();
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(350, 239);		
	}
}