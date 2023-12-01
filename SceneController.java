//Implements Switching Scenes and implements functionality to the DuoPush System -- Shannen Aganon

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneController {

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
private TextField enteredEmployeeID;
@FXML
private Label popUp;
@FXML
private Button submitEmployeeID;
 
//Switches to the Login Page -- Shannen Aganon
 public void switchToScene1(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("LoginScreen1.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
 
 //Switches to the DuoPush Page -- Shannen Aganon
 //This aligns with the design of EffortLogger as it ensures that only the authorized employees of the company has access to EffortLogger's information and features. 
 //The results of the Duo-Push security demonstrates the design goals for this prototype, as it ensures proper security measures for the applicaiton. 
 public void switchToScene2(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("SecurityMeasure.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
 
 //Switches to the EffortLogger's Landing Page
 public void switchToScene3(ActionEvent event) throws IOException {
	 if (enteredEmployeeID.getText().toString().isEmpty()) {
			popUp.setText("Field must be filled out!");
			popUp.setTextFill(Color.RED);
		}
		
	 
	 //Duo-Push Security Measures
		else if (enteredEmployeeID.getText().length() != 5 ) {
			if (enteredEmployeeID.getText().length() < 5) {
				popUp.setText("Employee ID Input must be 5 Characters!");
				popUp.setTextFill(Color.RED);
			}
			if (enteredEmployeeID.getText().length() > 5) {
				popUp.setText("Employee ID Input must be 5 Characters!");
				popUp.setTextFill(Color.RED);
				}
		}
	 
		else {
			Parent root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
		    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	 }
 
 //Switches to the Sign-Up Landing Page
 public void switchToSignUp(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("Account.fxml"));
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
	 
	 public void loadData(ActionEvent event) throws IOException {
	      root = FXMLLoader.load(getClass().getResource("HistoricalData.fxml"));
	      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	      scene = new Scene(root);
	      stage.setScene(scene);
	      stage.show();
	     }
	 
	 public void planningLandingPage(ActionEvent event) throws IOException {
	      root = FXMLLoader.load(getClass().getResource("PlanningPokerExample.fxml"));
	      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	      scene = new Scene(root);
	      stage.setScene(scene);
	      stage.show();
	     }
	 
}
