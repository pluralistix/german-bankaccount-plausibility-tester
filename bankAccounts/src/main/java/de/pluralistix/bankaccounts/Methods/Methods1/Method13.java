package de.pluralistix.bankaccounts.Methods.Methods1;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method13 extends Method00 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 8;

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, 1, 2, 1, 2, 1, 2, -1,
			-1, -1 };

	/**
	 */
	public Method13() {
		super();
		super.setWeight(WEIGHT);
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final String internalAccountNumber = ((Long) Long
				.parseLong(paramAccountNumber)).toString();
		super.validate(internalAccountNumber);
		if (!isValid() && internalAccountNumber.length() <= 8) {
			setNormalizedAccountNumber(internalAccountNumber + "00");
			super.validate(internalAccountNumber);
		}
	}
}
