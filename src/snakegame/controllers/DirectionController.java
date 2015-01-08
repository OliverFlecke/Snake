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
	
	// State of the game
	private boolean isStarted = false;
	private boolean firstPress = true;
	
	// key codes for the keys to react to
	int up, right, down, left;
	
	/**
	 * Constructor, which takes the player to control
	 * @param player Snake to control
	 */
	public DirectionController(Game game, Snake snake, HashMap<DIRECTION, Integer> keycodes) {
		this.snake = snake;
		this.game = game;
		
		this.up = keycodes.get(DIRECTION.UP);
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
				this.isStarted = true;
				break;
			case KeyEvent.VK_UP:
				//this.player.move(DIRECTION.UP);
				System.out.println("Up key pressed");
				this.snake.setDirection(DIRECTION.UP);
				this.isStarted = true;
				break;
			case KeyEvent.VK_LEFT:
				//this.player.move(DIRECTION.LEFT);
				System.out.println("Left key pressed");
				this.snake.setDirection(DIRECTION.LEFT);
				this.isStarted = true;
				break;	
			case KeyEvent.VK_RIGHT:
				//this.player.move(DIRECTION.RIGHT);
				System.out.println("Right key pressed");
				this.snake.setDirection(DIRECTION.RIGHT);
				this.isStarted = true;
				break;		
			default:
				break;
		}
		
		if (this.isStarted && this.firstPress) {
			this.snake.setReady();
			this.game.startGame();
			this.firstPress = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {}

	@Override
	public void keyTyped(KeyEvent event) {}
}