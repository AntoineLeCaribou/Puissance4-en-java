package jeu;

import java.util.Random;

import jeton.Jeton;
import joueur.Gagnant;
import joueur.Joueur;
import plateau.Plateau;

public class Partie {
	
	private int ordre;
	private Joueur[] joueurs;
	private Plateau plateau;
	
	public Partie(Joueur joueur1, Joueur joueur2, int ordre) {
		
		joueurs = new Joueur[] {joueur1, joueur2};
		plateau = new Plateau();
		
		//si un joueur aleatoire commence
		if (ordre == -1) {
			this.ordre = new Random().nextInt(2);
		}
		
		jouer();
	}

	private void jouer() {
		
		Joueur joueurActif = null;
		
		while(plateau.estFinit(joueurActif) == Gagnant.PasFinit) {
			joueurActif = joueurs[ordre];
			
			int choix = -1;
			while(choix == -1) {
				plateau.afficherPlateau();
				choix = joueurActif.ChoisirColonne(plateau);
			}
			
			Jeton nouveauJeton = joueurActif.getJeton();
			
			plateau.placerJeton(nouveauJeton, choix);
			
			prochainTour();
		}
		
		plateau.afficherPlateau();
		
		//affichage dans la console de la phrase qui conclut la partie
		if (plateau.estFinit(joueurActif) == Gagnant.GrilleCompletee)
			System.out.println(plateau.estFinit(joueurActif).getPhrase());
		else
			System.out.println(joueurActif.getPseudo() + plateau.estFinit(joueurActif).getPhrase());
	}
	
	private void prochainTour() {
		++ordre;
		if (ordre == 2)
			ordre = 0;
	}
}
