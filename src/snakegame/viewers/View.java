package snakegame.viewers;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import snakegame.DIRECTION;
import snakegame.controllers.DirectionController;
import snakegame.controllers.GameKeyboardController;
import snakegame.controllers.GameListener;
import snakegame.controllers.ViewController;
import snakegame.models.Game;
import snakegame.models.Player;
import snakegame.viewers.sound.Sound;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class View extends JFrame implements GameListener {

	private static final long serialVersionUID = -4697208908255317826L;

	private SnakeGrid snakeGrid;
	private Game game;
	private ArrayList<ScorePanel> scorepanels;
	


	public View(int width, int height, ArrayList<String> playerNames){
		super();
//		this.game = new Game(width, height);
		this.game = new Game(width, height, 2);
		this.snakeGrid = new SnakeGrid(game);
		
		//passes player names to game
		game.setPlayerNames(playerNames);
		
		HashMap<DIRECTION, Integer> defaultKeys = new HashMap<DIRECTION, Integer>();
		defaultKeys.put(DIRECTION.UP, KeyEvent.VK_UP);
		defaultKeys.put(DIRECTION.RIGHT, KeyEvent.VK_RIGHT);
		defaultKeys.put(DIRECTION.DOWN, KeyEvent.VK_DOWN);
		defaultKeys.put(DIRECTION.LEFT, KeyEvent.VK_LEFT);
		
		this.addKeyListener(new DirectionController(game, game.getSnakes().get(0), defaultKeys));
		this.addKeyListener(new DirectionController(game, game.getSnakes().get(1), 
				KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_A));
		game.getSnakes().get(1).setColor(Color.BLUE);
		this.addComponentListener(new ViewController());
		this.addKeyListener(new GameKeyboardController(this.game));
		this.game.addListener(this);
		
		//this.score = new ScorePanel(player);  TODO implementer loop over arraylist af players
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.getContentPane().add(snakeGrid, BorderLayout.CENTER);
		// TODO cycle through player list and create scorepanels, this.getContentPane().add(score, BorderLayout.PAGE_START);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.update();
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

		//score.updateScorePanel();
	}
}