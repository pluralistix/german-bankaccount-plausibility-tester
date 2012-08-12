package de.pluralistix.bankaccounts.Methods.Methods8;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Special.ImpersonalAccount;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method80 extends Method00 {

	/**	
	 */
	private static final int MODULO_A = 10;

	/**	
	 */
	private static final int MODULO_B = 7;

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, -1, -1, -1, 2, 1, 2, 1,
			2, -1 };

	/**
	 */
	public Method80() {
		super();
		super.setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9) {
			ImpersonalAccount s = new ImpersonalAccount();
			s.setAccountNumber(paramAccountNumber);
			s.validate(paramAccountNumber);
			setValid(s.isValid());
		} else {
			super.setModulo(MODULO_A);
			super.validate(paramAccountNumber);
			if (!isValid()) {
				super.setModulo(MODULO_B);
				int rest = product() % getModulo();
				if (rest != 0) {
					rest = getModulo() - rest;
				}
				if (rest == getCheckDigit()) {
					setValid(true);
				} else {
					setValid(false);
				}
			}
		}
	}
}
