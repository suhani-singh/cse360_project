package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mysqlconnect {
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
	public static ObservableList<tableData> getData() {		
		Connection conn = ConnectDb();
		ObservableList<tableData> list = FXCollections.observableArrayList();
		try {
//			Statement st = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM paststrategies.master_table");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tableData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}		
		return list;
	}
}
