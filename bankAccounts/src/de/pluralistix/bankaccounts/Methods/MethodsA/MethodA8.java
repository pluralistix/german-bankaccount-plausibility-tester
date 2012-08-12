package de.pluralistix.bankaccounts.Methods.MethodsA;

import de.pluralistix.bankaccounts.Methods.Methods3.Method32;
import de.pluralistix.bankaccounts.Methods.Methods7.Method72;
import de.pluralistix.bankaccounts.Methods.Special.ImpersonalAccount;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class MethodA8 extends Method32 {

	/**
	 * 
	 */
	public MethodA8() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9) {
			ImpersonalAccount s = new ImpersonalAccount();
			s.setAccountNumber(paramAccountNumber);
			s.validate(paramAccountNumber);
			setValid(s.isValid());
		} else {
			super.validate(paramAccountNumber);
			if (!isValid()) {
				Method72 m = new Method72();
				m.setAccountNumber(paramAccountNumber);
				m.validate(paramAccountNumber);
				setValid(m.isValid());
			}
		}
	}
}
