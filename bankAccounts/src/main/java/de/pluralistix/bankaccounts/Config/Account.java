package de.pluralistix.bankaccounts.Config;

import de.pluralistix.bankaccounts.Exceptions.SyntaxException;
import de.pluralistix.bankaccounts.Methods.Special.AMethod;
import de.pluralistix.bankaccounts.Methods.Special.IBAN;

/**
 * @author pluralistix
 */
public final class Account {

	/**
	 */
	private String iban = "not set";

	/**
	 */
	private boolean valid = false;

	/**
	 * @param iban
	 *            bla
	 */
	public Account(final String iban) {
		IBAN i = new IBAN();
		i.validate(iban);
		valid = i.isValid();
	}

	/**
	 * @param bankCode
	 *            bla
	 * @param accountNumber
	 *            bla
	 */
	public Account(final String bankCode, final String accountNumber) {
		this(bankCode, accountNumber, false, false, false);
	}

	/**
	 * @param bankCode
	 *            bla
	 * @param accountNumber
	 *            bla
	 * @param generateIBAN
	 *            bla
	 */
	public Account(final String bankCode, final String accountNumber,
			final boolean generateIBAN) {
		this(bankCode, accountNumber, generateIBAN, false, false);
	}

	/**
	 * @param bankCode
	 *            bla
	 * @param accountNumber
	 *            bla
	 * @param generateIBAN
	 *            bla
	 * @param displayBankInfo
	 * 			  bla
	 */
	public Account(final String bankCode, final String accountNumber,
			final boolean generateIBAN, final boolean displayBankInfo) {
		this(bankCode, accountNumber, generateIBAN, displayBankInfo, false);
	}

	/**
	 * @param bankCode
	 *            bla
	 * @param accountNumber
	 *            bla
	 * @param generateIBAN
	 *            bla
	 * @param displayBankInfo
	 *            bla
	 * @param withBranches
	 *            bla
	 */
	public Account(final String bankCode, final String accountNumber,
					final boolean generateIBAN, final boolean displayBankInfo,
					final boolean withBranches) {
		Bank bank = null;
		try {
			bank = Banks.getInstance().getBankByBlz(bankCode);
		} catch (Exception e) {
			System.err.println("could not find bank");
		}
		if (bank != null) {
			if (displayBankInfo) {
				bank.doDisplay(withBranches);
			}
			AMethod m;
			try {
				m = (AMethod) bank.getMethodClass().newInstance();
				m.setBankCode(bankCode);
				m.setAccountNumber(accountNumber);
				m.validate(m.getAccountNumber());
				valid = m.isValid();
				if (valid && generateIBAN) {
					try {
						iban = (new IBAN("DE", bankCode, accountNumber)).getIban();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (InstantiationException | IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (SyntaxException e) {
				System.err.println(accountNumber + " " + e.getMessage());
			}
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
	 */
	public final boolean isAcccountValid() {
		return valid;
	}
}
