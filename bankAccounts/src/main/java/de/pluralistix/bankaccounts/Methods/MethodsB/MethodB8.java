package de.pluralistix.bankaccounts.Methods.MethodsB;

import de.pluralistix.bankaccounts.Methods.Methods0.Method09;
import de.pluralistix.bankaccounts.Methods.Methods2.Method20;
import de.pluralistix.bankaccounts.Methods.Methods2.Method29;

/**
 * @author pluralistix
 */
public class MethodB8 extends Method20 {

	/**
	 * 
	 */
	public MethodB8() {
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
			Method29 m = new Method29();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
			if (!isValid()) {
				final long dummy = Long.parseLong(getNormalizedAccountNumber());
				if (dummy >= 5100000000L && dummy <= 5999999999L
						|| dummy >= 9010000000L && dummy <= 9109999999L) {
					setValid((new Method09()).isValid());
				}
			}
		}
	}
}
