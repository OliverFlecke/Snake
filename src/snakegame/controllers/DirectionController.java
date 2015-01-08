package snakegame.controllers;

import snakegame.DIRECTION;
import snakegame.models.Game;
import snakegame.models.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * Controller to handle arrow key input
 */
public class DirectionController implements KeyListener {
	// Field for the snake to control 
	private Snake snake;
	// Game this controller is connected to TODO
	private Game game;
	
	// Key codes to react to
	private HashMap<DIRECTION, Integer> keyCodes;
	
	private int[] keyCodesArray = new int[4];
	
	/**
	 * Constructor, which takes the player to control
	 * @param player Snake to control
	 */
	public DirectionController(Game game, Snake snake) {
		this.snake = snake;
		this.game = game;
	}

	@Override
	/**
	 * Control the game based on arrow key inputs
	 */
	public void keyPressed(KeyEvent event) {
		System.out.println("Key pressed");
		int keyCode = event.getKeyCode();
		switch (keyCode) {
			case KeyEvent.VK_DOWN:
				//this.player.move(DIRECTION.DOWN);
				System.out.println("Down key pressed");
				this.snake.setDirection(DIRECTION.DOWN);
				this.game.startGame();
				break;
			case KeyEvent.VK_UP:
				//this.player.move(DIRECTION.UP);
				System.out.println("Up key pressed");
				this.snake.setDirection(DIRECTION.UP);
				this.game.startGame();
				break;
			case KeyEvent.VK_LEFT:
				//this.player.move(DIRECTION.LEFT);
				System.out.println("Left key pressed");
				this.snake.setDirection(DIRECTION.LEFT);
				this.game.startGame();
				break;	
			case KeyEvent.VK_RIGHT:
				//this.player.move(DIRECTION.RIGHT);
				System.out.println("Right key pressed");
				this.snake.setDirection(DIRECTION.RIGHT);
				this.game.startGame();
				break;		
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {}

	@Override
	public void keyTyped(KeyEvent event) {}
}