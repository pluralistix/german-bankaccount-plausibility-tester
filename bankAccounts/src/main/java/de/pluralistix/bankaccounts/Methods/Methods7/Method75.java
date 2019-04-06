package de.pluralistix.bankaccounts.Methods.Methods7;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method75 extends Method00 {

	/**
	 */
	private static final int CHECKDIGITPOSITION_A = 8;

	/**
	 */
	private static final int CHECKDIGITPOSITION_B = 7;

	/**
	 */
	private static final int[] WEIGHT_A = new int[] { -1, 2, 1, 2, 1, 2, -1,
			-1, -1, -1 };

	/**
	 */
	private static final int[] WEIGHT_B = new int[] { -1, -1, 2, 1, 2, 1, 2,
			-1, -1, -1 };

	/**
	 */
	private static final int[] WEIGHT_C = new int[] { -1, -1, -1, -1, 2, 1, 2,
			1, 2, -1 };

	/**
	 */
	private final int checkDigitPositionFromSuper;

	/**
	 */
	public Method75() {
		super();
		checkDigitPositionFromSuper = getCheckDigitPosition();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (getNormalizedAccountNumber().length() != 6
				&& getNormalizedAccountNumber().length() != 7
				&& getNormalizedAccountNumber().length() != 9) {
			setValid(false);
			return;
		} else if (getNormalizedAccountNumber().length() == 9) {
			if (getNormalizedAccountNumber().substring(2, 3).equals("9")) {
				super.setCheckDigitPosition(CHECKDIGITPOSITION_B);
				super.setWeight(WEIGHT_B);
			} else {
				super.setCheckDigitPosition(CHECKDIGITPOSITION_A);
				super.setWeight(WEIGHT_A);
			}
		} else {
			super.setCheckDigitPosition(checkDigitPositionFromSuper);
			super.setWeight(WEIGHT_C);
		}
		super.validate(paramAccountNumber);
	}
}
