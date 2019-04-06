package de.pluralistix.bankaccounts.Methods.Methods7;

import de.pluralistix.bankaccounts.Methods.Special.ImpersonalAccount;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method73 extends Method72 {

	/**
	 */
	private static final int MODULO = 7;

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, -1, -1, -1, 2, 1, 2, 1,
			2, -1 };

	/**
	 */
	private final int[] weightFromSuper;

	/**
	 */
	public Method73() {
		super();
		weightFromSuper = getWeight();
	}

	/**
	 * @return bla
	 */
	private boolean internalValidate() {
		final int product = product();
		int rest = product % MODULO;
		if (rest != 0) {
			rest = MODULO - rest;
		}
		return (rest == getCheckDigit());
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setWeight(weightFromSuper);
		if (Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9) {
			ImpersonalAccount s = new ImpersonalAccount();
			s.setAccountNumber(paramAccountNumber);
			s.validate(paramAccountNumber);
			setValid(s.isValid());
		} else {
			super.validate(paramAccountNumber);
			if (!isValid()) {
				setWeight(WEIGHT);
				super.validate(paramAccountNumber);
				if (!isValid()) {
					setValid(internalValidate());
				}
			}
		}
	}
}
