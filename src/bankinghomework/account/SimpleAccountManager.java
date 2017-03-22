/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankinghomework.account;

import bankinghomework.account.dataobject.BankAccount;
import bankinghomework.account.dataobject.History;
import bankinghomework.account.dataobject.Transaction;
import bankinghomework.account.dataobject.TransactionType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kriszti
 */
public class SimpleAccountManager implements AccountManager {

    private static final Map<Integer, BankAccount> ACCOUNTLIST = new HashMap();

    @Override
    public Transaction transfer(BankAccount bankacc, int accountWhereId, long amount) {
        Transaction firstTransaction;

        BankAccount accountWhere = ACCOUNTLIST.get(accountWhereId);
        if (accountWhere == null) {
            firstTransaction = new Transaction(accountWhereId, new Date(), TransactionType.TRANSFER, amount, false, "Transfer was not successful. Target account does not exist.");
        } else if (!bankacc.takeAmount(amount)) {
            firstTransaction = new Transaction(accountWhereId, new Date(), TransactionType.TRANSFER, accountWhereId, amount, false, "Transfer was not successful. There was not enough money on your account.");
        } else {
            firstTransaction = new Transaction(accountWhereId, new Date(), TransactionType.TRANSFER, accountWhereId, amount, true, "Transfer was successful.");
            Transaction secondTransaction;
            secondTransaction = new Transaction(accountWhereId, new Date(), TransactionType.TRANSFER, amount, true, "Transfer was successful");
            updateHistory(secondTransaction, accountWhere.getHistory());
        }

        updateHistory(firstTransaction, bankacc.getHistory());

        return firstTransaction;
    }

    @Override
    public Transaction deposit(BankAccount bankacc, long amount) {
        bankacc.addAmount(amount);
        Transaction transaction = new Transaction(bankacc.getAccountNr(), new Date(), TransactionType.DEPOSIT, amount, true, "Deposit was succesful");
        updateHistory(transaction, bankacc.getHistory());

        return transaction;
    }

    @Override
    public Transaction withdraw(BankAccount bankacc, long amount) {
        boolean success = bankacc.takeAmount(amount);
        Transaction transaction = new Transaction(bankacc.getAccountNr(), new Date(), TransactionType.WITHDRAW, amount, success, success ? "Deposit was succesful" : "Deposit was not succesful");
        updateHistory(transaction, bankacc.getHistory());

        return transaction;
    }

    private void updateHistory(Transaction transaction, History history) {
        history.addTransaction(transaction);
    }

    @Override
    public BankAccount createAccount() {
        BankAccount bacc = new BankAccount();
        ACCOUNTLIST.put(bacc.getAccountNr(), bacc);
        return bacc;
    }

    @Override
    public List<Transaction> getHistory(int id) {
        // We check if the id is in the list. If it does not exist the list is empty, if it exists we return all items(of the list)
        BankAccount acc = ACCOUNTLIST.get(id);
        if (acc == null) {
             
        }
        return acc.getHistory().getTransactions();
    }

}
