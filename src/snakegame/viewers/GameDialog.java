package snakegame.viewers;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import snakegame.models.Game;



public class GameDialog extends GenericDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1124153227936952372L;
	
	//Create the buttons
	JButton restartBtn = new JButton("Restart");
	JButton closeBtn = new JButton("Close");
	
	//Make a JPanel to hold the btns
	JPanel btnShelf = new JPanel();
	
	//Make JLabel
	JLabel scoreText = new JLabel("", SwingConstants.CENTER);
		
	private Game game;
	
	public GameDialog(Game game, View view){
		super();
		this.game = game;
		int score = this.game.getScore();
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scoreText.setText("Score:" + score);
		btnShelf.add(restartBtn);
		btnShelf.add(closeBtn);
		this.getContentPane().add(scoreText, BorderLayout.NORTH);
		this.getContentPane().add(btnShelf, BorderLayout.SOUTH);
		add(btnShelf);
		
		
		closeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});	
		
		
		
		restartBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.dispose();
				new RunSnake();
				closeFrame();
			}
		});	
		
		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.setPreferredSize(getPreferredSize());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	

	}


