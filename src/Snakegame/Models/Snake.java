package snakegame.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

import snakegame.DIRECTION;

/**
 *	Snake class
 */
public class Snake {
	// Position of the snake 
	private LinkedList<Point> position = new LinkedList<Point>();
	private int length;

	private DIRECTION direction;	// Movement direction
	private int score = 0;		// Keeps track of the score
	
	/**
	 * Constructor to create a snake object 
	 */
	public Snake() {
		// Set the starting position at the middle of the screen
		position.add(new Point(Game.getDimension().width / 2, Game.getDimension().height / 2));
		position.add(new Point(Game.getDimension().width / 2 + 1, Game.getDimension().height / 2));
		
		// Set the starting length of the snake
		this.length = 2;
		this.direction = DIRECTION.RIGHT;
	}
	
	/**
	 * Create a snake with the passed point as a starting point
	 * @param startPosition for the snake
	 */
	public Snake(Point startPosition) {
		position.add(startPosition);
		this.length = 1;
	}
	
	/**
	 * Create a snake with the passed numbers as starting point
	 * @param x coordinate of the start position
	 * @param y coordinate of the start position
	 */
	public Snake(int x, int y) {
		this(new Point(x, y));
	}
	
	/**
	 * Create a snake from a array list
	 * @param startPosition list of start points
	 */
	public Snake(ArrayList<Point> startPosition) {
		for (Point point : startPosition) {
			this.position.add(point);
		}
		this.length = this.position.size();
	}
	
	/**
	 * Move the snake around the game. Makes sure that the move is not opposite the last one
	 * @param newDirection The direction to move the snake in
	 */
	public void move(DIRECTION newDirection) {
		switch (newDirection) {
			case UP:
				if (!(newDirection == DIRECTION.DOWN))
					this.direction = newDirection;
				break;
			case DOWN:
				if (!(newDirection == DIRECTION.UP))
					this.direction = newDirection;
				break;
			case LEFT:
				if (!(newDirection == DIRECTION.RIGHT))
					this.direction = newDirection;
				break;
			case RIGHT:
				if (!(newDirection == DIRECTION.LEFT))
					this.direction = newDirection;
				break;
			default:
				break;
		}
		this.move();
	}
	
	/**
	 * Moves the snake in it's current direction.
	 */
	public void move() {
		Point newHead;
		Point lastHead = this.position.getFirst();
		switch (this.direction) {
			case UP:
				newHead = new Point(lastHead.x, lastHead.y + 1);
				if (newHead.y > Game.getDimension().height) {
					newHead.y = 0;
				}
				break;
			case DOWN:
				newHead = new Point(lastHead.x, lastHead.y - 1);
				if (newHead.y < 0) {
					newHead.y = Game.getDimension().height;
				}
				break;
			case LEFT:
				newHead = new Point(lastHead.x - 1, lastHead.y);
				if (newHead.x < 0) {
					newHead.x = Game.getDimension().width;
				}
				break;
			case RIGHT:
				newHead = new Point(lastHead.x + 1, lastHead.y);
				if (newHead.x > Game.getDimension().width) {
					newHead.x = 0;
				}
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
	 * Get the points that represents the position of the snake
	 * @return The position of the snake
	 */
	public ArrayList<Point> getPosition() {
		ArrayList<Point> out = new ArrayList<Point>();
		for (Point current : this.position) {
			out.add(new Point(current));
		}
		return out;
	}
	
	/**
	 * Get the head of the snake. Get a new point object with heads coordinates 
	 * @return The head of the snake
	 */
	public Point getHead() {
		return new Point(this.position.getFirst());
	}
	
	/**
	 * Get the score of this snake
	 * @return The snakes score
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Check to see if the snake hit itself
	 * @return If the snake has hit itself
	 */
	public boolean checkCollision() {
		if (this.length > 1)
			for (Point current : this.position) {
				// Check to see, if not the same object, but the same coordinates
				if (!(this.position.getFirst() == current))
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