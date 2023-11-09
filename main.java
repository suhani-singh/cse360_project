package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

//this main class sets the general stage for the simplistic and intuitive design for the EffortLogger system
//a method to change scenes to whatever fxml file is passed via parameters is included
public class Main extends Application {
	
	private static Stage stage;
	
    @Override
    public void start(Stage primaryStage) throws IOException {
    	//log in scene set up
    	stage = primaryStage; 
    	primaryStage.setResizable(false);
    	Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml")); //uses the scene builder 
        primaryStage.setTitle("Tu56");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    
    public void changeScene(String fxml) throws IOException //accepts corresponding fxml file to change the scene
    {
    	Parent p = FXMLLoader.load(getClass().getResource(fxml));
    	stage.getScene().setRoot(p);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
