package snakegame.controllers;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * ViewController. Makes overall responses to view events. 
 */
public class ViewController implements ComponentListener {
	
	/**
	 * Update the component this controller is linked to
	 */
	@Override
	public void componentResized(ComponentEvent e) {
		((GameListener) e.getComponent()).update();
	}

	@Override
	public void componentHidden(ComponentEvent e) {}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}
}
