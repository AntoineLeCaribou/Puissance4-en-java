package main;

import jeton.JetonJaune;
import jeton.JetonRouge;
import jeu.Partie;
import joueur.Humain;
import joueur.OrdinateurAleatoireUnPeuIntelligent;
import joueur.OrdinateurMinMaxDepth1;
import joueur.OrdinateurMinMaxDepthN;

public class Main {

	public static void main(String[] args) {
		
		JetonRouge jetonRouge = new JetonRouge();
		JetonJaune jetonJaune = new JetonJaune();
		
		Humain joueur1 = new Humain("joueur 1", jetonRouge);
		//OrdinateurAleatoire joueur1 = new OrdinateurAleatoire("bot 1", jetonRouge);
		//OrdinateurAleatoireUnPeuIntelligent joueur1 = new OrdinateurAleatoireUnPeuIntelligent("bot 1", jetonRouge);
		//OrdinateurStrategique joueur1 = new OrdinateurStrategique("bot 1", jetonRouge);
		
		//OrdinateurAleatoire joueur2 = new OrdinateurAleatoire("bot 2", jetonJaune);
		//Humain joueur2 = new Humain("joueur 2", jetonJaune);
		//OrdinateurAleatoireUnPeuIntelligent joueur2 = new OrdinateurAleatoireUnPeuIntelligent("bot 2", jetonJaune);
		OrdinateurMinMaxDepthN joueur2 = new OrdinateurMinMaxDepthN("bot 2", jetonJaune, 6);
		
		int ordre = 1; //le joueur qui commence est al�atoire
		@SuppressWarnings("unused")
		Partie partie = new Partie(joueur1, joueur2, ordre);
	}

}
