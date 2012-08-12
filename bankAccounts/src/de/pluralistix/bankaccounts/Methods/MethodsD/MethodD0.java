/**
 */
package de.pluralistix.bankaccounts.Methods.MethodsD;

import de.pluralistix.bankaccounts.Methods.Methods0.Method09;
import de.pluralistix.bankaccounts.Methods.Methods2.Method20;

/**
 * @author pluralistix
 */
public class MethodD0 extends Method20 {

	/**
	 * 
	 */
	public MethodD0() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (!getNormalizedAccountNumber().matches("^57")) {
			super.validate(paramAccountNumber);
		} else {
			setValid((new Method09()).isValid());
		}
	}
}
