package snakegame.models;

public class Player implements Comparable<Player>{
	private String name;
	private int score;
	private int time;
	
	public Player(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public Player(String name) {
		this(name, 0);
	}
	
	public Player() {}
	
	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	
	public void addToScore(int delta){
		this.score += delta;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}	

	@Override
	public int compareTo(Player player) {
		if(player.score<this.score){
			return-1;
		}
		if(player.score==this.score){
			return name.compareTo(this.name);
		}
		return 1;
	}
}