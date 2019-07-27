/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Kevin Irons - 
 */
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

@SuppressWarnings({ "serial", "unused" })
public class Vehicles extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	//States/ Attributes
	protected String licensePlateNumber;
	protected String brand;
	protected String model;
	protected int year;
	protected String color;
	protected String engineSize;
	protected char transmission;
	protected double mileage;
	protected int numberOfSeat;
	protected double ratePerDay;
	protected String rentalStatus;
	
//Constructors
	//Primary Constructor
	public Vehicles(String licensePlateNumber, String brand, String model, int year, String color, String engineSize,
			char transmission, double mileage, int numberOfSeat, double ratePerDay, String rentalStatus) {
		
		this.licensePlateNumber = licensePlateNumber;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.color = color;
		this.engineSize = engineSize;
		this.transmission = transmission;
		this.mileage = mileage;
		this.numberOfSeat = numberOfSeat;
		this.ratePerDay = ratePerDay;
		this.rentalStatus = rentalStatus;
	}


	/**
	 * Launch the Vehicle Frame.
	 * Default constructors are the main display.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehicles frame = new Vehicles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}// Exception Handling
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vehicles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Main Header
		JLabel lblCarrent = new JLabel("CAR-4-RENT");
		lblCarrent.setForeground(Color.BLUE);
		lblCarrent.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblCarrent.setBackground(Color.YELLOW);
		lblCarrent.setBounds(205, 13, 300, 67);
		contentPane.add(lblCarrent);
		
		//Date: Display Current Date
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		textField = new JTextField();
		textField.setText(dateFormat.format(currentDate));
		textField.setColumns(10);
		textField.setBounds(595, 50, 86, 22);
		contentPane.add(textField);
		
		//Date: Label
		JLabel label = new JLabel("DATE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(595, 13, 50, 36);
		contentPane.add(label);
		
		
		//Separates sections of display with  a line
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 78, 624, 2);
		contentPane.add(separator);
		
		//Panel in Window		
		Panel panel = new Panel();
		panel.setBounds(10, 86, 690, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Display All Vehicles when clicked
		JButton btnViewVehicle = new JButton("View Vehicle");
		btnViewVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Call function
				viewVehicles();				
			}
		});
		btnViewVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewVehicle.setBounds(0, 0, 193, 47);
		panel.add(btnViewVehicle);
		
		
		//Search for any Vehicle on click
		JButton btnSearchVehicle = new JButton("Search Vehicle");
		btnSearchVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					searchOptions();
				} catch (Exception e) {
					e.printStackTrace();
				}//Catches Exception if thrown from function
			}
		});
		btnSearchVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchVehicle.setBounds(192, 0, 170, 47);
		panel.add(btnSearchVehicle);
		
		//Display User Rented Vehicles when clicked read from rentVehicles.txt file
		JButton btnMyRentals = new JButton("My Rentals");
		btnMyRentals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnMyRentals.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMyRentals.setBounds(361, 0, 156, 47);
		panel.add(btnMyRentals);
		
		//Display User returnable Vehicles when clicked read from rentVehicles.txt file
		JButton btnReturnVehicle = new JButton("Return Vehicle");
		btnReturnVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReturnVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturnVehicle.setBounds(515, 0, 175, 47);
		panel.add(btnReturnVehicle);
		
		//Holds table
		Panel tablePanel = new Panel();
		tablePanel.setBackground(Color.GREEN);
		tablePanel.setBounds(10, 147, 690, 253);
		contentPane.add(tablePanel);
		
		//Reference of Table Object
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
		
		//Store Max 3 Vehicles for one use to rentVehicles.txt file
		JButton btnRent = new JButton("RENT");
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRent.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnRent.setBounds(42, 416, 624, 57);
		contentPane.add(btnRent);
	}
	


	/**
	 * Utilities	.
	 */
	@SuppressWarnings("resource")
	public void viewVehicles() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		String[] cols = {"licensePlateNumber","type","brand","model","year","color","engineSize","transmission",
				"mileage","numberOfSeat","ratePerDay", "towingCapacity", "numberOfHelmets","rentalStatus"};
		
		model.setDataVector(null, cols);
		
		String filePath = "Vehicles.txt";
		
		File file = new File(filePath);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
//			 String firstLine = br.readLine().trim();
//			 String[] header = firstLine.split(" ");
//			 DefaultTableModel model = (DefaultTableModel)table.getModel();
//			 model.setColumnIdentifiers(header);
			 
			  // get lines from text file
	           Object[] tableLines = br.lines().toArray();
	            
	          // extract data from lines
	          // set data to table model
	          for(int i = 0; i < tableLines.length; i++)
	          {
	             String line = tableLines[i].toString().trim();
	             String[] dataRow = line.split(" ");
	             model.addRow(dataRow);
	          }
			
		}
		catch(Exception e) {
			Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	@SuppressWarnings("resource")
	public void searchOptions() throws Exception {
		table.setModel(new DefaultTableModel(null,new String[]{"licensePlateNumber","type","brand",
				"model","year","color","engineSize","transmission","mileage","numberOfSeat","ratePerDay", 
				"towingCapacity", "numberOfHelmets","rentalStatus"}));
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		boolean found = false;
		
		BufferedReader br = new BufferedReader(new FileReader("Vehicles.txt"));
	
		JOptionPane.showMessageDialog(null, "SEARCH TYPES ARE\n" + 
		 "****L- Licence Plate #: B- Brand: M- Model: Y: Year****\n");
		
		String key = JOptionPane.showInputDialog("ENTER SEARCH:  ");
		
		Object[] tableLines = br.lines().toArray();
		
		for(int i = 0; i < tableLines.length; i++)
        {
           String line = tableLines[i].toString().trim();
           
           if(line.contains(key)) {
        	   String[] dataRow = line.split(" ");
        	   model.addRow(dataRow);
        	   found = true;
        	   break;
           }
           
        }
		
		if (found) {
			JOptionPane.showMessageDialog(null,"Search Sucessfully Found");
		}
		else {
			JOptionPane.showMessageDialog(null,"Search Not Found");
		} 
	}
	

	
	/**
	 * Getters and Setters
	 */
	
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	public char getTransmission() {
		return transmission;
	}

	public void setTransmission(char transmission) {
		this.transmission = transmission;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	public double getRatePerDay() {
		return ratePerDay;
	}

	public void setRatePerDay(double ratePerDay) {
		this.ratePerDay = ratePerDay;
	}

	public String getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}
		
}// end of class
