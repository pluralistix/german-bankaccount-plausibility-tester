package de.pluralistix.bankaccounts.Methods.Methods5;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class Method56 extends AMethod {

	/**
	 */
	static final int MODULO = 11;

	/**
	 */
	static final int[] WEIGHT = new int[] { 4, 3, 2, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	public Method56() {
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
		int result = getModulo() - (product() % getModulo());
		if (getAccountNumber().length() == 10
				&& getAccountNumber().startsWith("9")) {
			if (result == 10) {
				result = 7;
			} else if (result == 11) {
				result = 8;
			}
		}
		if (result == 10 || result == 11) {
			setValid(false);
		} else {
			doValidate(result, false);
		}
	}

}
