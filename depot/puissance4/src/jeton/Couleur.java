package jeton;

/***
 * cette enumération modélise une couleur
 * les jetons de puissance 4 peuvent en contenir une
 * @author antoi
 */
public enum Couleur {
	/***
	 * création de la couleur jaune avec la lettre 'J'
	 */
	Jaune('J'),
	/***
	 * création de la couleur rouge avec la lettre 'R'
	 */
	Rouge('R');
	
	/***
	 * une couleur peut stocker une lettre, cela permet de l'afficher dans un terminal
	 * par exemple : la couleur rouge donne la lettre 'R', cela permet de l'afficher dans la grille du puissance 4
	 */
	private char lettre;
	
	/***
	 * constructeur d'une couleur
	 * @param lettre la lettre que possédera une couleur
	 */
	private Couleur(char lettre) {
		this.lettre = lettre;
	}
	
	/***
	 * getter de la lettre de la couleur
	 * @return la lettre de type char
	 */
	public char getLettre() {
		return lettre;
	}
}
