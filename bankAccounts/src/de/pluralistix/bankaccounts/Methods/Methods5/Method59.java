package de.pluralistix.bankaccounts.Methods.Methods5;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method59 extends Method00 {

	/**
	 */
	public Method59() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (paramAccountNumber.length() < 9) {
			setValid(true);
		} else {
			super.setAccountNumber(paramAccountNumber);
			super.validate(paramAccountNumber);
		}
	}
}
