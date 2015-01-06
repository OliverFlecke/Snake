package snakegame.models;

import java.awt.Point;
import java.util.ArrayList;

public class GameTester {
	
	public static void main(String args[]) {
		Game game = new Game(10, 10);
		printSnake(game.getSnakePosition());
	}
	
	private static void printSnake(ArrayList<Point> points) {
		for (Point point : points) {
			System.out.println(point);
		}
	}
}
