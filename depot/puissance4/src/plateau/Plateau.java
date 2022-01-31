package plateau;

import java.util.ArrayList;

import jeton.Couleur;
import jeton.Jeton;
import joueur.Gagnant;
import joueur.Joueur;

/***
 * modélise le plateau (ou la grille) du puissance 4
 * elle contient une matrice de jetons
 * elle permet de placer, retirer et globalement d'intérzgir avec la grille tout en sécurité
 * @author antoi
 */
public class Plateau {
	
	/***
	 * constante qui contient la largeur de la grille
	 */
	private final int dimensionX;
	/***
	 * constante qui contient la hauteur de la grille
	 */
	private final int dimensionY;
	
	/***
	 * la matrice qui contient tous les jetons (et aussi les cases vides)
	 */
	private Jeton[][] plateau;
	
	/***
	 * constructeur du plateau, il initialise la grille avec 7 de largeur et 6 de hauteur
	 */
	public Plateau() {
		this.dimensionX = 7;
		this.dimensionY = 6;
		this.plateau = new Jeton[dimensionX][dimensionY];
	}
	
	/***
	 * constructeur du plateau, permet d'instancier la grille avec une taille personnalisée
	 * @param dimX largeur du plateau
	 * @param dimY hauteur du plateau
	 */
	public Plateau(int dimX, int dimY) {
		this.dimensionX = dimX;
		this.dimensionY = dimY;
		this.plateau = new Jeton[dimensionX][dimensionY];
	}
	
	/***
	 * permet de placer dans la grille un jeton de notre choix dans la colonne de notre choix
	 * cette méthode vérifie que cette opération est bien possible
	 * @param jeton le jeton que l'on souhaite placer dans la colonne
	 * @param positionX la colonne dans laquelle on veut placer le jeton
	 * @return vrai si le placement est possible (si la colonne n'est pas vide), faux sinon
	 */
	public boolean placerJeton(Jeton jeton, int positionX) {
		
		int positionY = peutPlacer(positionX);
		
		//si la colonne est remplie
		if (positionY == -1) {
			return false;
		}
		
		//sinon une place est disponible !
		plateau[positionX][positionY] = jeton;
		
		return true;
	}
	
	/***
	 * permet de retirer un jeton de la grille, le jeton enlevé est le plus haut
	 * @param positionX la colonne dans laquelle on veut enlever un jeton
	 * @return faux si la colonne est vide, vrai sinon
	 */
	public boolean retirerJeton(int positionX) {
		
		int positionY = peutRetirer(positionX);
		
		//si la colonne est vide
		if (positionY == -1) {
			return false;
		}
		
		//sinon on peut retirer !
		plateau[positionX][positionY] = null;
		
		return true;
	}

	/***
	 * teste si on a le droit de retirer un jeton de la grille
	 * @param positionX la colonne visée par cette opération
	 * @return -1 si la colonne est vide, la hauteur de jeton le plus haut sinon
	 */
	private int peutRetirer(int positionX) {

		//pour toutes les cases de la colonne en descendant
		for (int positionY = plateau[0].length-1; positionY >= 0; positionY--) {
			
			//si une case est disponible
			if (plateau[positionX][positionY] == null) {
				//on continue de descendre
				continue;
			}
			
			//sinon si on croise un jeton
			return positionY;
		}
		
		//la colonne est remplie ...
		return -1;
	}

	/***
	 * teste si on peut placer un jeton dans la colonne donnée
	 * @param positionX la colonne dans laquelle on place le jeton
	 * @return -1 si la colonne est remplie, la hauteur de l'emplacement le plus bas sinon
	 */
	public int peutPlacer(int positionX) {
		
		//pour toutes les cases de la colonne
		for (int positionY = 0; positionY < plateau[0].length; positionY++) {
			
			//si une case est disponible
			if (plateau[positionX][positionY] == null) {
				//on arr�te et on retourne la ligne
				return positionY;
			}
		}
		
		//la colonne est remplie ...
		return -1;
	}
	
	/***
	 * affiche dans la console une représentation du plateau en ascii-art
	 */
	public void afficherPlateau() {
		
		System.out.println("---------------");
		for (int positionY = plateau[0].length - 1; positionY >= 0; positionY--) {
			System.out.print("|");
			
			for (int positionX = 0; positionX < plateau.length; positionX++) {
				
				char lettreJeton = ' ';
				if (plateau[positionX][positionY] != null) {
					lettreJeton = plateau[positionX][positionY].getCouleur().getLettre();
				}

				System.out.print(lettreJeton + "|");
			}
			System.out.print("\n");
		}
		System.out.println("---------------");
		System.out.println("||           ||");
	}

