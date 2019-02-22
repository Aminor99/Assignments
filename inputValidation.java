/*Name: Asia mInor
 * date: 2-7-19
 * Purpose: to test for input validation
 */
import javax.swing.JOptionPane;

public class inputValidation {
	//this is the main method
	public static void main (String [] args) {
		askNumber();
	}
	public static void askNumber() {
		String askContinue;
		
		do {
			String askInputNumber = JOptionPane.showInputDialog("Please input a number between between 1 and 5.");
			
			if(!askInputNumber.equals("1") && !askInputNumber.equals("2") && !askInputNumber.equals("3") && !askInputNumber.equals("4")
					&& !askInputNumber.equals("5")) {
				JOptionPane.showMessageDialog(null,"lol this isnt valid");
			} else {
			
			int number = Integer.parseInt(askInputNumber);
				if(number>= 1 && number <= 5) {
						checkValue(number);
				}
			}
			
			askContinue = JOptionPane.showInputDialog("Do You want to enter some more numbers? \n Type yes to continue or q to quit");
			
			if(askContinue.equalsIgnoreCase("yes")) {
				askNumber();
			} else if (askContinue.equalsIgnoreCase("q")) {
				JOptionPane.showMessageDialog(null,"Thanks for playing the number game");
				break;
			} else {
				JOptionPane.showMessageDialog(null, "That is incorrect input :/");
			}
			
		} while (askContinue != "q");
	}
	//this takes the value from the main method 
	//@param value, the number input from main ;)
	public static void checkValue(int value) {
		if (value >= 1 && value <= 5) {
			JOptionPane.showMessageDialog(null,"You entered a number inbetween 1 through 5!");
		} else if(value!=1 && value!= 2 && value !=3 && value != 4 && value != 5) {
			JOptionPane.showMessageDialog(null,"That is not valid input");
		} else {
			JOptionPane.showMessageDialog(null,"That is not valid input");
		}
	}
}
