package snakegame.models;

import java.awt.Dimension;
import java.util.ArrayList;

/**
 *	Game model with all the game rules and logic
 */
public class Game {
	// The snake player
	private Snake snake;
	// ArrayList of all the food objects on the game field
	private ArrayList<Food> food;
	
	private static Dimension size;
	
	/**
	 * Constructor which takes the size of the game and stores it
	 * @param size Size of the game board
	 */
	public Game(Dimension newSize) {
		size = newSize;
		this.food = new ArrayList<Food>();
		food.add(new Food(1));
		this.snake = new Snake();
		mainGame();
		new DirectionController(snake,this);
	}
	
	private void mainGame() {
		
		
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
	 * Get the dimension of the game 
	 * @return The dimensions of the game
	 */
	public static Dimension getDimension() {
		return size;
	}
	
	/**
	 * Remove this food object passed to method
	 * @param food Food object to delete 
	 */
	public void removeFood(Food eatenFood) {
		this.food.remove(eatenFood);
		eatenFood = null;
		
		// Create a new food object, so there always is a food object in the game
		this.createFoodInGame(1);
	}
	
	/**
	 * Create a new food object
	 * @param foodValue Value to give the new food object
	 */
	public void createFoodInGame(int foodValue) {
		this.food.add(new Food(foodValue));
	}
}
