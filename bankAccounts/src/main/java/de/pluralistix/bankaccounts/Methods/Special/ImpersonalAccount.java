package de.pluralistix.bankaccounts.Methods.Special;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class ImpersonalAccount extends Method06 {

	/**
	 */
	private static final int[] WEIGHT_A1 = new int[] { -1, -1, 8, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	private static final int[] WEIGHT_A2 = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	public ImpersonalAccount() {
		super();
		super.setWeight(WEIGHT_A1);
		setCrossSum(null);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final int rest = product() % getModulo();
		final int div = getModulo() - rest;
		if (rest == 0 || rest == 1) {
			setValid(0 == getCheckDigit());
		} else {
			setValid(div == getCheckDigit());
		}
		if (!isValid() && getWeight() != WEIGHT_A2) {
			super.setWeight(WEIGHT_A2);
			validate(paramAccountNumber);
		}
	}
}
