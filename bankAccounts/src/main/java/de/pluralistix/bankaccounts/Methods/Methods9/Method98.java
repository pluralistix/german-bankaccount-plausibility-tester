package de.pluralistix.bankaccounts.Methods.Methods9;

import de.pluralistix.bankaccounts.Methods.Methods0.Method01;
import de.pluralistix.bankaccounts.Methods.Methods3.Method32;

/**
 * @author pluralistix
 */
public class Method98 extends Method01 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, -1, 3, 7, 1, 3, 7, 1,
			3, -1 };

	/**
	 * 
	 */
	public Method98() {
		super();
		super.setWeight(WEIGHT);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.validate(paramAccountNumber);
		if (!isValid()) {
			Method32 m = new Method32();
			m.setAccountNumber(paramAccountNumber);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
