package jeton;

public enum Couleur {
	Jaune('J'),
	Rouge('R');
	
	private char lettre;
	
	private Couleur(char lettre) {
		this.lettre = lettre;
	}
	
	public char getLettre() {
		return lettre;
	}
}
