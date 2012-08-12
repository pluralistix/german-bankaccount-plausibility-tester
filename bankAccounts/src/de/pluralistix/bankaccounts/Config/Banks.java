package de.pluralistix.bankaccounts.Config;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * @author pluralistix
 */
public final class Banks {

	/**
	 */
	private static final Banks MYBANKS = new Banks("/banks.gz");

	/**
	 * @return bla
	 */
	public static Banks getInstance() {
		return MYBANKS;
	}

	/**
	 */
	private final HashMap<Long, List<Bank>> bankBranches = new HashMap<Long, List<Bank>>(
			15000);

	/**
	 */
	private final HashMap<Long, Bank> mainBanks = new HashMap<Long, Bank>(5000);

	/**
	 */
	private final HashMap<String, String> syntax = new HashMap<String, String>();

	/**
	 * @param paramPath
	 *            bla
	 */
	private Banks(final String paramPath) {
		try {
			buildSyntax();
			String line;
			InputStream is = getClass().getResourceAsStream(paramPath);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new GZIPInputStream(is)));
			while ((line = br.readLine()) != null) {
				try {
					Bank b = new Bank(getStringPart(line, "postcode"),
							getStringPart(line, "city"), getStringPart(line,
									"name"), getStringPart(line, "bankcode"),
							getStringPart(line, "method"), getStringPart(line,
									"type"));
					if (b.getType().equals("1")) {
						mainBanks.put(Long.parseLong(b.getBankCode()), b);
					} else {
						List<Bank> tmp = bankBranches.get(Long.parseLong(b
								.getBankCode()));
						if (tmp == null) {
							(tmp = new ArrayList<Bank>()).add(b);
						} else {
							tmp.add(b);
						}
						bankBranches.put(Long.parseLong(b.getBankCode()), tmp);
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

			}
			br.close();
			is.close();
			for (Long key : mainBanks.keySet()) {
				mainBanks.get(key).setBranches(bankBranches.get(key));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 */
	private void buildSyntax() {
		syntax.put("postcode", "67|72");
		syntax.put("type", "8|9");
		syntax.put("city", "72|107");
		syntax.put("bankcode", "0|8");
		syntax.put("name", "9|67");
		syntax.put("method", "150|152");
	}

	/**
	 * @param paramBankCode
	 *            bla
	 * @return bla
	 */
	public Bank getBankByBlz(final String paramBankCode) {
		try {
			return mainBanks.get(Long.valueOf(paramBankCode));
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * @param tosplit
	 *            bla
	 * @param paramName
	 *            bla
	 * @return bla
	 * @throws Exception
	 *             bla
	 */
	private String getStringPart(final String tosplit, final String paramName)
			throws Exception {
		return tosplit.substring(
				Integer.parseInt(syntax.get(paramName).split("\\|")[0]),
				Integer.parseInt(syntax.get(paramName).split("\\|")[1]));
	}

}
