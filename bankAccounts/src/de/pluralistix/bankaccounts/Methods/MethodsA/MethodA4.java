package de.pluralistix.bankaccounts.Methods.MethodsA;

import de.pluralistix.bankaccounts.Methods.Methods3.Method32;
import de.pluralistix.bankaccounts.Methods.Methods9.Method93;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class MethodA4 extends Method32 {

	/**
	 */
	private static final int MODULO_B = 7;

	/**
	 */
	private static final int[] WEIGHT_3 = new int[] { -1, -1, -1, -1, 6, 5, 4,
			3, 2, -1 };

	/**
	 */
	private int moduloFromSuper = 0;

	/**
	 */
	private int[] weightFromSuper = null;

	/**
	 */
	public MethodA4() {
		super();
		weightFromSuper = super.getWeight();
		moduloFromSuper = super.getModulo();
	}

	/**
	 */
	private void case1() {
		setModulo(moduloFromSuper);
		setWeight(weightFromSuper);
		var1();
		if (!isValid()) {
			var2();
			if (!isValid()) {
				var4();
			}
		}
	}

	/**
	 */
	private void case2() {
		setModulo(moduloFromSuper);
		var3();
		if (!isValid()) {
			var4();
		}
	}

	/**
	 * @return bla
	 */
	private boolean internalValidate() {
		final int product = product();
		int rest = product % MODULO_B;
		if (rest != 0) {
			rest = MODULO_B - rest;
		}
		return (rest == getCheckDigit());
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setAccountNumber(paramAccountNumber);
		if ((String.valueOf(Utils
				.stringToIntArray(getNormalizedAccountNumber())[2]) + String
				.valueOf(Utils.stringToIntArray(getNormalizedAccountNumber())[3]))
				.equals("99")) {
			case2();
		} else {
			case1();
		}
	}

	/**
	 */
	private void var1() {
		super.validate(getAccountNumber());
	}

	/**
	 */
	private void var2() {
		setModulo(MODULO_B);
		setValid(internalValidate());
	}

	/**
	 */
	private void var3() {
		setWeight(WEIGHT_3);
		super.validate(getAccountNumber());
	}

	/**
	 */
	private void var4() {
		Method93 m = new Method93();
		m.setAccountNumber(getAccountNumber());
		m.validate(getAccountNumber());
		setValid(m.isValid());
	}
}
