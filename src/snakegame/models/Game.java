package snakegame.models;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import javax.swing.Timer;

import snakegame.DIRECTION;
import snakegame.controllers.GameListener;
import snakegame.viewers.sound.Sound;

/**
 *	Game model with all the game rules and logic
 */
public class Game implements ActionListener {
	// List of viewers to notify of updates
	List<GameListener> listeners = new ArrayList<GameListener>();
	// The snake player
	private Snake snake;
	// ArrayList of all the food objects on the game field
	private ArrayList<Food> food;
	// int for storing highscore
	private int score=0;
	// Dimensions of the game field
	private Dimension size;
	
	// Game states
	private boolean gameOver;		
	// Is eating food
	private boolean isEating;
	
	// Timer to control the games speed
	private Timer gameTimer;
	// Delay in the timer
	private int timerValue = 200;

	/**
	 * Constructor which takes the size of the game and stores it
	 * @param size Size of the game board
	 */
	public Game(Dimension newSize) {
		size = newSize;
		this.snake = new Snake(this.getDimension());
		//creates initial food item and list
		this.food = new ArrayList<Food>();
		createFoodInGame(1);
		
		this.gameTimer = new Timer(this.timerValue, this);
	}

	/**
	 * Constructor, which takes two integers, and creates an dimension from those 
	 * @param width of the game
	 * @param height of the game
	 */
	public Game(int width, int height) {
		this(new Dimension(width, height));
	}

	/**
	 * Get the dimension of the game. Creates a new object, so nobody outside this class
	 * can edit the dimension of the game. 
	 * @return The dimensions of the game
	 */
	public Dimension getDimension() {
		return new Dimension(size);
	}

	/**½
	 * Remove this food object passed to method
	 * @param food Food object to delete 
	 */
	public void removeFood(Food eatenFood) {
		this.food.remove(eatenFood);

		// Creates a new food object, so there is always a food object in the game
		this.createFoodInGame(1);
	}

	/**
	 * Create a new food object
	 * @param foodValue Value to give the new food object
	 */
	private void createFoodInGame(int foodValue) {
		this.food.add(new Food(foodValue, this.getOccupiedCells(), this.getDimension()));
	}
	
	/**
	 * Start the time for the game
	 */
	public void startGame() {
		this.gameOver = false;
		this.gameTimer.start();
	}

	/**
	 * Updates the game following a snake movement, checking for collision with food and with the snake itself
	 */
	public void update() {
		//ends game if snake collides with itself
		if(this.snake.checkCollision()){
			endGame();
		}
		
		// Removes food, plays sound and increments score if in collision with snake head. Also generates new food.
		// Furthermore notifies viewer of update
		for(Food current : this.food){
			if(current.getPosition().equals(this.snake.getHead())) {
				this.snake.eatFood(current);
				removeFood(current);
				incrementScore();
				this.isEating = true;
			}
		}
		notifyListener();
		this.isEating = false;
	}
	
	/**
	 * Makes the snake move in the passed direction
	 */
	public void moveSnake(DIRECTION moveDirection) {
		this.snake.setDirection(moveDirection);
	}
	
	/*
	 * Makes the snake move in its current direction
	 */
	private void moveSnake() {
		this.snake.move();
		this.update();
	}
	
	/**
	 * Update the timer with a new delay value
	 * @param newTimer The new delay time
	 */
	public void updateTimer(int newTimer) {
		this.gameTimer.setDelay(newTimer);
	}
	
	/** 
	 * getter for all occupied cells
	 * @return ArrayList<Point>
	 */
	public ArrayList<Point> getOccupiedCells() {	
		ArrayList<Point> occupiedCells = snake.getPosition();
		for(Food current : this.food)
			occupiedCells.add(current.getPosition());
		return occupiedCells;
	}
	
	/** 
	 * getter for all snake occupied cells
	 * @return ArrayList<Point>
	 */
	public ArrayList<Point> getSnakePosition() {
		return snake.getPosition();
	}
	
	/** 
	 * getter for all food objects
	 * @return ArrayList<Food>
	 */
	public ArrayList<Food> getFood() {
		return this.food;	
	}
	
	/**
	 * increments score
	 */
	private void incrementScore() {
		score++;	
	}
	
	/**
	 * getter for score
	 */
	public int getScore(){
		return score;
	}
	
	/**
	 * Return true if any snake is eating
	 * @return if the snake is eating
	 */
	public boolean isEating() {
		return this.isEating;
	}

	/**
	 * Add listener to list
	 * @param GameListener Object to listen for updates
	 */
	public void addListener(GameListener toAdd) {
		listeners.add(toAdd);
	}
	
	/** 
	 * Call update method with listeners 
	 */
	private void notifyListener() {
		for (GameListener gl : listeners)
			gl.update();
	}
	
	/**
	 * call endgame method with listeners
	 */
	private void endGame() {
		this.gameOver = true;
		for (GameListener gl : listeners)
			gl.endGame();
	}

	/**
	 * Move the snake each time it is notified
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!this.gameOver) {
			this.moveSnake();
			this.gameTimer.restart();
		} else {
			this.gameTimer.stop();
		}
	}
}