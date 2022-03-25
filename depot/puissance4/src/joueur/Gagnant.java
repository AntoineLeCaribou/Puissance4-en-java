package joueur;

/***
 * modélise l'état d'une partie de puissance 4
 * @author antoi
 */
public enum Gagnant {
	
	/***
	 * Gagne : si le joueur actif a gagné
	 */
	Gagne(" a gagné la partie par puissance 4 !"),
	/***
	 * GrilleCompletee : lorsque le dernier étage de la grille est remplie
	 */
	GrilleCompletee("Egalité ! La grille est remplie, plus personne ne peut jouer ..."),
	/***
	 * PasFinit : lorsque la partie est toujours en cours =(pas de gagnant et des emplacement restants)
	 */
	PasFinit("");
	
	/***
	 * une phrase que contient l'état de partie, cette phrase est lachée en fin de partie pour dire qui a gagné
	 */
	private String phrase;
	
	/***
	 * constructeur d'un état de partie
	 * @param phrase prend la phrase de fin en paramètre
	 */
	private Gagnant(String phrase) {
		this.phrase = phrase;
	}
	
	/***
	 * getter de la phrase
	 * @return la phrase de fin
	 */
	public String getPhrase() {
		return this.phrase;
	}
}
