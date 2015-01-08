package snakegame.models;

import java.awt.Dimension;
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
	public Food(int foodValue, ArrayList<Point> occupiedCells, Dimension gameDimension) {
		this.eatValue = foodValue;
		this.position = this.createRandomPosition(occupiedCells, gameDimension);
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
		return new Point(this.position);
	}
	
	/**
	 * Get the x coordinate of the food object
	 * @return
	 */
	public int getX() {
		return this.position.x;
	}
	
	/**
	 * Get the y coordinate of the food object
	 * @return The y coordinate of the food object 
	 */
	public int getY() {
		return this.position.y;
	}
	
	/**
	 *	Creates a new random point in the game, where the food is placed 
	 *  @return A new random point
	 */
	private Point createRandomPosition(ArrayList<Point> occupiedCells, Dimension gameDimension) {
		Point position;
		// Insures the new food is not in an occupied cell
		do {
			position = Game.createRandomPoint(gameDimension);
		} while(occupiedCells.contains(position));	
		return position;
	}
}