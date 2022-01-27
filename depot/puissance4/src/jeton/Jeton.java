package jeton;

/***
 * cette classe modélise un jeton de puissance 4
 * tous ses enfants peuvent entrer dans une grille de puissance 4 ou être possédés par un joueur
 * @author antoi
 *
 */
public abstract class Jeton {
	
	/***
	 * la couleur du jeton, peut être jaune ou rouge en l'occurence
	 */
	private Couleur couleur;
	/***
	 * le jeton contraire, utile pour le minmax lorsque l'on doit placer un jaune après un rouge (ou inversement)
	 * permet de différencier deux jetons
	 * par exemple si mon jeton est jaune, alors le jeton contraire est rouge
	 */
	private Jeton contraire;

	/***
	 * constructeur d'un jeton
	 * @param couleur la couleur du jeton
	 * @param contraire le jeton contraire de celui-ci
	 */
	public Jeton(Couleur couleur, Jeton contraire) {
		this.couleur = couleur;
		this.contraire = contraire;
	}

	/***
	 * getter de la couleur du jeton
	 * @return la couleur du jeton, jaune ou rouge
	 */
	public Couleur getCouleur() {
		return couleur;
	}
	
	/***
	 * getter du jeton contraire
	 * @return le jeton contraire de l'instance que vous utilisez
	 */
	public Jeton getContraire() {
		return contraire;
	}
	
	/***
	 * permet de tester si deux jetons sont identiques
	 * le seul critère est la couleur
	 * @param jeton le jeton que l'on compare avec l'instance
	 * @return vrai si les deux jetons ont la même couleur, faux sinon
	 */
	public boolean equals(Jeton jeton) {
		if (jeton == null)
			return false;
		return couleur == jeton.couleur;
	}
}
