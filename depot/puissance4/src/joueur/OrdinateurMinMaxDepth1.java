package joueur;

import jeton.Jeton;
import plateau.Plateau;

public class OrdinateurMinMaxDepth1 extends Joueur{

	public OrdinateurMinMaxDepth1(String pseudo, Jeton jeton) {
		super(pseudo, jeton);
	}

	@Override
	public int ChoisirColonne(Plateau plateau) {
		
		int choix = choisirMeilleurColonne(plateau);
		System.out.println("["+ getPseudo() + "] a joué dans la colonne " + (choix + 1));
		return choix;
	}

	private int choisirMeilleurColonne(Plateau plateau) {

		int max = Integer.MIN_VALUE;
		int indexMax = -1;
		
		//pour toutes les colonnes
		for (int x = 0; x < plateau.getDimensionX(); x++) {
			
			int y = plateau.peutPlacer(x);
			//si on essaye de jouer dans une colonne injouable
			if (y == -1) continue;
			
			plateau.placerJeton(getJeton(), x);
			int score = plateau.evaluer(this);
			plateau.retirerJeton(x);
			
			if (score > max) {
				max = score;
				indexMax = x;
			}
		}
		
		return indexMax;
	}
}
