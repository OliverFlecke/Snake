package snakegame.viewers;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import snakegame.models.Game;
import snakegame.models.Snake;

public class ScoreText extends JPanel{
	
	private Game game;
	
	public ScoreText(Game game){
		this.game = game;
		this.setOpaque(false);
		if(game.getSnakes().size()<=2){
			this.setLayout(new GridLayout(2,1));
		}
		else{
			this.setLayout(new GridLayout(2,2));
		}
		
		
		for(Snake current : game.getSnakes()) {
			JLabel label = new JLabel(current.getName() + " | " + "Score:" + current.getScore(), SwingConstants.CENTER);
			label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, 13));
			this.add(label);
			//label.setBorder(new EmptyBorder(10, 20, 10, 20) );
		}
	}

}
