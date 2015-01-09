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
	List<GameListener> listeners; 			// List of viewers to notify of updates
	private ArrayList<Snake> snakes;		// The snakes
	private ArrayList<Food> food;			// ArrayList of all the food objects on the game field
	private int level = 0;					// int for storing highscore
	private Dimension size;					// Dimensions of the game field

	private boolean gameOver;				// Game states
	private Timer gameTimer;				// Timer to control the games speed
	private int timerValue = 150;			// Delay in the timer
	private int updateTimeValue = 20;		// Update time value

	/**
	 * Constructor which takes the size of the game and stores it
	 * @param size Size of the game board
	 */
	public Game(Dimension newSize) {
		this(newSize, 1);
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
	 * Constructor for multiplayer
	 * @param width
	 * @param height
	 * @param numberOfPlayers
	 */
	public Game(int width, int height, int numberOfPlayers) {
		this(new Dimension(width, height), numberOfPlayers);
	}
	
	/**
	 * Constructor to take the size of the game grid, and an int to define
	 * how many players, that are playing
	 * @param width	of the game
	 * @param height of the game
	 * @param numberOfPlayers in the game
	 */
	public Game(Dimension newSize, int numberOfPlayers) {
		this.size = newSize;
		this.setupGame(numberOfPlayers);
	}
	
	/**
	 * Creates the snakes and food objects at the start of the game
	 * @param numberOfPlayers Number of players in the game
	 */
	private void setupGame(int numberOfPlayers) {
		// Create the list for the game
		this.listeners = new ArrayList<GameListener>();
		this.snakes = new ArrayList<Snake>();
		this.food = new ArrayList<Food>();
		this.gameTimer = new Timer(this.timerValue, this);
		// Make a time value based on how big the game grid are
		this.updateTimeValue = 200 / ((this.size.width > this.size.height) ? this.size.width : this.size.height);
		
		// Create the different snakes
		if (numberOfPlayers == 1) {
			this.snakes.add(new Snake(this.getDimension()));
			createFoodInGame(1);
		} 
		else if (numberOfPlayers > 1 && numberOfPlayers <= 4) {
			int index = 0;
			while (numberOfPlayers > index) {
				this.snakes.add(new Snake(Game.createRandomPoint(this.getDimension()), this.getDimension()));
				createFoodInGame(1);			// Create a food object for each snake
				index++;						// Increment counter
			}
		}
	}

	/**
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
	 * Create a random point in the game field
	 * @return A random point within the game field
	 */
	public static Point createRandomPoint(Dimension gameDimension) {
		int x = (int) (Math.random() * gameDimension.width);
		int y = (int) (Math.random() * gameDimension.height);
		return new Point(x, y);
	}
	
	/**
	 * Updates the game following a snake movement, checking for collision with food and with the snake itself
	 */
	public void update() {
		// Assume everyone is dead
		boolean allDead = true;
		Food foodToRemove = null;
		// Removes food, plays sound and increments score if in collision with snake head. Also generates new food.
		for (Snake snake : this.snakes) {
			if (!(snake.isDead())) {
				for (Food current : this.food){
					if(current.getPosition().equals(snake.getHead())) {
						snake.eatFood(current);
						foodToRemove = current;
						incrementLevel();
						snake.setIsEating(true);
						
						// Updates the game, so it gets harder over time
						if (this.level % 10 == 0) {
							this.updateTimer();
						} 
					}
				}
				// Creates an array list of all the other snakes positions in the game
				ArrayList<Point> snakePositions = new ArrayList<Point>();
				for (Snake otherSnake : this.snakes) {
					if (!(snake.equals(otherSnake))) {
						for (Point point : otherSnake.getPosition())
							snakePositions.add(point);
					}
				}
				snake.getPlayer().incrementTime();
				//ends game if snake collides with itself or any other snake
				allDead = snake.checkCollision(snakePositions) && allDead;		
			}
		}
		if (allDead) 
			endGame();
		if (foodToRemove != null) 
			this.removeFood(foodToRemove);
		
		// Furthermore notifies viewer of update
		notifyListener();
		for (Snake snake : this.snakes) 
			snake.setIsEating(false);
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
	 * increments score
	 */
	private void incrementLevel() {
		level++;	
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
	 * Get the dimension of the game. Creates a new object, so nobody outside this class
	 * can edit the dimension of the game. 
	 * @return The dimensions of the game
	 */
	public Dimension getDimension() {
		return new Dimension(size);
	}
	
	/**
	 * @param names List of names to the players in the game
	 */
	public void setPlayerNames(ArrayList<String> names) {
		if (this.snakes.size() <= names.size()) {
			int index = 0;
			for (Snake snake : this.snakes) {
				snake.setName(names.get(index));
				index++;
			}
		}
	}
}