package snakegame.viewers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class ScorePanel extends JPanel{
	
	public ScorePanel() {
		super();
		this.setBackground(Color.BLUE);
		this.setLayout(new GridLayout(getPreferredSize().height, getPreferredSize().width));
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(10, 100);
	}

}
