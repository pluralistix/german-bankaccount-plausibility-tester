package de.pluralistix.bankaccounts.Methods.Methods9;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method91 extends Method06 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 7;
	/**
	 */
	private static final int[] WEIGHT_1 = new int[] { 7, 6, 5, 4, 3, 2, -1, -1, -1, -1 };

	/**
	 */
	private static final int[] WEIGHT_2 = new int[] { 2, 3, 4, 5, 6, 7, -1, -1, -1, -1 };

	/**
	 */
	private static final int[] WEIGHT_3 = new int[] { 10, 9, 8, 7, 6, 5, 0, 4, 3, 2 };

	/**
	 */
	private static final int[] WEIGHT_4 = new int[] { 9, 10, 5, 8, 4, 2, -1, -1, -1, -1 };

	/**
	 */
	private final Object[] weightArray;

	/**
	 */
	public Method91() {
		super();
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
		weightArray = new Object[] { WEIGHT_1, WEIGHT_2, WEIGHT_3, WEIGHT_4 };
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		for (int i = 0; i < weightArray.length && (!isValid()); i++) {
			setWeight((int[]) weightArray[i]);
			super.validate(paramAccountNumber);
		}
	}
}
