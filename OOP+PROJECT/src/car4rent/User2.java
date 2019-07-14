package car4rent;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class User2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
//States/ Attributes
	private String username;
	private String fullName;
	private String homeAddress;
	private String phoneNumber;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User2 frame = new User2();
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
	public User2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 81, 624, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("WELCOME TO CAR4RENT");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 52));
		label.setBackground(Color.YELLOW);
		label.setBounds(50, 11, 599, 64);
		contentPane.add(label);
		
		JLabel lblFullName = new JLabel("FULL NAME");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(40, 162, 154, 17);
		contentPane.add(lblFullName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(40, 213, 154, 17);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("PHONE #");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(40, 263, 154, 17);
		contentPane.add(lblPhone);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(237, 159, 427, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(237, 210, 427, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(237, 260, 427, 20);
		contentPane.add(textField_2);
		
		JLabel lblPleaseEnterYour = new JLabel("PLEASE ENTER YOUR PERSONAL DETAILS IN BOX BELOW.");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseEnterYour.setBounds(138, 94, 526, 37);
		contentPane.add(lblPleaseEnterYour);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnter.setBounds(337, 337, 133, 37);
		contentPane.add(btnEnter);
	}
	
	/**
	 * Save new user to userFile.txt.
	 */
	
	public void saveNewUser() {
		try {
			FileWriter fileObj = new FileWriter("userFile.txt", true);
			
			fileObj.write(username + "");
			fileObj.write(fullName + "");
			fileObj.write(homeAddress + "");
			fileObj.write(phoneNumber + "");
			fileObj.write("\n");
			fileObj.close();
		}
		catch(IOException e) {
			
		}
	}
}
