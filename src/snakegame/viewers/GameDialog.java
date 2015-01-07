package snakegame.viewers;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snakegame.models.Game;



public class GameDialog extends JFrame{

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
	
	private Game game;
	
	public GameDialog(Game game){
		super();
		this.game = game;
		int score = this.game.getScore();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnShelf.add(restartBtn);
		btnShelf.add(closeBtn);
		add(btnShelf);
		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.setPreferredSize(getPreferredSize());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(300, 150);

		
	}
}