package initial;

import java.util.*;
import personnages.Arbres;
import personnages.Cadenas;
import personnages.Clefs;
import personnages.Fleures;
import personnages.Herbes;
import personnages.Joueurs;
import personnages.Monstres;
import personnages.Ors;
import personnages.Pieges;
import personnages.Rochers;

/**
 * Classe permettant de crée le jeu.
 * 
 * La fonction Runnable permet d'appeler avec efficacité les l'initialisations
 *    l'affichage, les ticks, le render et l'init
 * 
 * @author Aurélien Boncenne
 */
public class Game implements Runnable{
	
	 /**
     * Booleen permettant de mettre en avant si la fonction runnable fonctionne
     * 
     * @see stop()
     * @see start()
     */
	private boolean running;
	/**
     * Variable erreur permettant de traiter lesdites erreurs.
     * 
     * @see stop()
     * @see start()
     */
	private Thread thread;
	/**
     * Tableau bidimentionnel generant la carte
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	String[][] map = new String[20][20];

	/**
     * variable initial joueurs
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Joueurs personnage = new Joueurs(0,0);
	/**
     * variable intial incrementant la vie du personnage
     * 
     */
	private int vie = personnage.getVie();
	/**
     * variable initial herbe
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Herbes herbe = new Herbes();
	/**
     * variable initial fleurs
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Fleures fleur = new Fleures();
	/**
     * variable initial arbres
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Arbres arbre = new Arbres();
	/**
     * variable initial rocher
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Rochers rocher = new Rochers();
	/**
     * variable initial clefs
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Clefs clef = new Clefs();
	/**
     * variable intial incrementant les clefs
     * 
     */
	private int trouseau = clef.getTrouseau();
	/**
     * variable initial ors
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Ors or = new Ors();
	/**
     * variable intial incrementant la bourse du personnage
     * 
     */
	private int bourse = or.getBourse();
	/**
     * variable initial cadenas
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Cadenas cadenas = new Cadenas();
	/**
     * variable initial piege
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Pieges piege = new Pieges();
	/**
     * variable initial monstres
     * 
     * @see afficherCarte()
     * @see initialiserCarte()
     */
	private Monstres monstre = new Monstres();
	/**
     * variable initial permettant de lire la tuile
     * 
     */
	private String tuile;
	
	/**
     * initialisations des variables X et Y necessaires à la position du joueur
     * @return map[X][Y]  
     * 
     */
	int Y = personnage.getY();
	int X = personnage.getX();
	
	/**
     * fonction initialisant la creation de la carte et l'affichage de la carte
     */
	private void init() {
		initialiserCarte();
		afficherCarte();
	}
	
