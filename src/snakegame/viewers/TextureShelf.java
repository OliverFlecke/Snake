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

	public static BufferedImage snakeHead(DIRECTION direction, int id){		
		//Direction check
		if (direction == null){
			direction = DIRECTION.UP;
		}
		
		switch(direction) {
		
		case UP:
			
			//Load in the image for the head.
			try {
				switch (id) {
					case 1:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player2HeadUp.png"));
						break;
					case 0:
					default:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player1HeadUp.png"));
						break;
				}
			} catch (IOException e) {
				 imageForHead = null;
			}
			break;
		
		case DOWN:
			
			//Load in the image for the head.
			try {
				switch (id) {
					case 1:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player2HeadDown.png"));
						break;
					case 0:
					default:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player1HeadDown.png"));
						break;
				}
			} catch (IOException e) {
				 imageForHead = null;
			}
			break;
		
		case LEFT:
			
			//Load in the image for the head.
			try {
				switch (id) {
					case 1:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player2HeadLeft.png"));
						break;
					case 0:
					default:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player1HeadLeft.png"));
						break;
				}
			} catch (IOException e) {
				 imageForHead = null;
			}
			break;
		
		case RIGHT:
			
			//Load in the image for the head.
			try {
				switch (id) {
					case 1:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player2HeadRight.png"));
						break;
					case 0:
					default:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player1HeadRight.png"));
						break;
				}
			} catch (IOException e) {
				 imageForHead = null;
			}
			break;
			
		}
		return imageForHead;
	}

	public static BufferedImage snakeTail(Point snakeTail, Point secondLastPoint, int id){
		checkPoint(snakeTail, secondLastPoint);
		
		if (snakeTail.y < secondLastPoint.y){
			
			//Load in the image for the head.
			try {
				switch (id) {
					case 1:
						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player2TailUp.png"));
						break;
					case 0:
					default:
						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player1TailUp.png"));
						break;
				
				}
			} catch (IOException e) {
				imageForTail = null;
			}
		}
		
		if (snakeTail.y > secondLastPoint.y){
			
			//Load in the image for the head.
			try {
				switch (id) {
					case 1:
						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player2TailDown.png"));
						break;
					case 0:
					default:
						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player1TailDown.png"));
						break;
				}	
			} catch (IOException e) {
				imageForTail = null;
			}
		}
		
		if (snakeTail.x > secondLastPoint.x){
			
			//Load in the image for the head.
			try {
				switch (id) {
				case 1:
					imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player2TailLeft.png"));
					break;
				case 0:
				default:
					imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player1TailLeft.png"));
					break;
				}
			} catch (IOException e) {
				imageForTail = null;
			}
		}
		
		if (snakeTail.x < secondLastPoint.x){
			
			//Load in the image for the head.
			try {
				switch (id) {
				case 1:
					imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player2TailRight.png"));
					break;				
				case 0:
				default:
					imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player1TailRight.png"));
					break;
				}
			} catch (IOException e) {
				imageForTail = null;
			}
		}
		
		return imageForTail;
	}
	
	public static BufferedImage snakeBody(Point beforeCurPos, Point curPos, Point afterCurPos, int id){
		checkPoint(curPos, beforeCurPos);
		checkPoint(curPos, afterCurPos);
		
		
		if (beforeCurPos.y != afterCurPos.y && beforeCurPos.x == afterCurPos.x){
			
			//Load in the image for the head.
			try {
				switch (id) {
				case 1: 
					imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player2BodyVertical.png"));
					break;
				case 0:
				default:
					imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player1BodyVertical.png"));
					break;
				}
			} catch (IOException e) {
				imageForBody = null;
			}
		}
		
		if (beforeCurPos.x != afterCurPos.x && beforeCurPos.y == afterCurPos.y && curPos.y == afterCurPos.y){
			
			//Load in the image for the head.
			try {
				switch (id) {
				case 1: 
					imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player2BodyHorizontal.png"));
					break;
				case 0:
				default:				
					imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player1BodyHorizontal.png"));
					break;
				}
			} catch (IOException e) {
				imageForBody = null;
			}
		}

		// Bending logic
		if ((pointRightOfCurrent(curPos, afterCurPos) && pointOverCurrent(curPos, beforeCurPos))
				|| (pointRightOfCurrent(curPos, beforeCurPos) && pointOverCurrent(curPos, afterCurPos))){
			
			//Load in the image for the head.
			try {
				switch (id) {
					case 1:
						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player2BodyBendLeft.png"));
						break;
					case 0:
					default:
						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player1BodyBendLeft.png"));
						break;
				}
			} catch (IOException e) {
				imageForBody = null;
			}
		}
		
		if ((pointLeftOfCurrent(curPos, beforeCurPos) && pointOverCurrent(curPos, afterCurPos))
				|| (pointLeftOfCurrent(curPos, afterCurPos) && pointOverCurrent(curPos, beforeCurPos))){
			
			//Load in the image for the head.
			try {
				switch (id) {
					case 1:
						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player2BodyBendUp.png"));
						break;
					case 0:
					default:
						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player1BodyBendUp.png"));
						break;
				}
			} catch (IOException e) {
				imageForBody = null;
			}
		}

		if (pointRightOfCurrent(curPos, beforeCurPos) && pointUnderCurrent(curPos, afterCurPos)
				|| pointRightOfCurrent(curPos, afterCurPos) && pointUnderCurrent(curPos, beforeCurPos)){
			
			//Load in the image for the head.
			try {
				switch (id) {
					case 1:
						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player2BodyBendRight.png"));
						break;
					case 0:
					default:
						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player1BodyBendRight.png"));
						break;
				}
			} catch (IOException e) {
				imageForBody = null;
			}
		}
		
		if ((pointLeftOfCurrent(curPos, beforeCurPos) && pointUnderCurrent(curPos, afterCurPos))
				|| (pointLeftOfCurrent(curPos, afterCurPos) && pointUnderCurrent(curPos, beforeCurPos))) {
			try {
				switch (id) {
					case 1:
						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player2BodyBendDown.png"));
						break;
					case 0:
					default:
						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player1BodyBendDown.png"));
						break;
				}
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
