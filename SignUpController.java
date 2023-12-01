package application;
// Michelle, Ketaki and Shreya worked on account creation and username check
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignUpController {
	
	// All Variable Declarations
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private Button start;
	@FXML
	private TextField username;
	@FXML 
	private PasswordField password;
	@FXML
	private PasswordField passwordCheck;
	@FXML 
	private Button signUp;
	@FXML
	private Label result;
	@FXML
	private Button goToLogin;
	@FXML
	private Button Login;
	@FXML
	private Label wrongLogIn;
	@FXML
	private TextField username1;
	@FXML
	private PasswordField password1;
	
	private String user;
	private String pass;
	
	@FXML
	private TextField employeeID;
		
	/********************************************************************************
	 * Michelle Tam
	 * public void to go switch to new scenes based on the event handler chosen. 
	 *******************************************************************************/
	
	public void goCreateAccount(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		}
	public void goToLoginScreen(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		} 
	
	/**********************************************************************************************************
	 * Michelle Tam: 
	 * public void checkSignUp used to check if all password requirements are met, if so go back to login page
	 **********************************************************************************************************/
	public void checkSignUp(ActionEvent event) throws IOException {
	    boolean accountSuccess = false;
		// Check to see if all inputs are filled out first 
		if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || passwordCheck.getText().toString().isEmpty()) {
			result.setText("All Fields must be filled out!");
			result.setTextFill(Color.RED);
		}
		/**
		 * This will be the password check:
		 * 	- The password must be at least 8 characters
		 *  - The password must contain a special character
		 *  - The password must contain an upper case letter
		 *  - The password must contain a lower case letter
		 */
		else if (password.getText().length() < 8) {
			result.setText("Password Length must be at least 8 Characters!");
			result.setTextFill(Color.RED);
		}
		else if (!password.getText().matches(".*[!@#$%^&*()_+\\-\\[\\]{};':\",.<>/?].*")) {
			result.setText("Password Must Contain a Special Character!");
			result.setTextFill(Color.RED);
		}
		else if (!password.getText().matches(".*[A-Z].*")) {
			result.setText("Password Must Contain one Uppercase Letter!");
			result.setTextFill(Color.RED);
		}
		else if (!password.getText().matches(".*[a-z].*")) {
			result.setText("Password Must Contain one Lowercase Letter!");
			result.setTextFill(Color.RED);
		}
		// The password checker just insures the password is inputed correctly. 
		else if(!passwordCheck.getText().matches(password.getText())) {
			result.setText("The Password Does not Match the one Above!!");
		}
		// Successful creation of account 
		else {
			result.setText("Account Successfully Created!");
			result.setTextFill(Color.LAWNGREEN);
		}
		if (accountSuccess == true) {
		     root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
		     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		     scene = new Scene(root);
		     stage.setScene(scene);
		     stage.show();
		}
	}
	
//------------------------------------------------------------------------------------------------------------// 
	public String checkpassword(String password1) {
		 String passwordCheck = "Passwordexample.!";

		 String result1 = " ";
			/**
			 * This will be the password check:
			 * 	- The password must be at least 8 characters
			 *  - The password must contain a special character
			 *  - The password must contain an upper case letter
			 *  - The password must contain a lower case letter
			 */
			if (password1.length() < 8) {
				result1 = "Password Length must be at least 8 Characters!";
			}
			else if (!password1.matches(".*[!@#$%^&*()_+\\-\\[\\]{};':\",.<>/?].*")) {
				result1 = "Password Must Contain a Special Character!";

			}
			else if (!password1.matches(".*[A-Z].*")) {
				result1 = "Password Must Contain one Uppercase Letter!";
			}
			else if (!password1.matches(".*[a-z].*")) {
				result1 = "Password Must Contain one Lowercase Letter!";
			}
			// The password checker just insures the password is inputed correctly. 
			else if(!passwordCheck.equals(password1)) {
				result1 = "The Password Does not Match the one Above!";
			}
			// Successful creation of account 
			else{
				result1 = "Account Successfully Created!";
			}
		    return result1;
	}
	    
//------------------------------------------------------------------------------------------------------------//

	
	/****************************************************************************************************************
	 * Shreya Marria:
	 * public void userLogIn used to check the login requirements are met, if so then duo push will be activated. 
	 ****************************************************************************************************************/
    
    public void userLogIn(ActionEvent event) throws IOException //method that correlates to the "Log In" button
    {
        user = username1.getText();
        pass = password1.getText();
        boolean success = false;
        
        if(user.equals("user1") && pass.equals("Examplenumber.1")) //example user name and password correlation 1
        {
            wrongLogIn.setText("Login Successful!"); // message delivery if inputs are correct
            success = true;
        }
        else if(user.equals("user2") && pass.equals("Examplenumber.2")) //example user name and password correlation 2
        {
            wrongLogIn.setText("Login Successful!"); // message delivery if inputs are correct
            success = true;
        }
        else if(user.isEmpty() && pass.isEmpty()) //check if no information is added, prompted for accessibility 
        {
            wrongLogIn.setText("Please enter your information"); //print accordingly
        }
        else //if the wrong password or User name is entered
        {
            wrongLogIn.setText("Wrong username or password!"); //print accordingly
        }
        
        if (success == true ) {
            root = FXMLLoader.load(getClass().getResource("DuoPush.fxml"));
     		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
     		  scene = new Scene(root);
     		  stage.setScene(scene);
     		  stage.show();
          }
    }

}
