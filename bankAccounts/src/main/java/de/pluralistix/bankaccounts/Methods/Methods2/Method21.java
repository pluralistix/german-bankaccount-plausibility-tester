package de.pluralistix.bankaccounts.Methods.Methods2;

import java.util.ArrayList;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method21 extends Method00 {

	/**
	 */
	private static final ArrayList<Integer> QUERSUMME = new ArrayList<>();

	/**
	 */
	public Method21() {
		super();
		super.setCrossSum(QUERSUMME);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		int result = product();
		while (result > 9) {
			result = Utils.crossSum(result);
		}
		result = getModulo() - result;
		if (result == getCheckDigit()) {
			setValid(true);
		} else {
			setValid(false);
		}
	}
}
