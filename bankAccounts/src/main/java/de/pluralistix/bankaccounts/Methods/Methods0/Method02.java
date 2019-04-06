package de.pluralistix.bankaccounts.Methods.Methods0;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method02 extends AMethod {

	/**
	 */
	private static final int MODULO = 11;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 2, 9, 8, 7, 6, 5, 4, 3, 2,
			-1 };

	/**
	 */
	private boolean special = false;

	/**
	 */
	public Method02() {
		super();
		super.setModulo(MODULO);
		super.setWeight(WEIGHT);
	}

	/**
	 * @return the sonder
	 */
    private boolean isSpecial() {
		return special;
	}

	/**
	 * @param paramSpecial
	 *            the special to set
	 */
	public final void setSpecial(final boolean paramSpecial) {
		special = paramSpecial;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		validateInternal();
	}

	/**
	 */
	private void validateInternal() {
		int result = product();
		final int rest = result % getModulo();
		if (rest == 0) {
			result = 0;
		} else if (isSpecial() && rest == 1) {
			final int[] intArray = Utils
					.stringToIntArray(getNormalizedAccountNumber());
			if (intArray[1] == 8 || intArray[1] == 9) {
				setValid(true);
			} else {
				setValid(false);
			}
			return;
		} else {
			result = getModulo() - (result % getModulo());
		}
		if (result == getCheckDigit()) {
			setValid(true);
		} else {
			setValid(false);
		}
	}
}
