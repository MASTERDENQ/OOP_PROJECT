package car4rent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vehicle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehicle frame = new Vehicle();
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
	public Vehicle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarrent = new JLabel("CAR-4-RENT");
		lblCarrent.setForeground(Color.BLUE);
		lblCarrent.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblCarrent.setBackground(Color.YELLOW);
		lblCarrent.setBounds(205, 13, 300, 67);
		contentPane.add(lblCarrent);
		
		JLabel lblSelectHowTo = new JLabel("SELECT HOW TO VIEW VEHICLES");
		lblSelectHowTo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectHowTo.setBounds(47, 101, 245, 20);
		contentPane.add(lblSelectHowTo);
		

		textField = new JTextField();
		textField.setText("TODAY'S DATE");
		textField.setColumns(10);
		textField.setBounds(580, 46, 116, 22);
		contentPane.add(textField);
		
		JLabel label = new JLabel("DATE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(616, 13, 50, 36);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 78, 624, 2);
		contentPane.add(separator);
		
		Panel panel = new Panel();
		panel.setBounds(10, 86, 690, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnViewVehicle = new JButton("View Vehicle");
		btnViewVehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewVehicle.setBounds(10, 0, 196, 47);
		panel.add(btnViewVehicle);
		
		JButton btnSearchVehicle = new JButton("Search Vehicle");
		btnSearchVehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearchVehicle.setBounds(203, 0, 159, 47);
		panel.add(btnSearchVehicle);
		
		JButton btnMyRentals = new JButton("My Rentals");
		btnMyRentals.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMyRentals.setBounds(361, 0, 153, 47);
		panel.add(btnMyRentals);
		
		JButton btnReturnVehicle = new JButton("Return Vehicle");
		btnReturnVehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReturnVehicle.setBounds(511, 0, 169, 47);
		panel.add(btnReturnVehicle);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 147, 690, 272);
		contentPane.add(panel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 139, 624, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(42, 425, 624, 2);
		contentPane.add(separator_2);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEnter.setBounds(10, 438, 355, 35);
		contentPane.add(btnEnter);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReset.setBounds(375, 438, 321, 35);
		contentPane.add(btnReset);
	}
}
