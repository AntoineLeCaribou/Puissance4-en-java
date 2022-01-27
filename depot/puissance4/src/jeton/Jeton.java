package jeton;

public abstract class Jeton {
	
	private Couleur couleur;
	private Jeton contraire;

	public Jeton(Couleur couleur, Jeton contraire) {
		this.couleur = couleur;
		this.contraire = contraire;
	}

	public Couleur getCouleur() {
		return couleur;
	}
	
	public Jeton getContraire() {
		return contraire;
	}
	
	public boolean equals(Jeton jeton) {
		if (jeton == null)
			return false;
		return couleur == jeton.couleur;
	}
}
