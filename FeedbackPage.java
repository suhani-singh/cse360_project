/**---------------------------------------------------------------------------------------------------
 * Author: Taequanson Clarke 
 * Description: This is the user report/alert system prototype for EffortLogger V2.0. 
 * The code below is responsible for the main page with two aspects: the bulletin tab and the input tab. 
 * The bulletin tab display all the reports and alerts currently reported in a list. 
 * The input tab is where a user may make and submit a report or an alert. 
 -----------------------------------------------------------------------------------------------------**/

package application;
import java.io.IOException;
/**---------------------------IMPORT STATEMENTS-----------------------------------**/ 
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**-------------------------------------------------------------------------------**/

//Main class for feedback page. 
public class FeedbackPage{
	
	/**----VARIABLES FOR ATTRIBUTES-----**/
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private Button start;
	@FXML
	private Button back;
	@FXML
	private Tab BULLETIN, COMPLAIN; //tabs
	@FXML
	private TextField titleInput; //input for title of report 
	@FXML
	private RadioButton highPriorityButton, mediumPriorityButton, lowPriorityButton; //buttons specifying report's priority 
	@FXML
	private TextArea descriptionInput; //input for detailed description for the report
	@FXML
	private Button submitButton; //submit button for report 
	@FXML
	private ListView<Object> alertViewList; //the list object for the the bulletin tab 
	
	ArrayList<ListItem> complaints = new ArrayList<ListItem>(); //Array of ListItem Objects (see ListItem.java for more details)
	
	/**
	 * METHOD: makeComplaint - constructs a complaint from user input and adds it the complaint list (variable: complaints)
	 * @param event
	 */
	public void makeComplaint(ActionEvent event) {
		
		try { // Exception handling 
			
			int priority; //variable to store priority integer
			
			String title = titleInput.getText(); //retrieve title from user input 
			String description = descriptionInput.getText(); //retrieve description from user input 
			
			/**------Depending on which button...------------*/
			if(highPriorityButton.isSelected()) { 
				priority = 3; 
			}else if(mediumPriorityButton.isSelected()) {
				priority = 2; 
			}else if(lowPriorityButton.isSelected()) {
				priority = 1; 
			}else {
				priority = 0;
			}
			/**-------...assign a priority value--------------*/ 
			
			/**
			 * add a new ListItem object with report info to the list of complaints
			 * ------------(see ListItem.java for more details)--------------------
			 */
			complaints.add(0, new ListItem(title, description, priority));  
			
			/*-------------------------------------------------------------*/
			alertViewList.getItems().add(this.toListView(complaints.get(0))); //Add latest submission to bulletin list 
		
		}catch(Exception e) {
			System.out.println(e); //print to console any exception 
		}
		
	}
	
	/**
	 * METHOD: toListView - takes a ListItem object and formats it into a String object to be displayed on the alert bulletin 
	 * @param item
	 * @return String
	 */
	private String toListView(ListItem item) {
		
		final String COLOR; //color to represent priority
		String date; //date of the report's creation
		String listView; //The current displayed String item 
		
		if(item.isUpdated()) {
			date = item.getDate(false); //get date edited 
		}else {
			date = item.getDate(true); //get date created 
		}
		
		/**----------SET PRIORITY COLOR-----------*/
		switch(item.getPriority()) {
		 	case 1: COLOR = "BLUE"; 
		 		break;
		 	case 2: COLOR = "YELLOW"; 
		 		break; 
		 	case 3: COLOR = "RED"; 
		 		break; 
		 	default: COLOR = ""; 
		 		break; 
		}
		/**---------------------------------------*/
		
		listView = item.getTitle() + "\t\t" + COLOR + "\t\t" + date; //format ListItem info into a string 
		
		return listView; //return formatted string 
	}
	 public void backToLanding(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		}

}
