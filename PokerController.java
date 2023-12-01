package application;
/*
 * Michelle Tam
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class PokerController {
	

	@FXML
	private Label label;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private Button start;
	@FXML
	private Button loadHistory;
	@FXML
	private Button goToPlay;
	@FXML
	private Button back;
	@FXML
	private Button back2;
	@FXML
	private Button feedBack;
	@FXML
	private Button DuoPush;
	@FXML
	private Button SignUp;
	@FXML
	private Button Strategies;
	@FXML
	private Button loadPastTasks;
	
	// Scene changes below
	public void loadTasks(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("LoadPastApproaches.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
		}
	 
	public void startNewRound(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("PlanningPokerNewRound.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
		}
	public void backToLanding(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
		}
	public void backToPlanningPoker(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("PlanningPokerPage.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
		}
	public void lookAtStrategies(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("LoadPastApproaches.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  
		 }
	public void lookAtHistory(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("FXMLDoc.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
}
