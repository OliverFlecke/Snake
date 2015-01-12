package snakegame.viewers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import snakegame.models.Game;
import snakegame.models.HighScore;



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
	
	//Make highscore tabel
	HighScoreTable table = new HighScoreTable();
	
		
	private Game game;
	
	public GameDialog(Game game, View view){
		super();
		this.game = game;
		int score = this.game.getSnakes().get(0).getScore();
		
		//Set transparency on shelfs
		btnShelf.setOpaque(false);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scoreText.setText("Score:" + score);
		btnShelf.add(restartBtn);
		btnShelf.add(closeBtn);
		
		
		//Arranging dialog
		background.setLayout(new BorderLayout());
		background.add(table,BorderLayout.NORTH);
		background.add(scoreText, BorderLayout.CENTER);
		background.add(btnShelf, BorderLayout.SOUTH);
		
		
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


