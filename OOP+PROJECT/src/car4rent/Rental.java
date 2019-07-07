package car4rent;

public class Rental {

//States/ Attributes
	private Vehicles vehicleObj = new Vehicles();
	
	private User userObj = new User();
	
	private Date dateBorrowed = new Date();
	private Date actualDateReturned = new Date();
	private Date expectedReturnDate = new Date();
	
	private double lateFee;
	private final double lateRate = 1000.00;
	private double totalOwed;
	private double finalCost;
	
//Constructors
	//Primary Constructor
		public Rental(Date dateBorrowed, Date actualDateReturned, Date expectedReturnDate) {
		
		this.dateBorrowed = dateBorrowed;
		this.actualDateReturned = actualDateReturned;
		this.expectedReturnDate = expectedReturnDate;
	}
	
//Utility Methods
	public void calculateCost() {
		
	}
	
	public void Receipt() {
				
	}
}// end of Receipt class
