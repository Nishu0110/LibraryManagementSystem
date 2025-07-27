package librarySystem;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Library {
	
	public static void addBook() {
		String id = JOptionPane.showInputDialog("Book ID :");
		String title = JOptionPane.showInputDialog("Title :");
		String author = JOptionPane.showInputDialog("Author :");
		
		try(Connection con = DBConnection.getConnection()){
			String sql = "INSERT INTO books(id, title, author, status) VALUES(?, ?, ?, 'Available')";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, author);
			stmt.execute();
			
			JOptionPane.showMessageDialog(null, "Book Added.");
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " +e.getMessage());
		}
		
	}
	
	
	public static void deleteBook() {
		
		String id = JOptionPane.showInputDialog("Enter Book ID to Delete: ");
		
		try(Connection con = DBConnection.getConnection()) {
			
			String sql = "DELETE FROM books  WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			int rows = stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, rows > 0? "Book Deleted." : "Book not Found.");
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " +e.getMessage());
		}
	}
	
	
	
	public static void issueBook() {
		
		String id = JOptionPane.showInputDialog("Enter Book ID to issue:");
		
		try(Connection con = DBConnection.getConnection()){
			String checkSql = "SELECT status FROM books WHERE id=?";
			PreparedStatement checkStmt = con.prepareStatement(checkSql);
			checkStmt.setString(1, id);
			
			ResultSet rs = checkStmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("status").equalsIgnoreCase("Available")) {
					String updateSql = "UPDATE books SET status='Issued' WHERE id=?";
					
					PreparedStatement updateStmt = con.prepareStatement(updateSql);
					updateStmt.setString(1, id);
					updateStmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Book Issued.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Book Already Issued.");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Book not found.");
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " +e.getMessage());
		}
	}

	
	public static void returnBook() {
		String id = JOptionPane.showInputDialog("Enter Book ID to return:"); 
		
		try(Connection con = DBConnection.getConnection()){
			String checkSql = "SELECT status FROM books WHERE id=?";
			
			PreparedStatement checkStmt = con.prepareStatement(checkSql);
			checkStmt.setString(1, id);
			ResultSet rs = checkStmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("status").equalsIgnoreCase("Issued")) {
					String updateSql = "UPDATE books SET status='Available' WHERE id=?";
					
					PreparedStatement  updateStmt = con.prepareStatement(updateSql);
					updateStmt.setString(1, id);
					updateStmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Book Returned.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Book is not Issued.");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Book not Found.");
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " +e.getMessage());
		}
	}
	
	
	public static void viewBooks() {
		
		JFrame frame = new JFrame("Books List");
		String[] columns = {"ID", "Title", "Author", "Status"};
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		JTable table = new JTable(tableModel);
		
		
		try(Connection con = DBConnection.getConnection()){
			String sql = "SELECT * FROM books";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String status = rs.getString("status");
				
				String[] row = {id, title, author, status};
				tableModel.addRow(row);
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " +e.getMessage());
		}
		
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane);
		frame.setSize(500, 300);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}
