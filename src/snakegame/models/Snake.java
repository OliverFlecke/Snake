package snakegame.models;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import snakegame.DIRECTION;

/**
 *	Snake class
 */
public class Snake {
	private LinkedList<Point> position;				// Position of the snake
	private int length;								// Length of the snake
	private DIRECTION direction;					// Movement direction 
	private DIRECTION lastDirection;				// The last direction to move in	
	private Player player;							// Player to keep track of name and score
	private Dimension gameDimension;				// Dimensions of the game
	private boolean isReady;						// State of the snake
	private boolean isEating;						// State of the snake to check if it is eating
	private boolean isDead;							// State of the snakes life
	
	/**
	 * Constructor to create a snake object with a default start point in the middle of the screen
	 */
	public Snake(Dimension gameDimension) {
		this(new Point(gameDimension.width / 2, gameDimension.height / 2), gameDimension);
	}
	
	/**
	 * Create a snake with the passed numbers as starting point
	 * @param x coordinate of the start position
	 * @param y coordinate of the start position
	 */
	public Snake(int x, int y, Dimension gameDimension) {
		this(new Point(x, y), gameDimension);
	}
	
	/**
	 * Create a snake with the passed point as a starting point
	 * @param startPosition for the snake
	 * @param name of the player
	 */
	public Snake(Point startPosition, Dimension gameDimension) {
		this.reset(startPosition);
		this.gameDimension = gameDimension;
		this.player = new Player();
	}
	
	/**
	 * Set the direction the snakes next move should be.
	 * Makes sure that the move is not opposite the last one
	 * @param newDirection The direction to move the snake in
	 */
	public void setDirection(DIRECTION newDirection) {
		if (this.lastDirection != null) // Makes sure the direction of the snake is not null
			switch (this.lastDirection) {
				case UP:
					if (newDirection != DIRECTION.DOWN)		// Can not go down when last move was up
						this.direction = newDirection;
					break;
				case DOWN:
					if (newDirection != DIRECTION.UP) 		// Can not go up when last move was down
						this.direction = newDirection;
					break;
				case LEFT:
					if (newDirection != DIRECTION.RIGHT)	// Can not go right when last move was left
						this.direction = newDirection;
					break;
				case RIGHT:
					if (newDirection != DIRECTION.LEFT)		// Can not go left when last move was right
						this.direction = newDirection;
					break;
				default:
					// Invalid move, do nothing
					break;
			}
		else {
			// The first time
			this.direction = newDirection;
			this.lastDirection = newDirection;
		}
	}
	
	/**
	 * Moves the snake in it's current direction.
	 */
	public void move() {
		if (!(this.isDead)) {
			Point newHead;
			Point lastHead = this.position.getFirst();
			switch (this.direction) {
				case UP:
					newHead = new Point(lastHead.x, lastHead.y + 1);
					if (newHead.y > this.gameDimension.height) {
						newHead.y = 0;
					}
					break;
				case DOWN:
					newHead = new Point(lastHead.x, lastHead.y - 1);
					if (newHead.y < 0) {
						newHead.y = this.gameDimension.height;
					}
					break;
				case LEFT:
					newHead = new Point(lastHead.x - 1, lastHead.y);
					if (newHead.x < 0) {
						newHead.x = this.gameDimension.width;
					}
					break;
				case RIGHT:
					newHead = new Point(lastHead.x + 1, lastHead.y);
					if (newHead.x > this.gameDimension.width) {
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
			// Update the last move direction
			this.lastDirection = this.direction;
			
			// If the length is smaller then the position list, remove the tail
			if (this.position.size() > this.length) 
				this.position.removeLast();
			
//			System.out.println(this.player.getName() + " move to [" + this.position.getFirst().x + "," 
//			+ this.position.getFirst().y + "]"); // Debug
		}
	}
	
	/**
	 * Check to see if the snake hit itself
	 * @return If the snake has hit itself
	 */
	public boolean checkCollision() {
		if (this.length > 1)
			for (Point current : this.position)
				// Check to see, if not the same object, but the same coordinates
				if (this.getHead().equals(current)) 
					if (!(this.position.getFirst() == current))		// Check it is not the same object
						return true;
		return false;
	}
	
	/**
	 * Check collision with other snakes in the game
	 * @param otherPoints The points of the other snakes
	 * @return True, if the snake has hit something
	 */
	public boolean checkCollision(ArrayList<Point> otherPoints) {
		boolean hasCollided = false;
		for (Point point : otherPoints) {
			if (this.getHead().equals(point))
				hasCollided = true;
		}
		if (this.checkCollision() || hasCollided) {
			this.isDead = true;
			return true;
		}	
		return false;
	}
	
	/**
	 * Eat food to make the snake grow and add food value to score 
	 * @param foodValue Value of the food eaten
	 */
	public void eatFood(Food foodEaten) {
		this.player.addToScore(foodEaten.getValue() * 100);
		this.length += foodEaten.getValue();
		this.isEating = true;
	}
	
	/**
	 * Reset the snake, to make it ready for a new game
	 * @param startPosition Its starting position
	 */
	public void reset(Point startPosition) {
		this.position = new LinkedList<Point>();
		this.position.add(startPosition);
		this.length = 2;
		this.direction = null; 
		this.lastDirection = null;
		this.isDead = false;
		this.isEating = false;
		this.isReady = false;
		
		if (this.player != null) {		
			this.player = new Player(this.getName(), 0, 0); 
		}
	}
	
	/**
	 * @return The position of the snake
	 */
	public ArrayList<Point> getPosition() {
		return new ArrayList<Point>(this.position);
	}
	
	/**
	 * @return The head of the snake
	 */
	public Point getHead() {
		return (this.position.getFirst());
	}
	
	/**
	 * @return The tail of the snake
	 */
	public Point getTail() {
		return this.position.getLast();
	}
	
	/**
	 * @return The snakes score
	 */
	public int getScore() {
		return this.player.getScore();
	}
	
	/**
	 * Setter method for the isReady field
	 */
	public void setReady() {
		this.isReady = true;
	}
	
	/**
	 * @return If the snake is ready
	 */
	public boolean getReady() {
		return this.isReady;
	}
	
	/**
	 * Set the name of the player
	 * @param name of the player
	 */
	public void setName(String name) {
		this.player.setName(name);
	}
	
	/**
	 * Get the name of the player
	 * @return The name of the player
	 */
	public String getName() {
		return this.player.getName();
	}
	
	/**
	 * Return the player object of this snake
	 * @return The player object of the snake
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * @return The direction of the snake
	 */
	public DIRECTION getCurrentDirection() {
		return this.direction;
	}
	
	/**
	 * @param isEating True if the snake is eating anything in this turn
	 */
	public void setIsEating(boolean isEating) {
		this.isEating = isEating;
	}
	
	/**
	 * @return True, if the snake is eating anything
	 */
	public boolean isEating() {
		return this.isEating;
	}
	
	/**
	 * @return True, if the snake is dead
	 */
	public boolean isDead() {
		return this.isDead;
	}
}