package joueur;

import jeton.Jeton;
import plateau.Plateau;

/***
 * modélise un joueur de puissance 4, tous ses enfant peuvent participer à des parties
 * @author antoi
 */
public abstract class Joueur {

	/***
	 * pseudonyme du joueur, permet d'afficher ses actions ou de lui demander des choses dans la console
	 */
	private String pseudo;
	/***
	 * le jeton que possède le joueur, ce jeton sera placé à la colonne que ce joueur choisit lorsque c'est sont tour
	 */
	private Jeton jeton;
	
	/***
	 * constructeur du joueur, permet à ses enfants (aux classes qui l'extend) d'être des joueurs
	 * @param pseudo le pseudonyme du joueur
	 * @param jeton le jeton qu'il placera lorsqu'il en aura l'occasion
	 */
	protected Joueur(String pseudo, Jeton jeton) {
		this.pseudo = pseudo;
		this.jeton = jeton;
	}
	
	/***
	 * getter du pseudo du joueur
	 * @return le pseudonyme
	 */
	public String getPseudo() {
		return this.pseudo;
	}
	
	/***
	 * getter du jeton du joueur
	 * @return le jeton
	 */
	public Jeton getJeton() {
		return this.jeton;
	}
	
	/***
	 * la méthode que possèdent et utilisent tous les enfants
	 * cette méthode permet de récupérer le numéro de colonne dans lequel veut jouer le joueur
	 * on part du principe que l'entier retourné est correct et vérifié par cette fonction
	 * @param plateau le plateau dans lequel le joueur va se déplacer
	 * @return le numéro de colonne dans lequel le joueur va placer un jeton [0,6] et non pas [1,7]
	 */
	public abstract int ChoisirColonne(Plateau plateau);

}
