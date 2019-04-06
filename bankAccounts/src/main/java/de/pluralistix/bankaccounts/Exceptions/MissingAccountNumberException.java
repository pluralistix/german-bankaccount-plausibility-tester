package de.pluralistix.bankaccounts.Exceptions;

/**
 * @author pluralistix
 */
public class MissingAccountNumberException extends Exception {

	/**
	 */
	private static final String MESSAGE = "A check without account number is not possible";

	/**
	 */
	private static final long serialVersionUID = -6791607939596989665L;

	/**
	 */
	public MissingAccountNumberException() {
		super(MESSAGE);
	}
}
