package project.accounts;

public class Account {

private static double accountBalance;
	
	
	
public void setAccountBalance(double ab) {
	accountBalance = ab;
}

public double getAccountBalance() {
	return accountBalance;
}

public double withdraw(double amount) {
	
	if(accountBalance <= 0) {
		System.out.println("Insuffient funds");
	}
	else if(amount > accountBalance) {
		System.out.println("Not enough funds");
	}
	else {
		
		double balanceAmount = accountBalance - amount;
		setAccountBalance(balanceAmount);
		System.out.println("Account balance: "+ balanceAmount);
	}
	
	return amount;
}


 public void deposit(double depositAmount) {
	
	double afterDepositBalance = accountBalance + depositAmount;
	setAccountBalance(afterDepositBalance);
	String show =  Double.toString(afterDepositBalance);
	System.out.println("Account balance: "+ show);
	
}
 public double transfer(double transfer) {
	 
	 double transTotal = accountBalance + transfer;
	 setAccountBalance(transTotal);
	 System.out.println("Account Balance: "+ transTotal);
	 
	 
	 return transTotal;
	 
 }



}

	
	
	


