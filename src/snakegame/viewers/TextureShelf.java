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
		checkPoint(snakeTail, secondLastPoint);
		
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
		checkPoint(curPos, beforeCurPos);
		checkPoint(curPos, afterCurPos);
		
		
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

		// Bending logic
		if ((pointRightOfCurrent(curPos, afterCurPos) && pointOverCurrent(curPos, beforeCurPos))
				|| (pointRightOfCurrent(curPos, beforeCurPos) && pointOverCurrent(curPos, afterCurPos))){
			
			//Load in the image for the head.
			try {
				imageForBody = ImageIO.read(SnakeGrid.class.getResource("images\\shenronBodyBendLeft.png"));
			} catch (IOException e) {
				imageForBody = null;
			}
		}
		
		if ((pointLeftOfCurrent(curPos, beforeCurPos) && pointOverCurrent(curPos, afterCurPos))
				|| (pointLeftOfCurrent(curPos, afterCurPos) && pointOverCurrent(curPos, beforeCurPos))){
			
			//Load in the image for the head.
			try {
				imageForBody = ImageIO.read(SnakeGrid.class.getResource("images\\shenronBodyBendUp.png"));
			} catch (IOException e) {
				imageForBody = null;
			}
		}

		if (pointRightOfCurrent(curPos, beforeCurPos) && pointUnderCurrent(curPos, afterCurPos)
				|| pointRightOfCurrent(curPos, afterCurPos) && pointUnderCurrent(curPos, beforeCurPos)){
			
			//Load in the image for the head.
			try {
				imageForBody = ImageIO.read(SnakeGrid.class.getResource("images\\shenronBodyBendRight.png"));
			} catch (IOException e) {
				imageForBody = null;
			}
		}
		
		if ((pointLeftOfCurrent(curPos, beforeCurPos) && pointUnderCurrent(curPos, afterCurPos))
				|| (pointLeftOfCurrent(curPos, afterCurPos) && pointUnderCurrent(curPos, beforeCurPos))) {
			try {
				imageForBody = ImageIO.read(SnakeGrid.class.getResource("images\\shenronBodyBendDown.png"));
			} catch (IOException e) {
				imageForBody = null;
			}
		}
		return imageForBody;
	}
	

	private static boolean pointLeftOfCurrent(Point current, Point other){
		return  current.x > other.x && current.y == other.y;
	}
	private static boolean pointRightOfCurrent(Point current, Point other){
		return current.x < other.x && current.y == other.y;
	}
	
	private static boolean pointOverCurrent(Point current, Point other){
		return current.x == other.x && current.y < other.y;
	}
	private static boolean pointUnderCurrent(Point current, Point other){
		return current.x == other.x && current.y > other.y;
	}
	
	private static void checkPoint(Point current, Point other) {
		if (other.x - current.x > 1) {
			other.x = -1;
		} else 
		if (other.x - current.x < -1) {
			other.x = current.x + 1;
		}
		
		if (other.y - current.y > 1) {
			other.y = -1;
		} else 
		if (other.y - current.y < -1) {
			other.y = current.y + 1;
		}
	}
}
