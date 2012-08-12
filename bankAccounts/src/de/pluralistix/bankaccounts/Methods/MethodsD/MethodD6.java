package de.pluralistix.bankaccounts.Methods.MethodsD;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods0.Method03;
import de.pluralistix.bankaccounts.Methods.Methods0.Method07;
import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class MethodD6 extends Method07 {

	/**
	 * 
	 */
	public MethodD6() {
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
			AMethod m = new Method03();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
			if (!isValid()) {
				m = new Method00();
				m.setAccountNumber(paramAccountNumber);
				m.validate(paramAccountNumber);
				setValid(m.isValid());
			}
		}
	}
}
