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
	public void componentHidden(ComponentEvent e) {}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}
}
