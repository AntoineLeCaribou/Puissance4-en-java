package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControlleurJeu {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private AnchorPane fond;
	
	public void barreQuitter(ActionEvent e) {
		ControlleurBarreSuperieur.quitter(e);
	}

	public void setColorBG(Color couleur) {
		if (couleur == Color.BLACK)
			fond.setStyle("-fx-background-color: #333333");
		else if (couleur == Color.WHITE)
			fond.setStyle("-fx-background-color: #ffffff");
	}
}
