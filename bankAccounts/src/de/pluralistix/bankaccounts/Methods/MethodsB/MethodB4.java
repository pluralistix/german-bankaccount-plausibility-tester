package de.pluralistix.bankaccounts.Methods.MethodsB;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods0.Method02;

/**
 * @author pluralistix
 */
public class MethodB4 extends Method02 {

	/**
	 * 
	 */
	public MethodB4() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Long.parseLong(getNormalizedAccountNumber()) < 9000000000L) {
			super.validate(paramAccountNumber);
		} else {
			Method00 m = new Method00();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
