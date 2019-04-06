package de.pluralistix.bankaccounts.Methods.Methods8;

import de.pluralistix.bankaccounts.Methods.Methods1.Method10;
import de.pluralistix.bankaccounts.Methods.Methods3.Method32;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method82 extends Method32 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, -1, -1, -1, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	public Method82() {
		super();
		super.setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9
				&& Utils.stringToIntArray(getNormalizedAccountNumber())[3] == 9) {
			Method10 m = new Method10();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		} else {
			super.validate(paramAccountNumber);
		}
	}
}
