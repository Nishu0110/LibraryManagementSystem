package librarySystem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LibraryApp extends JFrame {
	
	Library library = new Library();
	DefaultTableModel model;
	private String role;
	
	public LibraryApp(String userRole) {
		this.role = userRole;
		
		setTitle("Library Management System - WELCOME : "+ role);
		setSize(800, 500);
		setLayout(new FlowLayout());
		
		
		JButton addButton = new JButton("Add Book");
		JButton deleteButton = new JButton("Delete Book");
		JButton issueButton = new JButton("Issue Book");
		JButton returnButton = new JButton("Return Book");
		JButton logoutButton = new JButton("Logout");
		JButton viewButton = new JButton("View Books");
		
	
		
		
		// role as per login with admin full access and Librarian Limited access
		
		if(role.equals("Admin")) {
			add(addButton);
			add(deleteButton);
		}
		
		add(issueButton);
		add(returnButton);
		add(viewButton);
		add(logoutButton);
		
		
		
		//Button Actions
		
		
		addButton.addActionListener(e -> Library.addBook());
		deleteButton.addActionListener(e -> Library.deleteBook());
		issueButton.addActionListener(e -> Library.issueBook());
		returnButton.addActionListener(e -> Library.returnBook());
		viewButton.addActionListener(e -> Library.viewBooks());
		
		
		logoutButton.addActionListener(e ->{
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to Logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
			
			if(confirm == JOptionPane.YES_OPTION) {
				this.dispose(); // CLOSE CURRENT WINDOW
				new LoginScreen();// OPEN LOGIN WINDOW AGAIN
			}
		});
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	}

