package snakegame.viewers;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;


import snakegame.models.Game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 */
public class SnakeGrid extends JPanel {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1801348824563036162L;
	private int gameWidthScale;
	private int gameHeightScale;
	
	
	// The game object
	private Game game;

	public SnakeGrid(Game game) {
		super();

		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(getPreferredSize().height, getPreferredSize().width));
		
		this.game = game;
		updateGrid();
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(500, 500);
	}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        drawSnake(g2);

    }

    /**
     * Clear the game area
     * @param g
     */
	public void clearCanvas(Graphics g) {
		g.clearRect(0, 0, getPreferredSize().width, getPreferredSize().height);
	}
       	
	public void drawSnake(Graphics2D g2){
	    for (Point currentPos : game.getSnakePosition()) {
	    	g2.fillRect(currentPos.x*gameWidthScale, (Game.getDimension().height - currentPos.y)*gameHeightScale, gameWidthScale, gameHeightScale);
        }
	}

	//@Override
	public void endGame() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void updateGrid() {
		gameWidthScale = this.getSize().width / (Game.getDimension().width + 1);
		gameHeightScale = this.getSize().height / (Game.getDimension().height + 1);
		this.repaint();	
	}
}