package de.pluralistix.bankaccounts;

import de.pluralistix.bankaccounts.Config.Account;

public class runner {

    public static void main(String[] args) {
        //examples "stolen" from https://www.iban-bic.com/sample_accounts.html
        //correct
        Account a = new Account("50010517", "0648489890", true, true, true);
        System.out.println(a.getIban());
        System.out.println(a.isAcccountValid());

        //wrong
        Account b = new Account("50010517", "064847930", true, true, true);
        System.out.println(b.getIban());
        System.out.println(b.isAcccountValid());
    }
}
