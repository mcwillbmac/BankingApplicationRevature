package project.accounts;

public interface Account {

public static double accountBalance = 0;
	
	
	
     abstract double withdraw(double d);
	 abstract void deposit(double d);
	 abstract void setAccountBalance(double i);
	 abstract double getAccountBalance();
	 abstract double transfer(double d);
	
	
	
}

