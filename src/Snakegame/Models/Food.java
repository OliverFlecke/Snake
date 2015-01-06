package snakegame.models;

import java.awt.Point;
import java.util.ArrayList;

/**
 *	Food, which holds an eat value and a position
 */
public class Food {
	// The value of the food when eaten
	private int eatValue;
	// Position of the food
	private Point position;
	
	/**
	 * Constructor. Creates a new food object at a random position.
	 * @param foodValue The value of the new food. 
	 */
	public Food(int foodValue, ArrayList<Point> occupiedCells) {
		this.eatValue = foodValue;
		this.position = this.createRandomPosition(occupiedCells);
	}
	
	/**
	 * Get the value of the food
	 * @return The value of the food
	 */
	public int getValue() {
		return this.eatValue;
	}
	
	/**
	 * Get the position of the food
	 * @return The position of the food
	 */
	public Point getPosition() {
		return this.position;
	}
	
	/**
	 *	Creates a new random point in the game, where the food is placed 
	 *  @return A new random point
	 */
	private Point createRandomPosition(ArrayList<Point> occupiedCells) {
		
		int x = (int) (Math.random() * Game.getDimension().width);
		int y = (int) (Math.random() * Game.getDimension().height);
		
		// TODO add check to see if the food is on top of the snake
		return new Point(x, y);
	}
}