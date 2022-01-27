package joueur;

import jeton.Jeton;
import plateau.Plateau;

public abstract class Joueur {

	private String pseudo;
	private Jeton jeton;
	
	protected Joueur(String pseudo, Jeton jeton) {
		this.pseudo = pseudo;
		this.jeton = jeton;
	}
	
	public String getPseudo() {
		return this.pseudo;
	}
	
	public Jeton getJeton() {
		return this.jeton;
	}
	
	public abstract int ChoisirColonne(Plateau plateau);

}
