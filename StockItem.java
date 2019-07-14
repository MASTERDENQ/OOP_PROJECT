import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StockItem {
	
	private int PartNumber;
	private String Description;
	private double Price;
	
	public StockItem() {
		PartNumber = 1234;
		Description = "babaab";
		Price = 323.43;
	}
	
	public StockItem(int partNumber, String description, double price) {
		PartNumber = partNumber;
		Description = description;
		Price = price;
	}
	
	public void DisplayStockItem() {
		System.out.println("Part Number" + PartNumber);
		System.out.println("Desription" + Description);
		System.out.println("Price" + Price);
	}
	
	@SuppressWarnings("resource")
	public void GetStockItemFromUser() {
		try {
			Scanner in = new Scanner(System.in);
			
			System.out.println("Enter Part Number: ");
			PartNumber = in.nextInt();
			
			System.out.println("Enter Description: ");
			Description = in.next();
			
			System.out.println("Enter Price: ");
			Price = in.nextDouble();
		}
		catch(InputMismatchException e) {
			System.err.println("Wrong input type entered");
		}
	}
	
	public void SaveStockItem() {
		try {
			//File Writer will create the file if it does not exist
			//True will append data to the file
			FileWriter fileobject = new FileWriter("StockItem.txt", true);
			
			//Each attribute is separated by a space
			//Each record is separate by a new line
			fileobject.write(PartNumber + " ");
			fileobject.write(Description + " ");
			fileobject.write(Price + " ");
			fileobject.write("\n");
			fileobject.close();
		}
		catch(IOException e) {
			System.err.println("An Error Has Occured.");
		}
	}
	
	public void DisplayAllItems() throws IOException {
		try {
			File f = new File("StockItem.txt");
			Scanner scan = new Scanner(f);
			System.out.println("Part Number\t Description\t Price\t");
			System.out.println("----------\t-----------\t--------------\t");
			
			while(scan.hasNext()) {
				int PNum = scan.nextInt();
				String Desc = scan.next();
				double Pr = scan.nextDouble();
				
				System.out.println(PNum + "\t\t" + Desc + "\t\t" + Pr);
			}// end while
			
			scan.close();
		} catch(FileNotFoundException e) {
			System.err.println("Sorry File was not Found");
		}// end catch
	}// method
	
	

	public static void main(String[] args) throws IOException {
		
		StockItem s = new StockItem();
		s.GetStockItemFromUser();
		s.SaveStockItem();
		s.DisplayAllItems();
	}

}