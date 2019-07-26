package car4rent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Vehicle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void start() {
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
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		textField = new JTextField();
		textField.setText(dateFormat.format(currentDate));
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
		btnViewVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				String[] cols = {"licensePlateNumber","type","brand","model","year","color","engineSize","transmission",
						"mileage","numberOfSeat","ratePerDay", "towingCapacity", "numberOfHelmets","rentalStatus"};
				
				model.setDataVector(null, cols);
				
				String filePath = "Vehicles.txt";
				
				File file = new File(filePath);
				
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
//					 String firstLine = br.readLine().trim();
//					 String[] header = firstLine.split(" ");
//					 DefaultTableModel model = (DefaultTableModel)table.getModel();
//					 model.setColumnIdentifiers(header);
					 
					  // get lines from txt file
			           Object[] tableLines = br.lines().toArray();
			            
			          // extratct data from lines
			          // set data to jtable model
			          for(int i = 0; i < tableLines.length; i++)
			          {
			             String line = tableLines[i].toString().trim();
			             String[] dataRow = line.split(" ");
			             model.addRow(dataRow);
			          }
					
				}
				catch(Exception e) {
					Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, e);
				}
				
				
			}
		});
		btnViewVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewVehicle.setBounds(0, 0, 193, 47);
		panel.add(btnViewVehicle);
		
		JButton btnSearchVehicle = new JButton("Search Vehicle");
		btnSearchVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchVehicle.setBounds(192, 0, 170, 47);
		panel.add(btnSearchVehicle);
		
		JButton btnMyRentals = new JButton("My Rentals");
		btnMyRentals.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMyRentals.setBounds(361, 0, 156, 47);
		panel.add(btnMyRentals);
		
		JButton btnReturnVehicle = new JButton("Return Vehicle");
		btnReturnVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturnVehicle.setBounds(515, 0, 175, 47);
		panel.add(btnReturnVehicle);
		
		Panel tablePanel = new Panel();
		tablePanel.setBackground(Color.GREEN);
		tablePanel.setBounds(10, 147, 690, 253);
		contentPane.add(tablePanel);
		
		table = new JTable();
		GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
		gl_tablePanel.setHorizontalGroup(
			gl_tablePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_tablePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_tablePanel.setVerticalGroup(
			gl_tablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tablePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
					.addContainerGap())
		);
		tablePanel.setLayout(gl_tablePanel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 139, 624, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(42, 406, 624, 2);
		contentPane.add(separator_2);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnEnter.setBounds(42, 416, 624, 57);
		contentPane.add(btnEnter);
	}
	
	public void searchOptions() throws Exception {
		
		boolean found = false;
		
		Scanner scan = new Scanner(new File("Vehicles.txt"));
		char L, B, M, Y;
		JOptionPane.showMessageDialog(null, "SEARCH TYPES ARE\n"+ 
		 "****L- Licence Plate #: B- Brand: M- Model: Y: Year****");
		
		String input = JOptionPane.showInputDialog("PLEASE ENTER TYPE OF SEARCH CHARACTER:  ");
		
		while(scan.hasNext() && !found) {
			L=scan.next().charAt(0);
			B=scan.next().charAt(0);
			M=scan.next().charAt(0);
			Y=scan.next().charAt(0);
			if(scan.equals(input)){
				found=true;
			};
			
			//found=scan.contain(scan.next);
			if (found== true)
				break;
			
		}
		
		if (found) {
			JOptionPane.showMessageDialog(null,"Search Sucessfully Found");
		}
		else {
			JOptionPane.showMessageDialog(null,"Search Not Found");
		} scan.close();

			
	}
}// end of class and
