package snakegame.viewers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	JLabel scoreText = new JLabel();
	
	public GameDialog(Game game, View view){
		super();
		int score = game.getScore();
		scoreText.setText("Score:" + score);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				new View(10, 10);
				closeFrame();
			}
		});		
	}
	
		
}
