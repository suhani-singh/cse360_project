package application;
// Ketaki
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

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
 private Button LogOut;
 @FXML
 private Button work;
 

// To go to Log Out
public void goToLogIn(ActionEvent event) throws IOException {
	 root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
	 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	 scene = new Scene(root);
	 stage.setScene(scene);
	 stage.show();
	}
 
 
// To go to Duo push
public void goToDuoPush(ActionEvent event) throws IOException {
	 root = FXMLLoader.load(getClass().getResource("DuoPush.fxml"));
	 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	 scene = new Scene(root);
	 stage.setScene(scene);
	 stage.show();
	}

// signUp Button
public void goToSignUp(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("AccountCreation.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	}
// Team worked on
public void PlanningPokerLanding(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("PlanningPokerPage.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	}
// Team worked on
 public void startNewRound(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("PlanningPokerNewRound.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
 // Team worked on
 public void loadData(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("HistoricalData.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
 
 // Team worked on
 public void goBack(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("PlanningPokerPage.fxml"));
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
 
 // Switch to Feedback Page
 public void FeedBack(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("FeedBackPage.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	}
 
 // Switch to Workschedule
 public void WorkSchedule(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("WorkSchedule.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	}
}