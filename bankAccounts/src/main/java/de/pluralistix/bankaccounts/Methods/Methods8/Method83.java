package de.pluralistix.bankaccounts.Methods.Methods8;

import de.pluralistix.bankaccounts.Methods.Methods3.Method32;
import de.pluralistix.bankaccounts.Methods.Methods3.Method33;
import de.pluralistix.bankaccounts.Methods.Special.ImpersonalAccount;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method83 extends Method32 {

	/**
	 */
	private static final int MODULO_C = 7;

    /**
	 */
	public Method83() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.validate(paramAccountNumber);
		if (!isValid()) {
			Method33 m = new Method33();
            int[] weight = m.getWeight();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
			if (!isValid()) {
				if (Utils.stringToIntArray(getNormalizedAccountNumber())[9] < 7) {
					setWeight(weight);
					interalValidate(MODULO_C);
				} else {
					setValid(false);
				}
				if (!isValid()
						&& (Utils
								.stringToIntArray(getNormalizedAccountNumber())[2] == 9)) {
					ImpersonalAccount s = new ImpersonalAccount();
					s.setAccountNumber(paramAccountNumber);
					s.validate(paramAccountNumber);
					setValid(s.isValid());
				}
			}
		}
	}
}
