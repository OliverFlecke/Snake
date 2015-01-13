package snakegame.viewers;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;

import snakegame.models.Player;
import snakegame.models.HighScore;

public class HighScoreTable extends JPanel{
	private String[] columnNames = {"#", 
			"Name",
			"Score",
			"Time"};
	private ArrayList<Player> highScorePlayers;

	public HighScoreTable(){
		
		highScorePlayers = HighScore.getHighScore();
		
		
		Object[][] data = new Object[10][4]; 
		int j = 1;
		for(int i=0; i<10; i++){
			data[i][0]=j;
			data[i][1]=highScorePlayers.get(i).getName();
			data[i][2]=highScorePlayers.get(i).getScore();
			data[i][3]=highScorePlayers.get(i).getTime();
			j++;
		}
		
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
		
		System.out.println(HighScore.getNewHighScorePlayers());
		
		changeHighScoreRowColor();
	}

	private void changeHighScoreRowColor() {
		// TODO Auto-generated method stub
		
	}
	
}
