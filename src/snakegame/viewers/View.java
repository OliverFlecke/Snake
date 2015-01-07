package snakegame.viewers;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

import snakegame.controllers.DirectionController;
import snakegame.models.Game;

import java.awt.BorderLayout;

public class View extends JFrame{

	private SnakeGrid snakeGrid;
	private Game game;


	public View(){
		super();

		this.game = new Game(10, 10);
		this.snakeGrid = new SnakeGrid(500, 500, game);
		this.addKeyListener(new DirectionController(game));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.getContentPane().add(snakeGrid, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
}