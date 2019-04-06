package de.pluralistix.bankaccounts.Methods.Methods0;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class Method06 extends AMethod {

	/**
	 */
	private static final int MODULO = 11;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 4, 3, 2, 7, 6, 5, 4, 3, 2,
			-1 };

	/**
	 */
	private boolean doSubtractFirst = true;

	/**
	 */
	private int[][] specialRest = new int[][] { { 0, 0 }, { 1, 0 } };

	/**
	 */
	public Method06() {
		super();
		super.setModulo(MODULO);
		super.setWeight(WEIGHT);
	}

	/**
	 * @return the specialRest
	 */
	protected final int[][] getSpecialRest() {
		return specialRest;
	}

	/**
	 * @return the doSubStractFirst
	 */
    private boolean isDoSubtractFirst() {
		return doSubtractFirst;
	}

	/**
	 * @param paramaDoSubtractFirst
	 *            the doSubStractFirst to set
	 */
	protected final void setDoSubtractFirst(@SuppressWarnings("SameParameterValue") final boolean paramaDoSubtractFirst) {
		doSubtractFirst = paramaDoSubtractFirst;
	}

	/**
	 * @param paramSpecialRest
	 *            the specialRest to set
	 */
	public final void setSpecialRest(final int[][] paramSpecialRest) {
		specialRest = paramSpecialRest;
	}

	/**
	 * @param result
	 *            bla
	 * @return bla
	 */
	protected final int transformResult(final int result) {
		int returnvalue = result;
		boolean found = false;
		try {
			for (int[] y : getSpecialRest()) {
				if (y[0] == result) {
					returnvalue = y[1];
					found = true;
				}
			}
			if (!found) {
				throw new Exception();
			}
		} catch (Exception e) {
			if (isDoSubtractFirst()) {
				returnvalue = getModulo() - result;
			}
		}
		return returnvalue;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		int result = product() % getModulo();
		result = transformResult(result);
		if (result == getCheckDigit()) {
			setValid(true);
		} else {
			setValid(false);
		}
	}

}
