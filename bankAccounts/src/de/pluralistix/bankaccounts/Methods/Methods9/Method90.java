package de.pluralistix.bankaccounts.Methods.Methods9;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method90 extends Method06 {

	/**
	 */
	static final int MODULO_C = 7;

	/**
	 */
	static final int MODULO_D = 9;

	/**
	 */
	static final int MODULO_E = 10;

	/**
	 */
	static final int[] WEIGHT_A = new int[] { -1, -1, -1, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	static final int[] WEIGHT_B = new int[] { -1, -1, -1, -1, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	static final int[] WEIGHT_E = new int[] { -1, -1, -1, -1, 2, 1, 2, 1, 2, -1 };

	/**
	 */
	static final int[] WEIGHT_SACH = new int[] { -1, -1, 8, 7, 6, 5, 4, 3, 2,
			-1 };

	/**
	 */
	private Object[][] weightModuloArray = null;

	/**
	 */
	public Method90() {
		super();
		weightModuloArray = new Object[][] { { WEIGHT_B, MODULO_C },
				{ WEIGHT_B, MODULO_D }, { WEIGHT_E, MODULO_E } };
	}

	/**
	 * @return bla
	 */
	private boolean internalValidate() {
		boolean valid = false;
		for (int i = 0; i < weightModuloArray.length && (!valid); i++) {
			setWeight((int[]) weightModuloArray[i][0]);
			int rest = product() % (int) weightModuloArray[i][1];
			if (rest != 0) {
				rest = (int) weightModuloArray[i][1] - rest;
			}
			valid = (rest == getCheckDigit());
		}
		return valid;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9) {
			setWeight(WEIGHT_SACH);
			super.validate(paramAccountNumber);
		} else {
			setWeight(WEIGHT_A);
			super.validate(paramAccountNumber);
			if (!isValid()) {
				setWeight(WEIGHT_B);
				super.validate(paramAccountNumber);
				if (!isValid()) {
					setValid(internalValidate());
				}
			}
		}
	}
}
