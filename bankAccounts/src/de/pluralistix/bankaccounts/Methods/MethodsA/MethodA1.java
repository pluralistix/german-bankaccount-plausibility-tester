package de.pluralistix.bankaccounts.Methods.MethodsA;

import de.pluralistix.bankaccounts.Methods.Methods6.Method60;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class MethodA1 extends Method60 {

	/**
	 */
	public MethodA1() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.getLengtOfAccountAsNumber(paramAccountNumber) == 8
				|| Utils.getLengtOfAccountAsNumber(paramAccountNumber) == 10) {
			super.validate(paramAccountNumber);
		} else {
			setValid(false);
		}
	}
}
