package car4rent;

public class Vehicles {

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
	
	//Default Constructor
	public Vehicles() {
		
		this.licensePlateNumber = "3423 AW";
		this.brand = "Toyota";
		this.model = "E203";
		this.year = 2019;
		this.color = "RED";
		this.engineSize = "320";
		this.transmission = 'A';
		this.mileage = 23000;
		this.numberOfSeat = 5;
		this.ratePerDay = 5000;
		this.rentalStatus = "Available";
	}
	
//Utilities	
	public void viewVehicle() {
		
		System.out.println("| LICENCE NUMBER | BRAND | MODEL | YEAR | COLOR  "
				+ "| ENGINE SIZE | TRANSMISSION | MILEAGE | # OF SEATS | RENTAL STATUS | RATE PER DAY |");
		
		while(true) {
			System.out.println("|"+ licensePlateNumber + "|");
		}
			
	}
		
	public void searchVehicle() {
		
	}
	
	public void displayVehicles() {
		
	}
	
	public void returnVehicles() {
		
	}

//Getters and Setters
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
}// end of Vehicles class
