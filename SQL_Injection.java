package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;

import java.io.IOException;

//Suhani Singh
public class SQL {

	@FXML
	private Button login;
	@FXML
	private Label wrongLogIn;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	public void userLogIn(ActionEvent event) throws IOException //method that correlates to the "Log In" button
	{
		String u = username.getText();
		String p = password.getText();
		
		if(u.contains("SELECT") || p.contains("SELECT") || u.contains("FROM") || p.contains("FROM")) //checks if t
		{
			wrongLogIn.setText("INVALID LOGIN - HACKER REPORTED"); 
		}
		
		else //if the wrong password or user name is entered
		{
			wrongLogIn.setText("LOG IN SUCCESS"); //print
		}
	}
}
