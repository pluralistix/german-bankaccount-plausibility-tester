package de.pluralistix.bankaccounts.Methods.Methods1;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method16 extends Method06 {

    /**
	 */
    protected Method16() {
		super();
		int[][] specialRest = new int[][]{{0, 0}, {1, 0}};
        super.setSpecialRest(specialRest);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		String accountNumberStr = getNormalizedAccountNumber();
		int result = product() % getModulo();
		if (result == 1) {
			if (accountNumberStr.substring(8, 9).equals(
					accountNumberStr.substring(9, 10))) {
				setValid(true);
			} else {
				setValid(false);
			}
		} else {
			result = transformResult(result);
			if (result == getCheckDigit()) {
				setValid(true);
			} else {
				setValid(false);
			}
		}
	}
}
