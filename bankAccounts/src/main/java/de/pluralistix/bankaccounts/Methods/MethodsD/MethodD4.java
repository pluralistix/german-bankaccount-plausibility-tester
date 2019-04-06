package de.pluralistix.bankaccounts.Methods.MethodsD;

import de.pluralistix.bankaccounts.Methods.MethodsC.MethodC6;

/**
 * @author pluralistix
 */
public class MethodD4 extends MethodC6 {

	/**
	 */
	private static final int[] mapping = buildMapping();

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
	 * 
	 */
	public MethodD4() {
		super();
		String falseStartMatcher = "^0.*$";
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
