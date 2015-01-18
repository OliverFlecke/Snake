package snakegame.controllers;

/**
 * Listener interface, for all object how wants to be notified, when the game updates
 */
public interface GameListener {
	public void endGame();
	public void update();
}
