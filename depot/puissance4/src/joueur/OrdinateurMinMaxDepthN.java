package joueur;

import java.util.ArrayList;

import jeton.Jeton;
import plateau.Plateau;

public class OrdinateurMinMaxDepthN extends Joueur {

	private final int profondeurMax;
	
	public OrdinateurMinMaxDepthN(String pseudo, Jeton jeton, int profondeur) {
		super(pseudo, jeton);
		this.profondeurMax = profondeur;
	}

	@Override
	public int ChoisirColonne(Plateau plateau) {
		
		int choix = choisirMeilleurColonne(plateau);
		System.out.println("["+ getPseudo() + "] a joué dans la colonne " + choix);
		return choix;
	}
	
	private int choisirMeilleurColonne(Plateau plateau) {

		//ArrayList<Plateau> eventualites = new ArrayList<Plateau>();
		Score meilleurScore = calculerScoreProchainPlateau(plateau, 1, 0);
		return meilleurScore.getIndex();
	}

	private Score calculerScoreProchainPlateau(Plateau plateau, int profondeurActuelle, int index) {
		
		//si c'est le max que l'on explore
		if (profondeurActuelle == profondeurMax) {
			//plateau.afficherPlateau();
			//System.out.println("score : " + plateau.evaluer(this));
			return new Score(plateau.evaluer(this), index);
		}
		
		Jeton jeton;
		boolean minimum;
		if (profondeurActuelle % 2 != 0) {
			jeton = getJeton();
			minimum = false;
		}
		else {
			jeton = getJeton().getContraire();
			minimum = true;
		}

		ArrayList<Score> scores = new ArrayList<Score>();
		
		//sinon c'est loin d'etre finit
		for (int i = 0; i < plateau.getDimensionX(); i++) {
			if (plateau.peutPlacer(i) != -1) {
				plateau.placerJeton(jeton, i);
				scores.add(calculerScoreProchainPlateau(plateau, profondeurActuelle + 1, i));
				scores.get(scores.size()-1).setIndex(i);
				plateau.retirerJeton(i);
			}
		}
		
		if (profondeurActuelle == 1) {
			for (Score score : scores) {
				System.out.println(score.getIndex() + " : " + score.getScore());
			}
		}
		
		Score scoreOptimal = scores.get(0);
		//on trouve le score minimal
		if (minimum) {
			
			double min = Double.POSITIVE_INFINITY;
			
			for (Score score : scores) {
				if (score.getScore() < min)  {
					scoreOptimal = score;
					min = score.getScore();
				}
			}
		}
		//on trouve le score maximal
		else {
			
			double max = Double.NEGATIVE_INFINITY;
			
			for (Score score : scores) {
				if (score.getScore() > max) {
					scoreOptimal = score;
					max = score.getScore();
				}
			}
		}
		
		return scoreOptimal;
	}
}
