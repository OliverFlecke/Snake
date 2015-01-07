package snakegame.viewers;

import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Point;

import javax.swing.JPanel;

import snakegame.controllers.DirectionController;
import snakegame.controllers.GameListener;
import snakegame.models.Game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 */
public class SnakeGrid extends JPanel /* implements GameListener */ {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1801348824563036162L;

	private Dimension gridSize;
	
	// The game object
	private Game game;

	public SnakeGrid(Dimension gridSize, Game game) {
		super();
		this.gridSize = gridSize;

		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(gridSize.height, gridSize.width, 1, 1));
		this.setPreferredSize(gridSize);
		
		this.game = game;

		/*
		snakePos = new ArrayList<Point>();
		snakePos.add(new Point(5,1));
		snakePos.add(new Point(5,2));
		snakePos.add(new Point(5,3));
		snakePos.add(new Point(5,4));
		*/
	}

	public SnakeGrid(int n, int m, Game game) {
		this(new Dimension(n, m), game);
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
		g.clearRect(0, 0, gridSize.width, gridSize.height);
	}

       	
	public void drawSnake(Graphics2D g2){
	    for (Point currentPos : game.getSnakePosition()){
	    	g2.fillRect(currentPos.x*20, currentPos.y*20, 20,20);
        }

	}

	//@Override
	public void endGame() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void updateGrid() {
		// TODO Auto-generated method stub
		System.out.println("Update and repaint view");
		this.repaint();	
	}
}