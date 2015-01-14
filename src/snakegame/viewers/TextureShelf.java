package snakegame.viewers;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import snakegame.DIRECTION;

public class TextureShelf {
	
	// making variables for the picures
	public static BufferedImage imageForHead;
	
	
	
	

	

	
	
	public static BufferedImage snakeHead(DIRECTION direction){
		
		
		//Direction check
		if (direction == null){
			direction = DIRECTION.UP;
		}
		
		//Load in the image for the head.
		try {
			 imageForHead = ImageIO.read(SnakeGrid.class.getResource("images\\shenronHeadUp.png"));
		} catch (IOException e) {
			 imageForHead = null;
		}
		
		switch(direction) {
		
		case UP:
			
			//Load in the image for the head.
			try {
				 imageForHead = ImageIO.read(SnakeGrid.class.getResource("images\\shenronHeadUp.png"));
			} catch (IOException e) {
				 imageForHead = null;
			}
			break;
		
		case DOWN:
			
			//Load in the image for the head.
			try {
				 imageForHead = ImageIO.read(SnakeGrid.class.getResource("images\\shenronHeadDown.png"));
			} catch (IOException e) {
				 imageForHead = null;
			}
			break;
		
		case LEFT:
			
			//Load in the image for the head.
			try {
				 imageForHead = ImageIO.read(SnakeGrid.class.getResource("images\\shenronHeadLeft.png"));
			} catch (IOException e) {
				 imageForHead = null;
			}
			break;
		
		case RIGHT:
			
			//Load in the image for the head.
			try {
				 imageForHead = ImageIO.read(SnakeGrid.class.getResource("images\\shenronHeadRight.png"));
			} catch (IOException e) {
				 imageForHead = null;
			}
			break;
			
		}
		return imageForHead;
	}

	
}
