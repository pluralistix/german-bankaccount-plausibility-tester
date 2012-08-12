package de.pluralistix.bankaccounts.Methods.Methods2;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method26 extends Method06 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 8;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 2, 7, 6, 5, 4, 3, 2, -1,
			-1, -1 };

	/**
	 */
	public Method26() {
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
		if (getNormalizedAccountNumber().startsWith("00")) {
			setNormalizedAccountNumber(getNormalizedAccountNumber().substring(
					3, 10)
					+ "00");
		}
		super.validate(paramAccountNumber);
	}
}
