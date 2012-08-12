package de.pluralistix.bankaccounts.Exceptions;

/**
 * @author pluralistix
 */
public class SyntaxException extends NumberFormatException {

	/**
	 */
	private static final long serialVersionUID = 5494859074589818977L;

	/**
	 * @param message
	 *            bla
	 */
	public SyntaxException(final String message) {
		super(message);
	}

}
