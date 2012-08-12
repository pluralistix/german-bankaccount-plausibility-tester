package de.pluralistix.bankaccounts.Utils;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;

/**
 * @author pluralistix
 */
public final class Utils {

	/**
	 * @param accountNumber
	 *            bla
	 * @return bla
	 */
	public static Long accountAsNumber(final String accountNumber) {
		return Long.parseLong(accountNumber);
	}

	/**
	 * @param int1
	 *            bla
	 * @return bla
	 */
	public static int unitPosition(final int int1) {
		return int1 % AMethod.MAXLENGTHOFKONTO;
	}

	/**
	 * @param accountNumber
	 *            bla
	 * @return bla
	 */
	public static int getLengtOfAccountAsNumber(final String accountNumber) {
		return accountAsNumber(accountNumber).toString().length();
	}

	/**
	 * @param string
	 *            bla
	 * @return bla
	 */
	public static String lpad(final String string) {
		return lpad(string, 10, '0');
	}

	/**
	 * @param string
	 *            bla
	 * @param length
	 *            bla
	 * @param filler
	 *            bla
	 * @return bla
	 */
	public static String lpad(final String string, final int length,
			final char filler) {
		return String.format("%" + length + "s",
				((Long) Long.parseLong(string)).toString())
				.replace(' ', filler);
	}

	/**
	 * @param int1
	 *            bla
	 * @return bla
	 */
	public static int crossSum(int int1) {
		int sum = 0;
		while (int1 > 0) {
			sum = sum + int1 % AMethod.MAXLENGTHOFKONTO;
			int1 = int1 / AMethod.MAXLENGTHOFKONTO;
		}
		return sum;
	}

	/**
	 * @param string
	 *            bla
	 * @return bla
	 */
	public static String rpad(final String string) {
		return String.format("%-10s", string).replace(' ', '0');
	}

	/**
	 * @param myString
	 *            bla
	 * @return bla
	 */
	public static int[] stringToIntArray(final String myString) {
		return stringToIntArray(myString, myString.length());
	}

	/**
	 * @param myString
	 *            bla
	 * @param length
	 *            bla
	 * @return bla
	 */
	public static int[] stringToIntArray(final String myString, final int length) {
		char[] myChars = myString.toCharArray();
		int[] intArray = new int[length];
		for (int i = 0, x = 0; i < myChars.length; i++, x++) {
			if (String.valueOf(myChars[i]).equals("-")) {
				intArray[x] = Integer.parseInt(String.valueOf(myChars[++i]))
						* -1;
			} else {
				intArray[x] = Integer.parseInt(String.valueOf(myChars[i]));
			}
		}
		return intArray;
	}

	/**
	 */
	private Utils() {

	}
}
