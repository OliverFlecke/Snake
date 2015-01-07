package snakegame.viewers;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

import snakegame.controllers.DirectionController;
import snakegame.controllers.GameListener;
import snakegame.models.Game;

import java.awt.BorderLayout;

public class View extends JFrame implements GameListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4697208908255317826L;
	private SnakeGrid snakeGrid;
	private Game game;


	public View(){
		super();

		this.game = new Game(10, 10);
		this.snakeGrid = new SnakeGrid(500, 500, game);
		this.addKeyListener(new DirectionController(game));
		
		game.addListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.getContentPane().add(snakeGrid, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}


	@Override
	public void endGame() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		System.out.println("Update and repaint view");
		snakeGrid.updateGrid();
		
	}
}