package car4rent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cars extends Vehicles {
	
	private boolean covertible;

	public Cars(String licensePlateNumber, String brand, String model, int year, String color, String engineSize,
			char transmission, double mileage, int numberOfSeat, double ratePerDay, String rentalStatus,
			boolean covertible) {
		super(licensePlateNumber, brand, model, year, color, engineSize, transmission, mileage, numberOfSeat,
				ratePerDay, rentalStatus);
		this.covertible = covertible;
	}

	public void readInCars() throws FileNotFoundException {
		
		File f = new File("Vehiles.txt");
		
		Scanner scan = new Scanner(f);
		
		while(scan.hasNext()) {
			licensePlateNumber = scan.next();
			brand = scan.next();
			model = scan.next();
			year = scan.nextInt();
			color = scan.next();
			engineSize = scan.next();
			transmission = (char) scan.nextInt();
			mileage = scan.nextDouble();
			numberOfSeat = scan.nextInt();
			ratePerDay = scan.nextDouble();
			covertible = scan.nextBoolean();
			rentalStatus = scan.next();
		}// end while
		scan.close();		
	}
	
	
	
	

}
