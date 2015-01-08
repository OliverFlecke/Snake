package snakegame.models;

public class Player implements Comparable<Player>{
	private String name;
	private int score;
	
	public Player(String name, int score){
		this.name=name;
		this.score=score;
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
