package car4rent;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class User extends JFrame {

	//States/ Attributes
	private String username;
	private String fullName;
	private String homeAddress;
	private String phoneNumber;
		
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField fullNameTextField;
	private JTextField addressTextField;
	private JTextField phoneTextField;
	private JTextField textField;

	/**
	 * Launch this application window.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 81, 624, 2);
		contentPane.add(separator);
		
		JLabel lblCarrent = new JLabel("CAR-4-RENT");
		lblCarrent.setForeground(Color.BLUE);
		lblCarrent.setFont(new Font("Tahoma", Font.PLAIN, 52));
		lblCarrent.setBackground(Color.YELLOW);
		lblCarrent.setBounds(192, 13, 291, 63);
		contentPane.add(lblCarrent);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(40, 144, 86, 17);
		contentPane.add(lblUsername);
		
		JLabel lblFullName = new JLabel("FULL NAME");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(40, 196, 86, 17);
		contentPane.add(lblFullName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(40, 244, 86, 17);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("PHONE #");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(40, 290, 80, 15);
		contentPane.add(lblPhone);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(138, 143, 264, 18);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		fullNameTextField = new JTextField();
		fullNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fullNameTextField.setBounds(138, 194, 264, 19);
		contentPane.add(fullNameTextField);
		fullNameTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addressTextField.setColumns(10);
		addressTextField.setBounds(138, 242, 526, 19);
		contentPane.add(addressTextField);
		
		phoneTextField = new JTextField();
		phoneTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(138, 287, 264, 19);
		contentPane.add(phoneTextField);
		
		JLabel intro = new JLabel("PLEASE ENTER YOUR PERSONAL DETAILS IN BOX BELOW.");
		intro.setFont(new Font("Tahoma", Font.BOLD, 14));
		intro.setBounds(138, 94, 448, 36);
		contentPane.add(intro);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean pass = false;
				
				while(username == null || fullName == null || homeAddress == null || phoneNumber == null) {
					username = usernameTextField.getText();
					fullName = fullNameTextField.getText();
					homeAddress = addressTextField.getText();
					phoneNumber = phoneTextField.getText();
					pass = true;
				}	

				
				if(pass == true) {
					saveNewUser();
					Vehicle.start();
				}
				else {
					JOptionPane.showMessageDialog(null, "!!!!SORRY RETRY AGAIN. ALL FIELD MUST BE FILLED OUT PROPERTY!!!!");
					User.start();
				}
					
				dispose();
				
			
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEnter.setBounds(225, 335, 221, 42);
		contentPane.add(btnEnter);
		
		JLabel notice = new JLabel("PLEASE REPLACE ALL SPACE WITH AN UNDERSCORE \"_\".");
		notice.setBounds(12, 396, 397, 16);
		contentPane.add(notice);
		
		JLabel label = new JLabel("DATE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(577, 13, 50, 36);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setText("07/26/2019");
		textField.setColumns(10);
		textField.setBounds(572, 50, 86, 22);
		contentPane.add(textField);
	}
	
	/**
	 * Validate username.
	 * @throws FileNotFoundException 
	 */
	
	public static void signIn() throws FileNotFoundException {
		
		String input = JOptionPane.showInputDialog("PLEASE ENTER USERNAME: ");

		File uFile = new File("UserFile.txt");
		Scanner scan = new Scanner(uFile);
		
		boolean found = false;
		
		while(!found && scan.hasNext()){
			
			String name = scan.next();
			String fullname = scan.next();
			String address = scan.next();
			String number = scan.next();
			
			System.out.println(name);
			
			if(input.equals(name)) {
				found = true;
				Vehicle.start();// Vehicle object
				break;
			}
		}// end of while
		
		if(found == false) {
			System.out.println("User not found");
		}
		scan.close();
		
	}// end of signIn

	
	/**
	 * Save new user to userFile.txt.
	 */
	
	public void saveNewUser() {
		try {
			FileWriter fileObj = new FileWriter("UserFile.txt", true);
			
			fileObj.write(username + " ");
			fileObj.write(fullName + " ");
			fileObj.write(homeAddress + " ");
			fileObj.write(phoneNumber + " ");
			fileObj.write("\n");
			fileObj.close();
		}
		catch(IOException e) {
			
		}
	}
	
	//Getters and Setters
	public String getUsername() {
		return username; 
	}
	 
	public void setUsername(String username) { 
		this.username = username; 
		}
	 
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}


