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
			Parent root = FXMLLoader.load(getClass().getResource("Main_menu.fxml"));
			
			Scene scene = new Scene(root, Color.BLACK);
			
			Image icon = new Image("icon.png");
			stage.getIcons().add(icon);
			stage.setTitle("Puissance 4 - Main menu");
			stage.setWidth(960);
			stage.setHeight(540);
			stage.setResizable(false);
			//stage.setFullScreen(true);
			//stage.setFullScreenExitHint("Appuyez sur 'Echap' pour réduire la fenêtre");
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
