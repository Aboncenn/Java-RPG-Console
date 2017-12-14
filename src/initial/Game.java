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

public class Game implements Runnable{
	
	private boolean running;
	private Thread thread;
	
	// générer la carte
	String[][] map = new String[20][20];

	private Joueurs personnage = new Joueurs(0,0);
	// vie du personnage
	private int vie = personnage.getVie();
	private Herbes herbe = new Herbes() ;
	private Fleures fleur = new Fleures() ;
	private Arbres arbre = new Arbres();
	private Rochers rocher = new Rochers();
	private Clefs clef = new Clefs();
	private int trouseau = clef.getTrouseau();
	private Ors or = new Ors();
	// contenant d'or
	private int bourse = or.getBourse();
	private Cadenas cadenas = new Cadenas();
	private Pieges piege = new Pieges();
	private Monstres monstre = new Monstres();
	// variable pour vérifier la tuile ou va le personnage
	private String tuile;
	// coordonnées du joueur
	int Y = personnage.getY();
	int X = personnage.getX();
	
	// fonction intial
	private void init() {
		initialiserCarte();
		afficherCarte();
	}
	
	// Fonction avec toutes les actions lors des mouvements
	private void tick() throws InterruptedException {
		// consigne pour le joueur
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer un mouvement, 8 pour haut, 2 pour bas, 4 pour gauche et 6 pour droite");
		int str = sc.nextInt();
		
		if(str == 8) {
			for(int i =0  ; i < 1 ; i++ ) {
				for(int j = 0; j < 1;j++) {
					if(map[X][Y] != map[0][Y]) {
						// Si rocher
						if(map[X-1][Y] != rocher.getVal()) {
							//si arbre
							if(map[X-1][Y] != arbre.getVal()) {
								// si cadenas
								if(map[X-1][Y] != cadenas.getVal()) {
									// on indique que l'on déplace X
									X = personnage.setX(X -1);
									// Récupération de la tuile
									tuile = map[X][Y];
									// incrémentation de la bourse, du trouseau et de la vie
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
									// on indique ou ce trouve le personnage.
									map[X][Y] = personnage.getVal();
								}else {
									// Si le joueur possède une clef
									if(trouseau != 0) {
										System.out.println("Vous avez consomé une clef pour forcer ce cadenas !");
										trouseau--;
										// on lui donne deux d'or car il a réussi à ouvrir le cadenas
										for(int v = 0; v < 2; v++) {
											bourse++;
										}
										
										// on indique que l'on déplace X
										X = personnage.setX(X -1);
										// Récupération de la tuile
										tuile = map[X][Y];
										// incrémentation de la bourse, du trouseau et de la vie
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
							System.out.println("Vous êtes bloqués par un arbre!");
						}
						}else {
							System.out.println("Vous êtes bloqués par un rocher !");
						}
					}
				}
			}
		}
		if(str == 2) {
			for(int i =0  ; i < 1 ; i++ ) {
				for(int j = 0; j < 1; j++) {
					if(map[X][Y] != map[19][Y]) {
						// Si rocher
						if(map[X+1][Y] != rocher.getVal()) {
							//si arbre
							if(map[X+1][Y] != arbre.getVal()) {
								// si cadenas
								if(map[X+1][Y] != cadenas.getVal()) {
									// on indique que l'on déplace X
									X = personnage.setX(X +1);
									// Récupération de la tuile
									tuile = map[X][Y];
									// incrémentation de la bourse, du trouseau et de la vie
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
										System.out.println("Vous avez consomé une clef pour forcer ce cadenas !");
										trouseau--;
										for(int v = 0; v < 2; v++) {
											bourse++;
										}
										// on indique que l'on déplace X
										X = personnage.setX(X +1);
										// Récupération de la tuile
										tuile = map[X][Y];
										// incrémentation de la bourse, du trouseau et de la vie
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
								System.out.println("Vous êtes bloqués par un arbre!");
							}
						}else {
							System.out.println("Vous êtes bloqués par un rocher !");
						}
					}
				}
			}
		}
		if(str == 4) {
			for(int i =0  ; i < 1 ; i++ ) {
				for(int j = 0; j < 1; j++) {
					if(map[X][Y] != map[X][0]) {
						// Si rocher
						if(map[X][Y-1] != rocher.getVal()) {
							//si arbre
							if(map[X][Y-1] != arbre.getVal()) {
								// si cadenas
								if(map[X][Y-1] != cadenas.getVal()) {
									// on indique que l'on déplace Y
									Y = personnage.setY(Y -1);
									// Récupération de la tuile
									tuile = map[X][Y];
									// incrémentation de la bourse, du trouseau et de la vie
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
										System.out.println("Vous avez consomé une clef pour forcer ce cadenas !");
										trouseau--;
										
										for(int v = 0; v < 2; v++) {
											bourse++;
										}
										// on indique que l'on déplace Y
										Y = personnage.setY(Y -1);
										// Récupération de la tuile
										tuile = map[X][Y];
										// incrémentation de la bourse, du trouseau et de la vie
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
								System.out.println("Vous êtes bloqués par un arbre!");
							}
						}else {
							System.out.println("Vous êtes bloqués par un rocher !");
						}
					}
				}
			}
		}
		if(str == 6) {
			for(int i =0  ; i < 1 ; i++ ) {
				for(int j = 0; j < 1; j++) {
					if(map[X][Y] != map[X][19]) {
						// Si rocher
						if(map[X][Y+1] != rocher.getVal()) {
							//si arbre
							if(map[X][Y+1] != arbre.getVal()) {
								// si cadenas
								if(map[X][Y+1] != cadenas.getVal()) {
									// on indique que l'on déplace Y
									Y = personnage.setY(Y +1);
									// Récupération de la tuile
									tuile = map[X][Y];
									// incrémentation de la bourse, du trouseau et de la vie
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
										System.out.println("Vous avez consomé une clef pour forcer ce cadenas !");
										trouseau--;
											for(int v = 0; v < 2; v++) {
												bourse++;
											}
											// on indique que l'on déplace Y
										Y = personnage.setY(Y +1);
										// Récupération de la tuile
										tuile = map[X][Y];
										// incrémentation de la bourse, du trouseau et de la vie
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
							System.out.println("Vous êtes bloqués par un arbre!");
						}
					}else {
						System.out.println("Vous êtes bloqués par un rocher !");
					}
					}
				}
			}
		}
		if(str == 0) {
			// On compare la variable tuile avec les valeurs des tuiles
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
										System.out.println("C'est un cadenas rouillé : 6");}
									}else {	
								System.out.println("C'est de l'or : 5");}									
							}else {	
						System.out.println("C'est une petite clef : 4");}
					}else {
					System.out.println("Ce sont de belles fleures : 1");}
				}else {
				System.out.println("C'est de l'herbe : 0");}
		}else {
			System.out.println("Mouvement interdit");
		}
}
	private void render() {
		//Fonction d'affichage de la carte et de l'interface
		afficherCarte();
		System.out.println("il vous reste "+ vie + " point de vie . Votre bourse contient " + bourse + " d'or et votre trouseaux contient " + trouseau + " clefs");
	}
	
