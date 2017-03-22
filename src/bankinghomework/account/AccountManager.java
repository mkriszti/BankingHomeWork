/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankinghomework.account;

import bankinghomework.account.dataobject.BankAccount;
import bankinghomework.account.dataobject.Transaction;
import java.util.List;

/**
 *
 * @author Kriszti
 */
public interface AccountManager {

    Transaction transfer(BankAccount bankacc, int accountWhere, long amount);

    Transaction deposit(BankAccount bankacc, long amount);

    Transaction withdraw(BankAccount bankacc, long amount);

    BankAccount createAccount();

    List<Transaction> getHistory(int id);

}
