package snakegame.viewers;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import snakegame.controllers.*;
import snakegame.models.Game;
import snakegame.viewers.sound.Sound;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

public class View extends JFrame implements GameListener {

	private static final long serialVersionUID = -4697208908255317826L;

	private SnakeGrid snakeGrid;
	private Game game;
	private JPanel scorePanelHolder;
	private ArrayList<DirectionController> directionController = new ArrayList<DirectionController>();

	//private ScorePanel score;
	


	public View(int width, int height, ArrayList<String> playerNames) {
		super();
		this.game = new Game(width, height, playerNames);
		// Create the controllers to control players and game with keyboard event and other
		this.createControllers(playerNames.size());
		this.snakeGrid = new SnakeGrid(game);
		this.scorePanelHolder = new JPanel();	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			this.setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
		} catch (Exception e) {	}
		this.getContentPane().add(snakeGrid, BorderLayout.CENTER);
		
		scorePanelHolder.setLayout(new GridLayout(0,1));
		this.getContentPane().add(scorePanelHolder,BorderLayout.EAST);
		this.createScorePanels();
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.update();
	}

	/**
	 * Create score panels with current players
	 */
	public void createScorePanels() {
		this.scorePanelHolder.removeAll();
		//cycles through snakes creating scorepanels
		for(int i=0; i<game.getSnakes().size(); i++ ){
			scorePanelHolder.add(new ScorePanel(game.getSnakes().get(i).getPlayer()));
		}
		
		// Start the music
		Sound.MUSIC.loop();
	}
	
	/**
	 * Create controllers for all the players in the game
	 * @param numOfPlayers Number of players to create controls for
	 */
	public void createControllers(int numOfPlayers) {
		this.addComponentListener(new ViewController());
		this.addKeyListener(new GameKeyboardController(this.game));
		this.game.addListener(this);
		
		switch (numOfPlayers) {
			case 4:
				directionController.add(new DirectionController(game, game.getSnakes().get(3), 3));
			case 3:
				directionController.add(new DirectionController(game, game.getSnakes().get(2), 2));
			case 2: 
				directionController.add(new DirectionController(game, game.getSnakes().get(1), 1));
			case 1: 
				directionController.add(new DirectionController(game, game.getSnakes().get(0), 0));
			default:
				break;
		}
		for (DirectionController controller :  this.directionController) {
			this.addKeyListener(controller);
		}
	}

	@Override
	public void endGame() {
		Sound.MUSIC.stop();
		Sound.GAMEOVER.play();
		
		// Reset the game for new round, if wanted
		for (DirectionController controller : this.directionController) {
			controller.reset();
		}
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