package snakegame.viewers;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;





import javax.swing.border.LineBorder;

import snakegame.models.Food;
import snakegame.models.Game;
import snakegame.models.Snake;


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
		this.setBorder(new LineBorder(Color.black, 5));
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
        placeFood(g2);

    }


       	
	public void drawSnake(Graphics2D g2){
		for (Snake snake : game.getSnakes()){
		    for (Point currentPos : snake.getPosition()) {
		    	g2.setColor(Color.black);
		    	g2.fillRect(currentPos.x*gameWidthScale, (this.game.getDimension().height - currentPos.y)*gameHeightScale, gameWidthScale, gameHeightScale);

	        }
	    	g2.setColor(Color.green);
	    	Point head = snake.getHead();
	    	g2.fillRect(head.x*gameWidthScale, (this.game.getDimension().height - head.y)*gameHeightScale, gameWidthScale, gameHeightScale);
		}
	}

	//@Override
	public void updateGrid() {
		gameWidthScale = this.getSize().width / (this.game.getDimension().width + 1);
		gameHeightScale = this.getSize().height / (this.game.getDimension().height + 1);
		this.repaint();	
	}
	
	public void placeFood(Graphics2D g2) {
		g2.setColor(Color.cyan);
	    for (Food currentFood : game.getFood()) {
	    	Point currentPos = currentFood.getPosition();
	    	g2.fillRect(currentPos.x*gameWidthScale, (this.game.getDimension().height - currentPos.y)*gameHeightScale, gameWidthScale, gameHeightScale);
        }		
	}
}