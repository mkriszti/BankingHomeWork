/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankinghomework.account.dataobject;

/**
 *
 * @author Kriszti
 */
public class BankAccount {

    private static int GENERATEDACCID;
    private final int accountNr;
    private long balance;
    private final History history;

    public BankAccount() {
        this.accountNr = GENERATEDACCID;
        GENERATEDACCID++;
        history = new History();
    }

    public BankAccount(long balance) {
        this.accountNr = GENERATEDACCID;
        GENERATEDACCID++;
        this.balance = balance;
        history = new History();
    }

    public int getAccountNr() {
        return accountNr;
    }

    public long getBalance() {
        return balance;
    }

    public History getHistory() {
        return history;
    }

    public void addAmount(long amount) {
        balance = balance + amount;
    }

    public boolean takeAmount(long amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

}
