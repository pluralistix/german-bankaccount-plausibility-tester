package de.pluralistix.bankaccounts.Methods.MethodsC;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods5.Method58;

/**
 * @author pluralistix
 */
public class MethodC3 extends Method00 {

	/**
	 * 
	 */
	public MethodC3() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (!getNormalizedAccountNumber().startsWith("9")) {
			super.validate(paramAccountNumber);
		} else {
			Method58 m = new Method58();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
