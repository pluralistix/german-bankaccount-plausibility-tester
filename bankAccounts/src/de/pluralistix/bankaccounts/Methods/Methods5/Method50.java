package de.pluralistix.bankaccounts.Methods.Methods5;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method50 extends Method06 {

	/**
	 */
	static final int CHECKDIGITPOSITION = 7;

	/**
	 */
	static final int[] WEIGHT = new int[] { 7, 6, 5, 4, 3, 2, -1, -1, -1, -1 };

	/**
	 */
	public Method50() {
		super();
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
		super.setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.validate(paramAccountNumber);
		if (!isValid() && paramAccountNumber.length() < 8) {
			setNormalizedAccountNumber(paramAccountNumber + "000");
			super.validate(paramAccountNumber);
		}
	}
}
