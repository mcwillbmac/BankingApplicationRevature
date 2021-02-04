package project.models;

public class Savings extends Account {

	boolean open;

	public Savings(int accId, int usrId, int accType, double accountBalance) {
		super(accId, usrId, accType, accountBalance);
		// TODO Auto-generated constructor stub
	}

	public void setAccountBalance(double ab) {
		setAccountBalance(ab);
	}

	public double getAccountBalance() {
		return getAccountBalance();
	}

	public double withdraw(double amount) {

		if (getAccountBalance() <= 0) {
			System.out.println("Insuffient funds");
		} else if (amount > getAccountBalance()) {
			System.out.println("Not enough funds");

		} else {

			double balanceAmount = getAccountBalance() - amount;
			setAccountBalance(balanceAmount);
			System.out.println("Account balance: " + balanceAmount);
		}

		return amount;
	}

	public void deposit(double depositAmount) {

		double afterDepositBalance = getAccountBalance() + depositAmount;
		setAccountBalance(afterDepositBalance);
		String show = Double.toString(afterDepositBalance);
		System.out.println("Account balance: " + show);
	}

	public double transfer(double transfer) {

		double transTotal = getAccountBalance() + transfer;
		setAccountBalance(transTotal);
		System.out.println("Account Balance: " + transTotal);

		return transTotal;

	}

}
