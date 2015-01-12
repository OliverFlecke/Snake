package snakegame.models;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;

public class TestHighScore {
	public static void main(String[] args){
		Player player1 = new Player("allan",785,123);	
		Player player2 = new Player("b",2,2);
		Player player3 = new Player("c",3,3);
		Player player4 = new Player("d",4,4);
//		Player player5 = new Player("e",5);
//		Player player6 = new Player("f",6);
//		Player player7 = new Player("g",7);
//		Player player8 = new Player("h",8);
//		Player player9 = new Player("i",9);
//		Player player10 = new Player("j",10);
//		Player player11 = new Player("k",11);
//		Player player12 = new Player("l",12);
//		Player player13 = new Player("m",13);
//		Player player14 = new Player("n",14);
		
		ArrayList<Player> players =  new ArrayList<Player>();
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
//		players.add(player5);
//		players.add(player6);
//		players.add(player7);
//		players.add(player8);
//		players.add(player9);
//		players.add(player10);
//		players.add(player11);
//		players.add(player12);
//		players.add(player13);
//		players.add(player14);
		
	
		
		System.out.println("print players array");
		System.out.println(players);
		System.out.println("get current highscore");
		System.out.println(HighScore.getHighScore());
		System.out.println("submit score");
		HighScore.submitScore(players);
		System.out.println("get new highscore");
		System.out.println(HighScore.getHighScore());
		System.out.println("check if any submitted players are on highscore");
		
		
		
	}

}
