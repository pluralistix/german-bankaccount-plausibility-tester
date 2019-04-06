package de.pluralistix.bankaccounts.Methods.Special;

import java.util.HashMap;

import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class MethodMH10 extends AMethod {

	/**
	 */
	private static final HashMap<Integer, int[]> transformationMap = new HashMap<>();

	/**
	 */
	private static final int[] TRANSFORMATIONTABLE = new int[] { 1, 4, 3, 2, 1,
			4, 3, 2, 1 };

	/**
	 */
	private void buildMap() {
		transformationMap.put(1, new int[] { 0, 1, 5, 9, 3, 7, 4, 8, 2, 6 });
		transformationMap.put(2, new int[] { 0, 1, 7, 6, 9, 8, 3, 2, 5, 4 });
		transformationMap.put(3, new int[] { 0, 1, 8, 4, 6, 2, 9, 5, 7, 3 });
		transformationMap.put(4, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		final int[] intArray = Utils
				.stringToIntArray(getNormalizedAccountNumber());
		buildMap();
		int sum = 0;
		for (int i = 8; i >= 0; i--) {
			sum += transformationMap.get(TRANSFORMATIONTABLE[i])[intArray[i]];
		}
		sum = 10 - Utils.unitPosition(sum);
		if (sum == 10) {
			sum = 0;
		}
		if (sum == getCheckDigit()) {
			setValid(true);
		} else {
			setValid(false);
		}
	}

}
