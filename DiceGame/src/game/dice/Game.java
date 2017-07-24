package game.dice;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author rreynolds3
 * 
 *         GameLoop for Dice game.
 *
 */
public class Game {

	private int numberofPlayers = 4;
	private int currentRound = 1;
	private LinkedList<Player> players = new LinkedList<Player>();
	private int numberOfDice;
	private Dice dice;

	/*
	 * Constructor for game. Initializes the dice objects and players to LinkedList
	 */
	public Game() {
		System.out.println(
				"In this game players roll dice and try to collect the lowest score. A 4 counts as zero, all other numbers count as face value. A players score is the total spots showing on the dice when she finishes her turn (excluding fours because they’re zero). The object of the game is to get the lowest score possible. \r\n"
						+ "The game is played as follows between 4 players: \r\n"
						+ "- Play starts with one person randomly being chosen to start rolling and proceeds in succession until all players have rolled. \r\n"
						+ "- The player rolls all five dice, then must keep at least one dice but may keep more at her discretion (She can stop on her first roll if she so wishes). \r\n"
						+ "- Those dice which are not kept are rolled again and each round she must keep at least one more until all the dice are out. \r\n"
						+ "- Once each player has rolled the player who scored the lowest wins. \r\n"
						+ "- Repeat for three more rounds in succession so that the next person starts rolling first (at the end each player will have started). \r\n"
						+ "After all four rounds have been completed the player with the lowest combined score wins. ");

		dice = new Dice();
		for (int i = 0; i < numberofPlayers; i++) {
			players.add(new Player(i, 0));

		}

	}

	/*
	 * Ends the game. Gathers all player scores and determines the smallest score.
	 * Returns the playerID that corresponds to the winning score
	 */
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
		System.out.println("\n" + "The winning player is PLAYER: " + winningPlayer + " with FINAL score: " + min);
		return winningPlayer;
	}

	/*
	 * GameLoop for DiceGame. For each player, 5 dice are initially rolled. The
	 * player then selects which dice they would like to keep OR if they would like
	 * to keep all dice rolled. Each player's turn proceeds in this manner until
	 * each player has had 4 rounds selecting a total(per turn) of 5 dice. Then the
	 * winner is determined via winner()
	 */
	public void playGame() {
		Scanner keyboard = new Scanner(System.in);
		boolean endTurn;

		for (Player temp : players) {
			numberOfDice = 5;
			endTurn = false;
			System.out.println("\n" + "The current player is Player: " + temp.getId() + "\n");

			// 5 dice must be selected per player per round. The player can opt to end their
			// turn at any time and keep their current roll
			while (numberOfDice > 0 && endTurn == false) {
				System.out.println(
						"Please enter the Die Numbers of the dice you would like to keep or enter 'KEEP' if you would like to keep all dice"
								+ "\n");
				dice.roll(numberOfDice);

				// Check for proper input for keeping dice
				try {
					String keeper = keyboard.nextLine();
					if (keeper.equals("KEEP")) {
						endTurn = true;
						temp.setScore(dice.addAll());
					} else {

						String[] diceNumbers = keeper.split(",");
						for (String number : diceNumbers) {
							temp.setScore((dice.getDices().get(Integer.parseInt(number))));
							numberOfDice--;
						}
						System.out.println(
								"\n" + "Player " + temp.getId() + "'s current score is " + temp.getScore() + "\n");

					}
				} catch (NumberFormatException | IndexOutOfBoundsException e) {
					System.out.println("Please enter a valid input: 1,2,3,4 or KEEP");
				}
			}
			System.out.println(
					("\n" + "Player " + temp.getId() + "'s FINAL score for the round is " + temp.getScore() + "\n"));
		}

		// Endgame is triggered once we have 4 completed rounds of 4 players selecting 5
		// dice
		if (currentRound >= 4) {
			winner();
		} else {
			System.out.println("End of round: " + currentRound);
			currentRound++;
			playGame();

		}
		keyboard.close();
	}

}
