package jeu;

import java.util.Random;

import jeton.Jeton;
import joueur.Gagnant;
import joueur.Joueur;
import plateau.Plateau;

/***
 * modélise une partie de puissance 4
 * contient le plateau (la grille)
 * contient 2 joueurs
 * contient l'ordre des joueurs
 * @author antoi
 */
public class Partie {
	
	/***
	 * l'ordre de jeu
	 * 0 = le premier joueur
	 * 1 = le deuxieme joueur
	 */
	private int ordre;
	/***
	 * l'array qui contient tous les joueurs
	 */
	private Joueur[] joueurs;
	/***
	 * le plateau sur lequel prend place la partie
	 */
	private Plateau plateau;
	
	/***
	 * le constructeur de la partie
	 * @param joueur1 le premier joueur
	 * @param joueur2 le deuxième joueur
	 * @param ordre l'ordre de jeu, si -1 alors le joueur qui commence est aléatoire
	 */
	public Partie(Joueur joueur1, Joueur joueur2, int ordre) {
		
		joueurs = new Joueur[] {joueur1, joueur2};
		plateau = new Plateau();
		
		//si un joueur aleatoire commence
		if (ordre == -1) {
			this.ordre = new Random().nextInt(2);
		}
		
		jouer();
	}

	/***
	 * la méthode qui se lance dès la création de la partie et qui contient le cycle de la partie
	 * cad que tant que personne n'a gagné par puissance 4 ou que la grille n'est pas remplie, la partie continue à faire jouer les joueurs consécutivement
	 * une fois terminée elle affiche le gagnant (ou personne si égalité) et se termine
	 */
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
	
	/***
	 * permet de passer au prochain tour sans avoir une valeur incohérente, uniquement 0 ou 1 
	 */
	private void prochainTour() {
		++ordre;
		if (ordre == 2)
			ordre = 0;
	}
}
