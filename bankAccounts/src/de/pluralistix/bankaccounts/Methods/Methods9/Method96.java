package de.pluralistix.bankaccounts.Methods.Methods9;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods1.Method19;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method96 extends Method19 {

	/**
	 */
	public Method96() {
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
			Method00 m = new Method00();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
			if (!isValid()) {
				if (Utils.accountAsNumber(paramAccountNumber) >= 1300000
						&& Utils.accountAsNumber(paramAccountNumber) < 99399999) {
					setValid(true);
				} else {
					setValid(true);
				}
			}
		}
	}
}
