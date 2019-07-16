package car4rent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	public void searchVehicleFile(String key){

		File f = new File("UserFile.txt");

		Scanner scan = new Scanner(f);
		
		String input = key;

		BufferReader br = new BufferReader(f);

		while(true == br.contains(input) && scan.hasNext()){

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


		}
	}

//	public void readInCars() throws IOException {
//		
//		File f = new File("Vehiles.txt");
//		
//		Scanner scan = new Scanner(f);
//		
		
		
//		String[] words=null;  //Intialize the word Array
//	    FileReader fr = new FileReader(f);  //Creation of File Reader object
//	    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
//	      
//	    String line;     
//	    String input="Car";   // Input word to be searched
//	      
//	    while((line = br.readLine()) != null)   //Reading Content from the file
//	    {
//	       words = line.split(" ");  //Split the word using space
//	       
//	       for (String word : words) 
//	       {
//	    	   if (word.equals(input))   //Search for the given word
//	           {
//		    		licensePlateNumber = scan.next();
//		   			brand = scan.next();
//		   			model = scan.next();
//		   			year = scan.nextInt();
//		   			color = scan.next();
//		   			engineSize = scan.next();
//		   			transmission = (char) scan.nextInt();
//		   			mileage = scan.nextDouble();
//		   			numberOfSeat = scan.nextInt();
//		   			ratePerDay = scan.nextDouble();
//		   			covertible = scan.nextBoolean();
//		   			rentalStatus = scan.next();    
//	           }
//	       }
//	      }
		
//		while(scan.hasNext()) {
//		
//			licensePlateNumber = scan.next();
//			brand = scan.next();
//			model = scan.next();
//			year = scan.nextInt();
//			color = scan.next();
//			engineSize = scan.next();
//			transmission = (char) scan.nextInt();
//			mileage = scan.nextDouble();
//			numberOfSeat = scan.nextInt();
//			ratePerDay = scan.nextDouble();
//			covertible = scan.nextBoolean();
//			rentalStatus = scan.next();
//		}// end while
		scan.close();		
	}
	
	
	
	

}
