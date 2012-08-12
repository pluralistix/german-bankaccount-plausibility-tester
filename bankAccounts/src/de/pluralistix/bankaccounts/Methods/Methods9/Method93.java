package de.pluralistix.bankaccounts.Methods.Methods9;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method93 extends Method06 {

	/**
	 */
	private static final int CHECKDIGITPOSITION_1 = 6;

	/**
	 */
	private static final int CHECKDIGITPOSITION_2 = 10;

	/**
	 */
	static final int MODULO_1 = 11;

	/**
	 */
	static final int MODULO_2 = 7;

	/**
	 */
	static final int[] WEIGHT_1 = new int[] { 6, 5, 4, 3, 2, -1, -1, -1, -1, -1 };

	/**
	 */
	static final int[] WEIGHT_2 = new int[] { -1, -1, -1, -1, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	public Method93() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (getNormalizedAccountNumber().startsWith("0000")) {
			varB();
		} else {
			varA();
		}
	}

	/**
	 */
	private void varA() {
		setModulo(MODULO_1);
		setCheckDigitPosition(CHECKDIGITPOSITION_1);
		setWeight(WEIGHT_1);
		super.setAccountNumber(getAccountNumber());
		super.validate(getAccountNumber());
		if (!isValid()) {
			setModulo(MODULO_2);
			setCheckDigitPosition(CHECKDIGITPOSITION_1);
			setWeight(WEIGHT_1);
			super.setAccountNumber(getAccountNumber());
			super.validate(getAccountNumber());
		}
	}

	/**
	 */
	private void varB() {
		setModulo(MODULO_1);
		setCheckDigitPosition(CHECKDIGITPOSITION_2);
		setWeight(WEIGHT_2);
		super.setAccountNumber(getAccountNumber());
		super.validate(getAccountNumber());
		if (!isValid()) {
			setModulo(MODULO_2);
			setCheckDigitPosition(CHECKDIGITPOSITION_2);
			setWeight(WEIGHT_2);
			super.setAccountNumber(getAccountNumber());
			super.validate(getAccountNumber());
		}
	}
}
