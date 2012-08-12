package de.pluralistix.bankaccounts.Methods.Methods6;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method68 extends Method00 {

	/**
	 */
	private static final int[] WEIGHT_A = new int[] { -1, -1, -1, 1, 2, 1, 2,
			1, 2, -1 };

	/**
	 */
	private static final int[] WEIGHT_B1 = new int[] { 2, 1, 2, 1, 2, 1, 2, 1,
			2, -1 };

	/**
	 */
	private static final int[] WEIGHT_B2 = new int[] { 2, 1, -1, -1, 2, 1, 2,
			1, 2, -1 };

	/**
	 */
	public Method68() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.setCheckDigitPosition(10);
		final String internalAccountNumber = ((Long) Long
				.parseLong(paramAccountNumber)).toString();
		if (Utils.accountAsNumber(internalAccountNumber) >= 400000000
				&& Utils.accountAsNumber(internalAccountNumber) <= 499999999) {
			setValid(false);
			return;
		} else if (internalAccountNumber.length() == 10) {
			if (!internalAccountNumber.substring(3, 4).equals("9")) {
				setValid(false);
				return;
			} else {
				super.setWeight(WEIGHT_A);
			}
		} else if (internalAccountNumber.length() < 6) {
			setValid(false);
			return;
		} else {
			super.setWeight(WEIGHT_B1);
		}
		super.validate(internalAccountNumber);
		if (!isValid()) {
			super.setWeight(WEIGHT_B2);
			super.validate(internalAccountNumber);
		}
	}
}
