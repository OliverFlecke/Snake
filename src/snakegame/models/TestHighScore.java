package snakegame.models;

import java.util.ArrayList;
import java.util.Collections;

public class TestHighScore {
	public static void main(String[] args) {
		Player player1 = new Player("a",1);	
		Player player2 = new Player("a",1);
		Player player3 = new Player("a",1);
		Player player4 = new Player("f",1);
		Player player5 = new Player("j",1);
		Player player6 = new Player("b",98);
		Player player7 = new Player("n",2);
		Player player8 = new Player("m",35);
		Player player9 = new Player("s",22);
		Player player10 = new Player("d",33);
		Player player11 = new Player("v",56);
		Player player12 = new Player("z",78);
		Player player13 = new Player("x",23);
		Player player14 = new Player("l",35);
		player1.setTime(23);
		player2.setTime(50);
		player3.setTime(34);
		
		ArrayList<Player> players =  new ArrayList<Player>();
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		players.add(player6);
		players.add(player7);
		players.add(player8);
		players.add(player9);
		players.add(player10);
		players.add(player11);
		players.add(player12);
		players.add(player13);
		players.add(player14);
		
		System.out.println(players);
		Collections.sort(players);
		System.out.println(players);
		players.subList(9, players.size()-1).clear();
		System.out.println(players);
		
		System.out.println();
		
		HighScore highScore = new HighScore();
		
		
	}

}
