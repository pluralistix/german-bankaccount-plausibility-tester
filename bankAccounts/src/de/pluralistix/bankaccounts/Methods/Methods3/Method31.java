package de.pluralistix.bankaccounts.Methods.Methods3;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class Method31 extends AMethod {

	/**
	 */
	private static final int MODULO = 11;

	/**
	 */
	static final int[] WEIGHT = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, -1 };

	/**
	 */
	public Method31() {
		super();
		super.setModulo(MODULO);
		super.setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final int result = product();
		final int rest = result % getModulo();
		if (rest == 10) {
			setValid(false);
		} else {
			doValidate(rest, false);
		}
	}
}
