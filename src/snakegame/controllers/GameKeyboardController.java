package snakegame.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import snakegame.models.Game;

/**
 * Controller for the game class.
 */
public class GameKeyboardController implements KeyListener {
	// Field for the game
	private Game game;
	
	/**
	 * Constructor for the game keyboard controller
	 * @param game
	 */
	public GameKeyboardController(Game game) {
		this.game = game;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_P) {
			this.game.pause();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}
}