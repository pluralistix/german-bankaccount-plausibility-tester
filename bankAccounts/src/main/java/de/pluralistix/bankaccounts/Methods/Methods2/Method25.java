package de.pluralistix.bankaccounts.Methods.Methods2;

import de.pluralistix.bankaccounts.Methods.Methods0.Method02;

/**
 * @author pluralistix
 */
public class Method25 extends Method02 {

	/**
	 */
	private static final int MODULO = 11;

	/**
	 */
	private static final boolean SPECIAL = true;

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, 9, 8, 7, 6, 5, 4, 3, 2,
			-1 };

	/**
	 */
	public Method25() {
		super();
		super.setWeight(WEIGHT);
		super.setModulo(MODULO);
		super.setSpecial(SPECIAL);
	}

}
