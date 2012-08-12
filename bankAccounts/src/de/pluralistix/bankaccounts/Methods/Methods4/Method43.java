package de.pluralistix.bankaccounts.Methods.Methods4;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistixn
 */
public class Method43 extends AMethod {

	/**
	 */
	private static final int[] WEIGHT = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1,
			-1 };

	/**
	 */
	public Method43() {
		super();
		setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final int diff = getModulo() - (product() % getModulo());
		if (diff == 10) {
			doValidate(0, false);
		} else {
			doValidate(diff, false);
		}
	}
}
