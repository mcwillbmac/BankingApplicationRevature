package project.service;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sun.tools.sjavac.Log;

import project.models.*;
import project.dao.*;

public class userService {

	private static final Logger lo = Logger.getLogger(userService.class);

	public static void register() {

		String choic = "y";

		while (choic.equalsIgnoreCase("y")) {

			DaoInterface dao = new DaoOpps();
			userService us = new userService();
			lo.info("This is the start of the registration method.");
			System.out.println();
			System.out.println();
			System.out.println("Welcome to the Moon Rocket Bank!!!!! ");
			System.out.println("You have come to the number one bank in America. ");
			System.out.println("What would you like to do ?");
			System.out.println(
					"Enter [1] if you are a customer, [2] if you are a  teller, and [3] if you are a administrater. ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if (choice == 1) {
				lo.info("The user chose customer.");
				System.out.println();
				System.out.println();
				System.out.println("Enter [1] for new customer, or [2] to login. ");
				int ch = sc.nextInt();
				if (ch == 1) {
					lo.info("the user chose to create a new customer.");
					System.out.println();

					Customer cus = new Customer();

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
					int roleId = 1;
					Role ro = new Role(roleId);
					ro.setName("Customer");
					System.out.println("What type of account do you want? [1] for Checking or [2] for Savings\n");

					lo.info("here the customer is prompted to choose which type of account they want.");
					System.out.println();
					System.out.println();

					Scanner s = new Scanner(System.in);
					int c = s.nextInt();

					if (c == 1) {
						cus.setAccType(1);
						s.nextLine();
					} else {
						cus.setAccType(2);
					}

					System.out.println("Enter account balance");
					cus.setBalance(s.nextDouble());
					cus.setBalance(cus.getBalance());

					String accountInfo = new String();
					accountInfo = cus.getFirstName() + " " + cus.getLastName() + " " + cus.getAddress() + " "
							+ cus.getUserName() + " " + ro.getName() + " " + cus.getBalance() + " " + cus.getAccType();

					System.out.println(accountInfo + "\n");

					Customer cust = new Customer(cus.getFirstName(), cus.getLastName(), cus.getAddress(),
							cus.getUserName(), cus.getPassWord(), ro, cus.getBalance(), cus.getAccType());

					lo.info("here the customer is being put into the database.");

					System.out.println(dao.insertC(cust));

					lo.info("here the list of customers in the database is being returned.");

					System.out.println(us.returnAllUsersC());
				} else {

					lo.info("the user chose to login.");
					System.out.println();
					System.out.println();

					Customer u = new Customer();

					loginC(u);
				}

			} else if (choice == 2) {
				lo.info("the user chose teller.");
				System.out.println();
				System.out.println();

				System.out.println("Enter [1] for new bank teller employee, or [2] to login. ");
				int c = sc.nextInt();
				if (c == 1) {

					lo.info("here the user chose to create a new teller. ");
					System.out.println();
					System.out.println();

					Teller cu = new Teller();
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
					int roleId = 2;
					Role ro = new Role(roleId);
					ro.setName("Teller");
					String accountInfo = new String();
					accountInfo = cu.getFirstName() + " " + cu.getLastName() + " " + cu.getAddress() + " "
							+ cu.getUserName() + " " + ro.getId() + " " + ro.getName();

					System.out.println(accountInfo);
					Teller tell = new Teller(cu.getFirstName(), cu.getLastName(), cu.getAddress(), cu.getUserName(),
							cu.getPassWord(), ro);
					lo.info("the teller is being put into the database.");

					System.out.println(dao.insertT(tell));

					lo.info("here all tellers are being returned.");

					System.out.println(us.returnAllUsersT());

				} else {

					lo.info("the user chose to login.");
					System.out.println();
					System.out.println();

					Teller u = new Teller();
					loginT(u);
				}

			} else if (choice == 3) {

				lo.info("the user chose the bank admininstrator.");
				System.out.println();
				System.out.println();

				System.out.println("Enter [1] for new bank administrator, or [2] to login. ");
				int ci = sc.nextInt();
				if (ci == 1) {
					lo.info("the user chose to create a new bank admin.");
					System.out.println();
					System.out.println();

					BankAdmin c = new BankAdmin();
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
					int roleId = 3;
					Role ro = new Role(roleId);
					ro.setName("Admin");
					String accountInfo = new String();
					accountInfo = c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " "
							+ c.getUserName() + " " + ro.getId() + " " + ro.getName();

					System.out.println(accountInfo);
					BankAdmin adm = new BankAdmin(c.getFirstName(), c.getLastName(), c.getAddress(), c.getUserName(),
							c.getPassWord(), ro);
					lo.info("the bank admin is being inserted into the database.");

					System.out.println(dao.insertB(adm));

					lo.info("all the bank admins are being returned.");

					System.out.println(us.returnAllUsersB());
				} else {

					lo.info("the user chose to login.");
					System.out.println();
					System.out.println();

					BankAdmin u = new BankAdmin();
					loginB(u);
				}

			}
			System.out.println("Do you want to continue? y / n ");

			choic = sc.next();

		}
		System.out.println("Have a great day.");

		lo.info("the user chose to end the program. ");
	}

	static DaoOpps dao = new DaoOpps();

