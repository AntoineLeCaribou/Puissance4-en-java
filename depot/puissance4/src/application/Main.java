package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			
			ControlleurPrincipal controlleurPrincipal = loader.getController();
			controlleurPrincipal.setColorBG(Preferences.getColorModeNuit());
			
			Image icon = new Image("icon.png");
			stage.getIcons().add(icon);
			stage.setTitle("Puissance 4 - Main menu");
			stage.setWidth(960);
			stage.setHeight(600);
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
