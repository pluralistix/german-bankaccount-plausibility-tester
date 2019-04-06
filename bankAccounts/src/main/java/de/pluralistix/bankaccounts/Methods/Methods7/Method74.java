package de.pluralistix.bankaccounts.Methods.Methods7;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method74 extends Method00 {

	/**
	 */
	public Method74() {
		super();
	}

	/**
	 */
	private void internalValidate() {
		final int product = product();
		int rest = 5 - (product % 10);
		if (rest == 5) {
			rest = 0;
		} else if (rest < 0) {
			rest = 10 - (rest * -1);
		}
		if (rest == getCheckDigit()) {
			setValid(true);
		} else {
			setValid(false);
		}
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.validate(paramAccountNumber);
		if (!isValid() && paramAccountNumber.length() == 6) {
			internalValidate();
		}
	}

}
