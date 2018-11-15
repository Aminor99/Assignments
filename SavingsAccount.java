/*Name: Asia Minor
 *Date: November 15, 2018
 *Purpose: 12. SavingsAccount class , to write code to simulate a bank account 
 */
import javax.swing.JOptionPane;

public class SavingsAccount {

	private static double annual_rate, balance;
	
	public SavingsAccount(double b, double ar) {
			balance = b;
			annual_rate = ar;
	}
	//@param amount, takes the amount teh user inputs and returns the values subtracted from the balance
	public double withdraw(double amount) {
		System.out.println("You withdrew " + amount + " dollars.");
		amount = balance - amount;
		System.out.println("You now have " + amount + " dollars.");
		return amount;
	}
	//@param amount, takes the input form the user and returns the value added to the balance
	public double deposit(double amount) {
		System.out.println("You deposited " + amount + " dollars.");
		amount = balance + amount;
		System.out.println("You now have " + amount + " dollars.");
		return amount;
	}
	//@param amount, takes input from the user and returns the value divided by 12 and adds it to the balance
	public double monthly_interest(double amount) {
		System.out.println("Your monthly rate is " + amount + ".");
		double monthly_interest = annual_rate/12;
		double interest = balance * monthly_interest;
		amount = balance + interest;
		System.out.println("Your now have " + amount + ".");
		return amount;
	}
	public static void main (String [] args) {
		String askBalance, askAnnualRate, askWithdraw, askDeposit, askMonthlyRate;
		double balance, annualrate, withdraw, deposit, monthlyRate;
		
		askBalance = JOptionPane.showInputDialog(null, "What is your balance?");
		askAnnualRate = JOptionPane.showInputDialog(null, "What s your annual rate?");
		askWithdraw = JOptionPane.showInputDialog(null, "How much money do you want to withdraw?");
		askDeposit = JOptionPane.showInputDialog(null, "How much money do you want to deposit?");
		askMonthlyRate = JOptionPane.showInputDialog(null, "What s your monthly rate?");
		
		balance = Double.parseDouble(askBalance);
		annualrate = Double.parseDouble(askAnnualRate);
		withdraw = Double.parseDouble(askWithdraw);
		deposit = Double.parseDouble(askDeposit);
		monthlyRate = Double.parseDouble(askMonthlyRate);
		
		SavingsAccount SA = new SavingsAccount(balance, annualrate);
		double w = SA.withdraw(withdraw);
		double d = SA.deposit(deposit);
		double mR = SA.monthly_interest(monthlyRate);
		
		double total = w + d + mR;
		
		JOptionPane.showMessageDialog(null, "You now have a total of " + total + " in your account!");
	}

}
