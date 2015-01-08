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

/**
 *	Game model with all the game rules and logic
 */
public class Game implements ActionListener {
	List<GameListener> listeners = new ArrayList<GameListener>(); 	// List of viewers to notify of updates
	private ArrayList<Snake> snakes = new ArrayList<Snake>();		// The snakes
	private ArrayList<Food> food;			// ArrayList of all the food objects on the game field
	private int score = 1;					// int for storing highscore
	private Dimension size;					// Dimensions of the game field

	private boolean gameOver;				// Game states	
	private boolean isEating;				// Is eating food
	
	private Timer gameTimer;				// Timer to control the games speed
	private int timerValue = 100;			// Delay in the timer
	private int updateTimeValue = 20;		// Update time value

	/**
	 * Constructor which takes the size of the game and stores it
	 * @param size Size of the game board
	 */
	public Game(Dimension newSize) {
		size = newSize;
		this.snakes.add(new Snake(this.getDimension(), "Snake"));
		//this.snakes.add(new Snake(this.getDimension(), "Orm"));
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
		boolean gameReady = true;
		for (Snake snake : this.snakes)
			gameReady = snake.getReady() && gameReady;
		
		System.out.println("Start game");
		if (gameReady) {
			this.gameOver = false;
			this.gameTimer.start();
		}
	}

	/**
	 * Updates the game following a snake movement, checking for collision with food and with the snake itself
	 */
	public void update() {
		// Assume everyone is dead
		boolean allDead = true;
		// Removes food, plays sound and increments score if in collision with snake head. Also generates new food.
		for (Snake snake : this.snakes) {
			for (Food current : this.food){
				if(current.getPosition().equals(snake.getHead())) {
					snake.eatFood(current);
					removeFood(current);
					incrementScore();
					this.isEating = true;
					
					// Updates the game, so it gets harder over time
					if (this.score % 5 == 0) {
						this.updateTimer();
					} 
				}
			}
			//ends game if snake collides with itself or any other snake
			allDead = snake.checkCollision() && allDead;		
		}
		if (allDead) 
			endGame();
		
		// Furthermore notifies viewer of update
		notifyListener();
		this.isEating = false;
	}
	
	/**
	 * Makes the snake move in the passed direction
	 */
	public void moveSnake(DIRECTION moveDirection) {
		this.snakes.get(0).setDirection(moveDirection);
	}
	
	/*
	 * Makes the snake move in its current direction
	 */
	private void moveSnakes() {
		for (Snake snake : this.snakes)
			snake.move();
	}
	
	/**
	 * Pause or unpause the game
	 */
	public void pause() {
		if (this.gameTimer.isRunning()) 
			this.gameTimer.stop();
		else 
			this.gameTimer.start();
	}
	
	/**
	 * Update the timer with a new delay value
	 * @param newTimer The new delay time
	 */
	public void updateTimer(int newTimer) {
		this.gameTimer.setInitialDelay(newTimer);
	}
	
	/**
	 * Update the time with the default value
	 */
	private void updateTimer() {
		this.timerValue -= this.updateTimeValue;
		this.updateTimer(this.timerValue);
	}
	
	/** 
	 * getter for all occupied cells
	 * @return ArrayList<Point>
	 */
	public ArrayList<Point> getOccupiedCells() {	
		ArrayList<Point> occupiedCells = new ArrayList<Point>();
		for (Snake snake : this.snakes)
			for (Point point : snake.getPosition())
				occupiedCells.add(point);
		for (Food current : this.food)
			occupiedCells.add(current.getPosition());
		return occupiedCells;
	}
	
	/** 
	 * getter for all snake occupied cells
	 * @return ArrayList<Point>
	 */
	public ArrayList<Point> getSnakePosition() {
		ArrayList<Point> positions = new ArrayList<Point>();
		for (Snake snake : this.snakes) 
			for (Point point : snake.getPosition())
				positions.add(point);
		return positions;
	}
	
	/**
	 * All the snakes in the game
	 * @return The snakes in the game
	 */
	public ArrayList<Snake> getSnakes() {
		// TODO make it other objects, so the outside can't modify the snakes
		ArrayList<Snake> snakes = new ArrayList<Snake>();
		for (Snake snake : this.snakes) 
			snakes.add(snake);
		return this.snakes;
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
			this.moveSnakes();
			this.update();
			this.gameTimer.restart();
		} else {
			this.gameTimer.stop();
		}
	}
}