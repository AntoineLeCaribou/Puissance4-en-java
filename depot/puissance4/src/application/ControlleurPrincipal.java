package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControlleurPrincipal {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private AnchorPane fond;

	public void quitter(ActionEvent e) {
		Platform.exit();
	}
	
	public void option(ActionEvent e) throws IOException {
		sceneOptions(e);
	}

	public void jouer(ActionEvent e) {
		System.out.println("jouer");
	}
	
	private void sceneOptions(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Options.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Puissance 4 - Options");
		ControlleurOptions controlleurOptions = loader.getController();
		controlleurOptions.resetBoutonModeNuit();
		controlleurOptions.setColorBG(Preferences.getColorModeNuit());
		stage.show();
	}
	
	private void sceneJeu(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChoixJoueur.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Puissance 4 - Choix Des Joueurs");
		ControlleurOptions controlleurOptions = loader.getController();
		controlleurOptions.resetBoutonModeNuit();
		controlleurOptions.setColorBG(Preferences.getColorModeNuit());
		stage.show();
	}
	
	public void setColorBG(Color couleur) {
		if (couleur == Color.BLACK)
			fond.setStyle("-fx-background-color: #333333");
		else if (couleur == Color.WHITE)
			fond.setStyle("-fx-background-color: #ffffff");
	}
}
