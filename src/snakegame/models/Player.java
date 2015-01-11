package snakegame.models;



public class Player implements Comparable<Player>{
	private String name;
	private int score;
	private int time;
	
	public Player(String name, int score, int time){
		this.time = time;
		this.name = name;
		this.score = score;
	}
	
	
	public Player(String name) {
		this(name, 0, 0);
	}
	
	public Player(String name, int score) {
		this(name, score, 0);
	}
	
	public Player() {}
	
	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * Increment the timer of this player
	 */
	public void incrementTime() {
		this.time++;
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
	
	public String toString(){
		return "name:" + name + " score:" + score + " time:" + time + "\n";
		
	}

	@Override
	public int compareTo(Player player) {
		if(player.score<this.score){ //ranks lower if score is lower
			return-1;
		}
		if(player.score==this.score){ //in case of equal score
			if(player.time<this.time){ //ranks higher if time is lower
				return 1;
			}
			if(player.time>this.time){ // ranks lower if time is greater
				return -1;
			}
			
			return name.compareTo(this.name); // if time and score is equal, ranks lexicographically
		}
		return 1; //ranks higher if score is higher
	}
}