package snakegame.viewers;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import snakegame.models.Game;
import snakegame.models.Snake;

public class ScoreText extends JPanel{
	
	private Game game;
	
	public ScoreText(Game game){
		this.game = game;
		this.setOpaque(false);
		this.setLayout(new FlowLayout());
		
		for(Snake current : game.getSnakes()){
			this.add(new JLabel("    " + current.getName() + " | " + current.getScore() + "    ", SwingConstants.CENTER));
		}
	}

}
