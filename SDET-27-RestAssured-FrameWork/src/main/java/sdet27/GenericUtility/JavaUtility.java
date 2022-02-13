package sdet27.GenericUtility;

import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author DELL
 *
 */
public class JavaUtility {
	/**
	 * this method will generate a random value
	 * @return
	 */
	
	public int getRandomNumber() {
		Random r=new Random();
		int rand = r.nextInt();
		return rand;
	}
}
