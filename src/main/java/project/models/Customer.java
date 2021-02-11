package project.models;

public class Customer extends User {

	private int id;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String address;
	private Role role;
	private double balance;
	private int accType;

	public Customer() {
		super();
	}

	public Customer(int id, String firstName, String lastName, String address, String userName, String passWord,
			Role role, double balance, int accType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
		this.balance = balance;
		this.accType = accType;
	}

	public Customer(String firstName, String lastName, String address, String userName, String passWord, Role role,
			double balance, int accType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
		this.balance = balance;
		this.accType = accType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccType() {
		return accType;
	}

	public void setAccType(int accType) {
		this.accType = accType;
	}

	public double withdraw(double amount) {

		if (balance <= 0) {
			System.out.println("Insuffient funds");
		} else if (amount > balance) {
			System.out.println("Not enough funds");
		} else {

			double balanceAmount = balance - amount;
			setBalance(balanceAmount);
			System.out.println("Account balance: " + balanceAmount);
		}

		return amount;
	}

	public void deposit(double depositAmount) {

		double afterDepositBalance = balance + depositAmount;
		setBalance(afterDepositBalance);
		String show = Double.toString(afterDepositBalance);
		System.out.println("Account balance: " + show);

	}

	public double transfer(double transfer) {

		double transTotal = balance + transfer;
		setBalance(transTotal);
		System.out.println("Account Balance: " + transTotal);

		return transTotal;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + accType;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (accType != other.accType)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", address = "
				+ address + ",userName = " + userName + ", passWord = " + passWord + ", role = " + role + " balance = "
				+ balance + " " + "accType = " + accType + "]";
	}

}