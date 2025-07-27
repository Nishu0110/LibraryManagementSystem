package librarySystem;
import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class DBConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/library_db";
	
	private static final String user = "your username";
	
	private static final String password = "your password";
	
	//connection of DB
	
	public static Connection getConnection() throws SQLException {
		return
		 DriverManager.getConnection(url, user, password);
	}

}