	public static void loginC(Customer r) {

		System.out.println("Enter your user name. ");
		Scanner sc = new Scanner(System.in);
		r.setUserName(sc.nextLine());
		Customer u = dao.findByUsernameC(r.getUserName());
		System.out.println("Enter your password ");
		r.setPassWord(sc.nextLine());

		if (r.getPassWord().equals(u.getPassWord())) {

			System.out.println("you are logged in!");

			lo.info("the user is successfully logged in. ");
			System.out.println();
			System.out.println();

			System.out.println("What would you like to do? [1] to withdraw, [2] to deposit, or [3] to check balance. ");

			int chh = sc.nextInt();

			if (chh == 1) {

				lo.info("the user is making a withdraw.");
				System.out.println();
				System.out.println();

				System.out.println("Enter withdraw amount. ");
				double withdrawAmount = sc.nextDouble();
				dao.withdraw(withdrawAmount, u.getId());
				u = dao.findByIdC(u.getId());
				System.out.println("Your account balance is $" + u.getBalance());

			} else if (chh == 2) {

				lo.info("the user is making a deposit.");
				System.out.println();
				System.out.println();

				System.out.println("Enter deposit amount. ");
				double depositAmount = sc.nextDouble();
				dao.deposit(depositAmount, u.getId());
				u = dao.findByIdC(u.getId());
				System.out.println("Your account balance is $" + u.getBalance());

			} else if (chh == 3) {

				lo.info("the user chose to view their account.");
				System.out.println();
				System.out.println();

				System.out.println("Your account balance is $" + u.getBalance());

			}

		} else {

			Log.error("wrong password was entered");
			System.out.println();
			System.out.println();

			System.out.println("Wrong password...");
		}

	}

	public static void loginT(Teller r) {

		System.out.println("Enter your user name. ");
		Scanner sc = new Scanner(System.in);
		r.setUserName(sc.nextLine());
		Teller u = dao.findByUsernameT(r.getUserName());
		System.out.println("Enter your password ");
		r.setPassWord(sc.nextLine());

		if (r.getPassWord().equals(u.getPassWord())) {

			System.out.println("you are logged in!");

			lo.info("the user is logged in successfully.");
			System.out.println();
			System.out.println();

			System.out.println("What would you like to do?");

			System.out.println("[1] to view customers, [2] to view list of tellers. ");

			int x = sc.nextInt();

			if (x == 1) {

				lo.info("the user chose to view the list of customers.");
				System.out.println();
				System.out.println();

				userService us = new userService();
				System.out.println(us.returnAllUsersC());
			} else if (x == 2) {

				lo.info("the user chose to view the list of tellers.");
				System.out.println();
				System.out.println();

				userService us = new userService();
				System.out.println(us.returnAllUsersT());
			}

		} else {

			lo.error("wrong password was entered.");
			System.out.println();
			System.out.println();

			System.out.println("Wrong password...");
		}

	}

	public static void loginB(BankAdmin r) {

		System.out.println("Enter your user name. ");
		Scanner sc = new Scanner(System.in);
		r.setUserName(sc.nextLine());
		BankAdmin u = dao.findByUsernameB(r.getUserName());
		System.out.println("Enter your password ");
		r.setPassWord(sc.nextLine());

		if (r.getPassWord().equals(u.getPassWord())) {

			System.out.println("you are logged in!");

			lo.info("the user logged in successfully.");
			System.out.println();
			System.out.println();

			System.out.println("What would you like to do?");

			System.out
					.println("[1] to view customers, [2] to view list of tellers, [3] to view list of administators. ");

			int x = sc.nextInt();

			if (x == 1) {

				lo.info("the user chose to view all the customers.");
				System.out.println();
				System.out.println();

				userService us = new userService();
				System.out.println(us.returnAllUsersC());
			} else if (x == 2) {

				lo.info("the user chose to view the list of tellers.");
				System.out.println();
				System.out.println();

				userService us = new userService();
				System.out.println(us.returnAllUsersT());
			} else if (x == 3) {

				lo.info("the user chose to view the list of administrators.");
				System.out.println();
				System.out.println();

				userService us = new userService();
				System.out.println(us.returnAllUsersB());

			}

		} else {

			lo.error("wrong password was entered.");
			System.out.println();
			System.out.println();

			System.out.println("Wrong password...");
		}

	}

	public int add(Customer u) {

		lo.info("customer is being added to the database.");

		return dao.insertC(u);

	}

	public int add(Teller u) {

		lo.info("teller is being added to the database.");

		return dao.insertT(u);
	}

	public int add(BankAdmin u) {

		lo.info("bank admin is being added to the database.");

		return dao.insertB(u);
	}

	public List<Customer> returnAllUsersC() {

		return dao.findAllC();
	}

	public List<Teller> returnAllUsersT() {

		return dao.findAllT();
	}

	public List<BankAdmin> returnAllUsersB() {

		return dao.findAllB();
	}

	public Customer returnAUserByIdC(int id) {
		return dao.findByIdC(id);
	}

	public Teller returnAUserByIdT(int id) {
		return dao.findByIdT(id);
	}

	public BankAdmin returnAUserByIdB(int id) {
		return dao.findByIdB(id);
	}

}
