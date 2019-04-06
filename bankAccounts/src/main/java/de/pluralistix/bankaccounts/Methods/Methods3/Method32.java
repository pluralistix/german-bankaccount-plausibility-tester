	package de.pluralistix.bankaccounts.Methods.Methods3;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method32 extends Method06 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, -1, -1, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	public Method32() {
		super();
		super.setWeight(WEIGHT);
	}

	protected void interalValidate(final int modulo) {
		setModulo(modulo);
		int rest = product() % getModulo();
		if (rest != 0) {
			rest = getModulo() - rest;
		}
		if (rest == getCheckDigit()) {
			setValid(true);
		} else {
			setValid(false);
		}
	}
}
