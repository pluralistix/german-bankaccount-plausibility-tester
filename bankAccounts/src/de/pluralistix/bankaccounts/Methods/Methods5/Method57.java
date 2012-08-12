package de.pluralistix.bankaccounts.Methods.Methods5;

import de.pluralistix.bankaccounts.Methods.Methods0.Method00;

/**
 * @author pluralistix
 */
public class Method57 extends Method00 {

	/**
	 */
	private static final int CHEKDIGITPOSITION_VAR1 = 10;

	/**
	 */
	private static final int CHEKDIGITPOSITION_VAR2 = 3;

	/**
	 */
	private static final String MATCHER_VAR1 = "^(51|55|61|64|65|66|70|73|75|76|77|78|79|80|81|82|88|94|95).*$";

	/**
	 */
	private static final String MATCHER_VAR2 = "^(3[2-9]{1}|4[1-9]{1}|5([2-4]{1}|[6-9]){1}|6(0|[2-3]{1}|[7-9]{1})|7(1|2|4)|8([3-7]{1}|9)|9((0|2|3)|[6-8]{1})).*$";

	/**
	 */
	private static final int[] WEIGHT_VAR1 = new int[] { 1, 2, 1, 2, 1, 2, 1,
			2, 1, -1 };

	/**
	 */
	private static final int[] WEIGHT_VAR2 = new int[] { 1, 2, -1, 1, 2, 1, 2,
			1, 2, 1 };

	/**
	 */
	public Method57() {
		super();
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		super.setWeight(WEIGHT_VAR1);
		super.setCheckDigitPosition(CHEKDIGITPOSITION_VAR1);
		final String normalized = getNormalizedAccountNumber();
		if (normalized.startsWith("00")) {
			setValid(false);
			return;
		} else if (normalized.matches("^(7|8){6,}.*$")
				|| normalized.matches("^(40|50|91|99).*$")
				|| normalized.equals("0185125434")) {
			setValid(true);
			return;
		} else if (normalized.matches(MATCHER_VAR1)) {
			super.validate(paramAccountNumber);
		} else if (normalized.matches(MATCHER_VAR2)) {
			super.setWeight(WEIGHT_VAR2);
			super.setCheckDigitPosition(CHEKDIGITPOSITION_VAR2);
			super.validate(paramAccountNumber);
		} else if (Integer.parseInt(normalized.substring(0, 2)) < 32) {
			final int x = Integer.parseInt(normalized.substring(2, 4));
			final int y = Integer.parseInt(normalized.substring(6, 9));
			if (x <= 12 && y < 500) {
				setValid(true);
			} else {
				setValid(false);
			}
		}
	}

}
