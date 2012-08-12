package de.pluralistix.bankaccounts.Methods.Methods0;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistixn
 */
public class Method01 extends AMethod {

	/**
	 */
	private static final int[] WEIGHT = new int[] { 1, 7, 3, 1, 7, 3, 1, 7, 3,
			-1 };

	/**
	 */
	public Method01() {
		super();
		setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		doValidate(product(), true);
	}
}
