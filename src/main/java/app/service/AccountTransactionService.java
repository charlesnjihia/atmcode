/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.models.AccountTransaction;
import app.models.MoneyTransferDetails;

/**
 *
 * @author charles
 */
public interface AccountTransactionService {
    
  public AccountTransaction deposit(AccountTransaction accTransaction);  
  public AccountTransaction withdraw(AccountTransaction accTransaction);
  public float checkBalance(long accountId); 
  public AccountTransaction transferMoney(MoneyTransferDetails details);
  
    
    
}
