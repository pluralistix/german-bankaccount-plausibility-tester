package de.pluralistix.bankaccounts.Methods.Methods7;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method71 extends Method06 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, 6, 5, 4, 3, 2, 1, -1,
			-1, -1 };

	/**
	 */
	private int[][] specialRest = new int[][] { { 0, 0 }, { 1, 1 } };

	/**
	 */
	public Method71() {
		super();
		super.setWeight(WEIGHT);
		super.setSpecialRest(specialRest);
	}

}
