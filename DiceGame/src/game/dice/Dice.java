package game.dice;

import java.util.LinkedList;

public class Dice {
	/**
	 * 
	 * @author rreynolds3
	 * 
	 *         DiceObject class. Maintains a LinkedList of Dice along with the
	 *         current roll for the active player
	 *
	 */

	private LinkedList<Integer> dices = new LinkedList<Integer>();

	private int currentRoll;

	/*
	 * Rolls a number of dice as specified by the player and add each roll to the
	 * current linkedList of rolls
	 */
	public void roll(int numberofDice) {
		dices.clear();
		for (int i = 0; i < numberofDice; i++) {
			currentRoll = 1 + (int) (Math.random() * 6);
			dices.add(currentRoll);
			System.out.println("Die number " + dices.lastIndexOf(currentRoll) + " Rolled a " + currentRoll);
		}
	}

	/*
	 * adds all dice in the current LinkedList. Returns sum of dice.
	 */
	public int addAll() {
		int added = 0;
		for (int i = 0; i < dices.size(); i++) {
			if (dices.get(i) == 4) {

			} else {
				added += dices.get(i);
			}
		}
		return added;
	}

	public LinkedList<Integer> getDices() {

		return dices;
	}

	public void removeDice(int index) {
		dices.remove(index);
	}
}