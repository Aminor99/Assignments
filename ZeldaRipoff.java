//Name: Asia Minor
//Purpose: To simulate a game in a gameboy
//Date: 2-4-19
import javax.swing.JOptionPane;
import java.util.Random;

public class ZeldaRipoff {

//global variables
	private static int n, j, max = 24, min = 0, itemsCollected = 0, monstersDefeated = 0;
	private static String inputName;
	
//This initializes an empty 5x5 array
	private static String MAP[][] = new String [25][25];
	
//Those sweet sweet random numbers :)	
	
//the vertical position of the monsters in the map array	
	static Random ranMonster1Num = new Random(); 
	static Random ranMonster2Num = new Random(); 
	static Random ranMonster3Num = new Random(); 
	static Random ranMonster4Num = new Random(); 
	static Random ranMonster5Num = new Random(); 
	static Random ranMonster6Num = new Random();
	static int monsterNum1 = ranMonster1Num.nextInt(max) + min; 	
	static int monsterNum2 = ranMonster2Num.nextInt(max) + min; 	
	static int monsterNum3 = ranMonster3Num.nextInt(max) + min;
	static int monsterNum4 = ranMonster3Num.nextInt(max) + min; 	
	static int monsterNum5 = ranMonster5Num.nextInt(max) + min; 	
	static int monsterNum6 = ranMonster6Num.nextInt(max) + min;

//the horizontal position of the monsters in the map array
	static Random ranMonster1Num2 = new Random(); 
	static Random ranMonster2Num2 = new Random(); 
	static Random ranMonster3Num2 = new Random(); 
	static Random ranMonster4Num2 = new Random(); 
	static Random ranMonster5Num2 = new Random(); 
	static Random ranMonster6Num2 = new Random();
	static int monsterNum1_2 = ranMonster1Num2.nextInt(max) + min; 	
	static int monsterNum2_2 = ranMonster2Num2.nextInt(max) + min; 	
	static int monsterNum3_2 = ranMonster3Num2.nextInt(max) + min;
	static int monsterNum4_2 = ranMonster4Num2.nextInt(max) + min; 	
	static int monsterNum5_2 = ranMonster5Num2.nextInt(max) + min; 	
	static int monsterNum6_2 = ranMonster6Num2.nextInt(max) + min;
	
//the vertical position of the items in the map array	
	static Random ranItem1Num = new Random(); 
	static Random ranItem2Num = new Random(); 
	static Random ranItem3Num = new Random(); 
	static Random ranItem4Num = new Random();
	static Random ranItem5Num = new Random();
	static int itemNum1 = ranItem1Num.nextInt(max) + min; 
	static int itemNum2 = ranItem1Num.nextInt(max) + min; 
	static int itemNum3 = ranItem1Num.nextInt(max) + min;
	static int itemNum4 = ranItem1Num.nextInt(max) + min; 
	static int itemNum5 = ranItem1Num.nextInt(max) + min; 
	
//the horizontal position of the items in the mapp array	
	static Random ranItem1Num2 = new Random(); 
	static Random ranItem2Num2 = new Random(); 
	static Random ranItem3Num2 = new Random(); 
	static Random ranItem4Num2 = new Random();
	static Random ranItem5Num2 = new Random();
	static int itemNum1_2 = ranItem1Num2.nextInt(max) + min; 
	static int itemNum2_2 = ranItem1Num2.nextInt(max) + min; 
	static int itemNum3_2 = ranItem1Num2.nextInt(max) + min;
	static int itemNum4_2 = ranItem1Num2.nextInt(max) + min; 
	static int itemNum5_2 = ranItem1Num2.nextInt(max) + min; 
	
//initializing player character	 
	private static objects player = new objects (inputName, "p ", 12, 12); 
//the monsters that the player has to defeat	
	private static objects monster1 = new objects ("skeleton ", "m ", monsterNum1, monsterNum1_2);
	private static objects monster2 = new objects ("bat ", "m ", monsterNum2, monsterNum2_2);
	private static objects monster3 = new objects ("slime ", "m ", monsterNum3, monsterNum3_2);
	private static objects monster4 = new objects ("wolf ", "m ", monsterNum4, monsterNum4_2);
	private static objects monster5 = new objects ("golbin ", "m ", monsterNum5, monsterNum5_2);
	private static objects monster6 = new objects ("spider ", "m ", monsterNum6, monsterNum6_2);
	static objects monsters[] = {monster1, monster2, monster3, monster4, monster5, monster6};
//the items that the player has to collect	
	private static objects item1 = new objects ("Magic Pendant ", "a ", itemNum1, itemNum1_2);
	private static objects item2 = new objects ("Goblet of Honesty ", "a ", itemNum2, itemNum2_2);
	private static objects item3 = new objects ("Thunder Tome ", "a ", itemNum3, itemNum3_2);
	private static objects item4 = new objects ("Tiara of Strength ", "a ", itemNum4, itemNum4_2);
	private static objects item5 = new objects ("Gem of Teleportation", "a ", itemNum5, itemNum5_2);
	static objects items[] = {item1, item2, item3, item4, item5};

//main method	
	public static void main (String [] args) {
		String askStart = JOptionPane.showInputDialog("*Insert Cool Game Title Here* \n       Start \n       Load \n         Save \nPlease type in the option you wish to select.");
		if(askStart.equalsIgnoreCase("start")) {
			JOptionPane.showMessageDialog(null, "Game Start!");
		} else if (askStart.equalsIgnoreCase("save")) {
			saveGame(player, monsters, items, MAP);
		} 

		JOptionPane.showMessageDialog(null,"You are an adventurer. Your goal is to find the \n ancient artifacts and defeat all the monsters. \n Have fun and Venture on!");
		inputName = JOptionPane.showInputDialog("What will you name your character?");
		player.setName(inputName); //gives character name inputed
		JOptionPane.showMessageDialog(null, "A map will appear. You are represented by the letter p. The \n monsters are reprented by m and the artifacts by a.");
		showMap();
		
		if(itemsCollected >= 0 && itemsCollected < 6 && monstersDefeated >= 0 && monstersDefeated < 7) { //ADD SIMILAR FORMAT FOR MONSTERS
			do {
				askAction();
				comparePosition(player, monsters, items);
			}
			while(itemsCollected!=6 && monstersDefeated!=7);
		}
	}
//This places the player in the center of the map, and for now, one monster	
	//fills the array
	public static void showMap() {
		
		System.out.println("---------------------------------------------------------------------------"); //seperates the maps each time the loop pulls it up
		for(n = 0; n < MAP.length; ++n) {
			for(j = 0; j < MAP.length; ++j) {
				if(n == player.verticalPosition && j == player.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = player.displayLetter + (" "); //PLAYER CHARACTER
				} else if(n == monster1.verticalPosition && j == monster1.horizontalPosition) { //MONSTERS
					System.out.print(" ");
					MAP[n][j] = monster1.displayLetter + (" ");
				} else if(n == monster2.verticalPosition && j == monster2.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = monster2.displayLetter + (" ");
				} else if(n == monster3.verticalPosition && j == monster3.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = monster3.displayLetter + (" ");
				} else if(n == monster1.verticalPosition && j == monster1.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = monster3.displayLetter + (" ");
				} else if(n == monster4.verticalPosition && j == monster4.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = monster4.displayLetter + (" ");
				} else if(n == monster5.verticalPosition && j == monster5.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = monster5.displayLetter + (" ");
				} else if(n == monster6.verticalPosition && j == monster6.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = monster6.displayLetter + (" ");
				} else if (n == item1.verticalPosition && j == item1.horizontalPosition) { //ITEMS
					System.out.print(" ");
					MAP[n][j] = item1.displayLetter + (" ");
				} else if (n == item2.verticalPosition && j == item2.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = item2.displayLetter + (" ");
				} else if (n == item3.verticalPosition && j == item3.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = item3.displayLetter + (" ");
				} else if (n == item4.verticalPosition && j == item4.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = item4.displayLetter + (" ");
				} else if (n == item5.verticalPosition && j == item5.horizontalPosition) {
					System.out.print(" ");
					MAP[n][j] = item5.displayLetter + (" ");
				} else {
					MAP[n][j] = " [] ";
				}
				System.out.print(MAP[n][j]);
			}
				System.out.print("\n");
		}
		System.out.println("---------------------------------------------------------------------------");
	}
//asks action for user to perform
	public static void askAction() {
		String ask = JOptionPane.showInputDialog("What do you want to do?\n    Move \n    Quit \n    Save Game");
		if (ask.equalsIgnoreCase("move")) {
			askMove();
			showMap();
		} else if (ask.equalsIgnoreCase("quit")) {
			JOptionPane.showMessageDialog(null, "Thanks for playing!");
			System.exit(0);
		} else if (ask.equalsIgnoreCase("save game")) {
		    saveGame(player, monsters, items, MAP);
		}
	}
//supposed to save the game :/	
public static void saveGame(objects p, objects[] eA, objects[] iA, String[][] MAP) {
		
	}
//asks user if what direction they wanna go	
	public static void askMove() {
			String askMovement = JOptionPane.showInputDialog("Which direction do you want to move?  \n" +
					"      Up   Down\n" +
					"      Left Right");
		
		if (askMovement.equalsIgnoreCase("up")){
			moveUp(player);
		} else if (askMovement.equalsIgnoreCase("down")) {
			moveDown(player);
		} else if (askMovement.equalsIgnoreCase("left")) {
			moveLeft(player);
		} else if (askMovement.equalsIgnoreCase("right")) {
			moveRight(player);
		} else {
			JOptionPane.showMessageDialog(null, "That is not proper input.");
		}
	}
//moves the player up on the grid
//@param p, the player character	
	public static void moveUp(objects p) {
		p.setVerticalPosition(p.verticalPosition - 1);
	}
//moves the player down on the grid
//@param p, the player character
	public static void moveDown(objects p) {
		p.setVerticalPosition(p.verticalPosition + 1);
	}
//moves the player left on the grid
//@param p, the player character	
	public static void moveLeft(objects p) {
		p.setHorizontalPosition(p.horizontalPosition - 1);
	}
//moves the player right on the grid
//@param p, the player character	
	public static void moveRight(objects p) {
		p.setHorizontalPosition(p.horizontalPosition + 1);
	}
//compares the position of the player with all the enemies and items
//@param p, the player characters, @param eA, the array of enemies,	@param iA, the array of items
	public static void comparePosition(objects p, objects[] eA, objects[] iA) {
		int i, o; //for the loops, brother
		//the loops
		
	//im going to print these out to know where exactly where the computer thinks these objects are in the arra7	
		int pVP = p.getVerticalPosition();
		int pHP = p.getHorizontalPosition();  System.out.println("The player is at " + pVP + "," + pHP);
		
		for(i = 0; i < eA.length; ++i) {
			if(eA[i].displayLetter.equalsIgnoreCase("m ") && (p.verticalPosition == eA[i].verticalPosition) && (p.horizontalPosition == eA[i].horizontalPosition + 1)) { //if the enemy is to the RIGHT of the player
				objects chosenEnemy = eA[i];
				engageEnemy(p, chosenEnemy);
				//print statement for testing
					int eVP = chosenEnemy.getVerticalPosition();
					int eHP = chosenEnemy.getHorizontalPosition(); System.out.println("The " + chosenEnemy.name + " is at " + eVP + "," + eHP);
			} else if (eA[i].displayLetter.equalsIgnoreCase("m ") && (p.verticalPosition == eA[i].verticalPosition) && (p.horizontalPosition == eA[i].horizontalPosition - 1)){ //if the enemy is to the LEFT of the player
				objects chosenEnemy = eA[i];
				engageEnemy(p, chosenEnemy);
				//print statement for testing
					int eVP = chosenEnemy.getVerticalPosition();
					int eHP = chosenEnemy.getHorizontalPosition(); System.out.println("The " + chosenEnemy.name + " is at " + eVP + "," + eHP);
			} else if (eA[i].displayLetter.equalsIgnoreCase("m ") && (p.horizontalPosition == eA[i].horizontalPosition) && (p.verticalPosition == eA[i].verticalPosition - 1)) { //if the enemy is ABOVE the player
				objects chosenEnemy = eA[i];
				engageEnemy(p, chosenEnemy);
				//print statement for testing
					int eVP = chosenEnemy.getVerticalPosition();
					int eHP = chosenEnemy.getHorizontalPosition(); System.out.println("The " + chosenEnemy.name + " is at " + eVP + "," + eHP);
			} else if (eA[i].displayLetter.equalsIgnoreCase("m ") && (p.horizontalPosition == eA[i].horizontalPosition) && (p.verticalPosition == eA[i].verticalPosition + 1)) { //if the enemy is BELOW the player
				objects chosenEnemy = eA[i];
				engageEnemy(p, chosenEnemy);
				//print statement for testing
					int eVP = chosenEnemy.getVerticalPosition();
					int eHP = chosenEnemy.getHorizontalPosition(); System.out.println("The " + chosenEnemy.name + " is at " + eVP + "," + eHP);
			}
		}
		
		for(o = 0; o < iA.length; ++o) {
			if(iA[o].displayLetter.equalsIgnoreCase("a ") && (p.verticalPosition == iA[o].verticalPosition) && (p.horizontalPosition == iA[o].horizontalPosition + 1)) { //if the item is to the RIGHT of the player
				objects chosenItem = iA[o];
				pickUpItem(p, chosenItem);
					//print statement
					int eVP = chosenItem.getVerticalPosition();
					int eHP = chosenItem.getHorizontalPosition(); System.out.println("The " + chosenItem.name + " is at " + eVP + "," + eHP);
			} else if (iA[o].displayLetter.equalsIgnoreCase("a ") && (p.verticalPosition == iA[o].verticalPosition) && (p.horizontalPosition == iA[o].horizontalPosition - 1)){ //if the item is to the LEFT of the player
				objects chosenItem = iA[o];
				pickUpItem(p, chosenItem);
					//print statement
					int eVP = chosenItem.getVerticalPosition();
					int eHP = chosenItem.getHorizontalPosition(); System.out.println("The " + chosenItem.name + " is at " + eVP + "," + eHP);
			} else if (iA[o].displayLetter.equalsIgnoreCase("a ") && (p.horizontalPosition == iA[o].horizontalPosition) && (p.verticalPosition == iA[o].verticalPosition - 1)) { //if the item is ABOVE the player
				objects chosenItem = iA[o];
					pickUpItem(p, chosenItem);
					//print statement
					int eVP = chosenItem.getVerticalPosition();
					int eHP = chosenItem.getHorizontalPosition(); System.out.println("The " + chosenItem.name + " is at " + eVP + "," + eHP);
			} else if (iA[o].displayLetter.equalsIgnoreCase("a ") && (p.horizontalPosition == iA[o].horizontalPosition) && (p.verticalPosition == iA[o].verticalPosition + 1)) { //if the item is BELOW the player
				objects chosenItem = iA[o];
				pickUpItem(p, chosenItem);
					//print statement
					int eVP = chosenItem.getVerticalPosition();
					int eHP = chosenItem.getHorizontalPosition(); System.out.println("The " + chosenItem.name + " is at " + eVP + "," + eHP);
			}
		}
	}
//method is called whenever the player is near an enemy	
//@param p, the player, @param cE the enemy that the player was close to	
	public static void engageEnemy(objects p, objects cE) {
		Random ranEncounterNum = new Random();
		int encNum = ranEncounterNum.nextInt(20) + 0, r = 8; //the number that the random number needs to be higher than for the user to beat the enemy
		JOptionPane.showMessageDialog(null, p.name + " encountered the " + cE.name + "!");
		if(encNum > r) {
			JOptionPane.showMessageDialog(null, p.name + " defeated the " + cE.name + ".");
			monstersDefeated++;
			cE.setDisplayLetter("[]");
		} else if (encNum <= r) {
			JOptionPane.showMessageDialog(null, p.name + " were slain by the " + cE.name + ".\n You returned to your starting position.");
			p.setVerticalPosition(12);
			p.setHorizontalPosition(12);
		}
	}
//method is called whenever the player is near an item
//@param p, the player, @param cI, the item the player was close to	
	public static void pickUpItem(objects p, objects cI) {
		JOptionPane.showMessageDialog(null, p.name + " found the " + cI.name + "!");
		itemsCollected++;
		System.out.println("You have collected a total of " + itemsCollected + " artifacts.");
		cI.setDisplayLetter("[]");
	}
}
//a class i made so that each object could have a name, letter that represents them, and a number that shows theyre position on the map
class objects{
	
	String name, displayLetter;
	int verticalPosition = 0, horizontalPosition = 0;
	objects (String n, String dL, int vP, int hP){
		name = n;
		displayLetter = dL;
		verticalPosition = vP;
		horizontalPosition = hP;
	}
	public void setName(String n) {
		name = n;
	}
	public void setVerticalPosition(int vP) {
		verticalPosition = vP;
	}
	public int getVerticalPosition() {
		return verticalPosition;
	}
	public void setHorizontalPosition(int hP) {
		horizontalPosition = hP;
	}
	public int getHorizontalPosition() {
		return horizontalPosition;
	}
	public void setDisplayLetter(String sDL) {
		displayLetter = sDL;
	}
}