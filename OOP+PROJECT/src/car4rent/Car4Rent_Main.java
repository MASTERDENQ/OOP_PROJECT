/**
 * Written By :
 * Tyrone Wallace - 1706903
 */

package car4rent;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JPanel;

@SuppressWarnings({ "unused" })
public class Car4Rent_Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Car4Rent_Main window = new Car4Rent_Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Car4Rent_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 660, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Welcome Greetings
		JLabel lblWelcomeToCarrent = new JLabel("WELCOME TO CAR-4-RENT");
		lblWelcomeToCarrent.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblWelcomeToCarrent.setBackground(Color.YELLOW);
		lblWelcomeToCarrent.setForeground(Color.BLUE);
		lblWelcomeToCarrent.setBounds(25, 11, 599, 64);
		frame.getContentPane().add(lblWelcomeToCarrent);
		
		//Calls signIn Functions 
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					User.signIn();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnSignIn.setBounds(10, 128, 298, 328);
		frame.getContentPane().add(btnSignIn);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User.start();
				frame.dispose();
				
			}
		});
		btnSignUp.setBounds(318, 128, 316, 328);
		frame.getContentPane().add(btnSignUp);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 86, 624, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(296, 118, 328, -17);
		frame.getContentPane().add(separator_1);
		
		JLabel lblTheBestVehicle = new JLabel("THE BEST VEHICLE RENTAL COMPANY IN KINGSTON JAMACIA");
		lblTheBestVehicle.setBounds(172, 91, 362, 16);
		frame.getContentPane().add(lblTheBestVehicle);
	}//End of initialize()
}//End of class

