package librarySystem;
import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class DBConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/library_db";
	
	private static final String user = "root";
	
	private static final String password = "Nish0110";
	
	//connection of DB
	
	public static Connection getConnection() throws SQLException {
		return
		 DriverManager.getConnection(url, user, password);
	}

}