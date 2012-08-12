package de.pluralistix.bankaccounts.Methods.MethodsA;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods1.Method10;

/**
 * @author pluralistix
 */
public class MethodA3 extends Method00 {

	/**
	 */
	public MethodA3() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.validate(paramAccountNumber);
		if (!isValid()) {
			Method10 m = new Method10();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
