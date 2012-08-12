package de.pluralistix.bankaccounts.Methods.Methods6;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method67 extends Method00 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 8;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 2, 1, 2, 1, 2, 1, -1, -1,
			2, -1 };

	/**
	 */
	public Method67() {
		super();
		super.setWeight(WEIGHT);
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
	}

}
