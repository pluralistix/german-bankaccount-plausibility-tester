package de.pluralistix.bankaccounts.Methods.MethodsB;

import de.pluralistix.bankaccounts.Methods.Methods0.Method06;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class MethodB0 extends Method06 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 8;

	/**
	 */
	private static final int[] WEIGTH = new int[] { 4, 3, 2, 7, 6, 5, 4, 3, 2,
			-1 };

	/**
	 */
	public MethodB0() {
		super();
		super.setWeight(WEIGTH);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (Utils.getLengtOfAccountAsNumber(paramAccountNumber) < 10
				|| paramAccountNumber.substring(0, 1).equals("8")) {
			setValid(false);
			return;
		}
		if (paramAccountNumber.substring(CHECKDIGITPOSITION - 1,
				CHECKDIGITPOSITION).matches("([1236])")) {
			setValid(true);
			return;
		}
		super.validate(paramAccountNumber);
	}

}
