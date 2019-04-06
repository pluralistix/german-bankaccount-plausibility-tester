package de.pluralistix.bankaccounts.Methods.Methods5;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;

/**
 * @author pluralistix
 */
public class Method54 extends Method06 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, -1, 2, 7, 6, 5, 4, 3,
			2, -1 };

	/**
	 */
	public Method54() {
		super();
		super.setWeight(WEIGHT);
	}

	/**
	 * /**
	 * 
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (!getAccountNumber().startsWith("49")
				|| getAccountNumber().length() < 10) {
			setValid(false);
			return;
		}
		super.validate(paramAccountNumber);
	}

}
