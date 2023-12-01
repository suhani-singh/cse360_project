package application;
// Suhanni, Michelle, Shannen
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//class that connects to the mysql database
public class sqlConnect {
	Connection conn = null;
	
	public static Connection ConnectDb() {
		try {
			String user = "root";
			String pw = "root";
			String url = "jdbc:mysql://localhost:3306/paststrategies";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,pw);
			JOptionPane.showMessageDialog(null, "Connection Established");
			return conn;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	//this method runs connects to the database called projectrundb and goes through the table runs
	//that handles all the projectruns
	public static ObservableList<Projectrun> getDataRuns(){
		//establish connection
		Connection conn = ConnectDb();
		//create a list of projectruns
		ObservableList<Projectrun> list = FXCollections.observableArrayList();
		try {
			//get all projectruns from database into a sql query
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM paststrategies.projectrundb");
			//execute that sql query
			ResultSet rs = ps.executeQuery();
			//go through all rows of table and add them to the list
			while(rs.next()) {
				Boolean status = false;
				if(rs.getString(5).equals("1")) {
					status = true;
				} 
				list.add(new Projectrun(Integer.parseInt(rs.getString(1)), rs.getString(2),rs.getString(3), rs.getString(4), status));
			}
			conn.close();
		} catch (Exception e){
			System.out.println(e);
		}
		return list;
	}
}
