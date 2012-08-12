package de.pluralistix.bankaccounts.Methods.MethodsA;

import de.pluralistix.bankaccounts.Methods.Methods0.Method01;
import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class MethodA9 extends Method01 {

	/**
	 */
	public MethodA9() {
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
			Method06 m = new Method06();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
