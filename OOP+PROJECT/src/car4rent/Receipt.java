/**
 * Written By :
 * Tyrone Wallace - 1706903 
 * Shantia Lewis - 
 */
package car4rent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Receipt extends JFrame {

	private JPanel contentPane;
	
	//States/ Attributes	
		private Date dateBorrowed = new Date();
		private Date actualDateReturned = new Date();
		private Date expectedReturnDate = new Date();
		
		private double lateFee;
		private final double lateRate = 1000.00;
		private double totalOwed;
		private double finalCost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt frame = new Receipt();
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
	public Receipt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	//Primary Constructor
			public  Receipt(Date dateBorrowed, Date actualDateReturned, Date expectedReturnDate) {
			
			this.dateBorrowed = dateBorrowed;
			this.actualDateReturned = actualDateReturned;
			this.expectedReturnDate = expectedReturnDate;
		}
			
		//Utility Methods
		public void calculateCost() {
				
		}

			//Getters and Setters
		public Date getDateBorrowed() {
			return dateBorrowed;
		}

		public void setDateBorrowed(Date dateBorrowed) {
			this.dateBorrowed = dateBorrowed;
		}

		public Date getActualDateReturned() {
			return actualDateReturned;
		}

		public void setActualDateReturned(Date actualDateReturned) {
			this.actualDateReturned = actualDateReturned;
		}

		public Date getExpectedReturnDate() {
			return expectedReturnDate;
		}

		public void setExpectedReturnDate(Date expectedReturnDate) {
			this.expectedReturnDate = expectedReturnDate;
		}

		public double getLateFee() {
			return lateFee;
		}

		public void setLateFee(double lateFee) {
			this.lateFee = lateFee;
		}

		public double getTotalOwed() {
			return totalOwed;
		}

		public void setTotalOwed(double totalOwed) {
			this.totalOwed = totalOwed;
		}

		public double getFinalCost() {
			return finalCost;
		}

		public void setFinalCost(double finalCost) {
			this.finalCost = finalCost;
		}

		public double getLateRate() {
			return lateRate;
		}
}// end of Receipt class
