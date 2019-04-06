package de.pluralistix.bankaccounts.Methods.Methods5;

import de.pluralistix.bankaccounts.Methods.Methods2.Method20;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method52 extends Method20 {

	/**
	 */
	private static final int[] WEIGHT = new int[] { 2, 4, 8, 5, 10, 9, 7, 3, 6,
			1, 2, 4 };

	/**
	 */
	private int legacyAccountLength = 8;

	/**
	 * 
	 */
	protected Method52() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 * @return bla
	 */
	private String getDummy(final String paramAccountNumber) {
		String dummy;
		if (legacyAccountLength == 8) {
			final String part1 = paramAccountNumber.substring(0, 1);
			final String pzpart = "-1";
			final String part3 = paramAccountNumber.substring(2);
			if (getBankCode().length() > 4) {
				dummy = Integer.parseInt(getBankCode().substring(
						getBankCode().length() - 4))
						+ ""
						+ Integer.parseInt(part1)
						+ pzpart
						+ Integer.parseInt(part3);

			} else {
				dummy = Integer.parseInt(getBankCode()) + ""
						+ Integer.parseInt(part1) + pzpart
						+ Integer.parseInt(part3);
			}
		} else {
			final String part1 = paramAccountNumber.substring(0, 1);
			final String replacement = paramAccountNumber.substring(1, 2);
			final String pzpart = "-1";
			final String part3 = paramAccountNumber.substring(3);
			final String newBlz = getBankCode().substring(0, getBankCode().length() - 2)
					+ replacement + getBankCode().substring(getBankCode().length() - 1);
			if (newBlz.length() > 4) {
				dummy = Integer.parseInt(newBlz.substring(newBlz.length() - 4))
						+ "" + Integer.parseInt(part1) + pzpart
						+ Integer.parseInt(part3);

			} else {
				dummy = Integer.parseInt(newBlz) + "" + Integer.parseInt(part1)
						+ pzpart + Integer.parseInt(part3);
			}
		}
		return dummy;
	}

	/**
	 * @param paramLegacyAccountLength
	 *            the legacyAccountLength to set
	 */
	final void setLegacyAccountLength(
			@SuppressWarnings("SameParameterValue") final int paramLegacyAccountLength) {
		legacyAccountLength = paramLegacyAccountLength;
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public void validate(final String paramAccountNumber) {
		if (Long.parseLong(getNormalizedAccountNumber()) >= 9000000000L) {
			super.validate(paramAccountNumber);
		} else if (Utils.getLengtOfAccountAsNumber(paramAccountNumber) == legacyAccountLength) {
			final int checkDigit = Utils.stringToIntArray(paramAccountNumber)[legacyAccountLength - 7];
			String dummy = getDummy(paramAccountNumber);
			final int[] account = Utils.stringToIntArray(dummy,
					dummy.length() - 1);
			int product = 0;
			int keepme = 0;
			for (int i = 0; i < account.length; i++) {
				final int tomultiply = account[(account.length - i) - 1];
				if (tomultiply >= 0) {
					product += WEIGHT[i] * tomultiply;
				} else {
					keepme = WEIGHT[i];
				}
			}
			int rest = product % getModulo();
			int pz = 0;
			while ((rest + (pz * keepme)) % getModulo() != 10) {
				pz++;
			}
			if (pz == checkDigit) {
				setValid(true);
			} else {
				setValid(false);
			}

		} else {
			setValid(false);
		}
	}
}
