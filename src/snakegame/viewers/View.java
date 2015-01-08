package snakegame.viewers;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

import snakegame.controllers.DirectionController;
import snakegame.controllers.GameListener;
import snakegame.controllers.ViewController;
import snakegame.models.Game;
import snakegame.viewers.sound.Sound;
import java.awt.BorderLayout;

public class View extends JFrame implements GameListener {

	private static final long serialVersionUID = -4697208908255317826L;

	private SnakeGrid snakeGrid;
	private Game game;
	private ScorePanel score;


	public View(int width, int height){
		super();
		
		this.game = new Game(width, height);
		this.snakeGrid = new SnakeGrid(game);
		this.addKeyListener(new DirectionController(game));
		this.addComponentListener(new ViewController());
		this.game.addListener(this);
		this.score = new ScorePanel(game);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.getContentPane().add(snakeGrid, BorderLayout.SOUTH);
		this.getContentPane().add(score, BorderLayout.NORTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.snakeGrid.updateGrid();
		Sound.MUSIC.loop();
	}


	@Override
	public void endGame() {
		Sound.MUSIC.stop();
		Sound.GAMEOVER.play();
		new GameDialog(game, this);
	}


	@Override
	public void update() {
		snakeGrid.updateGrid();
		// If the snake is eating, play a sound
		if (this.game.isEating()) {
			Sound.EAT.play();
		}
		score.updateScore();
	}
}