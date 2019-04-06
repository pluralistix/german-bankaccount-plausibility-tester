package de.pluralistix.bankaccounts.Methods.Methods7;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method70 extends Method06 {

	/**
	 */
	private static final int[] WEIGHT_A = new int[] { 4, 3, 2, 7, 6, 5, 4, 3,
			2, -1 };

	/**
	 */
	private static final int[] WEIGHT_B = new int[] { 4, 3, 2, 7, 6, 5, 4, 3,
			2, -1 };

	/**
	 */
	public Method70() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (paramAccountNumber.substring(3, 4).equals("5")
				|| paramAccountNumber.substring(3, 5).equals("69")) {
			super.setWeight(WEIGHT_B);
		} else {
			super.setWeight(WEIGHT_A);
		}
		super.validate(paramAccountNumber);
	}

}
