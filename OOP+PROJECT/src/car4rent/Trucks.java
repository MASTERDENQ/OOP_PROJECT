/**
 * Written By :
 * Tyrone Wallace - 1706903
 */
package car4rent;

@SuppressWarnings({ "serial", "unused" })
public class Trucks extends Vehicles {
	
	private String towingCapacity;
	
	public Trucks(String licensePlateNumber, String brand, String model, int year, String color, String engineSize,
			char transmission, double mileage, int numberOfSeat, double ratePerDay, String rentalStatus, String towingCapacity) {
		super(licensePlateNumber, brand, model, year, color, engineSize, transmission, mileage, numberOfSeat, ratePerDay,
				rentalStatus);
		this.towingCapacity = towingCapacity;
	}//end of Constructor
	
	@Override
	public void setMileage(double mileage) {
		this.mileage = mileage;
		System.out.println("Changing of Truck Mileage");
	}
	
	@Override
	public double getMileage() {
		System.out.println("Retrieval of Truck Mileage");
		return mileage;
	}
	

}
