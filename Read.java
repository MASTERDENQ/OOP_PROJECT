


	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.InputMismatchException;
	import java.util.Scanner;

	public class Read {
		
		private int PartNumber;
		private String Description;
		private double Price;
		
		public Read() {
			PartNumber = 1234;
			Description = "babaab";
			Price = 323.43;
		}
		
		public Read(int partNumber, String description, double price) {
			PartNumber = partNumber;
			Description = description;
			Price = price;
		}
		
		public void DisplayRead() {
			System.out.println("Part Number" + PartNumber);
			System.out.println("Desription" + Description);
			System.out.println("Price" + Price);
		}
		
		@SuppressWarnings("resource")
		public void GetReadFromUser() {
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
		
		public void SaveRead() {
			try {
				//File Writer will create the file if it does not exist
				//True will append data to the file
				FileWriter fileobject = new FileWriter("Read.txt", true);
				
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
				File f = new File("Read.txt");
				Scanner scan = new Scanner(f);
				
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
			
			Read s = new Read();
			s.GetReadFromUser();
			s.SaveRead();
			s.DisplayAllItems();
		}

	}