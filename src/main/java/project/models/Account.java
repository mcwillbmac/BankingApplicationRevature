package project.models;


public class Account {

	private int accId;
	private int userId;
	private int accType;
	private int active;
	protected static double accountBalance;
	
	public Account() {
		
		
	}

	public Account(int accId, int userId, int accType, double accountBalance) {
		super();
		this.accId = accId;
		this.userId = userId;
		this.accType = accType;
		this.accountBalance = accountBalance;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getUsrId() {
		return userId;
	}

	public void setUsrId(int usrId) {
		this.userId = usrId;
	}

	public int getAccType() {
		return accType;
	}

	public void setAccType(int accType) {
		this.accType = accType;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accId;
		result = prime * result + accType;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + active;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accId != other.accId)
			return false;
		if (accType != other.accType)
			return false;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (active != other.active)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", userId=" + userId + ", accType=" + accType + ", active=" + active
				+ ", accountBalance=" + accountBalance + "]";
	}

}
