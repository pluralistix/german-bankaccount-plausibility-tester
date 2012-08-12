package de.pluralistix.bankaccounts.Methods.Methods7;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class Method77 extends AMethod {

	/**
	 */
	private static final int MODULO = 11;

	/**
	 */
	private static final int[] WEIGHT_A = new int[] { -1, -1, -1, -1, -1, 5, 4,
			3, 2, 1 };

	/**
	 */
	private static final int[] WEIGHT_B = new int[] { -1, -1, -1, -1, -1, 5, 4,
			3, 4, 5 };

	/**
	 */
	public Method77() {
		super();
		super.setModulo(MODULO);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 * @param weight
	 *            bla
	 * @return bla
	 */
	private boolean internalValidate(final String paramAccountNumber,
			final int[] weight) {
		super.setWeight(weight);
		boolean returnvalue = false;
		final int product = product();
		final int rest = product % getModulo();
		if (rest > 0) {
			returnvalue = false;
		} else {
			returnvalue = true;
		}
		return returnvalue;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setValid(internalValidate(paramAccountNumber, WEIGHT_A));
		if (!isValid()) {
			setValid(internalValidate(paramAccountNumber, WEIGHT_B));
		}
	}
}
