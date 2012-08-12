package de.pluralistix.bankaccounts.Methods.Methods2;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method28 extends Method06 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 8;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 8, 7, 6, 5, 4, 3, 2, -1,
			-1, -1 };

	/**
	 */
	public Method28() {
		super();
		super.setWeight(WEIGHT);
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
	}

}
