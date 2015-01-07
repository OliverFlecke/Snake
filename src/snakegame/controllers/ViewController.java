package snakegame.controllers;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import snakegame.viewers.View;

public class ViewController implements ComponentListener {
	
	private View view;
	
	public ViewController(View view) {
		this.view = view;
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		this.view.update();
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
