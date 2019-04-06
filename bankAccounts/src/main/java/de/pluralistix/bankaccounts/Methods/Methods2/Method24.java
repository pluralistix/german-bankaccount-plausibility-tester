package de.pluralistix.bankaccounts.Methods.Methods2;

import de.pluralistix.bankaccounts.Methods.Special.AMethod;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class Method24 extends AMethod {

	/**
	 */
	private static final int MODULO = 11;

	/**
	 */
	private static final int[] WEIGHT = new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3,
			-1 };

	/**
	 */
	public Method24() {
		super();
		super.setWeight(WEIGHT);
		super.setModulo(MODULO);
	}

	/**
	 * @return bla
	 */
	@Override
	protected final int product() {
		final int[] accountNummberArray = Utils
				.stringToIntArray(getNormalizedAccountNumber());
		final int[] weightArray = getWeight();
		int returnvalue = 0;
		int product;
		int x = 0;
		for (int i = 0; i < accountNummberArray.length; i++) {
			if (weightArray[i] != -1 && (x != 0 || accountNummberArray[i] != 0)) {
				product = ((accountNummberArray[i] * weightArray[x]) + weightArray[x])
						% getModulo();
				returnvalue += product;
				x++;
			}
		}
		return Utils.unitPosition(returnvalue);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (getNormalizedAccountNumber().matches("^([3456]).*$")) {
			setNormalizedAccountNumber(getNormalizedAccountNumber().substring(
					1, 10));
		} else if (getNormalizedAccountNumber().matches("^9.*$")) {
			setNormalizedAccountNumber(getNormalizedAccountNumber().substring(
					3, 10));
		}
		doValidate(product(), false);
	}

}
