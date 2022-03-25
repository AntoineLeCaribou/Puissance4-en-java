package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControlleurOptions {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private ToggleButton boutonModeNuit;
	@FXML
	private AnchorPane fond;
	
	public void appliquer(ActionEvent e) throws IOException {
		boolean modeActuel = boutonModeNuit.isSelected();
		Preferences.setModeNuit(modeActuel);
		setColorBG(Preferences.getColorModeNuit());
	}
	
	public void retour(ActionEvent e) throws IOException {
		scenePrincipal(e);
	}
	
	public void resetBoutonModeNuit() {
		boolean modeSauvegarde = Preferences.getModeNuit();
		boutonModeNuit.setSelected(modeSauvegarde);
	}

	private void scenePrincipal(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Puissance 4 - Menu Principal");
		ControlleurPrincipal controlleurPrincipal = loader.getController();
		controlleurPrincipal.setColorBG(Preferences.getColorModeNuit());
		stage.show();
	}

	public void setColorBG(Color couleur) {
		if (couleur == Color.BLACK)
			fond.setStyle("-fx-background-color: #333333");
		else if (couleur == Color.WHITE)
			fond.setStyle("-fx-background-color: #ffffff");
	}
	
	public void barreQuitter(ActionEvent e) {
		ControlleurBarreSuperieur.quitter(e);
	}
}
