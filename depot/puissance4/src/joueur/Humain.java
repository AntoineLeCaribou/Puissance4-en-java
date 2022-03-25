package joueur;

import java.util.Scanner;

import jeton.Jeton;
import plateau.Plateau;

/***
 * modélise un joueur de puissance 4 humain
 * @author antoi
 */
public class Humain extends Joueur{

	/***
	 * constructeur du joueur humain
	 * @param pseudo le pseudonyme du joueur
	 * @param jeton le jeton associé au joueur
	 */
	public Humain(String pseudo, Jeton jeton) {
		super(pseudo, jeton);
	}
	
	/***
	 * la méthode qui donne le choix du joueur
	 * 1- demande un numéro de colonne au joueur
	 * 2- elle attent une entrée
	 * 3- si l'entrée n'est pas un int, on va en 2
	 * 4- si l'entrée n'est pas comprise entre [1 et 7], alors on va en 2
	 * 5- si la colonne est indisponible (colonne remplie), alors on va en 2
	 * 6- on retourne finalement la valeur choisie par le joueur
	 */
	@Override
	public int ChoisirColonne(Plateau plateau) {
		
		System.out.println("[" + this.getPseudo() + "] veuillez choisir une colonne entre 1 et 7");
		System.out.print("> ");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean valide = false;
		int choix = -1;
		
		while (!valide) {
			choix = scanner.nextInt();
			
			if (choix >= 1 && choix <= 7)
				valide = true;
			else
				return -1;
		}
		choix--;
		if (plateau.peutPlacer(choix) == -1) {
			return -1;
		}
		return choix;
	}

}
