package snakegame.viewers;

import java.awt.*;
import javax.swing.SwingConstants;

import javax.swing.*;

import snakegame.models.Game;

public class ScorePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 98987685754434677L;
	private Game game;
	private JLabel scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
	private JLabel nameLabel = new JLabel("Name: Testname", SwingConstants.CENTER);
	private JLabel timerLabel = new JLabel("Time: 0", SwingConstants.CENTER);

	public ScorePanel(Game game) {
		super();
		this.game = game;
		this.setLayout(new GridLayout());
		this.add(nameLabel);
		this.add(scoreLabel);
		this.add(timerLabel);
		this.setBackground(Color.PINK);
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(50, 50);
	}

	public void updateScore() {
		
		String labelscore = Integer.toString(game.getSnakes().get(0).getScore());
		
		scoreLabel.setText("Score: " + labelscore);
		
	}
}
