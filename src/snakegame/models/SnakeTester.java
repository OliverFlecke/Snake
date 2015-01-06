package snakegame.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

import snakegame.DIRECTION;

public class SnakeTester {

	private static Snake snake;
	public static void main(String[] args) {
		Game game = new Game(10, 10);
		snake = game.getSnake();
		
		/*
		snake.move(DIRECTION.UP);
		System.out.println(snake.getHead());
		snake.move();
		System.out.println(snake.getHead());
		snake.move();
		System.out.println(snake.getHead());
		snake.move(DIRECTION.DOWN);
		System.out.println(snake.getHead());
		*/
		
		printSnake();
		snake.eatFood(new Food(3));
		snake.move(DIRECTION.UP);
		snake.move();
		snake.move();
		snake.move();
		snake.move();
		snake.move();
		snake.move();
		
		printSnake();
		
		snake.move(DIRECTION.LEFT);
		snake.move();
		snake.move();
		
		printSnake();
		
		snake.eatFood(new Food(3));
		snake.move();
		snake.move(DIRECTION.DOWN);
		snake.move();
		snake.move();
		snake.move();
		snake.move();
		snake.move();
		snake.move();
		
		snake.move(DIRECTION.LEFT);
		snake.move(DIRECTION.UP);
		snake.move(DIRECTION.RIGHT);
		//snake.move(DIRECTION.LEFT);
		
		printSnake();
		
		int score = snake.getScore();
		score += 5;
		System.out.println(score);
		System.out.println(snake.getScore());
		
		Point pos = snake.getHead();
		pos.x += 5;
		System.out.println(pos);
		System.out.println(snake.getHead());
		
		ArrayList<Point> poses = snake.getPosition();
		printSnake();
		
		poses.get(0).translate(5, 5);
		printSnake();
	}
	
	private static void printSnake() {
		System.out.println("\nNew move");
		for (Point current : snake.getPosition()) {
			System.out.println(current);
		}
		checkState();
	}
	
	private static void checkState() {
		if (snake.checkCollision())
			System.out.println("Collided");
	}
}
