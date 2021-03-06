package de.pluralistix.bankaccounts.Methods.Methods5;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;
import de.pluralistix.bankaccounts.Methods.Methods3.Method33;
import de.pluralistix.bankaccounts.Methods.Special.AMethod;
import de.pluralistix.bankaccounts.Methods.Special.ImpersonalAccount;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method51 extends Method06 {

	/**
	 */
	private static final int MODULO_C = 7;

	/**
	 */
	private static final int[] WEIGHT_A = new int[] { -1, -1, -1, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	private static final int[] WEIGHT_B_C = new int[] { -1, -1, -1, -1, 6, 5, 4, 3, 2,
			-1 };

	/**
	 */
	private final int moduloFromSuper;

	/**
	 */
	private boolean withImpersonalAccount = true;

	/**
	 */
    protected Method51() {
		super();
		moduloFromSuper = super.getModulo();
	}

	/**
	 * @return the withImpersonalAccount
	 */
    private boolean isWithImpersonalAccount() {
		return withImpersonalAccount;
	}

	/**
	 * @param paramWithImpersonalAccount
	 *            the withSachkonto to set
	 */
	public final void setWithSachkonto(final boolean paramWithImpersonalAccount) {
		withImpersonalAccount = paramWithImpersonalAccount;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		setWeight(WEIGHT_A);
		setModulo(moduloFromSuper);
		super.validate(paramAccountNumber);
		if (!super.isValid()) {
			AMethod m = new Method33();
			m.setWeight(WEIGHT_B_C);
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			if (!m.isValid()) {
				if ((isWithImpersonalAccount())
						&& Utils.stringToIntArray(getNormalizedAccountNumber())[2] == 9) {
					ImpersonalAccount s = new ImpersonalAccount();
					s.setAccountNumber(paramAccountNumber);
					s.validate(paramAccountNumber);
					setValid(s.isValid());
				} else {
					if (getNormalizedAccountNumber().substring(9, 10).matches(
							"([789])")) {
						setValid(false);
						return;
					}
					setModulo(MODULO_C);
					setWeight(WEIGHT_B_C);
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
			} else {
				setValid(true);
			}
		}
	}
}
