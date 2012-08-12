package de.pluralistix.bankaccounts.Methods.MethodsC;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods2.Method22;

/**
 * @author pluralistix
 */
public class MethodC2 extends Method22 {

	/**
	 * 
	 */
	public MethodC2() {
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
			Method00 m = new Method00();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
