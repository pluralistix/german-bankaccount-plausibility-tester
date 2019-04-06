package de.pluralistix.bankaccounts.Methods.Methods8;

import de.pluralistix.bankaccounts.Methods.Methods0.Method02;
import de.pluralistix.bankaccounts.Methods.Methods5.Method51;

/**
 * @author pluralistix
 */
public class Method85 extends Method51 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { -1, -1, 8, 7, 6, 5, 4, 3,
			2, -1 };

	/**
	 */
	private final int[] weigtFromSuper;

	/**
	 */
	public Method85() {
		super();
		weigtFromSuper = super.getWeight();
		super.setWithSachkonto(false);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setWeight(weigtFromSuper);
		super.validate(paramAccountNumber);
		if (!isValid()
				&& getNormalizedAccountNumber().substring(2, 4).equals("99")) {
			Method02 m = new Method02();
			m.setAccountNumber(paramAccountNumber);
			m.setWeight(WEIGHT);
			m.validate(paramAccountNumber);
			setValid(m.isValid());
		}
	}
}
