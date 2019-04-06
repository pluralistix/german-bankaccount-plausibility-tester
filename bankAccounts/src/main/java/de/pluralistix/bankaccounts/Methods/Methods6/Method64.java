package de.pluralistix.bankaccounts.Methods.Methods6;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method64 extends Method06 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 7;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 9, 10, 5, 8, 4, 2, -1, -1,
			-1, -1 };

	/**
	 */
	public Method64() {
		super();
		super.setWeight(WEIGHT);
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
	}
}
