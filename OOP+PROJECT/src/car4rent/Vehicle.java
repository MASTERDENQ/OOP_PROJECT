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
		
		JButton btnAll = new JButton("ALL");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAll.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnAll.setBounds(12, 134, 684, 85);
		contentPane.add(btnAll);
		
		JButton btnCars = new JButton("CARS");
		btnCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cars frame = new Cars();
			}
		});
		btnCars.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnCars.setBounds(12, 216, 684, 85);
		contentPane.add(btnCars);
		
		JButton btnBikes = new JButton("BIKES");
		btnBikes.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnBikes.setBounds(12, 293, 684, 90);
		contentPane.add(btnBikes);
		
		JButton btnTrucks = new JButton("TRUCKS");
		btnTrucks.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnTrucks.setBounds(12, 378, 684, 85);
		contentPane.add(btnTrucks);
		
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
	}
}
