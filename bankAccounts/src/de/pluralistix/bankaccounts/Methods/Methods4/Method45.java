package de.pluralistix.bankaccounts.Methods.Methods4;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods0.Method09;

/**
 * @author pluralistix
 */
public class Method45 extends Method00 {

	/**
	 */
	public Method45() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (getNormalizedAccountNumber().substring(0, 1).equals("0")
				|| getNormalizedAccountNumber().substring(4, 5).equals("1")) {
			setValid((new Method09()).isValid());
			return;
		} else {
			super.validate(paramAccountNumber);
		}
	}
}
