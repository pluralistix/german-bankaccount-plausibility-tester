package de.pluralistix.bankaccounts.Methods.MethodsB;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class MethodB9 extends AMethod {

	/**
	 */
	private static final int MODULO = 11;

	/**
	 */
	private static final int[] WEIGHT_1 = new int[] { -1, -1, 1, 2, 3, 1, 2, 3,
			1, -1 };

	/**
	 */
	private static final int[] WEIGHT_2 = new int[] { -1, -1, -1, 6, 5, 4, 3,
			2, 1, -1 };

	/**
	 */
	public MethodB9() {
		super();
		super.setModulo(MODULO);
	}

	/**
	 * @param variante
	 *            bla
	 * @return bla
	 */
	private int calc(final int variante) {
		final int[] accountNummberArray = Utils
				.stringToIntArray(getNormalizedAccountNumber());
		final int[] weightArray = getWeight();
		int returnvalue = 0;
		for (int i = 0; i < accountNummberArray.length; i++) {
			if (weightArray[i] != -1) {
				final int product = accountNummberArray[i] * weightArray[i];
				if (variante == 1) {
					final int sum = product + weightArray[i];
					final int rest = sum % getModulo();
					returnvalue += rest;
				} else {
					returnvalue += product;
				}

			}
		}
		if (variante == 1) {
			returnvalue = returnvalue % 10;
		} else if (variante == 2) {
			returnvalue = returnvalue % getModulo();
		}
		return returnvalue;
	}

	/**
	 * @param result
	 *            bla
	 * @return bla
	 */
	private boolean check(final int result) {
		int tmp = result;
		final boolean returnVal;
		if (tmp == getCheckDigit()) {
			returnVal = true;
		} else {
			tmp += 5;
			if (tmp >= 10) {
				tmp -= 10;
			}
			returnVal = (tmp == getCheckDigit());
		}
		return returnVal;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (getNormalizedAccountNumber().startsWith("000")) {
			setWeight(WEIGHT_2);
			setValid(check(calc(2)));
		} else if (getNormalizedAccountNumber().startsWith("00")) {
			setWeight(WEIGHT_1);
			setValid(check(calc(1)));
		} else {
			setValid(false);
		}
	}
}
