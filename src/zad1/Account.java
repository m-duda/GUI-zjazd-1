package zad1;

public class Account {
	
	private static double interestRate;
	private double balance;
	
	public Account (double balance){
		this.balance=balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public static void setInterestRate(double interestRate) {
		Account.interestRate = interestRate;
	}

	public static double getInterestRate() {
		return interestRate;
	}

	public void deposit(double deposit){
		if (deposit>0) {
			setBalance(balance+deposit);
		}
	}

	public void withdraw(double withdraw){
		if (withdraw<balance&withdraw>0){
			setBalance(balance-withdraw);
		}
	}
	
	public void transfer(Account konto, double transfer){
		if (transfer>0&transfer<balance){
			withdraw(transfer);
			konto.deposit(transfer);
		}
	}

	public void addInterest(){
		setBalance(balance*(100+interestRate)/100);
	}
}
