package joueur;

import jeton.Jeton;
import plateau.Plateau;

/***
 * modélise un bot moyen qui évalue la grille 1 coup en avance
 * @author antoi
 *
 */
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

	/***
	 * ce bot va évaluer tous les coups qu'il peut faire (avec un de profondeur),
	 * il va faire le coup qui lui procure le meilleur score (évalué avec plateau.evaluer())
	 * d'ailleurs comme il juge tous les quadruplets,
	 * il se trouve que la colonne du milieu en procure plus que les autres,
	 * alors le bot jouera par défaut au milieu
	 * @param plateau la grille que l'on utilise pour calculer
	 * @return la meilleur colonne ou placer son jeton d'après le bot moyen
	 */
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
