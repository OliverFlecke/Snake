package snakegame.models;



public class Player implements Comparable<Player>{
	private String name;
	private int score;
	private int time;
	
	public Player(String name, int score, int time) {
		this.name = name;
		this.score = score;
		this.time = time;
	}
	
	public Player() {}
	
	public void reset() {
		this.score = 0;
		this.time = 0;
	}
	
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
		if (player.score < this.score){ //ranks lower if score is lower
			return -1;
		}
		else if (player.score == this.score){ //in case of equal score
			if (player.time < this.time){ //ranks higher if time is lower
				return 1;
			}
			if (player.time > this.time){ // ranks lower if time is greater
				return -1;
			}
			
			return this.name.compareTo(player.name); // if time and score is equal, ranks lexicographically
		} else {
			return 1; //ranks higher if score is higher
		}
	}
}