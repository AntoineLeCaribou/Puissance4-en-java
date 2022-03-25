package jeton;

/***
 * modélise un jeton de puissance 4 de couleur jaune
 * @author antoi
 *
 */
public class JetonJaune extends Jeton{

	/***
	 * contructeur d'un jeton de couleur jaune, génére naturellement son inverse (un jeton rouge) dans son parent
	 */
	public JetonJaune() {
		super(Couleur.Jaune, new JetonRouge(true));
	}
	
	/***
	 * contructeur d'un jeton de couleur jaune, ne génére pas son parent (pour éviter une boucle infini)
	 * @param nePasGenererContraire sert juste à créer un autre constructeur
	 */
	public JetonJaune(boolean nePasGenererContraire) {
		super(Couleur.Jaune, null);
	}
}
