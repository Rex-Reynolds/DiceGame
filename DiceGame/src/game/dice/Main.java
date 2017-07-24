/**
 * 
 */
package game.dice;

/**
 * @author Rex Austin Reynolds III
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GUI gui = new GUI();
		Game game = new Game();
		gui.load();
		game.playGame(gui);

	}

}