	/***
	 * retourne l'état d'une partie de puissance 4
	 * @param joueur le joueur que l'on regarde (généralement le joueur actif)
	 * @return l'état de la partie, cf: la classe Gagnant pour plus d'info
	 */
	public Gagnant estFinit(Joueur joueur) {
		
		if (joueur == null)
			return Gagnant.PasFinit;
		
		//on regarde si le joueur a fait puissance4, si c'est le cas on retourne Gagnant.Joueur
		Couleur couleur = joueur.getJeton().getCouleur();
		
		boolean horizontal = finitHorizontal(couleur);
		boolean vertical = finitVertical(couleur);
		boolean diagonaleMontante = finitDiagonaleMontante(couleur);
		boolean diagonaleDescendante = finitDiagonaleDescendante(couleur);
		
		//si l'un de ces mode est vrai, alors le joueur actif a gagné
		if (horizontal || vertical || diagonaleMontante || diagonaleDescendante)
			return Gagnant.Gagne;
		
		//on regarde si la grille a des vides, si c'est le cas on return Gagnant.PasFinit
		int positionY = 5;
		for (int positionX = 0; positionX < plateau.length; positionX++) {
			//si une case de la ligne superieur n'est pas vide
			if (plateau[positionX][positionY] == null) {
				return Gagnant.PasFinit;
			}
		}
		
		//sinon on return Gagnant.GrilleCompletee
		return Gagnant.GrilleCompletee;
	}

	/***
	 * permet de vérifier que la partie ne possède pas un alignement horizontal de 4 jetons similaires
	 * @param couleur la couleur des jetons que l'on analyse
	 * @return vrai si la partie est finit, faux sinon
	 */
	private boolean finitHorizontal(Couleur couleur) {
		
		//pour toutes les lignes
		for (int positionY = 0; positionY < plateau[0].length; positionY++) {
			
			//on circule parmis les colonnes
			for (int positionX = 0; positionX < plateau.length-3; positionX++) {
				
				//si la premiere case est de la bonne couleur
				if (plateau[positionX][positionY] != null && plateau[positionX][positionY].getCouleur() == couleur) {
					
					boolean jeton2 = plateau[positionX+1][positionY] != null && plateau[positionX+1][positionY].getCouleur() == couleur;
					boolean jeton3 = plateau[positionX+2][positionY] != null && plateau[positionX+2][positionY].getCouleur() == couleur;
					boolean jeton4 = plateau[positionX+3][positionY] != null && plateau[positionX+3][positionY].getCouleur() == couleur;
					
					if (jeton2 && jeton3 && jeton4) {
						return true;
					}	
				}
			}
		}
		return false;
	}
	
	/***
	 * permet de vérifier que la partie ne possède pas un alignement diagonal montant de 4 jetons similaires
	 * @param couleur la couleur des jetons que l'on analyse
	 * @return vrai si la partie est finit, faux sinon
	 */
	private boolean finitDiagonaleMontante(Couleur couleur) {
		
		//pour toutes les lignes
		for (int positionY = 0; positionY < plateau[0].length-3; positionY++) {
			
			//on circule parmis les colonnes
			for (int positionX = 0; positionX < plateau.length-3; positionX++) {
				
				//si la premiere case est de la bonne couleur
				if (plateau[positionX][positionY] != null && plateau[positionX][positionY].getCouleur() == couleur) {
					
					boolean jeton2 = plateau[positionX+1][positionY+1] != null && plateau[positionX+1][positionY+1].getCouleur() == couleur;
					boolean jeton3 = plateau[positionX+2][positionY+2] != null && plateau[positionX+2][positionY+2].getCouleur() == couleur;
					boolean jeton4 = plateau[positionX+3][positionY+3] != null && plateau[positionX+3][positionY+3].getCouleur() == couleur;
					
					if (jeton2 && jeton3 && jeton4) {
						return true;
					}	
				}
			}
		}
		return false;
	}
	
