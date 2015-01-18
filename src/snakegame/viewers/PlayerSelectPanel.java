package snakegame.viewers;

import java.awt.FlowLayout;


import javax.swing.JPanel;

/**
 * Panel to the button for selecting the number of players
 */
public class PlayerSelectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8099161639164477982L;
	public PlayerPanel playerPanel;
	
	/**
	 * Constructor. Creates the panel to select number of players
	 * @param playerPanel
	 */
	public PlayerSelectPanel(PlayerPanel playerPanel){
		this.playerPanel = playerPanel;
		
		this.setOpaque(false);
		this.setLayout(new FlowLayout());
		for (int i = 1; i <= 4; i++){
			this.add(new SmallButton("" + i, playerPanel));
		}	
	}
}