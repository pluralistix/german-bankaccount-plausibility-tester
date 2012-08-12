package de.pluralistix.bankaccounts.Methods.MethodsC;

import de.pluralistix.bankaccounts.Methods.Methods1.Method15;
import de.pluralistix.bankaccounts.Methods.Methods5.Method58;

/**
 * @author pluralistix
 */
public class MethodC4 extends Method15 {

	/**
	 * 
	 */
	public MethodC4() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bal
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
