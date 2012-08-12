package de.pluralistix.bankaccounts.Methods.MethodsB;

import de.pluralistix.bankaccounts.Methods.Methods0.Method01;
import de.pluralistix.bankaccounts.Methods.Methods0.Method09;

/**
 * @author pluralistix
 */
public class MethodB7 extends Method01 {

	/**
	 * 
	 */
	public MethodB7() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final Long dummy = Long.parseLong(getNormalizedAccountNumber());
		if (dummy >= 1000000 && dummy <= 5999999 || dummy >= 700000000
				&& dummy <= 899999999) {
			super.validate(paramAccountNumber);
		} else {
			setValid((new Method09()).isValid());
		}
	}
}
