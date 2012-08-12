package de.pluralistix.bankaccounts.Methods.MethodsC;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods0.Method07;

/**
 * @author pluralistix
 */
public class MethodC9 extends Method00 {

	/**
	 * 
	 */
	public MethodC9() {
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
			Method07 m = new Method07();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
