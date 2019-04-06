package de.pluralistix.bankaccounts.Methods.MethodsA;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods1.Method10;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class MethodA5 extends Method00 {

	/**
	 * 
	 */
	public MethodA5() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.validate(paramAccountNumber);
		if (!isValid()
				&& (!(Utils.getLengtOfAccountAsNumber(paramAccountNumber) == 10 && Utils
						.stringToIntArray(paramAccountNumber)[1] == 9))) {
			Method10 m = new Method10();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
