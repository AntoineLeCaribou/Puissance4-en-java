package jeton;

/***
 * modélise un jeton de puissance 4 de couleur rouge
 * @author antoi
 *
 */
public class JetonRouge extends Jeton{

	/***
	 * contructeur d'un jeton de couleur rouge, génére naturellement son inverse (un jeton jaune) dans sont parent
	 */
	public JetonRouge() {
		super(Couleur.Rouge, new JetonJaune(true));
	}
	
	/***
	 * contructeur d'un jeton de couleur rouge, ne génére pas son parent (pour éviter une boucle infini)
	 * @param nePasGenererContraire sert juste à créer un autre constructeur
	 */
	public JetonRouge(boolean nePasGenererContraire) {
		super(Couleur.Rouge, null);
	}
}
