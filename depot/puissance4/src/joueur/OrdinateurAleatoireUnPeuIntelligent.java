package joueur;

import java.util.ArrayList;
import java.util.Random;

import jeton.Jeton;
import plateau.Plateau;

public class OrdinateurAleatoireUnPeuIntelligent extends Joueur{

	public OrdinateurAleatoireUnPeuIntelligent(String pseudo, Jeton jeton) {
		super(pseudo, jeton);
	}

	@Override
	public int ChoisirColonne(Plateau plateau) {
		
		//on circule dans les ligne
		for (int positionX = 0; positionX < plateau.getDimensionX(); positionX++) {
			
			if (plateau.peutPlacer(positionX) != -1) {
				//on place son jeton dans la colonne
				plateau.placerJeton(getJeton(), positionX);
				
				//si le bot ne peut pas gagner, essayer la prochaine colonne
				if (plateau.estFinit(this) == Gagnant.PasFinit) {
					plateau.retirerJeton(positionX);
					continue;
				}
				
				//sinon c'est un coup gagnant
				plateau.retirerJeton(positionX);
				System.out.println("["+ getPseudo() + "] a joué dans la colonne " + (positionX + 1));
				return positionX;
			}
		}
		
		int choix = choisirColonneAleatoire(plateau);
		System.out.println("["+ getPseudo() + "] a joué dans la colonne " + (choix + 1));
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
		
		return choix;
	}

}
