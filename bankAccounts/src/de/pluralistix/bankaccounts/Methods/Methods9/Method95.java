package de.pluralistix.bankaccounts.Methods.Methods9;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method95 extends Method06 {

	/**
	 */
	static final int[] WEIGHT = new int[] { 4, 3, 2, 7, 6, 5, 4, 3, 2, -1 };

	/**
	 */
	public Method95() {
		super();
		super.setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		final Long account = Utils.accountAsNumber(paramAccountNumber);
		if ((account >= 1 && account <= 1999999)
				|| (account >= 9000000 && account <= 25999999)
				|| (account >= 396000000 && account <= 499999999)
				|| (account >= 700000000 && account <= 799999999)) {
			setValid(true);
		} else {
			super.validate(paramAccountNumber);
		}
	}
}
