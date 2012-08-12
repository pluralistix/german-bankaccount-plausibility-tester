package de.pluralistix.bankaccounts.Methods.MethodsD;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods1.Method10;
import de.pluralistix.bankaccounts.Methods.Methods1.Method18;
import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class MethodD9 extends Method00 {

	/**
	 * 
	 */
	public MethodD9() {
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
			AMethod m = new Method10();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
			if (!isValid()) {
				m = new Method18();
				m.setAccountNumber(paramAccountNumber);
				m.validate(paramAccountNumber);
				setValid(m.isValid());
			}
		}
	}
}
