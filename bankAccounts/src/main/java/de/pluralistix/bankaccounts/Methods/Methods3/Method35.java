package de.pluralistix.bankaccounts.Methods.Methods3;

import de.pluralistix.bankaccounts.Methods.Methods1.Method16;

/**
 * @author pluralistix
 */
public class Method35 extends Method16 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2,
			-1 };

	/**
	 */
	public Method35() {
		super();
		super.setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		String accountNumberStr = getNormalizedAccountNumber();
		int result = product() % getModulo();
		if (result == 10) {
			if (accountNumberStr.substring(8, 9).equals(
					accountNumberStr.substring(9, 10))) {
				setValid(true);
			} else {
				setValid(false);
			}
		} else {
			if (result == getCheckDigit()) {
				setValid(true);
			} else {
				setValid(false);
			}
		}
	}
}
