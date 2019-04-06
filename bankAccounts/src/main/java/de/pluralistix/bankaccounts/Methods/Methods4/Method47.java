package de.pluralistix.bankaccounts.Methods.Methods4;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method47 extends Method06 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 9;

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, -1, -1, 6, 5, 4, 3, 2, -1, -1 };

	/**
	 */
	public Method47() {
		super();
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
		super.setWeight(WEIGHT);
	}
}
