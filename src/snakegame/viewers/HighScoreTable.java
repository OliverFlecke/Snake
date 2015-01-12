package snakegame.viewers;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;

import snakegame.models.Player;

public class HighScoreTable extends JPanel{
	private String[] columnNames = {"#", 
			"Name",
			"Score",
			"Time"};

	public HighScoreTable(ArrayList<Player> players){
		
		Object[][] data = new Object[10][4]; 
		int j = 1;
		for(int i=0; i<10; i++){
			data[i][0]=j;
			data[i][1]=players.get(i).getName();
			data[i][2]=players.get(i).getScore();
			data[i][3]=players.get(i).getTime();
			j++;
		}
		
		JTable table = new JTable(data, columnNames);
		table.setEnabled(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		this.setOpaque(false);

		this.add(table);    
		
		this.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 20));
		
		this.setLayout(new BorderLayout());
		this.add(table.getTableHeader(), BorderLayout.PAGE_START);
		this.add(table, BorderLayout.CENTER);
	}
	
}
