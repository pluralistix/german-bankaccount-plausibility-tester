package de.pluralistix.bankaccounts.Methods.MethodsC;

import java.util.ArrayList;

import de.pluralistix.bankaccounts.Methods.Methods1.Method17;

/**
 * @author pluralistix
 */
public class MethodC1 extends Method17 {

	/**
	 */
	private static final int CHECKDIGITPOSITION_VAR2 = 10;

	/**
	 */
	private static final int[] WEIGHT_VAR2 = new int[] { 1, 2, 1, 2, 1, 2, 1,
			2, 1, -1 };

	/**
	 */
	private int checkDigistPositionFromSuper = 0;

	/**
	 */
	private ArrayList<Integer> querSumme = new ArrayList<Integer>(4);

	/**
	 */
	private ArrayList<Integer> querSummeFromSuper = null;

	/**
	 */
	private int[] weightFromSuper = null;

	/**
	 * 
	 */
	public MethodC1() {
		super();
		checkDigistPositionFromSuper = super.getCheckDigitPosition();
		weightFromSuper = super.getWeight();
		querSummeFromSuper = super.getCrossSum();
		initQuersumme();
	}

	/**
	 */
	private void initQuersumme() {
		querSumme.add(1);
		querSumme.add(3);
		querSumme.add(5);
		querSumme.add(7);
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		if (!getNormalizedAccountNumber().startsWith("5")) {
			setCrossSum(querSummeFromSuper);
			setCheckDigitPosition(checkDigistPositionFromSuper);
			setWeight(weightFromSuper);
			super.validate(paramAccountNumber);
		} else {
			setCheckDigitPosition(CHECKDIGITPOSITION_VAR2);
			setWeight(WEIGHT_VAR2);
			setCrossSum(querSumme);
			super.validate(paramAccountNumber);
		}
	}
}
