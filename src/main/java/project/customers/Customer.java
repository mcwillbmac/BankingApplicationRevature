package project.customers;
import java.util.Scanner;


public class Customer {
	
	private String userName;
	private String passWord;
	public String firstName;
	public String lastName;
	public String address;
	
	
	public Customer() {
		
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your First Name.");
		firstName = sc.nextLine();
		setFirstName(firstName);
		System.out.println("Enter your Last Name.");
		lastName = sc.nextLine();
		setLastName(lastName);
		System.out.println("Enter your address.");
		address = sc.nextLine();
		setAddress(address);
		System.out.println("Create a username");
		userName = sc.nextLine();
		setUserName(userName);
		System.out.println("Create a password");
		passWord = sc.nextLine();
		setPassWord(passWord);
		String accountInfo = new String();
		accountInfo = firstName + " "+ lastName + " " + address + " " + userName;
		sc.close();
		return accountInfo;
	}
	
	
	
	
	

}
