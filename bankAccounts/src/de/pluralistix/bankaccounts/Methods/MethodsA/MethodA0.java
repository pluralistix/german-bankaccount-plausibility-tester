package de.pluralistix.bankaccounts.Methods.MethodsA;

import de.pluralistix.bankaccounts.Methods.Methods3.Method37;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class MethodA0 extends Method37 {

	/**
	 */
	public MethodA0() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.accountAsNumber(paramAccountNumber) >= 100
				|| Utils.accountAsNumber(paramAccountNumber) <= 999) {
			setValid(true);
		} else {
			super.validate(paramAccountNumber);
		}
	}

}
