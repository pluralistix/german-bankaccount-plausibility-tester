package de.pluralistix.bankaccounts.Methods.Methods8;

import de.pluralistix.bankaccounts.Methods.Methods3.Method33;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method87 extends Method33 {

	/**
	 */
	private static final int MODULO = 7;

	/**
	 */
	private static final int[][] TAB1 = new int[][] { { 0, 0 }, { 1, 4 },
			{ 2, 3 }, { 3, 2 }, { 4, 6 } };

	/**
	 */
	private static final int[][] TAB2 = new int[][] { { 0, 7 }, { 1, 1 },
			{ 2, 5 }, { 3, 9 }, { 4, 8 } };

	/**
	 */
	private final int moduloFromSuper;

	/**
	 */
	public Method87() {
		super();
		moduloFromSuper = super.getModulo();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setValid(false);
		final int[] konto = Utils.stringToIntArray("0"
				+ getNormalizedAccountNumber(), 11);
		int i = 4;
		while (i < konto.length && konto[i] == 0) {
			i++;
		}
		int c2 = i % 2;
		int d2 = 0;
		int a5 = 0;
		int p;
		do {
			switch (konto[i]) {
			case 0:
				konto[i] = 5;
				break;
			case 1:
				konto[i] = 6;
				break;
			case 5:
				konto[i] = 10;
				break;
			case 6:
				konto[i] = 1;
				break;
			default:
				break;
			}
			if (c2 == d2) {
				if (konto[i] > 5) {
					if (c2 == 0) {
						c2 = 1;
						d2 = 1;
						a5 = a5 + 6 - (konto[i] - 6);
					} else {
						c2 = 0;
						d2 = 0;
						a5 = a5 + konto[i];
					}
				} else {
					if (c2 == 0) {
						c2 = 1;
						a5 = a5 + konto[i];
					} else {
						c2 = 0;
						a5 = a5 + konto[i];
					}
				}
			} else {
				if (konto[i] > 5) {
					if (c2 == 0) {
						c2 = 1;
						d2 = 0;
						a5 = a5 - 6 + (konto[i] - 6);
					} else {
						c2 = 0;
						d2 = 1;
						a5 = a5 - konto[i];
					}
				} else {
					if (c2 == 0) {
						c2 = 1;
						a5 = a5 - konto[i];
					} else {
						c2 = 0;
						a5 = a5 - konto[i];
					}
				}
			}
			i++;
		} while (i < 10);

		while (a5 < 0 || a5 > 4) {
			if (a5 > 4) {
				a5 = a5 - 5;
			} else {
				a5 = a5 + 5;
			}
		}

		if (d2 == 0) {
			p = TAB1[a5][1];
		} else {
			p = TAB2[a5][1];
		}

		if (p == konto[10]) {
			setValid(true);
		} else {
			if (konto[4] == 0) {
				if (p > 4) {
					p = p - 5;
				} else {
					p = p + 5;
				}
				if (p == konto[10]) {
					setValid(true);
				}
			}
		}
		if (!isValid()) {
			setModulo(moduloFromSuper);
			super.validate(paramAccountNumber);
		}
		if (!isValid()) {
			interalValidate(MODULO);
		}
	}

}
