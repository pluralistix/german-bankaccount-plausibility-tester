package de.pluralistix.bankaccounts.Methods.Methods6;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method63 extends Method00 {

	/**
	 */
	private static final int CHECKDIGITPOSITION_A = 8;

	/**
	 */
	private static final int CHECKDIGITPOSITION_B = 10;

	/**
	 */
	private static final int[] WEIGHT_A = new int[] { -1, 1, 2, 1, 2, 1, 2, -1,
			-1, -1 };

	/**
	 */
	private static final int[] WEIGHT_B = new int[] { -1, -1, -1, 1, 2, 1, 2,
			1, 2, -1 };

	/**
	 */
	public Method63() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		if (Long.valueOf(paramAccountNumber) > 999999999) {
			setValid(false);
			return;
		}
		if (Long.valueOf(paramAccountNumber) < 10000000) {
			super.setCheckDigitPosition(CHECKDIGITPOSITION_B);
			super.setWeight(WEIGHT_B);
			super.validate(paramAccountNumber);
		} else {
			super.setWeight(WEIGHT_A);
			super.setCheckDigitPosition(CHECKDIGITPOSITION_A);
			super.validate(paramAccountNumber);
		}
	}
}
