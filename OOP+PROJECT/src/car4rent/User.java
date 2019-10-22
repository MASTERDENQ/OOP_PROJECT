/**
 * Written By :
 * Tyrone Wallace - 1706903
 */
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })
public class User extends JFrame {

	//JFrame
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField fullNameTextField;
	private JTextField addressTextField;
	private JTextField phoneTextField;
	private JTextField textField;
	
	//States/ Attributes
	private String username;
	private String fullName;
	private String homeAddress;
	private String phoneNumber;


	/**
	 * Launch the User Frame.
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
	 * Create the User Frame.
	 */
	public User() {
		
		//Creates main Panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Separate contents on panel
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 81, 624, 2);
		contentPane.add(separator);
		
		//Label
		JLabel lblCarrent = new JLabel("CAR-4-RENT");
		lblCarrent.setForeground(Color.BLUE);
		lblCarrent.setFont(new Font("Tahoma", Font.PLAIN, 52));
		lblCarrent.setBackground(Color.YELLOW);
		lblCarrent.setBounds(192, 13, 291, 63);
		contentPane.add(lblCarrent);
		
		//Username
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(40, 144, 86, 17);
		contentPane.add(lblUsername);
		
		//FullName
		JLabel lblFullName = new JLabel("FULL NAME");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(40, 196, 86, 17);
		contentPane.add(lblFullName);
		
		//Address
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(40, 244, 86, 17);
		contentPane.add(lblAddress);
		
		//Phone #
		JLabel lblPhone = new JLabel("PHONE #");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(40, 290, 80, 15);
		contentPane.add(lblPhone);
		
		//Accepts Username
		usernameTextField = new JTextField();
		usernameTextField.setBounds(138, 143, 264, 18);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		//Accepts FullName
		fullNameTextField = new JTextField();
		fullNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fullNameTextField.setBounds(138, 194, 264, 19);
		contentPane.add(fullNameTextField);
		fullNameTextField.setColumns(10);
		
		////Accepts Address
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addressTextField.setColumns(10);
		addressTextField.setBounds(138, 242, 526, 19);
		contentPane.add(addressTextField);
		
		//Accepts Phone #
		phoneTextField = new JTextField();
		phoneTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(138, 287, 264, 19);
		contentPane.add(phoneTextField);
		
		//Instructions
		JLabel intro = new JLabel("PLEASE ENTER YOUR PERSONAL DETAILS IN BOX BELOW.");
		intro.setFont(new Font("Tahoma", Font.BOLD, 14));
		intro.setBounds(138, 94, 448, 36);
		contentPane.add(intro);
		
		//Accepts and validates User input when clicked
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				username = usernameTextField.getText();
				fullName = fullNameTextField.getText();
				homeAddress = addressTextField.getText();
				phoneNumber = phoneTextField.getText();		
				
				if(username.isEmpty() && fullName.isEmpty() && homeAddress.isEmpty() && phoneNumber.isEmpty()) {
					JOptionPane.showMessageDialog(null, "!!!!SORRY TRY AGAIN. ALL FIELD MUST BE FILLED OUT PROPERTY!!!!");
					User.start();
				}	
				else {	
					saveNewUser();
					Vehicles.start();
				}
				
				dispose();
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEnter.setBounds(225, 335, 221, 42);
		contentPane.add(btnEnter);
		
		//Additional Notice
		JLabel notice = new JLabel("PLEASE REPLACE ALL SPACE WITH AN UNDERSCORE \"_\".");
		notice.setBounds(12, 396, 397, 16);
		contentPane.add(notice);
		
		//Date: Label
		JLabel label = new JLabel("DATE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(587, 13, 50, 36);
		contentPane.add(label);
		
		//Date: Display Current Date
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		textField = new JTextField();
		textField.setText(dateFormat.format(currentDate));
		textField.setColumns(10);
		textField.setBounds(587, 49, 86, 22);
		contentPane.add(textField);
	}
	
	/**
	 * Validate on signIn Username.
	 * @throws FileNotFoundException 
	 */
	
	public static void signIn() throws FileNotFoundException {
		
		String input = JOptionPane.showInputDialog("PLEASE ENTER USERNAME: ");

		File uFile = new File("userFile.txt");
		Scanner scan = new Scanner(uFile);
		
		boolean found = false;
		
		while(!found && scan.hasNext()){
			
			String name = scan.next();
			String fullname = scan.next();
			String address = scan.next();
			String number = scan.next();
			
			//System.out.println(name);
			
			if(input.equals(name)) {
				found = true;
				Vehicles.start();// Vehicle object
				break;
			}
		}// end of while
		
		if(found == false) {
			JOptionPane.showMessageDialog(null,"Search Not Found");
		}
		
		scan.close();
		
	}// end of signIn

	
	/**
	 * Save new user to userFile.txt.
	 */
	
	public void saveNewUser() {
		try {
			FileWriter fileObj = new FileWriter("userFile.txt", true);
			
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


