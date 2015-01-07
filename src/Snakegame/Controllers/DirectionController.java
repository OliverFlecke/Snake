package snakegame.controllers;

import snakegame.DIRECTION;
import snakegame.models.Snake;
import snakegame.models.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Controller to handle arrow key input
 */
public class DirectionController implements KeyListener {
	// Field for the game to control 
	private Game game;
	// State to see if the game is started
	private boolean isStarted = false;
	private boolean firstPress = true;
	
	/**
	 * Constructor, which takes the player to control
	 * @param player Snake to control
	 */
	public DirectionController(Game game) {
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
				this.game.moveSnake(DIRECTION.DOWN);
				this.isStarted = true;
				break;
			case KeyEvent.VK_UP:
				//this.player.move(DIRECTION.UP);
				System.out.println("Up key pressed");
				this.game.moveSnake(DIRECTION.UP);
				this.isStarted = true;
				break;
			case KeyEvent.VK_LEFT:
				//this.player.move(DIRECTION.LEFT);
				System.out.println("Left key pressed");
				this.game.moveSnake(DIRECTION.LEFT);
				this.isStarted = true;
				break;	
			case KeyEvent.VK_RIGHT:
				//this.player.move(DIRECTION.RIGHT);
				System.out.println("Right key pressed");
				this.game.moveSnake(DIRECTION.RIGHT);
				this.isStarted = true;
				break;		
			default:
				break;
		}
		
		// Start the games time, if an direction key is pressed
		if (this.isStarted && this.firstPress) {
			this.game.startGame();
			this.firstPress = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		
	}

	@Override
	public void keyTyped(KeyEvent event) {}
}