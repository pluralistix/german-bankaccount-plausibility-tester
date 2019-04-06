package de.pluralistix.bankaccounts.Methods.Methods8;

import de.pluralistix.bankaccounts.Methods.Methods3.Method33;
import de.pluralistix.bankaccounts.Methods.Special.ImpersonalAccount;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method84 extends Method33 {

	/**
	 */
	private static final int MODULO = 7;
	/**
	 */
	private final int moduloFromSuper;

	/**
	 */
	public Method84() {
		super();
		moduloFromSuper = super.getModulo();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setModulo(moduloFromSuper);
		super.validate(paramAccountNumber);
		if (!isValid()) {
			if (Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9) {
				ImpersonalAccount s = new ImpersonalAccount();
				s.setAccountNumber(paramAccountNumber);
				s.validate(paramAccountNumber);
				setValid(s.isValid());
			} else {
				interalValidate(MODULO);
			}
		}
	}
}
