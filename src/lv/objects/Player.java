package objects;

public class Player {
	
	 private Integer startingPosition;
	 private String pseudo;
	 private int win ;
	 
	public Player(Integer startingPosition, String pseudo, int win) {
		super();
		this.startingPosition = 0;
		this.pseudo = pseudo;
		this.win = 0;
	}

	public Integer getStartingPosition() {
		return startingPosition;
	}

	public void setStartingPosition(Integer startingPosition) {
		this.startingPosition = startingPosition;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}
	
}
