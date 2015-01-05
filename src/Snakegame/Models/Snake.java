package Snakegame.Models;

import java.awt.Point;
import java.util.*;

import Snakegame.DIRECTION;

/**
 *	Snake class
 */
public class Snake {
	// Position of the snake 
	private LinkedList<Point> position = new LinkedList<Point>();

	private int speed;				// Snakes speed 
	private DIRECTION direction;	// Movement direction
	private int score = 0;		// Keeps track of the score
	
	/**
	 * Constructor to create a snake object 
	 */
	public Snake() {
		this.speed = 1;
		
		// Set the starting position at the middle of the screen
		position.add(new Point(Game.getDimension().height / 2, Game.getDimension().width / 2));
	}
	
	/**
	 * Move the snake around the game
	 * @param newDirection The direction to move the snake in
	 */
	public void move(DIRECTION newDirection) {
		// TODO Make the snake implement a way to move around
	}
	
	/**
	 * Eat food to make the snake grow and add food value to score 
	 * @param foodValue Value of the food eaten
	 */
	public void eatFood(Food foodEaten) {
		// TODO The snake should be able to eat food and score points
	}
}