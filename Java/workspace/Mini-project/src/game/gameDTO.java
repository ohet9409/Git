package game;

public class gameDTO {
	private String player;
	private int time;
	private String gamedate;
	private int rank;
	
	public gameDTO() {
		super();
	}
	public gameDTO(String player, int time, String gamedate, int rank) {
		super();
		this.player = player;
		this.time = time;
		this.gamedate = gamedate;
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "gameDTO [player=" + player + ", time=" + time + ", gamedate=" + gamedate + ", rank=" + rank + "]";
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getGamedate() {
		return gamedate;
	}
	public void setGamedate(String gamedate) {
		this.gamedate = gamedate;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	

}
