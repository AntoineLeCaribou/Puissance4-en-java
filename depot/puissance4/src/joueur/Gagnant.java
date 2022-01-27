package joueur;

public enum Gagnant {
	
	Gagne(" a gagné la partie par puissance 4 !"),
	GrilleCompletee("Egalité ! La grille est remplie, plus personne ne peut jouer ..."),
	PasFinit("");
	
	private String phrase;
	
	private Gagnant(String phrase) {
		this.phrase = phrase;
	}
	
	public String getPhrase() {
		return this.phrase;
	}
}
