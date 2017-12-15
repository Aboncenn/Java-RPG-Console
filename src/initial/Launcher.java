package initial;
/**
 * <b>Launcher permet de lancer le jeu en appelant  Game</b>
 * 
 * @author Aurélien Boncenne
 * @version 1.0
 */
public class Launcher {
	 /**
     * Game start
     * 
     * @see Game
     */
	public static void main(String[] args) {
		// lancement du jeu.
		Game game = new Game();
		game.start();

	}

}
