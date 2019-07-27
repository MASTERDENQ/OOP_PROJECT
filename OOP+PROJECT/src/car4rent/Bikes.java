/**
 * Written By :
 * Tyrone Wallace - 1706903
 */
package car4rent;

@SuppressWarnings({ "serial", "unused" })
public class Bikes extends Vehicles {
	
	private int numberOfHelmets;

	public Bikes(String licensePlateNumber, String brand, String model, int year, String color, String engineSize,
			char transmission, double mileage, int numberOfSeat, double ratePerDay, String rentalStatus, int numberOfHelmets) {
		super(licensePlateNumber, brand, model, year, color, engineSize, transmission, mileage, numberOfSeat, ratePerDay,
				rentalStatus);
		this.numberOfHelmets = numberOfHelmets;
	}//end of Constructor
	
	@Override
	public void setMileage(double mileage) {
		this.mileage = mileage;
		System.out.println("Changing of Bike Mileage");
	}
	
	@Override
	public double getMileage() {
		System.out.println("Retrieval of Bike Mileage");
		return mileage;
	}
	

}
