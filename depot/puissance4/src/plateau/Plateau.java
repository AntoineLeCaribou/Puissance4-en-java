package plateau;

import java.util.ArrayList;

import jeton.Couleur;
import jeton.Jeton;
import joueur.Gagnant;
import joueur.Joueur;

public class Plateau {
	
	private final int dimensionX;
	private final int dimensionY;
	
	private Jeton[][] plateau;
	
	public Plateau() {
		this.dimensionX = 7;
		this.dimensionY = 6;
		this.plateau = new Jeton[getDimensionX()][dimensionY];
	}
	
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

	public int getDimensionX() {
		return dimensionX;
	}

	public Jeton getCase(int positionX, int positionY) {
		return plateau[positionX][positionY];
	}

	
	public int evaluer(Joueur joueur) {
		
		ArrayList<Jeton[]> quadruplets = new ArrayList<Jeton[]>();
		quadruplets = ajouterQuadruplets();
		
		int somme = 0;
		
		for (Jeton[] quadruplet : quadruplets) {
			somme += evaluerQuadruplet(joueur, quadruplet);
		}
		
		return somme;
	}
	
	private ArrayList<Jeton[]> ajouterQuadruplets() {
		
		ArrayList<Jeton[]> copy = new ArrayList<Jeton[]>();
		
		copy = ajouterQuadrupletsHorizontal(copy);
		copy = ajouterQuadrupletsVertical(copy);
		copy = ajouterQuadrupletsDiagonalMontants(copy);
		copy = ajouterQuadrupletsDiagonalDescendants(copy);
		
		return copy;
	}

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
