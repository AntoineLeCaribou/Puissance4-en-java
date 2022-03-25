package joueur;

/***
 * structure qui sauvgarde le score d'une grille et son index de la colonne de la grille evaluée
 * @author antoi
 */
public class Score {
	
	/***
	 * le score de la grille sauvegardé
	 */
	private int score;
	/***
	 * l'index de la colonne du score de la grille sauvegardé
	 */
	private int index;
	
	/***
	 * constructeur d'un score d'une grille
	 * @param score le score de la grille, un entier qui peut être négatif
	 * @param index l'index de la colonne de ce score de la grille concernée
	 */
	public Score(int score, int index) {
		this.score = score;
		this.index = index;
	}
	
	/***
	 * getter du score de la grille
	 * @return le score
	 */
	public int getScore() {
		return score;
	}

	/***
	 * getter de l'index de la colonne de la grille
	 * @return l'index
	 */
	public int getIndex() {
		return index;
	}

	/***
	 * permet de redéfinir l'index
	 * @param index l'index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
}
