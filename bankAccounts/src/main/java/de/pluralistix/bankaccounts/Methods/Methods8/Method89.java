package de.pluralistix.bankaccounts.Methods.Methods8;

import java.util.ArrayList;

import de.pluralistix.bankaccounts.Methods.Methods1.Method10;
import de.pluralistix.bankaccounts.Methods.Methods3.Method32;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method89 extends Method32 {

	/**
	 */
	private static final ArrayList<Integer> QUERSUMME = new ArrayList<>();

	/**
	 */
	public Method89() {
		super();
		super.setCrossSum(QUERSUMME);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final int length = Utils.getLengtOfAccountAsNumber(paramAccountNumber);
		if (length == 7) {
			super.validate(paramAccountNumber);
		} else if (length == 8 || length == 9) {
			Method10 m = new Method10();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		} else {
			setValid(false);
		}
	}
}
