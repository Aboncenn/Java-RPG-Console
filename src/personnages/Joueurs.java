package personnages;

public class Joueurs {
	int y, x ;
	String val = " X";
	int vie = 10;

	public Joueurs(int y, int x) {
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public int setY(int y) {
		return this.y = y;
	}

	public int getX() {
		return x;
	}

	public int setX(int x) {
		return this.x = x;
	}
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
}
