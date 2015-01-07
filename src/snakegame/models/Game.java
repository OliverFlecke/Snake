package snakegame.models;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

import snakegame.controllers.DirectionController;
import snakegame.controllers.GameListener;

/**
 *	Game model with all the game rules and logic
 */
public class Game {
	//List of viewers to notify of updates
	List<GameListener> listeners = new ArrayList<GameListener>();
	// The snake player
	private Snake snake;
	// ArrayList of all the food objects on the game field
	private ArrayList<Food> food;
	//int for storing highscore
	private int score=0;

	private static Dimension size;

	/**
	 * Constructor which takes the size of the game and stores it
	 * @param size Size of the game board
	 */
	public Game(Dimension newSize) {
		size = newSize;
		this.snake = new Snake();
		//creates initial food item and list
		this.food = new ArrayList<Food>();
		createFoodInGame(1);
		//creates listener for snake and game
		new DirectionController(snake,this);
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
	public static Dimension getDimension() {
		return new Dimension(size);
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
		this.food.add(new Food(foodValue, this.getOccupiedCells()));
	}

	/**
	 * Updates the game following a snake movement, checking for collision with food and with the snake itself
	 */
	public void update() {
		//ends game if snake collides with itself
		if(this.snake.checkCollision()){
			endGame();
		}
		/**
		 * removes food if in collision with snake head and increments score. Also generates new food.
		 * Furthermore notifies viewer of update
		 */
		for(Food current : this.food){
			if(current.getPosition()==this.snake.getHead()){
				removeFood(current);
				incrementScore();
			}
		}
		notifyListener();

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

	/**Add listener to list
	 * 
	 * @param GameListener
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
		for (GameListener gl : listeners)
			gl.endGame();

	}
	
	/** 
	 * getter for all occupied cells
	 * @return ArrayList<Point>
	 */

	public ArrayList<Point> getOccupiedCells() {	
		ArrayList<Point> occupiedCells = snake.getPosition();
		for(Food current : this.food){
			occupiedCells.add(current.getPosition());
		}
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
}
