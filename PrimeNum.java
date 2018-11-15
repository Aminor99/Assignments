/* Name: Asia Minor
   Purpose: To ask the user to input a whole number and finds out if that number is prime or not
   Date: November 13, 2018 	 
*/

import javax.swing.JOptionPane;

public class PrimeNum {
	
	private static int inputNum, z = 0, i, t; //The number the user inputs
	private static String askInputNum; //The string of the number so i can use joptionpane
	private static int arrayOfPrimeNums[] = {3,5,7,11};

	public static void main(String[] args) {
		
		try { //try catch is weird :I
			askInputNum = JOptionPane.showInputDialog(null, "Please input a whole positive number!");
			inputNum = Integer.parseInt(askInputNum);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "This is incorrect input >:U");
		}
		
		isPrime(inputNum);

	}
//Checks to see if the number is prime or not	
//@param num, the number that the user inputs, @return the same value	
	public static int isPrime(int num) {
		if(z != inputNum % 2) {
			for(i=0; i < 4; ++i) {
				if(z != inputNum % arrayOfPrimeNums[i]) {
					t++; //I had the print statement heare but it printed out 4 times and i did not want that
				}
			}
		} if(t <= 0 || t < 4) {
			JOptionPane.showMessageDialog(null,"This is not a prime number!");
		}
		if(t == 4) {
			JOptionPane.showMessageDialog(null, "This is a prime number!");
		}
		return num;
	}
}
