package snakegame.viewers;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4289097539606612476L;
	
	
	//make an array with room for as many textJpanels as there are players
	private TextJPanel[] playerArray = new TextJPanel[4];
	
	
	public PlayerPanel(int numbOfPlayers){
		
		if (numbOfPlayers <= 2){
			this.setLayout(new GridLayout(2,1));
		} else {
			this.setLayout(new GridLayout(2,2));
		}
		this.setOpaque(false);
		
		for (int i=1; i <= numbOfPlayers; i ++){
			TextJPanel newPanel = new TextJPanel("Player" + i, "Player"+i+"Name");
			playerArray[i-1] = newPanel;
			this.add(newPanel);
			
		}
		
		
	}

	public void updatePlayers(int numbOfPlayers){
		this.removeAll();

		for (int i=1; i <= numbOfPlayers; i ++){
			TextJPanel newPanel = new TextJPanel("Player" + i, "Player"+i+"Name");
			playerArray[i-1] = newPanel;
			this.add(newPanel);	
			
		}
		this.revalidate();
		this.repaint();
	}	
}
