package jeton;

public class JetonJaune extends Jeton{

	public JetonJaune() {
		super(Couleur.Jaune, new JetonRouge(true));
	}
	
	public JetonJaune(boolean nePasGenererContraire) {
		super(Couleur.Jaune, null);
	}
}
