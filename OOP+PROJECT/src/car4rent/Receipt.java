package car4rent;

public class Receipt {

//States/ Attributes
	private Date dateBorrowed = new Date();
	private Date actualDateReturned = new Date();
	private double ratePerDay;
	private Date expectedReturnDate = new Date();
	private double lateFee;
	private final double lateRate = 1000.00;
	private double totalOwed;
	private double finalCost;
	
//Constructors
	//Primary Constructor
	public Receipt(Date dateBorrowed, Date actualDateReturned, double ratePerDay, Date expectedReturnDate) {
		
		this.dateBorrowed = dateBorrowed;
		this.actualDateReturned = actualDateReturned;
		this.ratePerDay = ratePerDay;
		this.expectedReturnDate = expectedReturnDate;
	}
	
	//Copy Constructor
	public Receipt(Receipt money) {
		
		
	}
	
//Utility Methods
	public void calculateCost() {
		
	}

//toString
	@Override
	public String toString() {
		return "Receipt [dateBorrowed=" + dateBorrowed + ", actualDateReturned=" + actualDateReturned + ", ratePerDay="
				+ ratePerDay + ", expectedReturnDate=" + expectedReturnDate + ", lateFee=" + lateFee + ", lateRate="
				+ lateRate + ", totalOwed=" + totalOwed + ", finalCost=" + finalCost + "]";
	}

}// end of Receipt class
