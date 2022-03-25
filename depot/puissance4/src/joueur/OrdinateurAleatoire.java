package joueur;

import java.util.ArrayList;
import java.util.Random;

import jeton.Jeton;
import plateau.Plateau;

/***
 * modélise un bot vraiment idiot
 * @author antoi
 */
public class OrdinateurAleatoire extends Joueur {

	/***
	 * constructeur de ce bot
	 * @param pseudo pseudonyme du bot
	 * @param jeton jeton que va utiliser ce bot
	 */
	public OrdinateurAleatoire(String pseudo, Jeton jeton) {
		super(pseudo, jeton);
	}

	@Override
	public int ChoisirColonne(Plateau plateau) {
		
		int choix = choisirColonneAleatoire(plateau);
		System.out.println("["+ getPseudo() + "] a joué dans la colonne " + choix);
		return choix;
		
	}

	/***
	 * le bot récupère toutes les colonnes disponibles
	 * il prend ensuite une colonne aléatoirement
	 * @param plateau la grille concernée par cette opération
	 * @return la colonne que le bot a choisit [0,6]
	 */
	private int choisirColonneAleatoire(Plateau plateau) {
		
		int choix = -1;
		
		ArrayList<Integer> colonnesDisponibles = new ArrayList<Integer>();
		
		for (int i = 0; i < plateau.getDimensionX(); i++) {
			if (plateau.peutPlacer(i) != -1)
				colonnesDisponibles.add(i);
		}
		
		int indexRandom = new Random().nextInt(colonnesDisponibles.size());
		choix = colonnesDisponibles.get(indexRandom);
		
		System.out.println("["+ getPseudo() + "] a joué dans la colonne " + (choix + 1));
		
		return choix;
	}
}
