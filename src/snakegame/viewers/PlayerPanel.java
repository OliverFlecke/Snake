package snakegame.viewers;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4289097539606612476L;
	
	
	//make an array with room for as many textJpanels as there are players
	private TextJPanel[] playerArray = new TextJPanel[4];
	private ArrayList<String> names = new ArrayList<String>();
	
	
	public PlayerPanel(int numbOfPlayers){
		
		if (numbOfPlayers <= 2){
			this.setLayout(new GridLayout(2,1));
		} else {
			this.setLayout(new GridLayout(2,2));
		}
		this.setOpaque(false);
		
		for (int i=1; i <= numbOfPlayers; i ++){
			TextJPanel newPanel = new TextJPanel("Player" + i, "Player"+i);
			playerArray[i-1] = newPanel;
			this.add(newPanel);
			
		}
		
		
	}

	public void updatePlayers(int numbOfPlayers){
		this.removeAll();
		playerArray = new TextJPanel[4];

		for (int i=1; i <= numbOfPlayers; i ++){
			TextJPanel newPanel = new TextJPanel("Player" + i, "Player"+i+"Name");
			playerArray[i-1] = newPanel;
			this.add(newPanel);	
			
		}
		this.revalidate();
		this.repaint();
	}
	
	public ArrayList<String> names(){
		
		names.clear();
		
		for(int i=0; i < 4; i++){
			if (playerArray[i] instanceof TextJPanel ){
				names.add(i, playerArray[i].getTxt());
			}
			
		}
		return names
				
				;
	}
}
