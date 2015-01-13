package snakegame.viewers;

import java.awt.FlowLayout;


import javax.swing.JPanel;

public class PlayerSelectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8099161639164477982L;
	public PlayerPanel playerPanel;
	
	public PlayerSelectPanel(PlayerPanel playerPanel){
		this.playerPanel = playerPanel;
		
		this.setOpaque(false);
		this.setLayout(new FlowLayout());
		for (int i=1; i <=4; i ++){
			this.add(new SmallButton(""+ i, playerPanel));
		}
		
	}

}
