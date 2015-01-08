package snakegame.viewers;

import java.awt.*;

import javax.swing.*;

import snakegame.models.Game;

public class ScorePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 98987685754434677L;
	private Game game;
	private JLabel label = new JLabel("0");

	public ScorePanel(Game game) {
		super();
		this.game = game;
		this.setLayout(new GridBagLayout());
		this.add(label);
		this.setBackground(Color.PINK);
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(50, 50);
	}

	public void updateScore() {
		
		String labelscore = Integer.toString(game.getSnakes().get(0).getScore());
		
		label.setText(labelscore);
		
	}
}
