package de.pluralistix.bankaccounts.Methods.MethodsB;

import de.pluralistix.bankaccounts.Methods.Methods0.Method01;
import de.pluralistix.bankaccounts.Methods.Methods0.Method05;

/**
 * @author pluralistix
 */
public class MethodB1 extends Method05 {

	/**
	 * 
	 */
	public MethodB1() {
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
			Method01 m = new Method01();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
