package de.pluralistix.bankaccounts.Methods.Methods4;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods0.Method01;

/**
 * @author pluralistix
 */
public class Method49 extends Method00 {

	/**
	 */
	public Method49() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setAccountNumber(paramAccountNumber);
		super.validate(paramAccountNumber);
		if (!isValid()) {
			Method01 m = new Method01();
			m.setAccountNumber(this.getAccountNumber());
			m.validate(this.getAccountNumber());
			setValid(m.isValid());
		}
	}
}
