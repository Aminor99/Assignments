/*Name: Asia Minor
 *Date: November 15, 2018
 *Purpose: To create a class that will toss a coin and randomly choose between heads or tails :) 
 *	Problem 16: Coin Toss
 */

import javax.swing.JOptionPane;
import java.util.Random;

public class Coin {
	
	private static String sideUp;
	
	Coin(){
		String sideUp;
	}
	
	public static Coin tossCoin(Coin coinTossed) {
		Random ranCoin = new Random();
		int sideOfCoin = ranCoin.nextInt(2) + 0;
				System.out.println(sideOfCoin);
		if(sideOfCoin == 1) {
			sideUp = new String("heads");
		} else if (sideOfCoin == 0) {
			sideUp = new String("tails");
		}
		getSideUp();
		return coinTossed;
	}
	public static String getSideUp() {
		//JOptionPane.showMessageDialog(null, "You tossed " + sideUp + ".");
		return sideUp;
	}
	
	static Coin c1 = new Coin();
	
	public static void main(String [] args) {
		int t = 0, h = 0;
		
		//reachable point
		for(int i = 0; i < 20; ++i) {
			Coin.tossCoin(c1);
			if(c1.sideUp.equals("tails")) {
				t++;
			} else if(c1.sideUp.equals("heads")) {
				h++;
			}
		}
		JOptionPane.showMessageDialog(null, "You tossed tails " + t + " times!");
		JOptionPane.showMessageDialog(null, "You tossed heads " + h + " times!");
	}

}
