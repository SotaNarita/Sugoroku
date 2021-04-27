package sugoroku;

import java.util.Random;

public class Dice {
	private Random rand = new Random();
	private int[] diceNumber={1, 2, 3, 4, 5, 6};
	
	//サイコロを転がすメソッド
	public int diceRoll() {
		int roll = diceNumber[rand.nextInt(diceNumber.length)];
		return roll;
	}
}
