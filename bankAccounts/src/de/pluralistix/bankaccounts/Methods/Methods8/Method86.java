package de.pluralistix.bankaccounts.Methods.Methods8;

import de.pluralistix.bankaccounts.Methods.Methods3.Method32;
import de.pluralistix.bankaccounts.Methods.Methods7.Method72;
import de.pluralistix.bankaccounts.Methods.Special.ImpersonalAccount;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method86 extends Method72 {

	/**
	 */
	public Method86() {
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
			if (Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9) {
				ImpersonalAccount s = new ImpersonalAccount();
				s.setAccountNumber(paramAccountNumber);
				s.validate(paramAccountNumber);
				setValid(s.isValid());
			} else {
				Method32 m = new Method32();
				m.setAccountNumber(paramAccountNumber);
				m.validate(paramAccountNumber);
				setValid(m.isValid());
			}
		}
	}
}