	public void run() {
		// Fonction de runable qui appelle les autres fonctions
		init();
		// boolean running qui vérifie si on ne lance pas deux fois le jeu
		while(running) {
			try {
				tick();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
			
			// If de victoire et de défaites
			if(bourse == 10) {
				System.out.print("VOUS AVEZ GAGNE !");
				stop();
			}
			if(vie == 0) {
				System.out.print("VOUS AVEZ PERDU !");
				stop();
			}
		}
		// arrêt du jeu
		stop();
		
	}
// fonction de génération de la carte
	public void initialiserCarte() {
		for(int x = 0; x < 20; x++) {
			for(int y = 0; y <20;y++) {
				// on place le X dans les variables de positions
				map[X][Y] = personnage.getVal();
				// Placement des minimuns
				for(int k = 0; k <3; k++) { 
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

				Random random = new Random();
				//switch aléatoire
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
					map[x][y] = herbe.getVal();
					break;
				case 5:
					map[x][y] = or.getVal();
					break;
				case 6:
					map[x][y] = herbe.getVal();
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
// affichage de la carte
	public void afficherCarte() {
		
		for(int i = 0; i < 20; i++ ) {
			for(int j = 0; j <20;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
		
	}
	// Fonction runnable de start et de stop
	public synchronized void start() {
		// on véfrifie si le jeu ne ce lance pas deux fois
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		// idem, on vérifie que le jeu n'est pas déjà à l'arrêt
		if(!running)
			return;
		running = false;
		System.out.println("Arrêt du jeu");
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
