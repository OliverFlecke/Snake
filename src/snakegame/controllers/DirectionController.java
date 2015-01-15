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
	// Game this controller is connected to
	private Game game;
	
	// State of the game
	private boolean isStarted = false;
	private boolean firstPress = true;
	
	// key codes for the keys to react to
	private int up, right, down, left;
	
	/**
	 * Constructor, which takes the player to control
	 * @param player Snake to control
	 */
	public DirectionController(Game game, Snake snake, HashMap<DIRECTION, Integer> keycodes) {
		this.snake = snake;
		this.game = game;
		
		this.up = keycodes.get(DIRECTION.UP);
		this.right = keycodes.get(DIRECTION.RIGHT);
		this.down = keycodes.get(DIRECTION.DOWN);
		this.left = keycodes.get(DIRECTION.LEFT);
	}
	
	/**
	 * Take a player type
	 * @param game
	 * @param snake
	 * @param playerType
	 */
	public DirectionController(Game game, Snake snake, int playerNumber) {
		this.game = game;
		this.snake = snake;
		this.setPlayerType(playerNumber);
	}
	
	/**
	 * Take key inputs as integers
	 * @param game
	 * @param snake
	 * @param up
	 * @param right
	 * @param down
	 * @param left
	 */
	public DirectionController(Game game, Snake snake, int up, int right, int down, int left) {
		this.snake = snake;
		this.game = game;
		
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
	}
	
	/** 
	 * Reset the controller. 
	 */
	public void reset() {
		this.isStarted = false;
		this.firstPress = true;
	}

	public void setPlayerType(int playerNumber) {
		switch (playerNumber) {
			case 0:
				this.up = KeyEvent.VK_UP;
				this.down = KeyEvent.VK_DOWN;
				this.left = KeyEvent.VK_LEFT;
				this.right = KeyEvent.VK_RIGHT;
				break;
			case 1:
				this.up = KeyEvent.VK_W;
				this.right = KeyEvent.VK_D;
				this.down = KeyEvent.VK_S;
				this.left = KeyEvent.VK_A;
				break;
			case 2: 
				this.up = KeyEvent.VK_T;
				this.right = KeyEvent.VK_H;
				this.down = KeyEvent.VK_G;
				this.left = KeyEvent.VK_F;
				break;
			case 3:
				this.up = KeyEvent.VK_I;
				this.right = KeyEvent.VK_L;
				this.down = KeyEvent.VK_K;
				this.left = KeyEvent.VK_J;
				break;
		}
	}
	
	@Override
	/**
	 * Control the game based on arrow key inputs
	 */
	public void keyPressed(KeyEvent event) {
		int keyCode = event.getKeyCode();
		if (!this.snake.isDead())
			if (keyCode == this.up || keyCode == this.right || keyCode == this.left || keyCode == this.down) {
				if (keyCode == this.up) 		{ this.snake.setDirection(DIRECTION.UP); } 
				else if (keyCode == this.right) { this.snake.setDirection(DIRECTION.RIGHT); } 
				else if (keyCode == this.down) 	{ this.snake.setDirection(DIRECTION.DOWN); } 
				else if (keyCode == this.left) 	{ this.snake.setDirection(DIRECTION.LEFT); }
				this.isStarted = true;
			}
		
		if (this.isStarted && this.firstPress) {
			this.snake.setReady();
			this.game.startGame();
			this.firstPress = false;
		}
	}
	/*
	 * switch (keyCode) {
			case this.down:
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
	 */

	@Override
	public void keyReleased(KeyEvent event) {}

	@Override
	public void keyTyped(KeyEvent event) {}
}