package snakegame.viewers;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 * Dialog to show the highscore 
 */
public class StandAloneHighScore extends GenericDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5036302346854160772L;
	
	public StandAloneHighScore(){
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