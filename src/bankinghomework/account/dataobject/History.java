/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankinghomework.account.dataobject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kriszti
 */
public class History {

    List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public History() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getHistoryByType(TransactionType type) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals(type)) {
                result.add(transaction);
            }
        }
        return result;
    }
}
