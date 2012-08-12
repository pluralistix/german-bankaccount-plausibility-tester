package de.pluralistix.bankaccounts.Methods.Special;

import java.util.ArrayList;
import java.util.Arrays;

import de.pluralistix.bankaccounts.Exceptions.MissingAccountNumberException;
import de.pluralistix.bankaccounts.Exceptions.SyntaxException;
import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public abstract class AMethod {

	/**
	 */
	static final int DEFAULTCHECKDIGITPOSITION = 10;

	/**
	 */
	static final int DEFAULTMODULO = 10;

	/**
	 */
	public static final int MAXLENGTHOFKONTO = 10;

	/**
	 * @param blz
	 *            bla
	 * @param accountNumber
	 *            bla
	 */
	private static void syntaxCheck(final int blz, final String accountNumber) {
		if (String.valueOf(blz).length() != 8 && blz != -1) {
			throw new SyntaxException("bank code not in the right format");
		}
		try {
			if (Long.valueOf(accountNumber) < 10L
					|| Long.valueOf(accountNumber) > 9999999999L) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			throw new SyntaxException(
					"account number not in the right format");
		}
	}

	/**
	 */
	private String accountNumber = null;

	/**
	 */
	private String bankCode = null;

	/**
	 */
	private int checkDigitPosition = DEFAULTCHECKDIGITPOSITION;

	/**
	 */
	private int diffLength;

	/**
	 */
	private boolean unitPosition = false;

	/**
	 */
	private int modulo = DEFAULTMODULO;

	/**
	 */
	private String normalizedAccountNumber = null;

	/**
	 */
	private ArrayList<Integer> crossSum = null;

	/**
	 */
	private boolean substractRestFromTen = true;

	/**
	 */
	private boolean valid = false;

	/**
	 */
	private int[] weight = null;

	/**
	 * @param result
	 *            bla
	 * @param paramUnitPosition
	 *            bla
	 */
	public final void doValidate(final int result, final boolean paramUnitPosition) {
		int resulttmp = result;
		if (paramUnitPosition) {
			if (isSubstractRestFromTen()) {
				resulttmp = Utils
						.unitPosition(10 - Utils.unitPosition(resulttmp));
			} else {
				resulttmp = Utils.unitPosition(resulttmp);
			}
		}
		if (resulttmp == getCheckDigit()) {
			setValid(true);
		} else {
			setValid(false);
		}
	}

	/**
	 * @return the accountNumber
	 */
	public final String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the blz
	 */
	protected final String getBankCode() {
		return bankCode;
	}

	/**
	 * @return the checkDigit
	 */
	public final int getCheckDigit() {
		return Integer.parseInt(normalizedAccountNumber.substring(
				getCheckDigitPosition() - 1, getCheckDigitPosition()));
	}

	/**
	 * @return the checkDigitPosition
	 */
	public final int getCheckDigitPosition() {
		return checkDigitPosition;
	}

	/**
	 * @return the diffLength
	 */
	protected final int getDiffLength() {
		return diffLength;
	}

	/**
	 * @return the modulo
	 */
	public final int getModulo() {
		return modulo;
	}

	/**
	 * @return the normalizedAccountNumber
	 */
	public final String getNormalizedAccountNumber() {
		return normalizedAccountNumber;
	}

	/**
	 * @return the quersumme
	 */
	public final ArrayList<Integer> getCrossSum() {
		return crossSum;
	}

	/**
	 * @return the weight
	 */
	public final int[] getWeight() {
		return weight;
	}

	/**
	 * @return the einerstelle
	 */
	public final boolean isUnitPosition() {
		return unitPosition;
	}

	/**
	 * @return the substractRestFromTen
	 */
	public final boolean isSubstractRestFromTen() {
		return substractRestFromTen;
	}

	/**
	 * @return the valid
	 */
	public final boolean isValid() {
		return valid;
	}

	/**
	 * @return bla
	 */
	public final int myHash() {
		StringBuilder sb = new StringBuilder();
		sb.append(getCheckDigitPosition() + "|");
		sb.append(getModulo() + "|");
		sb.append(getCrossSum() == null ? "null" : getCrossSum() + "|");
		sb.append(getWeight() == null ? "null" : Arrays.toString(getWeight())
				+ "|");
		sb.append(isUnitPosition() + "|");
		sb.append(isValid());
		return sb.toString().hashCode();
	}

	/**
	 * @return bla
	 */
	public int product() {
		final int[] accountNummberArray = Utils
				.stringToIntArray(getNormalizedAccountNumber());
		final int[] weightArray = getWeight();
		int returnvalue = 0;
		int product = 0;
		for (int i = 0; i < accountNummberArray.length; i++) {
			if (weightArray[i] != -1) {
				product = accountNummberArray[i] * weightArray[i];
				if (getCrossSum() != null) {
					final int size = getCrossSum().size();
					try {
						if ((size > 0) && (!getCrossSum().contains(i))) {
							returnvalue += product;
						} else {
							returnvalue += Utils.crossSum(product);
						}
					} catch (Exception e) {
						returnvalue += Utils.crossSum(product);
					}
				} else {
					if (isUnitPosition()) {
						returnvalue += Utils.unitPosition(product);
					} else {
						returnvalue += product;
					}

				}
			}
		}
		return returnvalue;

	}

	/**
	 * @param paramAccountNumber
	 *            the accountNumber to set
	 */
	public final void setAccountNumber(final String paramAccountNumber) {
		setAccountNumber(paramAccountNumber, true);
	}

	/**
	 * @param paramAccountNumber
	 *            the accountNumber to set
	 * @param validateSyntax
	 *            bla
	 */
	public final void setAccountNumber(final String paramAccountNumber,
			final boolean validateSyntax) {
		if (validateSyntax) {
			syntaxCheck(-1, paramAccountNumber);
		}
		accountNumber = Utils.accountAsNumber(paramAccountNumber).toString();
		diffLength = paramAccountNumber.length() - accountNumber.length();
		setNormalizedAccountNumber(paramAccountNumber);
	}

	/**
	 * @param paramBankCode
	 *            the blz to set
	 */
	public final void setBankCode(final String paramBankCode) {
		bankCode = paramBankCode;
	}

	/**
	 * @param paramCheckDigitPosition
	 *            the checkDigitPosition to set
	 */
	public final void setCheckDigitPosition(final int paramCheckDigitPosition) {
		checkDigitPosition = paramCheckDigitPosition;
	}

	/**
	 * @param paramUnitPosition
	 *            the einerstelle to set
	 */
	public final void setUnitPosition(final boolean paramUnitPosition) {
		unitPosition = paramUnitPosition;
	}

	/**
	 * @param paramModulo
	 *            the modulo to set
	 */
	public final void setModulo(final int paramModulo) {
		modulo = paramModulo;
	}

	/**
	 * @param paramNormalizedAccountNumber
	 *            the normalizedAccountNumber to set
	 */
	public final void setNormalizedAccountNumber(
			final String paramNormalizedAccountNumber) {
		normalizedAccountNumber = Utils.lpad(paramNormalizedAccountNumber);
	}

	/**
	 * @param paramCrossSum
	 *            the quersumme to set
	 */
	public final void setCrossSum(final ArrayList<Integer> paramCrossSum) {
		crossSum = paramCrossSum;
	}

	/**
	 * @param paramSubstractRestFromTen
	 *            the substractRestFromTen to set
	 */
	public final void setSubstractRestFromTen(
			final boolean paramSubstractRestFromTen) {
		substractRestFromTen = paramSubstractRestFromTen;
	}

	/**
	 * @param paramValid
	 *            the valid to set
	 */
	public final void setValid(final boolean paramValid) {
		valid = paramValid;
	}

	/**
	 * @param paramWeight
	 *            the weight to set
	 */
	public final void setWeight(final int[] paramWeight) {
		weight = paramWeight;
	}

	/**
	 * @throws MissingAccountNumberException
	 *             bla
	 */
	public final void validate() throws MissingAccountNumberException {
		if (getAccountNumber() != null) {
			validate(getAccountNumber());
		} else {
			throw new MissingAccountNumberException();
		}
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	public abstract void validate(final String paramAccountNumber);

}
