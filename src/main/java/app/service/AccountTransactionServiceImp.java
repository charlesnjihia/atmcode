/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.models.AccountNumber;
import app.models.AccountTransaction;
import app.models.MoneyTransferDetails;
import app.repositories.AccountNumberRepository;
import app.repositories.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author charles
 */
@Service
public class AccountTransactionServiceImp implements  AccountTransactionService{
    
@Autowired
AccountTransactionRepository accountTransactionRepository;   
@Autowired
AccountNumberRepository accountNumberRepository;   

 
 @Override
public AccountTransaction deposit(AccountTransaction accTransaction){
    
 AccountTransaction depositTransaction=accountTransactionRepository.save(accTransaction);
 return depositTransaction;
    
}
@Override
public AccountTransaction withdraw(AccountTransaction accTransaction){
  float balance= this.checkBalance(accTransaction.getAccountNumber().getAccountId()); 
  
  if(balance>=accTransaction.getTransactionAmount()){
      
   accTransaction.setTransactionAmount(accTransaction.getTransactionAmount()*-1);
   AccountTransaction depositTransaction=accountTransactionRepository.save(accTransaction);
   return depositTransaction;     
  }
  return null;   
    
}
  @Override
  public float checkBalance(long accountId){      
   float balance=accountTransactionRepository.findSumOfTransaction(accountId);
   return balance;    
  }
  
  @Override
  public AccountTransaction transferMoney(MoneyTransferDetails details){
  
   AccountNumber sourceAccount=accountNumberRepository.findByAccountNo(details.getSourceAccount());   
   float accountBalance=accountTransactionRepository.findSumOfTransaction(sourceAccount.getAccountId());
   
   if(accountBalance>=details.getTransferAmount()){
   //withdaraw from the source Account    
   AccountTransaction transferTransaction=new AccountTransaction();
   transferTransaction.setAccountNumber(new AccountNumber(sourceAccount.getAccountId()));
   transferTransaction.setTransactionType(AccountTransaction.TRANSFER);
   transferTransaction.setTransactionAmount(details.getTransferAmount()*-1);
   AccountTransaction withdralTransaction= accountTransactionRepository.save(transferTransaction);
   
   //perform a deposit to the destinationAccount
    AccountNumber destinationAccount=accountNumberRepository.findByAccountNo(details.getDestinationAccount());   
   
   transferTransaction.setAccountNumber(new AccountNumber(destinationAccount.getAccountId()));
   transferTransaction.setTransactionType(AccountTransaction.DEPOSIT);
   transferTransaction.setTransactionAmount(details.getTransferAmount());
   accountTransactionRepository.save(transferTransaction);
   
   return withdralTransaction;    
   }
   
  return null;   
      
  }   
    
}
