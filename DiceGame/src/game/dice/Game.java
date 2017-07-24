package game.dice;

import java.util.LinkedList;

public class Game {
	private LinkedList<Player> players = new LinkedList<Player>();
	private int numberofPlayers = 4;
	private GUI gui;

	public void playGame(GUI gui) {
		this.gui = gui;

		new Dice();
		for (int i = 0; i < numberofPlayers; i++) {
			players.add(new Player(i, 0));
		}

		gui.setOutputText("In Dice Game, players roll dice and try to collect the lowest score. " + "\n"
				+ "A 4 counts as zero, all other numbers count as face value. " + "\n"
				+ "A player’s score is the total spots showing on the dice when she finishes " + "\n"
				+ "her turn (excluding fours because they’re zero). The object of the game is to get " + "\n"
				+ "the lowest score possible. ");

	}

	private int winner() {
		int winningPlayer = 0;
		int min;

		min = players.get(0).getScore();
		for (Player temp : players) {
			if (temp.getScore() < min) {
				min = temp.getScore();
				winningPlayer = temp.getId();

			}

		}
		gui.setOutputText("\n" + "The winning player is PLAYER: " + winningPlayer + " with FINAL score: " + min);
		return winningPlayer;
	}

}
