import java.util.Random;
import javax.swing.JOptionPane;

public class FiveRandomNumbers {
	
	public static void main(String [] args) {
		
		JOptionPane.showMessageDialog(null,"So the thing thats gonna happen is that 5\n random numbers are created. \nIt gonna check to see if the numbers \nare in between 1 and 5.");
		
		int randomNumbers[] = new int[5];
		
		for(int i = 0; i < randomNumbers.length; ++i) {
			Random ranNum = new Random();
			randomNumbers[i] = ranNum.nextInt(25) + 0;
		}
		
		checkForValidation(randomNumbers);
	}
	public static void checkForValidation(int array[]) {
		
		for(int i = 0; i < array.length; ++i) {
			if (array[i]<= 1 && array[i] >= 5) {
				JOptionPane.showMessageDialog(null, array[i] +" is inbetween 1 and 5!");
			} else {
				JOptionPane.showMessageDialog(null,array[i] + " is not between 1 and 2. :(");
			}
		}
	}
}
