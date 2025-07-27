package librarySystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class LoginScreen extends JFrame{
	
	private JTextField userField;
	private JPasswordField passField;
	private JComboBox<String> roleBox;
	
	
	public LoginScreen() {
		setTitle("Library Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 248, 255));
		add(panel);
		
		JLabel title = new JLabel("Library Management System");
		title.setFont(new Font("SansSerif", Font.BOLD, 16));
		title.setBounds(80, 20, 260, 30);
		panel.add(title);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(50, 70, 80, 25);
		panel.add(userLabel);
		
		userField = new JTextField();
		userField.setBounds(140, 70, 200, 25);
		panel.add(userField);
		
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(50, 110, 80, 25);
		panel.add(passLabel);
		
		passField = new JPasswordField();
		passField.setBounds(140, 110, 200, 25);
		panel.add(passField);
		
		
		JLabel roleLabel = new JLabel("Role:");
		roleLabel.setBounds(50, 150, 80, 25);
		panel.add(roleLabel);
		
		roleBox = new JComboBox<>(new String[] {"Admin", "Librarian"});
		roleBox.setBounds(140, 150, 200, 25);
		panel.add(roleBox);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(140, 200, 90, 30);
		panel.add(loginButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(250, 200, 90, 30);
		panel.add(clearButton);
		
		
		loginButton.addActionListener(e -> Login());
		clearButton.addActionListener(e -> {
			userField.setText("");
			passField.setText("");
		});
		setVisible(true);
	}
	
	
	private void Login() {
		String username = userField.getText().trim();
		String password = new String(passField.getPassword());
		String role = (String) roleBox.getSelectedItem();
		
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM users WHERE username=? AND password=? AND role=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, role);
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				
				JOptionPane.showMessageDialog(this,"Login Successful as a " +role);
				
				//opens main window based on role
				dispose();
				new LibraryApp(role);
						
			}
			else {
				JOptionPane.showMessageDialog(this,"Invalid Username or Password or Role.");
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(this, "Database Error: " +ex.getMessage());
			
		}
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(LoginScreen :: new);
	}
}
