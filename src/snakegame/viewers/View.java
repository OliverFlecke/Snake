package snakegame.viewers;

import javax.swing.BoxLayout;
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
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class View extends JFrame implements GameListener {

	private static final long serialVersionUID = -4697208908255317826L;

	private SnakeGrid snakeGrid;
	private Game game;
	private ArrayList<ScorePanel> scorepanels;
	private JPanel scorePanelHolder;

	//private ScorePanel score;
	


	public View(int width, int height, ArrayList<String> playerNames){
		super();
		this.game = new Game(width, height, 2);
		//passes player names to game
		game.setPlayerNames(playerNames);
	
		this.snakeGrid = new SnakeGrid(game);
		this.scorePanelHolder = new JPanel();
		
		
		//TODO put somewhere else
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
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.getContentPane().add(snakeGrid, BorderLayout.CENTER);
		
		scorePanelHolder.setLayout(new GridLayout(0,1));
		
		this.getContentPane().add(scorePanelHolder,BorderLayout.EAST);
		
		//cycles through snakes creating scorepanels
		for(int i=0; i<game.getSnakes().size(); i++ ){
			scorePanelHolder.add(new ScorePanel(game.getSnakes().get(i).getPlayer()));
		}
		
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
		for(int i = 0; i < game.getSnakes().size(); i++ ) {
			Component component = this.scorePanelHolder.getComponent(i);
			if (component instanceof ScorePanel)
				((ScorePanel) component).update();
		}
	}
}