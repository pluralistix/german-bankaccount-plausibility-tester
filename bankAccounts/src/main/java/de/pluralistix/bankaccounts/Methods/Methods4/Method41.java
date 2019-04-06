package de.pluralistix.bankaccounts.Methods.Methods4;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method41 extends Method00 {

	/**
	 */
	public Method41() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (paramAccountNumber.substring(3, 4).equals("9")) {
			setAccountNumber(paramAccountNumber.substring(3, 10));
		}
		super.validate(paramAccountNumber);
	}
}
