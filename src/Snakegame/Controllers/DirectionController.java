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
	// Field for the snake to control 
	private Snake player;
	private Game game;
	
	/**
	 * Constructor, which takes the player to control
	 * @param player Snake to control
	 */
	public DirectionController(Snake player, Game game) {
		this.player = player;
		this.game = game;
	}

	@Override
	/**
	 * Control the snake based on arrow key inputs
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getID()) {
			case KeyEvent.VK_DOWN:
				this.player.move(DIRECTION.DOWN);
				this.game.update();
				break;
			case KeyEvent.VK_UP:
				this.player.move(DIRECTION.UP);
				this.game.update();
				break;
			case KeyEvent.VK_LEFT:
				this.player.move(DIRECTION.LEFT);
				this.game.update();
				break;	
			case KeyEvent.VK_RIGHT:
				this.player.move(DIRECTION.RIGHT);
				this.game.update();
				break;
				
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}