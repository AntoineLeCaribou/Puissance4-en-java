package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ControlleurBarreSuperieur {

	public static void quitter(ActionEvent e) {
		Platform.exit();
	}
}
