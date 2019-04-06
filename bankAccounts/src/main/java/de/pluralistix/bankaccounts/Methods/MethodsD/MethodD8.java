package de.pluralistix.bankaccounts.Methods.MethodsD;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods0.Method09;

/**
 * @author pluralistix
 */
public class MethodD8 extends Method00 {

	/**
	 * 
	 */
	public MethodD8() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (getNormalizedAccountNumber().matches("^[1-9].*$")) {
			super.validate(paramAccountNumber);
		} else if (Long.valueOf(getNormalizedAccountNumber()) >= 10000000
				&& Long.valueOf(getNormalizedAccountNumber()) <= 99999999) {
			setValid((new Method09()).isValid());
		}

	}
}
