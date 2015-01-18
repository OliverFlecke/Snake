package snakegame.viewers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
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
		
	//Make high score tabel
	HighScoreTable table = new HighScoreTable();
	
	public GameDialog(Game game, View view){
		super();
		
		//Set transparency on shelfs
		btnShelf.setOpaque(false);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnShelf.add(restartBtn);
		btnShelf.add(closeBtn);
		
		
		//Arranging dialog
		background.setLayout(new BorderLayout());
		background.add(table,BorderLayout.NORTH);
		background.add(new ScoreText(game), BorderLayout.CENTER);
		background.add(btnShelf, BorderLayout.SOUTH);
		
		
		closeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});	
		
		restartBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//view.dispose();
				//new RunSnake();
				game.restartGame();
				view.createScorePanels();
				view.update();
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