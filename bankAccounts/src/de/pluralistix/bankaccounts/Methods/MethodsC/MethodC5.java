package de.pluralistix.bankaccounts.Methods.MethodsC;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Methods.Methods0.Method09;
import de.pluralistix.bankaccounts.Methods.Methods2.Method29;
import de.pluralistix.bankaccounts.Methods.Special.AMethod;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class MethodC5 extends Method00 {

	/**
	 * 
	 */
	public MethodC5() {
		super();
	}

	/**
	 * @param length
	 *            bla
	 */
	private void setWeightAndCheckDigitPosition(final int length) {
		setCheckDigitPosition((11 - length) + 5);
		final int[] weight = new int[10];
		for (int i = getCheckDigitPosition() - 1 - 5; i < getCheckDigitPosition() - 1; i++) {
			weight[i] = (getCheckDigitPosition() - i) % 2 == 0 ? 2 : 1;
		}
		setWeight(weight);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final int length = Utils.getLengtOfAccountAsNumber(paramAccountNumber);
		if ((length == 6 || length == 9) && !getAccountNumber().startsWith("9")) {
			setWeightAndCheckDigitPosition(length);
			super.validate(paramAccountNumber);
		} else if ((length == 8
				&& Utils.accountAsNumber(paramAccountNumber) >= 30000000 && Utils
				.accountAsNumber(paramAccountNumber) < 60000000)
				|| (length == 10) && paramAccountNumber.matches("^(70|85).*$")) {
			setValid((new Method09()).isValid());
		} else if (length == 10) {
			AMethod m = null;
			if (paramAccountNumber.matches("^(1|[4-6]|9).*$")) {
				m = new Method29();
			} else if (paramAccountNumber.startsWith("3")) {
				m = new Method00();
			}
			if (m != null) {
				m.setAccountNumber(paramAccountNumber);
				m.validate(paramAccountNumber);
				setValid(m.isValid());
			}
		} else {
			setValid(false);
		}
	}
}
