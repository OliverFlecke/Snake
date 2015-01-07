package snakegame.viewers;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

import snakegame.controllers.DirectionController;
import snakegame.controllers.GameListener;
import snakegame.models.Game;

import java.awt.BorderLayout;

public class View extends JFrame implements GameListener {

	private static final long serialVersionUID = -4697208908255317826L;

	private SnakeGrid snakeGrid;
	private Game game;


	public View(int width, int height){
		super();
		
		this.game = new Game(width, height);
		this.snakeGrid = new SnakeGrid(game);
		this.addKeyListener(new DirectionController(game));
		
		game.addListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.getContentPane().add(snakeGrid, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.snakeGrid.updateGrid();
	}


	@Override
	public void endGame() {
		GameDialog endGameDialog = new GameDialog(game, this);
		
	}


	@Override
	public void update() {
		System.out.println("Update and repaint view");
		snakeGrid.updateGrid();
		
	}
}