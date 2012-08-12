package de.pluralistix.bankaccounts.Methods.Special;

import java.math.BigInteger;

import de.pluralistix.bankaccounts.Utils.Utils;

/**
 * @author pluralistix
 */
public class IBAN extends AMethod {

	/**
	 */
	private static final int CHECKER = 1;

	/**
	 */
	private static final Long MODULO = 97L;

	/**
	 */
	private String cleanedAccountNumber = null;

	/**
	 */
	private String iban;

	/**
	 * 
	 */
	public IBAN() {
		super();
	}

	/**
	 * @param countryCode
	 *            bla
	 * @param blz
	 *            bla
	 * @param konto
	 *            bla
	 * @throws Exception
	 *             bla
	 */
	public IBAN(final String countryCode, final String blz, final String konto)
			throws Exception {
		generateIban(countryCode, blz, konto);
	}

	/**
	 * @param country
	 *            bla
	 * @param ckeckDigit
	 *            bla
	 * @return bla
	 */
	private BigInteger buildChecker(final String country,
			final String ckeckDigit) {
		return new BigInteger(cleanedAccountNumber.substring(4) + country
				+ ckeckDigit);
	}

	/**
	 * @param accountNumber
	 *            bla
	 * @return bla
	 * @throws Exception
	 *             bla
	 */
	private String cleanUp(final String accountNumber) throws Exception {
		final String tmp = accountNumber.replace("-", "").replace(" ", "")
				.replace("/", "");
		if (tmp.matches("[a-z|A-Z]{2,}[0-9]{5,}")) {
			return tmp;
		} else {
			throw new Exception("Iban has wrong format");
		}
	}

	/**
	 * @return bla
	 * @throws Exception
	 *             bla
	 */
	private String country2Number() throws Exception {
		final String tmp = cleanedAccountNumber.substring(0, 2).toUpperCase();
		if (tmp.toUpperCase().matches("[A-Z]{2}")) {
			return String.valueOf(tmp.getBytes()[0] - 55)
					+ String.valueOf(tmp.getBytes()[1] - 55);
		} else {
			throw new Exception("Iban has to start with country code");
		}
	}

	/**
	 * @param countryCode
	 *            bla
	 * @return bla
	 * @throws Exception
	 *             bla
	 */
	private String country2Number(final String countryCode) throws Exception {
		if (countryCode.toUpperCase().matches("[A-Z]{2}")) {
			return String.valueOf(countryCode.getBytes()[0] - 55)
					+ String.valueOf(countryCode.getBytes()[1] - 55);
		} else {
			throw new Exception("Iban has to start with country code");
		}
	}

	/**
	 * @param countryCode
	 *            bla
	 * @param blz
	 *            bla
	 * @param konto
	 *            bla
	 * @return bla
	 * @throws Exception
	 *             bla
	 */
	private String generateIban(final String countryCode, final String blz,
			final String konto) throws Exception {
		final String country = country2Number(countryCode);
		final int checkDigit = 98 - getRest(
				new BigInteger(blz + Utils.lpad(konto) + country + "00"))
				.intValue();
		iban = countryCode + Utils.lpad(String.valueOf(checkDigit), 2, '0')
				+ blz + Utils.lpad(konto);
		if (validateInternal(iban)) {
			return iban;
		} else {
			throw new Exception("could not generate IBAN");
		}
	}

	/**
	 * @return the iban
	 */
	public final String getIban() {
		return iban;
	}

	/**
	 * @return bla
	 * @throws Exception
	 *             bla
	 */
	private String getIbanCheckDigit() throws Exception {
		final String tmp = cleanedAccountNumber.substring(2, 4);
		if (!tmp.matches("^(00|01|99)$")) {
			return tmp;
		} else {
			throw new Exception("checkdigit must not be 00 or 01 or 99");
		}
	}

	/**
	 * @param bi
	 *            bla
	 * @return bla
	 */
	private BigInteger getRest(final BigInteger bi) {
		return bi.mod(BigInteger.valueOf(MODULO));
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 */
	@Override
	public final void validate(final String paramAccountNumber) {
		setValid(validateInternal(paramAccountNumber));
	}

	/**
	 * @param paramAccountNumber
	 *            bla
	 * @return bla
	 */
	private boolean validateInternal(final String paramAccountNumber) {
		try {
			cleanedAccountNumber = cleanUp(paramAccountNumber);
			final String countryConverted = country2Number();
			final String checkDigit = getIbanCheckDigit();
			final BigInteger check = buildChecker(countryConverted, checkDigit);
			return (getRest(check).intValue() == CHECKER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
