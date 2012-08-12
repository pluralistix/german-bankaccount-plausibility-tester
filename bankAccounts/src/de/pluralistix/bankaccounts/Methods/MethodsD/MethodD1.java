package de.pluralistix.bankaccounts.Methods.MethodsD;

import de.pluralistix.bankaccounts.Methods.MethodsC.MethodC6;

/**
 * @author pluralistix
 */
public class MethodD1 extends MethodC6 {

	/**
	 */
	private static int[] mapping = new int[] { 4363380, 4363381, 4363382,
			4363383, 4363384, 4363385, 4363386, 0, 0, 4363389 };

	/**
	 */
	private String falseStartMatcher = "^(7|8).*$";

	/**
	 * 
	 */
	public MethodD1() {
		super();
		setFalseStartMatcher(falseStartMatcher);
		setMapping(mapping);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.validate(paramAccountNumber);
	}
}
