package de.pluralistix.bankaccounts.Methods.Methods8;

import de.pluralistix.bankaccounts.Methods.Methods3.Method32;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method88 extends Method32 {

	/**
	 */
	static final int[] WEIGHT = new int[] { -1, -1, 8, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	private int[] weightFromSuper = null;

	/**
	 */
	public Method88() {
		super();
		weightFromSuper = getWeight();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9) {
			setWeight(WEIGHT);
			super.validate(paramAccountNumber);
		} else {
			setWeight(weightFromSuper);
			super.validate(paramAccountNumber);
		}
	}
}
