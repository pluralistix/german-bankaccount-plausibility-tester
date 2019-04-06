package de.pluralistix.bankaccounts.Methods.MethodsB;

import de.pluralistix.bankaccounts.Methods.Methods2.Method20;
import de.pluralistix.bankaccounts.Methods.Methods5.Method53;

/**
 * @author pluralistix
 */
public class MethodB6 extends Method20 {

	/**
	 * 
	 */
	public MethodB6() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final long dummy = Long.parseLong(getNormalizedAccountNumber()
				.substring(0, 5));
		if (Long.parseLong(getNormalizedAccountNumber()) >= 1000000000L
				|| (dummy >= 2691 && dummy <= 2699)) {
			super.validate(paramAccountNumber);
		} else {
			Method53 m = new Method53();
			m.setAccountNumber(paramAccountNumber);
			m.setBankCode(getBankCode());
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
