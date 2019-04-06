package de.pluralistix.bankaccounts.Methods.MethodsD;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class MethodD5 extends Method06 {

	/**
	 */
	private static final int MODULO_1 = 11;

	/**
	 */
	private static final int MODULO_2 = 7;

	/**
	 */
	private static final int MODULO_3 = 10;

	/**
	 */
	private static final int[] WEIGHT_1 = new int[] { -1, -1, 8, 7, 6, 5, 4, 3,
			2, -1 };

	/**
	 */
	private static final int[] WEIGHT_2 = new int[] { -1, -1, -1, 7, 6, 5, 4,
			3, 2, -1 };

	/**
	 */
	private final int[][] specialRest = new int[][] { { 0, 0 } };

	/**
	 */
	private final int[][] specialRestFromSuper;

	/**
	 * 
	 */
	public MethodD5() {
		super();
		specialRestFromSuper = getSpecialRest();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setSpecialRest(specialRestFromSuper);
		setWeight(WEIGHT_1);
		setModulo(MODULO_1);
		super.validate(paramAccountNumber);
		if (!isValid()
				&& !getNormalizedAccountNumber().subSequence(2, 4).equals("99")) {
			setWeight(WEIGHT_2);
			super.validate(paramAccountNumber);
			if (!isValid()) {
				setSpecialRest(specialRest);
				setModulo(MODULO_2);
				super.validate(paramAccountNumber);
				if (!isValid()) {
					setModulo(MODULO_3);
					super.validate(paramAccountNumber);
				}
			}
		}
	}
}
