package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControlleurChoixJoueurs {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private int numJoueurQuiCommence;
	
	@FXML private AnchorPane fond;
	
	@FXML private Circle jetonRouge;
	@FXML private Circle jetonJaune;
	@FXML private Circle jetonOrange;
	
	@FXML private Text textJetonOrange;
	
	@FXML private ChoiceBox<String> mode1;
	@FXML private ChoiceBox<String> mode2;
	
	public void initChoiceBoxes() {
		
		mode1.getItems().addAll("Humain","Bot très facile","Bot facile", "Bot moyen", "Bot difficile");
		mode2.getItems().addAll("Humain","Bot très facile","Bot facile", "Bot moyen", "Bot difficile");
		
		mode1.setValue("Humain");
		mode2.setValue("Humain");
	}
	
	public void setColorBG(Color couleur) {
		if (couleur == Color.BLACK)
			fond.setStyle("-fx-background-color: #333333");
		else if (couleur == Color.WHITE)
			fond.setStyle("-fx-background-color: #ffffff");
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
	
	public void retour(ActionEvent e) throws IOException {
		scenePrincipal(e);
	}
	
	public void commencer(ActionEvent e) throws IOException {
		sceneJeu(e);
	}
	
	private void sceneJeu(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Jeu.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Puissance 4 - Jeu");
		ControlleurJeu controlleurJeu = loader.getController();
		controlleurJeu.setColorBG(Preferences.getColorModeNuit());
		stage.show();
	}

	public void barreQuitter(ActionEvent e) {
		ControlleurBarreSuperieur.quitter(e);
	}

	public void choixJetonOrange() {
		jetonRouge.setFill(Color.GREY);
		jetonOrange.setFill(Color.ORANGE);
		jetonJaune.setFill(Color.GREY);
		textJetonOrange.setVisible(true);
		numJoueurQuiCommence = -1;
	}
	
	public void choixJetonRouge() {
		jetonRouge.setFill(Color.RED);
		jetonOrange.setFill(Color.GREY);
		jetonJaune.setFill(Color.GREY);
		textJetonOrange.setVisible(false);
		numJoueurQuiCommence = 0;
	}
	
	public void choixJetonJaune() {
		jetonRouge.setFill(Color.GREY);
		jetonOrange.setFill(Color.GREY);
		jetonJaune.setFill(Color.YELLOW);
		textJetonOrange.setVisible(false);
		numJoueurQuiCommence = 1;
	}
	
	public void resetJetons() {
		choixJetonOrange();
	}
}
