package snakegame.viewers;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Point;

import snakegame.DIRECTION;

public class TextureShelf {
	
	// making variables for the picures
	private static BufferedImage imageForHead;
	private static BufferedImage imageForTail;
	private static BufferedImage imageForBody;
	
	
	
	

	

	
	
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

	public static BufferedImage snakeTail(Point snakeTail, Point secondLastPoint){
		
		
		if (snakeTail.y < secondLastPoint.y){
			
			//Load in the image for the head.
			try {
				imageForTail = ImageIO.read(SnakeGrid.class.getResource("images\\shenronTailUp.png"));
			} catch (IOException e) {
				imageForTail = null;
			}
		}
		
		if (snakeTail.y > secondLastPoint.y){
			
			//Load in the image for the head.
			try {
				imageForTail = ImageIO.read(SnakeGrid.class.getResource("images\\shenronTailDown.png"));
			} catch (IOException e) {
				imageForTail = null;
			}
		}
		
		if (snakeTail.x > secondLastPoint.x){
			
			//Load in the image for the head.
			try {
				imageForTail = ImageIO.read(SnakeGrid.class.getResource("images\\shenronTailLeft.png"));
			} catch (IOException e) {
				imageForTail = null;
			}
		}
		
		if (snakeTail.x < secondLastPoint.x){
			
			//Load in the image for the head.
			try {
				imageForTail = ImageIO.read(SnakeGrid.class.getResource("images\\shenronTailRight.png"));
			} catch (IOException e) {
				imageForTail = null;
			}
		}
		
		return imageForTail;
	}
	
	public static BufferedImage snakeBody(Point beforeCurPos, Point curPos, Point afterCurPos){
		
		
		
		if (beforeCurPos.y != afterCurPos.y && beforeCurPos.x == afterCurPos.x){
			
			//Load in the image for the head.
			try {
				imageForBody = ImageIO.read(SnakeGrid.class.getResource("images\\shenronBodyVertical.png"));
			} catch (IOException e) {
				imageForBody = null;
			}
		}
		
		if (beforeCurPos.x != afterCurPos.x && beforeCurPos.y == afterCurPos.y && curPos.y == afterCurPos.y){
			
			//Load in the image for the head.
			try {
				imageForBody = ImageIO.read(SnakeGrid.class.getResource("images\\shenronBodyHorizontal.png"));
			} catch (IOException e) {
				imageForBody = null;
			}
		}
		
		if (beforeCurPos.x < afterCurPos.x && beforeCurPos.y > afterCurPos.y && curPos.y == beforeCurPos.y && curPos.y > afterCurPos.y && curPos.x > beforeCurPos.x && curPos.x == afterCurPos.x){
			
			//Load in the image for the head.
			try {
				imageForBody = ImageIO.read(SnakeGrid.class.getResource("images\\shenronBodyBendDown.png"));
			} catch (IOException e) {
				imageForBody = null;
			}
		}
		

		return imageForBody;
	}
}
