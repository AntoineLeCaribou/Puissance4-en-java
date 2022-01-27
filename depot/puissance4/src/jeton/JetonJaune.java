package jeton;

/***
 * modélise un jeton de puissance 4 de couleur jaune
 * @author antoi
 *
 */
public class JetonJaune extends Jeton{

	/***
	 * contructeur d'un jeton de couleur jaune, génére naturellement son inverse (un jeton rouge) dans sont parent
	 */
	public JetonJaune() {
		super(Couleur.Jaune, new JetonRouge(true));
	}
	
	/***
	 * contructeur d'un jeton de couleur jaune, ne génére pas son parent (pour éviter une boucle infini)
	 */
	public JetonJaune(boolean nePasGenererContraire) {
		super(Couleur.Jaune, null);
	}
}
