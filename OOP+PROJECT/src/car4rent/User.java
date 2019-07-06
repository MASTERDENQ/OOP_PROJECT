package car4rent;

public class User {
	
//States/ Attributes
//	private String username;
//	private String password;
	private String fullName;
	private String homeAddress;
	private String phoneNumber;

	//Primary Constructor
	public User(String username, String password, String fullName, String homeAddress, String phoneNumber) {
	
		//this.username = username;
		//this.password = password;
		this.fullName = fullName;
		this.homeAddress = homeAddress;
		this.phoneNumber = phoneNumber;
	}
	
	//Default Constructors
	public User() {
		
		//this.username = "admin";
		//this.password = "onehundred";
		this.fullName = "Admin";
		this.homeAddress = "kingston city";
		this.phoneNumber = "1(876) 987-6543";
	}
	
	//Getters and Setters
	/*
	 * public String getUsername() { return username; }
	 */
	/*
	 * public void setUsername(String username) { this.username = username; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}// end of User class
