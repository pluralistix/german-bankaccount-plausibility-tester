package de.pluralistix.bankaccounts.Methods.Methods2;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method22 extends AMethod {

	/**
	 */
	private static final boolean UNITPOSITION = true;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 3, 1, 3, 1, 3, 1, 3, 1, 3,
			-1 };

	/**
	 */
    protected Method22() {
		super();
		super.setWeight(WEIGHT);
		super.setUnitPosition(UNITPOSITION);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		int result = product();
		result = getModulo() - (result % getModulo());
		if (Utils.unitPosition(result) == getCheckDigit()) {
			setValid(true);
		} else {
			setValid(false);
		}
	}
}
