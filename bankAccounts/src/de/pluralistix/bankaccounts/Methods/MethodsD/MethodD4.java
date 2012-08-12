/**
 */
package de.pluralistix.bankaccounts.Methods.MethodsD;

import de.pluralistix.bankaccounts.Methods.MethodsC.MethodC6;

/**
 * @author pluralistix
 */
public class MethodD4 extends MethodC6 {

	/**
	 */
	private static int[] mapping = buildMapping();

	/**
	 * @return bla
	 */
	private static int[] buildMapping() {
		final int[] mapping = new int[10];
		for (int i = 1; i < mapping.length; i++) {
			mapping[i] = 428259;
		}
		return mapping;
	}

	/**
	 */
	private String falseStartMatcher = "^0.*$";

	/**
	 * 
	 */
	public MethodD4() {
		super();
		setFalseStartMatcher(falseStartMatcher);
		setMapping(mapping);
		setStartPosition(0);
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
