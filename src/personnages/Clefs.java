package personnages;

/**
 * Classe permettant de crée un cadenas.
 * 
 * 
 * @author Aurélien Boncenne
 */
public class Clefs {
	/**
	 * String val qui est appelé dans la console
	 * @param val
	 */
	String val = " 4";
	/**
	 * init du trousseau
	 * @param trousseau
	 */
	int trouseau = 0;
	
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
	 *Getter et Setter de trousseau
	 * @return trousseau
	 */
	public int getTrouseau() {
		return trouseau;
	}

	public void setTrouseau(int trouseau) {
		this.trouseau = trouseau;
	}

}
