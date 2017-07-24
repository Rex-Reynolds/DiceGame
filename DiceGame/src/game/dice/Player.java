package game.dice;

/**
 * 
 * @author rreynolds3
 * 
 *         PlayerObject class. Allows PlayerObjects to maintain a unique ID and
 *         cumulative score
 *
 */

public class Player {
	private int id;
	private int score;

	public Player(int id, int score) {
		this.id = id;
		this.score = score;
	}

	public void setScore(int dice) {
		score += dice;
	}

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public void setID(int d) {
		this.id = d;

	}

}
