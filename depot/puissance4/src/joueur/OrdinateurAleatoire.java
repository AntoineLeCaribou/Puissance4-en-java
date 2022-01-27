package joueur;

import java.util.ArrayList;
import java.util.Random;

import jeton.Jeton;
import plateau.Plateau;

public class OrdinateurAleatoire extends Joueur {

	public OrdinateurAleatoire(String pseudo, Jeton jeton) {
		super(pseudo, jeton);
	}

	@Override
	public int ChoisirColonne(Plateau plateau) {
		
		int choix = choisirColonneAleatoire(plateau);
		System.out.println("["+ getPseudo() + "] a joué dans la colonne " + choix);
		return choix;
		
	}

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
