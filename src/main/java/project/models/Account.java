package project.models;

import java.util.Scanner;

public class Account {

	private int accId;
	private int usrId;
	private int accType;
	private int active;
	private double accountBalance;

	public Account(int accId, int usrId, int accType, double accountBalance) {
		super();
		this.accId = accId;
		this.usrId = usrId;
		System.out.println("Enter account type. [1] for Checking or [2] for Savings");
		Scanner sc = new Scanner(System.in);
		accType = sc.nextInt();
		this.accType = accType;
		//this.active = active;
		this.accountBalance = accountBalance;
		sc.close();
	}
	
	
	
	public void setAccountBalance(double ab) {
		accountBalance = ab;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public double withdraw(double amount) {

		if (accountBalance <= 0) {
			System.out.println("Insuffient funds");
		} else if (amount > accountBalance) {
			System.out.println("Not enough funds");
		} else {

			double balanceAmount = accountBalance - amount;
			setAccountBalance(balanceAmount);
			System.out.println("Account balance: " + balanceAmount);
		}

		return amount;
	}

	public void deposit(double depositAmount) {

		double afterDepositBalance = accountBalance + depositAmount;
		setAccountBalance(afterDepositBalance);
		String show = Double.toString(afterDepositBalance);
		System.out.println("Account balance: " + show);

	}

	public double transfer(double transfer) {

		double transTotal = accountBalance + transfer;
		setAccountBalance(transTotal);
		System.out.println("Account Balance: " + transTotal);

		return transTotal;

	}

}
