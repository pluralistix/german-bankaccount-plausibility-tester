package de.pluralistix.bankaccounts.Methods.Methods6;

import de.pluralistix.bankaccounts.Methods.Methods0.Method09;
import de.pluralistix.bankaccounts.Methods.Methods2.Method28;
import de.pluralistix.bankaccounts.Methods.Special.MethodMH10;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method69 extends Method28 {

	/**
	 */
	public Method69() {
		super();
	}

	/**
	 * @return bla
	 */
	private boolean internalValidate() {
		MethodMH10 m = new MethodMH10();
		m.setAccountNumber(getAccountNumber());
		m.validate(getAccountNumber());
		return m.isValid();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final Long lAccountNumber = Utils.accountAsNumber(paramAccountNumber);
		if (lAccountNumber >= 9300000000L && lAccountNumber <= 9399999999L) {
			setValid((new Method09()).isValid());
		} else if (lAccountNumber >= 9700000000L
				&& lAccountNumber <= 9799999999L) {
			setValid(internalValidate());
			return;
		}
		super.validate(paramAccountNumber);
		if (!isValid()) {
			setValid(internalValidate());
		}
	}
}
