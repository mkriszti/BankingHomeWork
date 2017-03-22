/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankinghomework;

import bankinghomework.account.AccountManager;
import bankinghomework.account.SimpleAccountManager;
import bankinghomework.account.dataobject.BankAccount;

/**
 *
 * @author Kriszti
 */
public class BankingHomework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccountManager accountManager = new SimpleAccountManager();
        BankAccount accountOne = accountManager.createAccount();
        BankAccount accountTwo = accountManager.createAccount();
        BankAccount accountThree = accountManager.createAccount();
        BankAccount accountFour = accountManager.createAccount();
        
        System.out.println(accountManager.deposit(accountOne, 50000));
        System.out.println(accountManager.deposit(accountTwo, 50000));
        System.out.println(accountManager.withdraw(accountOne, 2000));
   //     System.out.println(accountManager.transfer(accountOne, accountTwo.getAccountNr(), 190000));
        
        System.out.println(accountManager.getHistory(0));
        System.out.println(accountOne.getBalance());

    }

}
