/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankinghomework.account.dataobject;

import java.util.Date;

/**
 *
 * @author Kriszti
 */
public class Transaction {

    private static int GENERATEDID = 1;
    private final int id;
    private final int accountNr;
    private final Date date;
    private final TransactionType type;
    private final int accountWhere;
    private final long amount;
    private final boolean success;
    private final String message;

    public Transaction(int accountNr, Date date, TransactionType type, int accountWhere, long amount, boolean success, String message) {
        this.id = GENERATEDID;
        GENERATEDID++;
        this.accountNr = accountNr;
        this.date = date;
        this.type = type;
        this.accountWhere = accountWhere;
        this.amount = amount;
        this.success = success;
        this.message = message;
    }

    public Transaction(int accountNr, Date date, TransactionType type, long amount, boolean success, String message) {
        this.id = GENERATEDID;
        GENERATEDID++;
        this.accountNr = accountNr;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.success = success;
        this.accountWhere = -1;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public int getAccountNr() {
        return accountNr;
    }

    public Date getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }

    public int getAccountWhere() {
        return accountWhere;
    }

    public long getAmount() {
        return amount;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        String accWhere = accountWhere == -1 ? "" : "" + accountWhere;
        return "Transaction{" + "accountNr=" + accountNr + ", date=" + date + ", type=" + type + ", " + accWhere + ", amount=" + amount + ", success=" + success + ", message=" + message + '}';
    }

}
