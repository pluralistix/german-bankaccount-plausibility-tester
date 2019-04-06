package de.pluralistix.bankaccounts.Config;

import java.util.List;

/**
 * @author pluralistix
 */
public class Bank {

	/**
	 */
	private final String bankCode;

	/**
	 */
	private List<Bank> branches = null;

	/**
	 */
	private final String type;

	/**
	 */
	private Class<?> methodClass;

	/**
	 */
	private final String methode;

	/**
	 */
	private final String name;

	/**
	 */
	private final String city;

	/**
	 */
	private final String postCode;

	/**
	 * @param paramPostCode
	 *            bla
	 * @param paramCity
	 *            bla
	 * @param paramName
	 *            bla
	 * @param paramBankCode
	 *            bla
	 * @param paramMethod
	 *            bla
	 * @param paramType
	 *            bla
	 */
	public Bank(final String paramPostCode, final String paramCity,
			final String paramName, final String paramBankCode,
			final String paramMethod, final String paramType) {
		bankCode = paramBankCode;
		postCode = paramPostCode;
		name = paramName;
		city = paramCity;
		methode = paramMethod;
		try {
			methodClass = Class
					.forName("de.pluralistix.bankaccounts.Methods.Methods"
							+ methode.trim().substring(0, 1) + ".Method"
							+ methode);
		} catch (Exception ignored) {

		}
		type = paramType;
	}

	/**
	 * @param withBranches
	 *            bla
	 */
	public void doDisplay(final boolean withBranches) {
		if (withBranches && getBranches() != null) {
			System.out.println(toString());
			for (Bank b : getBranches()) {
				System.out.println(b.toString());
			}
		} else {
			System.out.println(toString());
		}
	}

	/**
	 * @return bla
	 */
	public final String getBankCode() {
		return bankCode;
	}

	/**
	 * @return the branches
	 */
	private List<Bank> getBranches() {
		return branches;
	}

	/**
	 * @return bla
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @return bla
	 */
	public final int getHashCode() {
		return this.hashCode();
	}

	/**
	 * @return bla
	 */
	public Class<?> getMethodClass() {
		return methodClass;
	}

	/**
	 * @return bla
	 */
	public final String getMethod() {
		return methode;
	}

	/**
	 * @return bla
	 */
	private String getName() {
		return name;
	}

	/**
	 * @return bla
	 */
	private String getCity() {
		return city;
	}

	/**
	 * @return bla
	 */
	private String getPostCode() {
		return postCode;
	}

	/**
	 * @param paramBranches
	 *            bla
	 */
	public final void setBranches(final List<Bank> paramBranches) {
		branches = paramBranches;
	}

	/**
	 * @return bla
	 */
	@Override
	public final String toString() {
		return (getType().equals("1") ? "Hauptbank\nBLZ: " + getBankCode() : "Filiale") + "\nName: "
				+ getName() + "\nPlz: " + getPostCode() + "\nOrt: " + getCity();
	}
}
