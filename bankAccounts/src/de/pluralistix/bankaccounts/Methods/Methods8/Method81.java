package de.pluralistix.bankaccounts.Methods.Methods8;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;
import de.pluralistix.bankaccounts.Methods.Special.ImpersonalAccount;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method81 extends Method06 {

	/**
	 */
	static final int[] WEIGHT = new int[] { -1, -1, -1, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	public Method81() {
		super();
		super.setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9) {
			ImpersonalAccount s = new ImpersonalAccount();
			s.setAccountNumber(paramAccountNumber);
			s.validate(paramAccountNumber);
			setValid(s.isValid());
		} else {
			super.validate(paramAccountNumber);
		}
	}
}
