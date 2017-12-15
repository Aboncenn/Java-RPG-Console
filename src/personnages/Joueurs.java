package personnages;
/**
 * Classe permettant de crée un cadenas.
 * 
 * 
 * @author Aurélien Boncenne
 */
public class Joueurs {
	/**
	 * int y et x initialisé
	 * @param x, y
	 */
	int y, x ;
	/**
	 * String valeur appelé en console
	 * @param val
	 */
	String val = " X";
	/**
	 * int initiation de la vie
	 * @param vie
	 */
	int vie = 10;
	/**
	 * constructeur de Joueur
	 * @return x,y
	 */
	public Joueurs(int y, int x) {
		this.x = x;
		this.y = y;
	}
	/**
	 * getter et setter de y
	 * @param y
	 */
	public int getY() {
		return y;
	}

	public int setY(int y) {
		return this.y = y;
	}
	/**
	 * getter et setter de x
	 * @param x
	 */
	public int getX() {
		return x;
	}

	public int setX(int x) {
		return this.x = x;
	}
	/**
	 *Getter et Setter de val
	 * @return val
	 */
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	/**
	 * getter et setter de vie
	 * @param vie
	 */
	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
}
