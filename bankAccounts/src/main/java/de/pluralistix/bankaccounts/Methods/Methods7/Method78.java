package de.pluralistix.bankaccounts.Methods.Methods7;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method78 extends Method00 {

	/**
	 */
	public Method78() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (paramAccountNumber.length() == 8) {
			setValid(false);
		} else {
			super.validate(paramAccountNumber);
		}
	}
}
