package snakegame.viewers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Point;
import snakegame.DIRECTION;

/**
 * Responsible for reading all images for the snakes' bodies, head and tail into the program
 */
public class TextureShelf {
	
	/**
	 * Getting the head image based on the passed direction and the player's id
	 * @param direction of the snake
	 * @param id The number of the snake in the game. This view supports four different snakes
	 * @return A image of the snake's head
	 */
	public static BufferedImage snakeHead(DIRECTION direction, int id) {
		// Varible for the head
		BufferedImage imageForHead = null;
		
		// Direction check. Insures the snake has a direction
		if (direction == null) {
			direction = DIRECTION.UP;
		}
		
		// Select the right image based on the snakes direction and it's id. Defaults chooses the first players images
		switch(direction) {
		// Selects the image for the head turning up
		case UP:
			try {
				switch (id) {
//					case 3:
//						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player4HeadUp.png"));
//						break;
//					case 2:
//						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player3HeadUp.png"));
//						break;
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
		
		// Selects the image for the head, if the head is turned down
		case DOWN:
			try {
				switch (id) {
//					case 3:
//						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player4HeadDown.png"));
//						break;
//					case 2:
//						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player3HeadDown.png"));
//						break;
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
		
		// Selected the image if the head is turned left
		case LEFT:
			try { 
				switch (id) {
//					case 3:
//						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player4HeadLeft.png"));
//						break;
//					case 2:
//						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player3HeadLeft.png"));
//						break;
					case 1:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player2HeadLeft.png"));
						break;
					case 0:
					default:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player1HeadLeft.png"));
						break;
				}
			} catch (IOException e) { imageForHead = null; }
			break;
		
		// Reading in the right head of the snake
		case RIGHT:
			try {
				switch (id) {
//					case 3:
//						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player4HeadRight.png"));
//						break;
//					case 2:
//						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player3HeadRight.png"));
//						break;
					case 1:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player2HeadRight.png"));
						break;
					case 0:
					default:
						imageForHead = ImageIO.read(SnakeGrid.class.getResource("images/player1HeadRight.png"));
						break;
				}
			} catch (IOException e) { imageForHead = null; }
			break;
		}
		return imageForHead;
	}

	/**
	 * Read in the tail of the snake. Calculates which way the tail should point, and the returns thre right image
	 * @param snakeTail The point of the snake
	 * @param secondLastPoint The point right before the snake
	 * @param id The number the snake is in the game
	 * @return The image for the given snakes tail
	 */
	public static BufferedImage snakeTail(Point snakeTail, Point secondLastPoint, int id) {
		// Variable for the tail
		BufferedImage imageForTail = null;
		
		// Insures the secondlast point is right next to the snakes tail. Insures it's turned in the right direction
		checkPoint(snakeTail, secondLastPoint);
		
		// The tail is moving up
		if (snakeTail.y < secondLastPoint.y) {
			try {
				switch (id) {
//					case 3:
//						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player4TailUp.png"));
//						break;
//					case 2:
//						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player3TailUp.png"));
//						break;
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
		
		// The tail is moving down
		if (snakeTail.y > secondLastPoint.y) {
			try {
				switch (id) {
//					case 3:
//						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player4TailDown.png"));
//						break;
//					case 2:
//						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player3TailDown.png"));
//						break;
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
		
		// The snake is going left
		if (snakeTail.x > secondLastPoint.x) {
			try {
				switch (id) {
//					case 3:
//						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player4TailLeft.png"));
//						break;
//					case 2:
//						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player3TailLeft.png"));
//						break;
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
		
		// The snake's tail is going right
		if (snakeTail.x < secondLastPoint.x) {
			try {
				switch (id) {
//					case 3:
//						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player4TailRight.png"));
//						break;
//					case 2:
//						imageForTail = ImageIO.read(SnakeGrid.class.getResource("images/player3TailRight.png"));
//						break;
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
		
		// And returns the image we have found
		return imageForTail;
	}
	
	/**
	 * Get the image for this body point
	 * @param beforeCurPos The point before the one we are drawing
	 * @param curPos The point we are drawing
	 * @param afterCurPos Point after the point we are drawing
	 * @param id of the snake which are being drawn
	 * @return The image for this points body
	 */
	public static BufferedImage snakeBody(Point beforeCurPos, Point curPos, Point afterCurPos, int id) {
		// Variable for the body image
		BufferedImage imageForBody = null;
		
		// Checks the two points before and after, to insure they are next to the current point
		checkPoint(curPos, beforeCurPos);
		checkPoint(curPos, afterCurPos);
		
		// If this body part is going vertical 
		if (beforeCurPos.y != afterCurPos.y && beforeCurPos.x == afterCurPos.x){
			try {
				switch (id) {
//					case 3: 
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player4BodyVertical.png"));
//						break;
//					case 2:
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player3BodyVertical.png"));
//						break;
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
		
		// The snake is going horizontal 
		if (beforeCurPos.x != afterCurPos.x && beforeCurPos.y == afterCurPos.y && curPos.y == afterCurPos.y){
			try {
				switch (id) {
//					case 3: 
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player4BodyHorizontal.png"));
//						break;
//					case 2:
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player3BodyHorizontal.png"));
//						break;
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

		// Bending logic. If the body is bending left
		if ((pointRightOfCurrent(curPos, afterCurPos) && pointOverCurrent(curPos, beforeCurPos))
				|| (pointRightOfCurrent(curPos, beforeCurPos) && pointOverCurrent(curPos, afterCurPos))) {
			try {
				switch (id) {
//					case 3: 
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player4BodyBendLeft.png"));
//						break;
//					case 2:
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player3BodyBendLeft.png"));
//						break;
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
		
		// If the body is beding up
		if ((pointLeftOfCurrent(curPos, beforeCurPos) && pointOverCurrent(curPos, afterCurPos))
				|| (pointLeftOfCurrent(curPos, afterCurPos) && pointOverCurrent(curPos, beforeCurPos))) {
			try {
				switch (id) {
//					case 3: 
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player4BodyBendUp.png"));
//						break;
//					case 2:
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player3BodyBendUp.png"));
//						break;
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

		// If the head is bending right
		if (pointRightOfCurrent(curPos, beforeCurPos) && pointUnderCurrent(curPos, afterCurPos)
				|| pointRightOfCurrent(curPos, afterCurPos) && pointUnderCurrent(curPos, beforeCurPos)) {
			try {
				switch (id) {
//					case 3: 
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player4BodyBendRight.png"));
//						break;
//					case 2:
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player3BodyBendRight.png"));
//						break;
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
		
		// If the body is bending down
		if ((pointLeftOfCurrent(curPos, beforeCurPos) && pointUnderCurrent(curPos, afterCurPos))
				|| (pointLeftOfCurrent(curPos, afterCurPos) && pointUnderCurrent(curPos, beforeCurPos))) {
			try {
				switch (id) {
//					case 3: 
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player4BodyBendDown.png"));
//						break;
//					case 2:
//						imageForBody = ImageIO.read(SnakeGrid.class.getResource("images/player3BodyBendDown.png"));
//						break;
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
	
	/**
	 * Checks if the point is to the left of the current point
	 * @param current The point to be painted
	 * @param other The point to check against
	 * @return True, if the point is to the left of current
	 */
	private static boolean pointLeftOfCurrent(Point current, Point other){
		return  current.x > other.x && current.y == other.y;
	}
	
	/**
	 * Checks if the other point is right of current
	 * @param current The point to be drawn
	 * @param other The point to check against
	 * @return True, if the other player is to the right of current
	 */
	private static boolean pointRightOfCurrent(Point current, Point other){
		return current.x < other.x && current.y == other.y;
	}
	
	/**
	 * Checks if the point is over the current
	 * @param current The point to be drawn
	 * @param other The point to check against
	 * @return True, if the other point is over the current
	 */
	private static boolean pointOverCurrent(Point current, Point other){
		return current.x == other.x && current.y < other.y;
	}
	
	/**
	 * Checks if the other point is under the current
	 * @param current The point to be drawn
	 * @param other The point to check against
	 * @return True, if the point is under the current
	 */
	private static boolean pointUnderCurrent(Point current, Point other){
		return current.x == other.x && current.y > other.y;
	}
	
	/**
	 * Insures the two points are next to each other. This will push the other point outside the game grid at some points
	 * @param current The point to be drawn
	 * @param other The point to check
	 */
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