package de.pluralistix.bankaccounts.Methods.Methods2;

import de.pluralistix.bankaccounts.Methods.Methods1.Method16;

/**
 * @author pluralistix
 */
public class Method23 extends Method16 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 7;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 7, 6, 5, 4, 3, 2, -1, -1,
			-1, -1 };

    /**
	 */
	public Method23() {
		super();
		super.setWeight(WEIGHT);
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
	}

	/**
	 * @param paramAccountNumber
	 * 			bla
	 */
	@Override
	public final void validate(String paramAccountNumber) {
		final int rest = product() % 11;
		if (rest == 0) {
			setValid(0 == getCheckDigit());
		} else if (rest == 1) {
			setValid(getNormalizedAccountNumber().substring(5, 6).equals(
					getNormalizedAccountNumber().substring(6, 7)));
		} else {
			setValid(11 - rest == getCheckDigit());
		}
	}
}
