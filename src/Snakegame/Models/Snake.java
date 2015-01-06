package snakegame.models;

import java.awt.Point;
import java.util.*;

import snakegame.DIRECTION;

/**
 *	Snake class
 */
public class Snake {
	// Position of the snake 
	private LinkedList<Point> position = new LinkedList<Point>();
	private int length;

	private int speed;				// Snakes speed 
	private DIRECTION direction;	// Movement direction
	private int score = 0;		// Keeps track of the score
	
	/**
	 * Constructor to create a snake object 
	 */
	public Snake() {
		this.speed = 1;
		
		// Set the starting position at the middle of the screen
		position.add(new Point(Game.getDimension().width / 2, Game.getDimension().height / 2));
		// position.add(new Point(Game.getDimension().width / 2 + 1, Game.getDimension().height / 2));
		
		// Set the starting length of the snake
		this.length = 1;
	}
	
	/**
	 * Move the snake around the game
	 * @param newDirection The direction to move the snake in
	 */
	public void move(DIRECTION newDirection) {
		this.direction = newDirection;
		this.move();
	}
	
	/**
	 * Moves the snake in it's current direction
	 */
	public void move() {
		Point newHead;
		Point lastHead = this.position.getFirst();
		switch (this.direction) {
			case UP:
				newHead = new Point(lastHead.x, lastHead.y + 1);
				break;
			case DOWN:
				newHead = new Point(lastHead.x, lastHead.y - 1);
				break;
			case LEFT:
				newHead = new Point(lastHead.x - 1, lastHead.y);
				break;
			case RIGHT:
				newHead = new Point(lastHead.x + 1, lastHead.y);
				break;
			// Makes sure that a point is created
			default:
				newHead = new Point();
				break;
		}
		// Update the position of the snake
		this.position.addFirst(newHead);
		
		// If the length is smaller then the position list, remove the tail
		if (this.position.size() > this.length) 
			this.position.removeLast();
	}
	
	/**
	 * Get the position of the snake
	 * @return The position of the snake
	 */
	public LinkedList<Point> getPosition() {
		return this.position;
	}
	
	/**
	 * Get the head of the snake
	 * @return The head of the snake
	 */
	public Point getHead() {
		return this.position.getFirst();
	}
	
	/**
	 * Check to see if the snake hit itself
	 * @return If the snake has hit itself
	 */
	public boolean checkCollision() {
		for (Point current : this.position) {
			if (this.getHead().equals(current)) 
				return true;
		}
		
		return false;
	}
	
	/**
	 * Eat food to make the snake grow and add food value to score 
	 * @param foodValue Value of the food eaten
	 */
	public void eatFood(Food foodEaten) {
		// TODO The snake should be able to eat food and score points
		this.score += foodEaten.getValue();
		this.length += foodEaten.getValue();
	}
}