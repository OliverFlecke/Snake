package snakegame.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Controller to handle arrow key input
 */
public class DirectionController implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getID()) {
			case KeyEvent.VK_DOWN:
				
				break;
			case KeyEvent.VK_UP:
				
				break;
			case KeyEvent.VK_LEFT:
				
				break;	
			case KeyEvent.VK_RIGHT:
				
				break;
				
			default:
					break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}