package de.pluralistix.bankaccounts.Methods.Methods1;

import de.pluralistix.bankaccounts.Exceptions.NotImplementedException;
import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public class Method12 extends AMethod {

	/**
	 * @throws NotImplementedException
	 *             bla
	 */
	public Method12() throws NotImplementedException {
		throw new NotImplementedException(this.getClass().getSimpleName()
				+ " ist nicht implementiert");
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
	}

}