	/***
	 * permet de vérifier que la partie ne possède pas un alignement diagonal descendant de 4 jetons similaires
	 * @param couleur la couleur des jetons que l'on analyse
	 * @return vrai si la partie est finit, faux sinon
	 */
	private boolean finitDiagonaleDescendante(Couleur couleur) {
		
		//pour toutes les lignes
		for (int positionY = 3; positionY < plateau[0].length; positionY++) {
			
			//on circule parmis les colonnes
			for (int positionX = 0; positionX < plateau.length-3; positionX++) {
				
				//si la premiere case est de la bonne couleur
				if (plateau[positionX][positionY] != null && plateau[positionX][positionY].getCouleur() == couleur) {
					
					boolean jeton2 = plateau[positionX+1][positionY-1] != null && plateau[positionX+1][positionY-1].getCouleur() == couleur;
					boolean jeton3 = plateau[positionX+2][positionY-2] != null && plateau[positionX+2][positionY-2].getCouleur() == couleur;
					boolean jeton4 = plateau[positionX+3][positionY-3] != null && plateau[positionX+3][positionY-3].getCouleur() == couleur;
					
					if (jeton2 && jeton3 && jeton4) {
						return true;
					}	
				}
			}
		}
		return false;
	}
	
	/***
	 * permet de vérifier que la partie ne possède pas un alignement vertical de 4 jetons similaires
	 * @param couleur la couleur des jetons que l'on analyse
	 * @return vrai si la partie est finit, faux sinon
	 */
	private boolean finitVertical(Couleur couleur) {
		
		//pour toutes les colonnes
		for (int positionX = 0; positionX < plateau.length; positionX++) {
			
			//on circule parmis les lignes
			for (int positionY = 3; positionY < plateau[0].length; positionY++) {
				
				//si la premiere case est de la bonne couleur
				if (plateau[positionX][positionY] != null && plateau[positionX][positionY].getCouleur() == couleur) {
					
					boolean jeton2 = plateau[positionX][positionY-1] != null && plateau[positionX][positionY-1].getCouleur() == couleur;
					boolean jeton3 = plateau[positionX][positionY-2] != null && plateau[positionX][positionY-2].getCouleur() == couleur;
					boolean jeton4 = plateau[positionX][positionY-3] != null && plateau[positionX][positionY-3].getCouleur() == couleur;
					
					if (jeton2 && jeton3 && jeton4) {
						return true;
					}	
				}
			}
		}
		return false;
	}

	/***
	 * getter de la largeur de la grille
	 * @return la largeur
	 */
	public int getDimensionX() {
		return dimensionX;
	}
	
	/***
	 * getter de la heuteur de la grille
	 * @return la largeur
	 */
	public int getDimensionY() {
		return dimensionY;
	}

	/***
	 * getter d'une case de la grille grâce aux coordonnées
	 * @param positionX l'index de la largeur
	 * @param positionY l'index de la hauteur
	 * @return le jeton qui se situe dans la case, null si la case est vide
	 */
	public Jeton getCase(int positionX, int positionY) {
		return plateau[positionX][positionY];
	}

	/***
	 * permet d'évaluer le score d'une grille en maximisant les coups qui avantagent le joueur donnée en paramètres
	 * cette méthode fait la sommet de l'évaluation de tous les quadruplets de la grille
	 * @param joueur le joueur que l'on évalue dans notre grille
	 * @return un entier qui peut être négatif
	 */
	public int evaluer(Joueur joueur) {
		
		ArrayList<Jeton[]> quadruplets = new ArrayList<Jeton[]>();
		quadruplets = ajouterQuadruplets();
		
		int somme = 0;
		
		for (Jeton[] quadruplet : quadruplets) {
			somme += evaluerQuadruplet(joueur, quadruplet);
		}
		
		return somme;
	}
	
	/***
	 * permet d'ajouter tous les quadruplets de la grille
	 * @return la liste de tous les quadruplets
	 */
	private ArrayList<Jeton[]> ajouterQuadruplets() {
		
		ArrayList<Jeton[]> copy = new ArrayList<Jeton[]>();
		
		copy = ajouterQuadrupletsHorizontal(copy);
		copy = ajouterQuadrupletsVertical(copy);
		copy = ajouterQuadrupletsDiagonalMontants(copy);
		copy = ajouterQuadrupletsDiagonalDescendants(copy);
		
		return copy;
	}

	/***
	 * trouve tous les qudruplets en diagonal descendante
	 * @return la liste de tous les quadruplets concernés
	 */
	private ArrayList<Jeton[]> ajouterQuadrupletsDiagonalDescendants(ArrayList<Jeton[]> quadruplets) {
		ArrayList<Jeton[]> copy = (ArrayList<Jeton[]>) quadruplets.clone();
		
		//pour toutes les lignes
		for (int positionY = 3; positionY < plateau[0].length; positionY++) {
			
			//on circule parmis les colonnes
			for (int positionX = 0; positionX < plateau.length-3; positionX++) {
				
				copy.add(new Jeton[]
				{
					plateau[positionX][positionY],
					plateau[positionX+1][positionY-1],
					plateau[positionX+2][positionY-2],
					plateau[positionX+3][positionY-3]
				});
			}
		}
		
		return copy;
	}

