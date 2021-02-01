package project.service;

import java.util.Scanner;

import project.users.Customer;

public class userService {

	public String register() {
		Scanner sc = new Scanner(System.in);
		Customer cus = new Customer();
		System.out.println("Enter your First Name.");
		cus.firstName = sc.nextLine();
		cus.setFirstName(cus.firstName);
		System.out.println("Enter your Last Name.");
		cus.lastName = sc.nextLine();
		cus.setLastName(cus.lastName);
		System.out.println("Enter your address.");
		cus.address = sc.nextLine();
		cus.setAddress(cus.address);
		System.out.println("Create a username");
		cus.userName = sc.nextLine();
		cus.setUserName(cus.userName);
		System.out.println("Create a password");
		cus.passWord = sc.nextLine();
		cus.setPassWord(cus.passWord);
		String accountInfo = new String();
		accountInfo = cus.firstName + " "+ cus.lastName + " " + cus.address + " " + cus.userName;
		sc.close();
		return accountInfo;
	}
	
}
