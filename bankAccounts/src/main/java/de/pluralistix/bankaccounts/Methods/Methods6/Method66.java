package de.pluralistix.bankaccounts.Methods.Methods6;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method66 extends Method06 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, 7, -1, -1, 6, 5, 4, 3,
			2, -1 };

    /**
	 */
	public Method66() {
		super();
		super.setWeight(WEIGHT);
        int[][] specialRest = new int[][]{{0, 1}, {1, 0}};
        super.setSpecialRest(specialRest);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Long.valueOf(paramAccountNumber) > 999999999L) {
			setValid(false);
		} else {
			super.validate(paramAccountNumber);
		}
	}
}
