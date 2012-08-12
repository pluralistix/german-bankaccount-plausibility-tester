package de.pluralistix.bankaccounts.Methods.Methods9;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method97 extends AMethod {

	/**
	 */
	public Method97() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.accountAsNumber(paramAccountNumber) >= 10000) {
			final long div = (Utils.accountAsNumber(paramAccountNumber) / 10) / 11;
			final long prod = div * 11;
			final long dif = (Utils.accountAsNumber(paramAccountNumber) / 10)
					- prod;
			if (dif == 10 ? 0 == Utils
					.stringToIntArray(getNormalizedAccountNumber())[9]
					: dif == Utils
							.stringToIntArray(getNormalizedAccountNumber())[9]) {
				setValid(true);
			} else {
				setValid(false);
			}
		} else {
			setValid(false);
		}
	}

}
