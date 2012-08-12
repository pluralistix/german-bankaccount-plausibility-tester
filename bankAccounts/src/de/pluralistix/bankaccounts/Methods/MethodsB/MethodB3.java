package de.pluralistix.bankaccounts.Methods.MethodsB;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;
import de.pluralistix.bankaccounts.Methods.Methods3.Method32;

/**
 * @author pluralistix
 */
public class MethodB3 extends Method32 {

	/**
	 * 
	 */
	public MethodB3() {
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
			Method06 m = new Method06();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
