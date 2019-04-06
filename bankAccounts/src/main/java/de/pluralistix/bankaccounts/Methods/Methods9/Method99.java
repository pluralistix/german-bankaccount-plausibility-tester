package de.pluralistix.bankaccounts.Methods.Methods9;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method99 extends Method06 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { 4, 3, 2, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	public Method99() {
		super();
		super.setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.accountAsNumber(paramAccountNumber) >= 396000000
				&& Utils.accountAsNumber(paramAccountNumber) <= 499999999) {
			setValid(true);
		} else {
			super.validate(paramAccountNumber);
		}
	}
}
