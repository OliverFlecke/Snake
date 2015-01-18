package snakegame.viewers;



import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import snakegame.models.Food;
import snakegame.models.Game;
import snakegame.models.Snake;
import snakegame.viewers.sound.Sound;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The grid where the game is displayed
 */
public class SnakeGrid extends JPanel {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1801348824563036162L;
	
	// Scale for the game width and height
	private double gameWidthScale;
	private double gameHeightScale;
	
	// Image for the background and food
	private BufferedImage background;
	//private BufferedImage food;
	
	// The game object
	private Game game;
	private ArrayList<Food> lastFoodArray;

	/**
	 * Constructor for the snakegrid
	 * @param game to dislpay in the grid
	 */
	public SnakeGrid(Game game) {
		super();
		
		//Load in the background image.
		try {
			background = ImageIO.read(SnakeGrid.class.getResource("images/snakeGrassText.jpg"));
		} catch (IOException e) {
    		this.setBackground(Color.GRAY);
		}
		
//		try {
//			food = ImageIO.read(SnakeGrid.class.getResource("images/foodText.png"));
//		} catch (IOException e) {
//    		this.setBackground(Color.GRAY);
//		}
		
		this.setLayout(new GridLayout(getPreferredSize().height, getPreferredSize().width));
		this.setBorder(new LineBorder(new Color(167,160,108), 5));
		this.game = game;
		this.lastFoodArray = new ArrayList<Food>();
		updateGrid();

	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(500, 500);
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        drawBackground(g2);
        drawSnake(g2);
        placeFood(g2);
    }
    
	/**
	 * Draw the background of the grid
	 * @param g2
	 */
    public void drawBackground(Graphics2D g2){
    	int width = this.getWidth();
    	int height = this.getHeight();

    	for (int i=0; i < width; i +=background.getWidth()) {
    		for (int j=0; j < height; j +=background.getHeight()) {
    			g2.drawImage(background, i, j, this);
    		}
    	}
    }
    
    /**
     * Draw the snakes in the game
     * @param g2
     */
	public void drawSnake(Graphics2D g2){
		int id = 0;
		for (Snake snake : game.getSnakes()) {
			g2.setColor(Color.BLACK);
		    for (Point currentPos : snake.getPosition()) {
		    	if (!(currentPos.equals(snake.getHead())) && !(currentPos.equals(snake.getTail()))) {
		    		Point pointBeforeCurrent;
		    		Point pointAfterCurrent;
		    		pointBeforeCurrent = new Point(snake.getPosition().get(snake.getPosition().indexOf(currentPos)+1));
		    		pointAfterCurrent = new Point(snake.getPosition().get(snake.getPosition().indexOf(currentPos)-1));
		    		g2.drawImage(TextureShelf.snakeBody(pointBeforeCurrent, currentPos, pointAfterCurrent, id), (int) (currentPos.x * gameWidthScale) + 1, 
			    			(int) ((this.game.getDimension().height - currentPos.y)*gameHeightScale) + 1, 
			    			(int) (gameWidthScale) + 1, (int) (gameHeightScale) + 1, this);
		    	}
		    }
		    
	    	Point tail = snake.getTail();
	    	Point head = snake.getHead();
	    	Point secondLastPoint;
	    	//find secondlast point but get head if secondlast point is head.
	    	if (snake.getPosition().get(snake.getPosition().size()-1) != head){
	    		secondLastPoint = new Point(snake.getPosition().get(snake.getPosition().size()-2));
	    	} else {
	    		secondLastPoint = head;
	    	}
	    	
	    	g2.drawImage(TextureShelf.snakeTail(tail, secondLastPoint, id), (int) (tail.x * gameWidthScale) + 1, 
	    			(int) ((this.game.getDimension().height - tail.y) * gameHeightScale) + 1, 
	    			(int) (gameWidthScale + 1), (int) (gameHeightScale + 1), this);
		    
	    	g2.setColor(Color.green);
	    	
	    	g2.drawImage(TextureShelf.snakeHead(snake.getCurrentDirection(), id), (int) (head.x * gameWidthScale) + 1, 
	    			(int) ((this.game.getDimension().height - head.y) * gameHeightScale) + 1, 
	    			(int) (gameWidthScale + 1), (int) (gameHeightScale + 1), this);

			// If the snake is eating, play a sound
			if (snake.isEating()) {
				Sound.EAT.play();
			}
			
			id++;
		}
	}
	
	/**
	 * Draw the food objects on the game grid
	 * @param g2
	 */
	public void placeFood(Graphics2D g2) {
		g2.setColor(Color.cyan);
	    for (Food currentFood : game.getFood()) {
	    	Point currentPos = currentFood.getPosition();
	    	g2.drawImage(TextureShelf.getFoodImage(currentFood, game.getSnakes().size()), (int) (currentPos.x * gameWidthScale), 
	    			(int) ((this.game.getDimension().height - currentPos.y) * gameHeightScale), 
	    			(int) (gameWidthScale)+10, (int) (gameHeightScale)+10, this);
        }		
	    
	    // Insures the images gets remove again
	    for (Food currentFood : this.lastFoodArray) {
	    	if (!(game.getFood().contains(currentFood)))
	    		TextureShelf.removeFood(currentFood);
	    }
	    this.lastFoodArray.clear();
	    for (Food currentFood : game.getFood()) {
	    	this.lastFoodArray.add(currentFood);
	    }
	}

	/**
	 * Update the scales of the grid
	 */
	public void updateGrid() {
		gameWidthScale = this.getSize().width / (this.game.getDimension().width + 1.0);
		gameHeightScale = this.getSize().height / (this.game.getDimension().height + 1.0);
		this.repaint();	
	}
}