	/***
	 * trouve tous les qudruplets en diagonal montante
	 * @return la liste de tous les quadruplets concernés
	 */
	private ArrayList<Jeton[]> ajouterQuadrupletsDiagonalMontants(ArrayList<Jeton[]> quadruplets) {
		ArrayList<Jeton[]> copy = (ArrayList<Jeton[]>) quadruplets.clone();
		
		//pour toutes les lignes
		for (int positionY = 0; positionY < plateau[0].length-3; positionY++) {
			
			//on circule parmis les colonnes
			for (int positionX = 0; positionX < plateau.length-3; positionX++) {
				
				copy.add(new Jeton[]
				{
					plateau[positionX][positionY],
					plateau[positionX+1][positionY+1],
					plateau[positionX+2][positionY+2],
					plateau[positionX+3][positionY+3]
				});
			}
		}
		
		return copy;
	}

	/***
	 * trouve tous les qudruplets en vertical
	 * @return la liste de tous les quadruplets concernés
	 */
	private ArrayList<Jeton[]> ajouterQuadrupletsVertical(ArrayList<Jeton[]> quadruplets) {
		ArrayList<Jeton[]> copy = (ArrayList<Jeton[]>) quadruplets.clone();
		
		//pour toutes les colonnes
		for (int positionX = 0; positionX < plateau.length; positionX++) {
			
			//on circule parmis les lignes
			for (int positionY = 3; positionY < plateau[0].length; positionY++) {
				
				copy.add(new Jeton[]
				{
					plateau[positionX][positionY],
					plateau[positionX][positionY-1],
					plateau[positionX][positionY-2],
					plateau[positionX][positionY-3]
				});
			}
		}
		
		return copy;
	}

	/***
	 * trouve tous les qudruplets en horizontal
	 * @return la liste de tous les quadruplets concernés
	 */
	private ArrayList<Jeton[]> ajouterQuadrupletsHorizontal(ArrayList<Jeton[]> quadruplets) {
		ArrayList<Jeton[]> copy = (ArrayList<Jeton[]>) quadruplets.clone();
		
		//pour toutes les lignes
		for (int positionY = 0; positionY < plateau[0].length; positionY++) {
			
			//on circule parmis les colonnes
			for (int positionX = 0; positionX < plateau.length-3; positionX++) {
				
				copy.add(new Jeton[]
				{
					plateau[positionX][positionY],
					plateau[positionX+1][positionY],
					plateau[positionX+2][positionY],
					plateau[positionX+3][positionY]
				});
			}
		}
		
		return copy;
	}

	/***
	 * permet de donner une valeur à un quadruplet par rapport au nombre de vides, de jetons d'adversaire et de nos jetons
	 * @param joueur le joueur qui fait l'évaluation des quadruplets
	 * @param jetons la liste des jetons (4 en l'occurence) qui composent le quadruplet
	 * @return un score que représente un quadruplet
	 */
	private int evaluerQuadruplet(Joueur joueur, Jeton[] jetons) {
		
		int nbJetonCorrect = 0;
		int nbJetonOppose = 0;
		
		for (Jeton jeton : jetons) {
			
			//case vide
			if (jeton == null)
				continue;
			
			//jeton du bot
			if (jeton.equals(joueur.getJeton())) {
				nbJetonCorrect++;
			}
			//jeton de l'adversaire
			else if (jeton.equals(joueur.getJeton().getContraire())) {
				nbJetonOppose++;
			}
		}
		
		//si c'est un melange de rouge et de jaune, alors ça ne vaut rien
		if (nbJetonCorrect > 0 && nbJetonOppose > 0)
			return 0;
		
		//si le quadruplet est vide
		if (nbJetonCorrect == 0 && nbJetonOppose == 0)
			return 0;
		
		switch (nbJetonCorrect) {
		case 1:
			return 1;
		case 2:
			return 5;
		case 3:
			return 500;
		case 4:
			return Integer.MAX_VALUE / 2;
		}
		
		switch (nbJetonOppose) {
		case 1:
			return -1;
		case 2:
			return -5;
		case 3:
			return -500;
		case 4:
			return Integer.MIN_VALUE;
		}
		return 0;
	}
}
