package de.pluralistix.bankaccounts.Methods.Methods5;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class Method58 extends AMethod {

	/**
	 */
	private static final int MODULO = 11;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 0, 0, 0, 0, 6, 5, 4, 3, 2,
			-1 };

	/**
	 */
	public Method58() {
		super();
		super.setWeight(WEIGHT);
		super.setModulo(MODULO);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (paramAccountNumber.length() >= 6) {
			int result = product();
			final int rest = result % getModulo();
			if (rest == 0) {
				result = 0;
			} else if (rest == 1) {
				setValid(false);
				return;
			} else {
				result = getModulo() - (result % getModulo());
			}
			if (result == getCheckDigit()) {
				setValid(true);
			} else {
				setValid(false);
			}
		} else {
			setValid(false);
		}
	}
}
