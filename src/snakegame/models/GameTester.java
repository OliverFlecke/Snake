package snakegame.models;

import java.awt.Point;
import java.util.ArrayList;

public class GameTester {
	
	public static void main(String args[]) {
		Game game = new Game(10, 10, 2);
		printSnake(game.getSnakePosition());
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ole");
		names.add("Per");
		
		game.setPlayerNames(names);
		for (Snake snake : game.getSnakes()) {
			System.out.println(snake.getName());
		}
	}
	
	private static void printSnake(ArrayList<Point> points) {
		for (Point point : points) {
			System.out.println(point);
		}
	}
}
