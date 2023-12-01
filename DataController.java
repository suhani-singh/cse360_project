package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DataController implements Initializable{
	
	@FXML
	private Label label;
	
	@FXML
	private Stage stage;
	
	@FXML
	private Scene scene;
	
	@FXML
	private Parent root;
	
	@FXML
	private Button backToPoker;
	
    @FXML
    private TableView<tableData> table_tasks;
    /**
     * ----------------------------------------------------------------------------------------------------------------------
     */
    @FXML
    private TableColumn<tableData, String> past_progress_col;
    
    @FXML
    private TableColumn<tableData, String> project_details_col;
    
    @FXML
    private TableColumn<tableData, String> timelines_col;
    
    @FXML
    private TableColumn<tableData, String> tasks_col;

    @FXML
    private TableColumn<tableData, String> approaches_col;

    @FXML
    private TableColumn<tableData, String> logs_col;
    /**
     * ----------------------------------------------------------------------------------------------------------------------
     */
    
    ObservableList<tableData> listM;
    
//    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	timelines_col.setCellValueFactory(new PropertyValueFactory<tableData, String>("Timelines"));
    	tasks_col.setCellValueFactory(new PropertyValueFactory<tableData, String>("Tasks"));
    	approaches_col.setCellValueFactory(new PropertyValueFactory<tableData, String>("Approaches"));
    	logs_col.setCellValueFactory(new PropertyValueFactory<tableData, String>("Logs"));
    	listM = mysqlconnect.getData();
    	table_tasks.setItems(listM);
    }

	public void backToPlanningPoker(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("PlanningPokerPage.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
		}
}
