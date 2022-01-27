package joueur;

import java.util.Scanner;

import jeton.Jeton;
import plateau.Plateau;

public class Humain extends Joueur{

	public Humain(String pseudo, Jeton jeton) {
		super(pseudo, jeton);
	}
	
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
