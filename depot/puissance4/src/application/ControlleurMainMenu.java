package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ControlleurMainMenu {

	public void quitter(ActionEvent e) {
		Platform.exit();
	}
	
	public void option(ActionEvent e) {
		System.out.println("options");
	}

	public void jouer(ActionEvent e) {
		System.out.println("jouer");
	}
}
