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
	private boolean validateWithEinerStelle = true;

	/**
	 */
	public Method00() {
		super();
		setWeight(WEIGHT);
		super.setCrossSum(QUERSUMME);
	}

	/**
	 * @return the validateWithEinerStelle
	 */
	public final boolean isValidateWithEinerStelle() {
		return validateWithEinerStelle;
	}

	/**
	 * @param paramValidateWithEinerStelle
	 *            the validateWithEinerStelle to set
	 */
	public final void setValidateWithEinerStelle(
			final boolean paramValidateWithEinerStelle) {
		validateWithEinerStelle = paramValidateWithEinerStelle;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		doValidate(product(), isValidateWithEinerStelle());
	}
}
