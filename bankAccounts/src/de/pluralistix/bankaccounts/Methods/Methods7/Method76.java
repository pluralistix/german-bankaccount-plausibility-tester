package de.pluralistix.bankaccounts.Methods.Methods7;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method76 extends Method06 {

	/**
	 */
	private static final int CHECKDIGITPOSITION_1 = 8;

	/**
	 */
	private static final int CHECKDIGITPOSITION_2 = 10;

	/**
	 */
	private static final int MAXLENGTH = 10;

	/**
	 */
	private static final int MINLENGTH = 0;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 2, 3, 4, 5, 6, 7, 0, 0, 0,
			0 };

	/**
	 */
	private boolean doSubStractFirst = false;

	/**
	 */
	private int[][] specialRest = new int[][] { { 10, -1 } };

	/**
	 */
	public Method76() {
		super();
		setDoSubtractFirst(doSubStractFirst);
		setSpecialRest(specialRest);
	}

	/**
	 * @param account
	 *            bla
	 * @param length
	 *            bla
	 */
	private void calculate(final int[] account, final int length) {
		final int[] actualWeight = new int[WEIGHT.length];
		for (int i = account.length, x = 0; i > 0 && x < length - 1; i--, x++) {
			if (i >= getCheckDigitPosition()) {
				x--;
			} else {
				actualWeight[i - 1] = WEIGHT[x];
			}
		}
		setWeight(actualWeight);
		super.validate(getAccountNumber());
	}

	/**
	 * @param secondAttempt
	 *            bla
	 * @return bla
	 */
	private boolean internalValidate(final boolean secondAttempt) {
		boolean doValidate = true;
		if (secondAttempt) {
			setCheckDigitPosition(CHECKDIGITPOSITION_2);
		} else {
			setCheckDigitPosition(CHECKDIGITPOSITION_1);
		}
		final int length = Long
				.valueOf(
						getNormalizedAccountNumber().substring(1,
								getCheckDigitPosition())).toString().length();
		if (!secondAttempt && (length < MINLENGTH || length > MAXLENGTH)) {
			setValid(false);
			doValidate = false;
		}
		if (doValidate) {
			calculate(Utils.stringToIntArray(getNormalizedAccountNumber()),
					length);
		}
		if (!isValid() && !secondAttempt
				&& Utils.getLengtOfAccountAsNumber(getAccountNumber()) < 9
				&& !getAccountNumber().endsWith("00")) {
			internalValidate(true);
		}
		return isValid();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (!getNormalizedAccountNumber().substring(0, 1).matches(
				"^(1|2|3|5).*$")) {
			setValid(internalValidate(false));
		} else {
			setValid(false);
		}
	}
}
