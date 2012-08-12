package de.pluralistix.bankaccounts.Methods.Methods7;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method79 extends Method00 {

	/**
	 */
	private static final int CHECKDIGITPOSITION_A = 10;

	/**
	 */
	private static final int CHECKDIGITPOSITION_B = 9;

	/**
	 */
	private static final int[] WEIGHT_A = new int[] { 2, 1, 2, 1, 2, 1, 2, 1,
			2, -1 };

	/**
	 */
	private static final int[] WEIGHT_B = new int[] { 1, 2, 1, 2, 1, 2, 1, 2,
			-1, -1 };

	/**
	 */
	public Method79() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (getNormalizedAccountNumber().length() < 10) {
			setValid(false);
		} else {
			final int firstDigit = Utils.stringToIntArray(paramAccountNumber)[0];
			if (firstDigit == 1 || firstDigit == 2 || firstDigit == 9) {
				super.setWeight(WEIGHT_B);
				super.setCheckDigitPosition(CHECKDIGITPOSITION_B);
			} else {
				super.setWeight(WEIGHT_A);
				super.setCheckDigitPosition(CHECKDIGITPOSITION_A);
			}
		}
		super.validate(paramAccountNumber);
	}
}
