package de.pluralistix.bankaccounts.Methods.Methods6;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method61 extends Method00 {

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
	public Method61() {
		super();
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.setWeight(WEIGHT_A);
		if (paramAccountNumber.length() + getDiffLength() < 10) {
			setValid(false);
        } else if (!paramAccountNumber.substring(8, 9).equals("8")) {
			super.validate(paramAccountNumber);
		} else {
			super.setWeight(WEIGHT_B);
			super.validate(paramAccountNumber);
		}
	}
}
