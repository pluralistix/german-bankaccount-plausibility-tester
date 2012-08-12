package de.pluralistix.bankaccounts.Methods.MethodsB;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods0.Method02;

/**
 * @author pluralistix
 */
public class MethodB2 extends Method02 {

	/**
	 * 
	 */
	public MethodB2() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Long.parseLong(getNormalizedAccountNumber()) < 8000000000L) {
			super.validate(paramAccountNumber);
		} else {
			Method00 m = new Method00();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
