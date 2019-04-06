package de.pluralistix.bankaccounts.Methods.Methods1;

import java.util.ArrayList;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class Method17 extends AMethod {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 8;

	/**
	 */
	private static final int MODULO = 11;
	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, 1, 2, 1, 2, 1, 2, -1, -1, -1 };

	/**
	 */
	private final ArrayList<Integer> querSumme = new ArrayList<>(3);

	/**
	 */
    protected Method17() {
		super.setWeight(WEIGHT);
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
		super.setModulo(MODULO);
		initQuersumme();
		super.setCrossSum(querSumme);
	}

	/**
	 */
	private void initQuersumme() {
		querSumme.add(2);
		querSumme.add(4);
		querSumme.add(6);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		int result = product();
		result = (result - 1) % getModulo();
		if (result != 0) {
			result = 10 - result;
		}
		if (result == getCheckDigit()) {
			setValid(true);
		} else {
			setValid(false);
		}
	}
}
