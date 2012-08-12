package de.pluralistix.bankaccounts.Methods.MethodsC;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class MethodC6 extends Method00 {

	/**
	 */
	private static final int CHECKDIGITPOSITION = 16;

	/**
	 */
	private static int[] mapping = new int[] { 4451970, 4451981, 4451992,
			4451993, 0, 4344990, 4344991, 5499570, 0, 5499579 };

	/**
	 */
	private static final int[] WEIGHT = new int[] { 2, 1, 2, 1, 2, 1, 2, 1, 2,
			1, 2, 1, 2, 1, 2, -1 };

	/**
	 * @param paramMapping
	 *            the mapping to set
	 */
	public static final void setMapping(final int[] paramMapping) {
		mapping = paramMapping;
	}

	/**
	 */
	private String falseStartMatcher = "^(4|8).*$";

	/**
	 */
	private int startPosition = 1;

	/**
	 * 
	 */
	public MethodC6() {
		super();
		super.setWeight(WEIGHT);
		super.setCheckDigitPosition(CHECKDIGITPOSITION);
	}

	/**
	 * @param paramFalseStartMatcher
	 *            the falseStartMatcher to set
	 */
	public final void setFalseStartMatcher(final String paramFalseStartMatcher) {
		falseStartMatcher = paramFalseStartMatcher;
	}

	/**
	 * @param paramStartPosition
	 *            the startPosition to set
	 */
	public final void setStartPosition(final int paramStartPosition) {
		startPosition = paramStartPosition;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		if (!getNormalizedAccountNumber().matches(falseStartMatcher)) {
			final String dummyAccountNumber = String.valueOf(mapping[Integer
					.parseInt(getNormalizedAccountNumber().substring(0, 1))])
					+ getNormalizedAccountNumber().substring(startPosition, 10);
			setAccountNumber(dummyAccountNumber, false);
			super.validate(dummyAccountNumber);
			setAccountNumber(paramAccountNumber);
		} else {
			setValid(false);
		}

	}
}
