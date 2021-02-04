package project.service;

import java.util.List;
import java.util.Scanner;
import project.models.*;
import project.dao.*;

public class userService {

	public static void register() {
		DaoInterface dao = new DaoOpps();
		userService us = new userService();
		System.out.println("Welcome to the Moon Rocket Bank!!!!! ");
		System.out.println("You have come to the number one bank in America. ");
		System.out.println("What would you like to do ?");
		System.out.println(
				"Enter [1] if you are a customer, [2] if you are a  teller, and [3] if you are a administrater. ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Enter [1] for new customer, or [2] to login. ");
			int ch = sc.nextInt();
			if (ch == 1) {
				User cus = new Customer();

				sc.nextLine();
				System.out.println("Enter your First Name.");

				cus.setFirstName(sc.nextLine());
				cus.setFirstName(cus.getFirstName());
				System.out.println("Enter your Last Name.");
				cus.setLastName(sc.nextLine());
				cus.setLastName(cus.getLastName());
				System.out.println("Enter your address.");
				cus.setAddress(sc.nextLine());
				cus.setAddress(cus.getAddress());
				System.out.println("Create a username");
				cus.setUserName(sc.nextLine());
				cus.setUserName(cus.getUserName());
				System.out.println("Create a password");
				cus.setPassWord(sc.nextLine());
				cus.setPassWord(cus.getPassWord());
				String accountInfo = new String();
				accountInfo = cus.getFirstName() + " " + cus.getLastName() + " " + cus.getAddress() + " "
						+ cus.getUserName();
				sc.close();
				System.out.println(accountInfo);
				Customer cust = new Customer(Customer.id++, cus.getFirstName(), cus.getLastName(),cus.getUserName(), cus.getPassWord(),
						cus.getAddress());
				System.out.println(dao.insertC(cust));

				//System.out.println(us.returnAllUsers());
			} else {

				User u = new Customer();
				login(u);
			}

		} else if (choice == 2) {
			System.out.println("Enter [1] for new bank teller employee, or [2] to login. ");
			int c = sc.nextInt();
			if (c == 1) {
				User cu = new Teller();
				sc.nextLine();
				System.out.println("Enter your First Name.");
				cu.setFirstName(sc.nextLine());
				cu.setFirstName(cu.getFirstName());
				System.out.println("Enter your Last Name.");
				cu.setLastName(sc.nextLine());
				cu.setLastName(cu.getLastName());
				System.out.println("Enter your address.");
				cu.setAddress(sc.nextLine());
				cu.setAddress(cu.getAddress());
				System.out.println("Create a username");
				cu.setUserName(sc.nextLine());
				cu.setUserName(cu.getUserName());
				System.out.println("Create a password");
				cu.setPassWord(sc.nextLine());
				cu.setPassWord(cu.getPassWord());
				int roleId = 1;
				Role ro = new Role(roleId);
				ro.setName("Bank Teller");
				String accountInfo = new String();
				accountInfo = cu.getFirstName() + " " + cu.getLastName() + " " + cu.getAddress() + " "
						+ cu.getUserName() + " " + ro.getId() + " " + ro.getName();
				sc.close();
				System.out.println(accountInfo);
				User tell = new Teller(cu.getUserName(), cu.getPassWord(), cu.getFirstName(), cu.getLastName(),
						cu.getAddress(), ro);
				System.out.println(dao.insert(tell));

				System.out.println(us.returnAllUsers());

			} else {

				User u = new Teller();
				login(u);
			}

		} else if (choice == 3) {

			System.out.println("Enter [1] for new bank administrator, or [2] to login. ");
			int ci = sc.nextInt();
			if (ci == 1) {
				User c = new BankAdmin();
				sc.nextLine();
				System.out.println("Enter your First Name.");
				c.setFirstName(sc.nextLine());
				c.setFirstName(c.getFirstName());
				System.out.println("Enter your Last Name.");
				c.setLastName(sc.nextLine());
				c.setLastName(c.getLastName());
				System.out.println("Enter your address.");
				c.setAddress(sc.nextLine());
				c.setAddress(c.getAddress());
				System.out.println("Create a username");
				c.setUserName(sc.nextLine());
				c.setUserName(c.getUserName());
				System.out.println("Create a password");
				c.setPassWord(sc.nextLine());
				c.setPassWord(c.getPassWord());
				int roleId = 2;
				Role ro = new Role(roleId);
				ro.setName("Administrator");
				String accountInfo = new String();
				accountInfo = c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " " + c.getUserName()
						+ " " + ro.getId() + " " + ro.getName();
				sc.close();
				System.out.println(accountInfo);
				User adm = new BankAdmin(c.getUserName(), c.getPassWord(), c.getFirstName(), c.getLastName(),
						c.getAddress(), ro);
				System.out.println(dao.insert(adm));
				System.out.println(us.returnAllUsers());
			} else {

				User u = new BankAdmin();
				login(u);
			}

		}

	}

	static DaoInterface dao = new DaoOpps();

	public static void login(User r) {

		// 1. Let's assign a User u equal to the User that the findByUSername method

		// returns...

		System.out.println("Enter your user name. ");
		Scanner sc = new Scanner(System.in);
		r.setUserName(sc.nextLine());
		User u = dao.findByUsername(r.getUserName());
		System.out.println("Enter your password ");
		r.setPassWord(sc.nextLine());
		// the service layer

		// 2. Check that the user that we return has the same password as the password
		// passed into THIS method (login)
		if (r.getPassWord().equals(u.getPassWord())) {

			System.out.println("you are logged in!");

		} else {

			System.out.println("Wrong password...");
		}

	}

	public int add(User u) {

		return dao.insert(u);
	}

	public List<User> returnAllUsers() {

		return dao.findAll();
	}

	public User returnAUserById(int id) {
		return dao.findById(id);
	}

}
