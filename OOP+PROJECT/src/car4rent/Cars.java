/**
 * Written By :
 * Tyrone Wallace - 1706903
 */
package car4rent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings({ "serial", "unused" })
public class Cars extends Vehicles {

	public Cars(String licensePlateNumber, String brand, String model, int year, String color, String engineSize,
			char transmission, double mileage, int numberOfSeat, double ratePerDay, String rentalStatus) {
		
		super(licensePlateNumber, brand, model, year, color, engineSize, transmission, mileage, numberOfSeat,
				ratePerDay, rentalStatus);
	}//end of Constructor
	
	@Override
	public void setMileage(double mileage) {
		this.mileage = mileage;
		System.out.println("Changing of Car Mileage");
	}
	
	@Override
	public double getMileage() {
		System.out.println("Retrieval of Car Mileage");
		return mileage;
	}
	
}//End of class
