package jeton;

public class JetonRouge extends Jeton{

	public JetonRouge() {
		super(Couleur.Rouge, new JetonJaune(true));
	}
	
	public JetonRouge(boolean nePasGenererContraire) {
		super(Couleur.Rouge, null);
	}
}