	/**
	 * Classe permettant de suivre chaque mouvement du joueur sur la carte.
	 */
	private void tick() throws InterruptedException {
		/**
		 * Appel de la fonction Scanner
		 * @param Scanner
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer un mouvement, 8 pour haut, 2 pour bas, 4 pour gauche et 6 pour droite");
		int str = sc.nextInt();
		/**
		 * Suite de if
		 */
		if(str == 8) {
			for(int i =0  ; i < 1 ; i++ ) {
				for(int j = 0; j < 1;j++) {
					if(map[X][Y] != map[0][Y]) {
						/**
						 * En cas de rocher
						 * @param rocher
						 */
						if(map[X-1][Y] != rocher.getVal()) {
							/**
							 * En cas d'arbre
							 * @param arbre
							 */
							if(map[X-1][Y] != arbre.getVal()) {
								/**
								 * En cas de cadenas
								 * @param cadenas
								 */
								if(map[X-1][Y] != cadenas.getVal()) {
									/**
									 * On set l'init X 
									 * @param X
									 * @return X
									 */
									X = personnage.setX(X -1);
									/**
									 * On lit la tuile
									 * @param tuile
									 *
									 */
									tuile = map[X][Y];
									/**
									 * selon la réponse de la tuile, on agit
									 * @param tuile
									 *@param bourse
									 *@param trousseau
									 *@param vie
									 */
									if(map[X][Y] == or.getVal()) {
										bourse++;
									}
									if(map[X][Y] == clef.getVal()) {
										trouseau++;
									}
									if(map[X][Y] == piege.getVal() ) {
										vie --;
									}
									if(map[X][Y] == monstre.getVal() ) {
										for(int v = 0; v < 2; v++) {
											vie --;
										}
									}
									/**
									 *modification de la valeur map [x][y]
									 *@return map[x][y]
									 */
									map[X][Y] = personnage.getVal();
								}else {
									/**
									 *if le joueur à une clef
									 *@return trouseau
									 */
									if(trouseau != 0) {
										System.out.println("Vous avez consome une clef pour forcer ce cadenas !");
										trouseau--;
										/**
										 *On donne deux piece d'or si il ouvre un cadenas
										 *@return bourse
										 */
										for(int v = 0; v < 2; v++) {
											bourse++;
										}
										
										/**
										 * On set l'init X 
										 * @param X
										 * @return X
										 */
										X = personnage.setX(X -1);
										/**
										 * On lit la tuile
										 * @param tuile
										 *
										 */
										tuile = map[X][Y];
										/**
										 * selon la réponse de la tuile, on agit
										 * @param tuile
										 *@param bourse
										 *@param trousseau
										 *@param vie
										 */
										if(map[X][Y] == or.getVal()) {
											bourse++;
										}
										if(map[X][Y] == clef.getVal()) {
											trouseau++;
										}
										if(map[X][Y] == piege.getVal() ) {
											vie --;
										}
										if(map[X][Y] == monstre.getVal() ) {
											for(int v = 0; v < 2; v++) {
												vie --;
											}
										}
										map[X][Y] = personnage.getVal();
									}else {
									System.out.println("Vous n'avez pas les clefs pour passer par ici !");
									}
								}
								}else {
							System.out.println("Vous etes bloques par un arbre!");
						}
						}else {
							System.out.println("Vous etes bloques par un rocher !");
						}
					}
				}
			}
		}
		if(str == 2) {
			for(int i =0  ; i < 1 ; i++ ) {
				for(int j = 0; j < 1; j++) {
					if(map[X][Y] != map[19][Y]) {
						/**
						 * En cas de rocher
						 * @param rocher
						 */
						if(map[X+1][Y] != rocher.getVal()) {
							/**
							 * En cas d'arbre
							 * @param arbre
							 */
							if(map[X+1][Y] != arbre.getVal()) {
								/**
								 * En cas de cadenas
								 * @param cadenas
								 */
								if(map[X+1][Y] != cadenas.getVal()) {
									/**
									 * On set l'init X 
									 * @param X
									 * @return X
									 */
									X = personnage.setX(X +1);
									/**
									 * On lit la tuile
									 * @param tuile
									 *
									 */
									tuile = map[X][Y];
									/**
									 * selon la réponse de la tuile, on agit
									 * @param tuile
									 *@param bourse
									 *@param trousseau
									 *@param vie
									 */
									if(map[X][Y] == or.getVal()) {
										bourse++;
									}
									if(map[X][Y] == clef.getVal()) {
										trouseau++;
									}
									if(map[X][Y] == piege.getVal() ) {
										vie --;
									}
									if(map[X][Y] == monstre.getVal() ) {
										for(int v = 0; v < 2; v++) {
											vie --;
										}
									}

									map[X][Y] = personnage.getVal();
								}else {
									if(trouseau != 0) {
										System.out.println("Vous avez consome une clef pour forcer ce cadenas !");
										trouseau--;
										for(int v = 0; v < 2; v++) {
											bourse++;
										}
										/**
										 * On set l'init X 
										 * @param X
										 * @return X
										 */
										X = personnage.setX(X +1);
										/**
										 * On lit la tuile
										 * @param tuile
										 *
										 */
										tuile = map[X][Y];
										/**
										 * selon la réponse de la tuile, on agit
										 * @param tuile
										 *@param bourse
										 *@param trousseau
										 *@param vie
										 */
										if(map[X][Y] == or.getVal()) {
											bourse++;
										}
										if(map[X][Y] == clef.getVal()) {
											trouseau++;
										}
										if(map[X][Y] == piege.getVal() ) {
											vie --;
										}
										if(map[X][Y] == monstre.getVal() ) {
											for(int v = 0; v < 2; v++) {
												vie --;
											}
										}
										map[X][Y] = personnage.getVal();
									}else {
									System.out.println("Vous n'avez pas les clefs pour passer par ici !");									
									}
								}
								}else {
								System.out.println("Vous etes bloques par un arbre!");
							}
						}else {
							System.out.println("Vous etes bloques par un rocher !");
						}
					}
				}
			}
		}
		if(str == 4) {
			for(int i =0  ; i < 1 ; i++ ) {
				for(int j = 0; j < 1; j++) {
					if(map[X][Y] != map[X][0]) {
						/**
						 * En cas de rocher
						 * @param rocher
						 */
						if(map[X][Y-1] != rocher.getVal()) {
							/**
							 * En cas d'arbre
							 * @param arbre
							 */
							if(map[X][Y-1] != arbre.getVal()) {
								/**
								 * En cas de cadenas
								 * @param cadenas
								 */
								if(map[X][Y-1] != cadenas.getVal()) {
									/**
									 * On set l'init Y 
									 * @param Y
									 * @return Y
									 */
									Y = personnage.setY(Y -1);
									/**
									 * On lit la tuile
									 * @param tuile
									 *
									 */
									tuile = map[X][Y];
									/**
									 * selon la réponse de la tuile, on agit
									 * @param tuile
									 *@param bourse
									 *@param trousseau
									 *@param vie
									 */
									if(map[X][Y] == or.getVal()) {
										bourse++;
									}
									if(map[X][Y] == clef.getVal()) {
										trouseau++;
									}
									if(map[X][Y] == piege.getVal() ) {
										vie --;
									}
									if(map[X][Y] == monstre.getVal() ) {
										for(int v = 0; v < 2; v++) {
											vie --;
										}
									}
									map[X][Y] = personnage.getVal();
								}else {
									if(trouseau != 0) {
										System.out.println("Vous avez consome une clef pour forcer ce cadenas !");
										trouseau--;
										
										for(int v = 0; v < 2; v++) {
											bourse++;
										}
										/**
										 * On set l'init Y 
										 * @param Y
										 * @return Y
										 */
										Y = personnage.setY(Y -1);
										/**
										 * On lit la tuile
										 * @param tuile
										 *
										 */
										tuile = map[X][Y];
										/**
										 * selon la réponse de la tuile, on agit
										 * @param tuile
										 *@param bourse
										 *@param trousseau
										 *@param vie
										 */
										if(map[X][Y] == or.getVal()) {
											bourse++;
										}
										if(map[X][Y] == clef.getVal()) {
											trouseau++;
										}
										if(map[X][Y] == piege.getVal() ) {
											vie --;
										}
										if(map[X][Y] == monstre.getVal() ) {
											for(int v = 0; v < 2; v++) {
												vie --;
											}
										}
										map[X][Y] = personnage.getVal();
									}else {
									System.out.println("Vous n'avez pas les clefs pour passer par ici !");									
									}
								}
								}else {
								System.out.println("Vous etes bloques par un arbre!");
							}
						}else {
							System.out.println("Vous etes bloques par un rocher !");
						}
					}
				}
			}
		}
		if(str == 6) {
			for(int i =0  ; i < 1 ; i++ ) {
				for(int j = 0; j < 1; j++) {
					if(map[X][Y] != map[X][19]) {
						/**
						 * En cas de rocher
						 * @param rocher
						 */
						if(map[X][Y+1] != rocher.getVal()) {
							/**
							 * En cas d'arbre
							 * @param arbre
							 */
							if(map[X][Y+1] != arbre.getVal()) {
								/**
								 * En cas de cadenas
								 * @param cadenas
								 */
								if(map[X][Y+1] != cadenas.getVal()) {
									/**
									 * On set l'init Y 
									 * @param Y
									 * @return Y
									 */
									Y = personnage.setY(Y +1);
									/**
									 * On lit la tuile
									 * @param tuile
									 *
									 */
									tuile = map[X][Y];
									/**
									 * selon la réponse de la tuile, on agit
									 * @param tuile
									 *@param bourse
									 *@param trousseau
									 *@param vie
									 */
									if(map[X][Y] == or.getVal()) {
										bourse++;
									}
									if(map[X][Y] == clef.getVal()) {
										trouseau++;
									}
									if(map[X][Y] == piege.getVal() ) {
										vie --;
									}
									if(map[X][Y] == monstre.getVal() ) {
										if(map[X][Y] == monstre.getVal() ) {
											for(int v = 0; v < 2; v++) {
												vie --;
											}
										}
									}
									map[X][Y] = personnage.getVal();
								}else {
									if(trouseau != 0) {
										System.out.println("Vous avez consome une clef pour forcer ce cadenas !");
										trouseau--;
											for(int v = 0; v < 2; v++) {
												bourse++;
											}
											/**
											 * On set l'init Y 
											 * @param Y
											 * @return Y
											 */
										Y = personnage.setY(Y +1);
										/**
										 * On lit la tuile
										 * @param tuile
										 *
										 */
										tuile = map[X][Y];
										/**
										 * selon la réponse de la tuile, on agit
										 * @param tuile
										 *@param bourse
										 *@param trousseau
										 *@param vie
										 */
										if(map[X][Y] == or.getVal()) {
											bourse++;
										}
										if(map[X][Y] == clef.getVal()) {
											trouseau++;
										}
										if(map[X][Y] == piege.getVal() ) {
											vie --;
										}
										if(map[X][Y] == monstre.getVal() ) {
											for(int v = 0; v < 2; v++) {
												vie --;
											}
										}
										map[X][Y] = personnage.getVal();
									}else {
									System.out.println("Vous n'avez pas les clefs pour passer par ici !");							
									}
								}
								}else {
							System.out.println("Vous etes bloques par un arbre!");
						}
					}else {
						System.out.println("Vous etes bloques par un rocher !");
					}
					}
				}
			}
		}
		if(str == 0) {
			/**
			 * On compare la valeur tuile obtenu avec les elements
			 * @param herbes
			 *@param fleur
			 *@param clef
			 *@param or
			 *@param cadenas
			 *@param piege
			 *@param monstre
			 */
				if(tuile != herbe.getVal()) {
					if(tuile != fleur.getVal()) {
						if(tuile != clef.getVal()) {
							if(tuile != or.getVal()) {
								if(tuile != cadenas.getVal()) {
									if(tuile != piege.getVal()) {
										if(tuile != monstre.getVal()) {
											stop();												
											}else {
											System.out.println("C'est un monstre disgracieux : 8");
											}
											}else {	
											System.out.println("IT'S A TRAP : 7");}
										}else {	
										System.out.println("C'est un cadenas rouille : 6");}
									}else {	
								System.out.println("C'est de l'or : 5");}									
							}else {	
						System.out.println("C'est une petite clef : 4");}
					}else {
					System.out.println("Ce sont de belles fleures : 1");}
				}else {
				System.out.println("C'est de l'herbe : 0");}
		}
}
	/**
	 * Classe permettant l'affichage de la carte
	 */
	private void render() {
		/**
		 * Classe permettant l'affichage de la carte
		 * @return map
		 */
		afficherCarte();
		System.out.println("il vous reste "+ vie + " point de vie . Votre bourse contient " + bourse + " d'or et votre trouseaux contient " + trouseau + " clefs");
	}
	/**
	 * Classe run qui lance les autres fonctions
	 * @return runnable
	 */
	public void run() {
		/**
		 * insertion de la fonction init()
		 */
		init();
		/**
		 * verification que running est true
		 * @param running
		 * @throws si il est déjà en train de tourner ou si un element problematique apparait dans les ticks
		 */
		while(running) {
			try {
				tick();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/**
			*Appel fonction render
			 */
			render();
			
			/**
			 * en cas de victoire et de defaites
			 * @param bourse
			 * @param vie
			 */
			if(bourse == 10) {
				System.out.print("VOUS AVEZ GAGNE !");
				stop();
			}
			if(vie == 0) {
				System.out.print("VOUS AVEZ PERDU !");
				stop();
			}
		}
		/**
		 * arrêt du jeu
		 *
		 * @return stop
		 */
		stop();
		
	}
	/**
	 * Fonction intialisation de la carte
	 *
	 * @return map
	 */
	public void initialiserCarte() {
		for(int x = 0; x < 20; x++) {
			for(int y = 0; y <20;y++) {
				/**
				 * set de la position du personnage
				 *@param X
				 *@param Y
				 * @return map[X][Y]
				 */
				map[X][Y] = personnage.getVal();
				/**
				 * placement des minimuns
				 *@param cadenas
				 *@param clef
				 *@param fleur
				 *@param arbre
				 *@param rocher
				 *@param piege
				 *@param or
				 */
				for(int k = 0; k <20; k++) { 
					map[x][y] = cadenas.getVal();
					map[x][y] = clef.getVal();
				};
				for(int k = 0; k <5; k++) {
					map[x][y] = fleur.getVal();
					map[x][y] = arbre.getVal();
				};
				for(int k = 0; k <10; k++) {
					map[x][y] = rocher.getVal();
					map[x][y] = piege.getVal();
				}
				for(int k = 0; k <15; k++) {
					map[x][y] = monstre.getVal();
				}
				for(int k = 0; k <20; k++) {
					map[x][y] = or.getVal();
				}
				/**
				 * fonction random
				 */
				Random random = new Random();
				/**
				 * switch aleatoire
				 * @return map[x][y]
				 */
				switch(random.nextInt(9)) {
				case 0:
					map[x][y] = herbe.getVal();
				case 1:
					map[x][y] = fleur.getVal();
					break;
				case 2:
					map[x][y] = arbre.getVal();
					break;
				case 3:
					map[x][y] = rocher.getVal();
					break;
				case 4:
					map[x][y] = clef.getVal();
					break;
				case 5:
					map[x][y] = or.getVal();
					break;
				case 6:
					map[x][y] = cadenas.getVal();
					break;
				case 7:
					map[x][y] = piege.getVal();
					break;
				case 8:
					map[x][y] = monstre.getVal();
					break;
					
				}
			}
		}
	}
	/**
	 * Fonction affichage de la carte
	 *
	 * @return map[i][j]
	 */
	public void afficherCarte() {
		
		for(int i = 0; i < 20; i++ ) {
			for(int j = 0; j <20;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
		
	}
	/**
	 * Fonction start() permettant de lancer le runnable
	 *
	 * @return start
	 * @param running
	 */
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * Fonction stop() permettant de stoper le runnable
	 *
	 * @return stop
	 * @param running
	 */
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		System.out.println("Arret du jeu");
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
