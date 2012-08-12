package de.pluralistix.bankaccounts.Methods.Methods4;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method46 extends Method06 {

	/**
	 */
	static final int CHECKDIGITPOSITION = 8;

	/**
	 */
	static final int[] WEIGHT = new int[] { -1, -1, 6, 5, 4, 3, 2, -1, -1, -1 };

	/**
	 */
	public Method46() {
		super();
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
		super.setWeight(WEIGHT);
	}
}
