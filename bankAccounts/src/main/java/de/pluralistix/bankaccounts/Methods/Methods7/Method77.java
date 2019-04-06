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
	 * @param weight
	 *            bla
	 * @return bla
	 */
	private boolean internalValidate(final int[] weight) {
		super.setWeight(weight);
		final int product = product();
		final int rest = product % getModulo();
		return ( rest <= 0 );
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setValid(internalValidate(WEIGHT_A));
		if (!isValid()) {
			setValid(internalValidate(WEIGHT_B));
		}
	}
}
