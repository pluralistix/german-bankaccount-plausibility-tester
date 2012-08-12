package de.pluralistix.bankaccounts.Methods.Methods0;

import java.util.ArrayList;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class Method00 extends AMethod {

	/**
	 */
	private static final ArrayList<Integer> QUERSUMME = new ArrayList<Integer>();

	/**
	 */
	private static final int[] WEIGHT = new int[] { 2, 1, 2, 1, 2, 1, 2, 1, 2,
			-1 };

	/**
	 */
	private boolean validateWithUnitPosition = true;

	/**
	 */
	public Method00() {
		super();
		setWeight(WEIGHT);
		super.setCrossSum(QUERSUMME);
	}

	/**
	 * @return the validateWithUnitPosition
	 */
	public final boolean isValidateWithUnitPosition() {
		return validateWithUnitPosition;
	}

	/**
	 * @param paramValidateWithUnitPosition
	 *            the validateWithEinerStelle to set
	 */
	public final void setValidateWithunitPosition(
			final boolean paramValidateWithUnitPosition) {
		validateWithUnitPosition = paramValidateWithUnitPosition;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		doValidate(product(), isValidateWithUnitPosition());
	}
}
