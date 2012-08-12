package de.pluralistix.bankaccounts.Methods.Methods2;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Special.MethodMH10;

/**
 * @author pluralistix
 */
public class Method27 extends Method00 {

	/**
	 */
	public Method27() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Long.valueOf(getAccountNumber()) < 1000000000) {
			super.validate(paramAccountNumber);
		} else {
			MethodMH10 m = new MethodMH10();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}

}
