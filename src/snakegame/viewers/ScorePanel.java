package snakegame.viewers;

import java.awt.*;

import javax.swing.*;

import snakegame.models.Player;

public class ScorePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 98987685754434677L;
	private Player player;
	private JLabel scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
	private JLabel nameLabel = new JLabel("Name: Testname", SwingConstants.CENTER);
	private JLabel timerLabel = new JLabel("Time: 0", SwingConstants.CENTER);

	public ScorePanel(Player player) {
		super();
		this.player = player;
		this.setLayout(new GridLayout(0,1));
		this.add(nameLabel);
		this.add(scoreLabel);
		this.add(timerLabel);
		this.setBackground(new Color(121,115,79));
		//top, left, bottom, right-for setting border
		this.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, new Color(167,160,108)));
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(200, 50);
	}

	public void update() {		
		
		scoreLabel.setText("Score: " + player.getScore());
		timerLabel.setText("Time: " + player.getTime());
		nameLabel.setText("Name: " + player.getName());
		
	}
}
