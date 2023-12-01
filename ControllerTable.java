package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ControllerTable implements Initializable{
	
	//list of attributes that are shown on the scenebuilder's screen, from the fxml
	
	@FXML
	private Label label;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	
	@FXML
    private Button addButton;
	
	@FXML
    private Button back;

    @FXML
    private TableColumn<Projectrun, Integer> col_ID;

    @FXML
    private TableColumn<Projectrun, String> col_task;
    
    @FXML
    private TableColumn<Projectrun, String> col_details;
    
    @FXML
    private TableColumn<Projectrun, String> col_members;
    
    @FXML
    private TableColumn<Projectrun, String> col_complaints;
    
    @FXML
    private TableColumn<Projectrun, Boolean> col_status;
    
    @FXML
    private TableView<Projectrun> table_view;

    @FXML
    private TextField projectidtext;

    @FXML
    private CheckBox taskcheckbox;
    
    @FXML
    private TextField memberstext;
    
    @FXML
    private TextField complaintstext;
    
    @FXML
    private Button refreshButton;
    
    @FXML
    private Button updateButton;

    @FXML
    private TextField tasktext;
    
    //list of project runs that is kept track of
    ObservableList<Projectrun> listM;
    int index = -1;
    
    //local variables for given connection to all events such as add/update/refresh/run
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    //this is to create a new project run, when the user clicks the add button
    @FXML
    void added(ActionEvent event) {
    	//connecting to backend sql database
    	conn = sqlConnect.ConnectDb();
    	//grabbing the values from the text fields and setting them into the sql fields
    	String sql = "insert into paststrategies.projectrundb (projectid, task, members, complaints, status) values (?, ?, ?, ?, ?)";
    	try {
    		pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(projectidtext.getText()));
            pst.setString(2, tasktext.getText());
            pst.setString(3, memberstext.getText());
            pst.setString(4, complaintstext.getText());
            boolean status = taskcheckbox.isSelected();
            pst.setBoolean(5, status);
            //executing sql statement
    		pst.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
  //this is to refresh and show an updated table after the user makes a change such as delete/update/add
    @FXML
    void refreshed(ActionEvent event) {
    	col_ID.setCellValueFactory(new PropertyValueFactory<Projectrun, Integer>("id"));
//    	col_details.setCellValueFactory(new PropertyValueFactory<Projectrun, String>("projectdetails"));
		col_task.setCellValueFactory(new PropertyValueFactory<Projectrun, String>("task"));
		col_members.setCellValueFactory(new PropertyValueFactory<Projectrun, String>("members"));
		col_complaints.setCellValueFactory(new PropertyValueFactory<Projectrun, String>("complaint"));
		col_status.setCellValueFactory(new PropertyValueFactory<Projectrun, Boolean>("status"));
		listM = sqlConnect.getDataRuns();
		table_view.setItems(listM);
		//this line keeps the table view sorting the rows in order of the project id, so project runs with the same id
		//are shown together
		table_view.getSortOrder().add(col_ID);
    }
    
  //this is to delete a project run, when the user selects that row from a table
    @FXML
    void deleted(ActionEvent event) {
    	ObservableList<Projectrun> pr;
    	pr =  table_view.getSelectionModel().getSelectedItems();
    	//connecting to backend sql database
    	conn = sqlConnect.ConnectDb();
		//grabbing the values from the text fields and setting them into the sql fields
    	String sql = "DELETE FROM paststrategies.projectrundb WHERE projectid = ? AND task = ? AND members = ? AND complaints = ? AND status = ?";
    	try {
    		pst = conn.prepareStatement(sql);
            pst.setInt(1, pr.get(0).getId());
            pst.setString(2, pr.get(0).getTask());
            pst.setString(3, pr.get(0).getMembers());
            pst.setString(4, pr.get(0).getComplaint());
            boolean status = pr.get(0).getStatus();
            pst.setBoolean(5, status);
            //executing sql statement
    		pst.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    //this is to update the status of a task, given the project id, task, and status of a row
    @FXML
    void updated(ActionEvent event) {
    	//connecting to backend sql database
    	conn = sqlConnect.ConnectDb();
    	//sql statement for updating
    	String sql = "UPDATE paststrategies.projectrundb SET status = ? WHERE projectid = ? AND task = ? AND members = ? AND complaints = ? AND status = ?";
    	try {
    		pst = conn.prepareStatement(sql);
    		//grabbing the values from the text fields and setting them into the sql fields
    		pst = conn.prepareStatement(sql);
            pst.setInt(2, Integer.parseInt(projectidtext.getText()));
            pst.setString(3, tasktext.getText());
            pst.setString(4, memberstext.getText());
            pst.setString(5, complaintstext.getText());
            boolean status = taskcheckbox.isSelected();
            pst.setBoolean(1, status);
            //executing sql statement
    		pst.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		col_ID.setCellValueFactory(new PropertyValueFactory<Projectrun, Integer>("id"));
//		col_details.setCellValueFactory(new PropertyValueFactory<Projectrun, String>("projectdetails"));
		col_task.setCellValueFactory(new PropertyValueFactory<Projectrun, String>("task"));
		col_members.setCellValueFactory(new PropertyValueFactory<Projectrun, String>("members"));
		col_complaints.setCellValueFactory(new PropertyValueFactory<Projectrun, String>("complaint"));
		col_status.setCellValueFactory(new PropertyValueFactory<Projectrun, Boolean>("status"));
		listM = sqlConnect.getDataRuns();
		table_view.setItems(listM);
		//this line keeps the table view sorting the rows in order of the project id, so project runs with the same id
		//are shown together
		table_view.getSortOrder().add(col_ID);
	}
    
	public void backToPlanningPoker(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("PlanningPokerPage.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
		}
}
