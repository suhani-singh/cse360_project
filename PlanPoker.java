package application;
/**
 * Shannen Aganon
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;


public class PlanPoker {
	
	@FXML
	private Label label;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private Button back;
	@FXML
    private PasswordField player1;

    @FXML
    private PasswordField player2;

    @FXML
    private PasswordField player3;

    @FXML
    private PasswordField player4;

    @FXML
    private PasswordField player5;

    @FXML
    private PasswordField player6;

    @FXML
    private PasswordField player7;

    @FXML
    private PasswordField player8;

    @FXML
    private PasswordField player9;
    
    @FXML
    private PasswordField player10;
    
    @FXML
    private Label result;
	
    @FXML 
    private Label warning;
    
    @FXML
    private Button submitPoints;
    
    
    //Event Handler --> When they submit the points of all th people 
    public void checkInput(ActionEvent event) throws IOException {
		displayAverage();
	}
    
    //Go Back
	public void backToPlanningPoker(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("PlanningPokerPage.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
		}
    
    public void displayAverage () {
    	result.setText("");
    	warning.setText("");
    	
    	//Arrays needed for this program
    	List<String> validPlayers = new ArrayList<>();
    	List<Integer> validValues = new ArrayList<>();
    	List<String> invalidPlayers = new ArrayList<>();
    	List<String> emptyPlayers = new ArrayList<>();
    	
    	
    	//Conditions for each player to correctly check the points
    	
    	//First check if they are valid
    	if (isValidInput(player1.getText())) {
            validPlayers.add("Player 1");
            validValues.add(Integer.parseInt(player1.getText()));
        }
    	else if (isInputEmpty(player1.getText())) {
    		emptyPlayers.add("Player 1");
    	}
    	else {
            invalidPlayers.add("Player 1");
        }

        if (isValidInput(player2.getText())) {
            validPlayers.add("Player 2");
            validValues.add(Integer.parseInt(player2.getText()));
        }
        else if (isInputEmpty(player2.getText())) {
    		emptyPlayers.add("Player 2");
    	}
        else {
            invalidPlayers.add("Player 2");
        }
        if (isValidInput(player3.getText())) {
            validPlayers.add("Player 3");
            validValues.add(Integer.parseInt(player3.getText()));
        }
        else if (isInputEmpty(player3.getText())) {
    		emptyPlayers.add("Player 3");
    	}
        else {
            invalidPlayers.add("Player 3");
        }
      
        if (isValidInput(player4.getText())) {
            validPlayers.add("Player 4");
            validValues.add(Integer.parseInt(player4.getText()));
        }
        else if (isInputEmpty(player4.getText())) {
    		emptyPlayers.add("Player 4");
    	}
        else {
            invalidPlayers.add("Player 4");
        }
        if (isValidInput(player5.getText())) {
            validPlayers.add("Player 5");
            validValues.add(Integer.parseInt(player5.getText()));
        }
        else if (isInputEmpty(player5.getText())) {
    		emptyPlayers.add("Player 5");
    	}
        else {
            invalidPlayers.add("Player 5");
        }
        if (isValidInput(player6.getText())) {
            validPlayers.add("Player 6");
            validValues.add(Integer.parseInt(player6.getText()));
        }
        else if (isInputEmpty(player6.getText())) {
    		emptyPlayers.add("Player 6");
    	}
        else {
            invalidPlayers.add("Player 6");
        }
        if (isValidInput(player7.getText())) {
            validPlayers.add("Player 7");
            validValues.add(Integer.parseInt(player7.getText()));
        }
        else if (isInputEmpty(player7.getText())) {
    		emptyPlayers.add("Player 7");
    	}
        else {
            invalidPlayers.add("Player 7");
        }
        if (isValidInput(player8.getText())) {
            validPlayers.add("Player 8");
            validValues.add(Integer.parseInt(player8.getText()));
        }
        else if (isInputEmpty(player8.getText())) {
    		emptyPlayers.add("Player 8");
    	}
        else {
            invalidPlayers.add("Player 8");
        }
        if (isValidInput(player9.getText())) {
            validPlayers.add("Player 9");
            validValues.add(Integer.parseInt(player9.getText()));
        }
        else if (isInputEmpty(player9.getText())) {
    		emptyPlayers.add("Player 9");
    	}
        else {
            invalidPlayers.add("Player 9");
        }
        if (isValidInput(player10.getText())) {
            validPlayers.add("Player 10");
            validValues.add(Integer.parseInt(player10.getText()));
        }
        else if (isInputEmpty(player10.getText())) {
    		emptyPlayers.add("Player 10");
    	}
        else {
            invalidPlayers.add("Player 10");
        }
        
        
        
        //If there are no players
        if (validPlayers.isEmpty()) {
        	result.setText("0");
            result.setTextFill(Color.BLUE);
        }
        
        
        //Calculate the average
        if (!invalidPlayers.isEmpty()) {
        	warning.setText(String.join(", ", invalidPlayers) + " have entered incorrect values!");
            warning.setTextFill(Color.RED);
        }
    	
        else if (!validPlayers.isEmpty()) {
    	   
    	   int sum = 0;
           for (Integer value : validValues) {
               sum += value;
           }

           // Calculate the average
           double average = (double) sum / validPlayers.size();

            // Display or use the average as needed
            result.setText(String.valueOf(average));
            result.setTextFill(Color.BLUE);
        }
    	
    }
    
    
    //Check to see if the input is valid
    private boolean isValidInput(String input) {
        try {
            int value = Integer.parseInt(input);
            return value >= 1 && value <= 5;
        } catch (NumberFormatException e) {
            return false; // Not a valid integer
        }
    }
    
    //Check to see if the input is empty
    private boolean isInputEmpty(String input) {
    	if (input.isEmpty()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
}
