package joueur;

public class Score {
	
	private int score;
	private int index;
	
	public Score(int score, int index) {
		this.score = score;
		this.index = index;
	}
	
	public int getScore() {
		return score;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
