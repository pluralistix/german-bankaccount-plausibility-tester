package de.pluralistix.bankaccounts.Methods.MethodsC;

import de.pluralistix.bankaccounts.Methods.Methods2.Method20;
import de.pluralistix.bankaccounts.Methods.Methods5.Method52;

/**
 * @author pluralistix
 */
public class MethodC0 extends Method52 {

	/**
	 * 
	 */
	public MethodC0() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (getNormalizedAccountNumber().startsWith("00")) {
			super.validate(paramAccountNumber);
			if (!isValid()) {
				setValid(validate2());
			}
		} else {
			setValid(validate2());
		}
	}

	/**
	 * @return bla
	 */
	private boolean validate2() {
		Method20 m = new Method20();
		m.setAccountNumber(getAccountNumber());
		m.validate(getAccountNumber());
		return m.isValid();
	}
}
