package de.pluralistix.bankaccounts.Methods.Methods6;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method65 extends Method00 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 8;

	/**
	 */
	private static final int[] WEIGHT_A = new int[] { 2, 1, 2, 1, 2, 1, 2, -1,
			-1, -1 };

	/**
	 */
	private static final int[] WEIGHT_B = new int[] { 2, 1, 2, 1, 2, 1, 2, -1,
			1, 2 };

	/**
	 */
	public Method65() {
		super();
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
	}

	@Override
	public final void validate(final String paramAccountNumber) {
		super.setWeight(WEIGHT_A);
		if (paramAccountNumber.substring(8, 9).equals("9")) {
			super.setWeight(WEIGHT_B);
		}
		super.validate(paramAccountNumber);
	}
}
