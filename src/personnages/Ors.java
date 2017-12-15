package personnages;
/**
 * Classe permettant de crée un cadenas.
 * 
 * 
 * @author Aurélien Boncenne
 */
public class Ors {
	/**
	 * String val qui est appelé dans la console
	 * @param val
	 */
	String val = " 5";
	/**
	 * int initalisant la variable bourse
	 * @param bourse
	 */
	int bourse = 0;
	/**
	 *Getter et Setter de bourse
	 * @return bourse
	 */
	public int getBourse() {
		return bourse;
	}

	public void setBourse(int bourse) {
		this.bourse = bourse;
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
}
