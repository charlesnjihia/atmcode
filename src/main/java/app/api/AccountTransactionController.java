/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.api;


import app.models.AccountTransaction;
import app.models.MoneyTransferDetails;
import app.service.AccountTransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author charles
 */
@RestController(value = "/transactions")
public class AccountTransactionController {
@Autowired
AccountTransactionServiceImp accountTransactionService;   

 @RequestMapping(value = "/deposit", method = RequestMethod.POST)
 public ResponseEntity<AccountTransaction> depositCash(@RequestBody AccountTransaction trans) {
        
        AccountTransaction depositTransaction=accountTransactionService.deposit(trans);
 
       if (depositTransaction == null) {
           
            return new ResponseEntity<AccountTransaction>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AccountTransaction>(depositTransaction, HttpStatus.OK);
        
    }
 @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
 public ResponseEntity<AccountTransaction> withdralCash(@RequestBody AccountTransaction trans) {
        
        AccountTransaction withdralTransaction=accountTransactionService.withdraw(trans);
 
       if (withdralTransaction == null) {
           
            return new ResponseEntity<AccountTransaction>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AccountTransaction>(withdralTransaction, HttpStatus.OK);
        
    }
 
 @RequestMapping(value = "/getbalance/{id}", method = RequestMethod.GET)
 public ResponseEntity<Float> getBalance(@PathVariable long accountId) {
        
        float balance=accountTransactionService.checkBalance(accountId);      
        return new ResponseEntity<Float>(balance, HttpStatus.OK);
        
    }
 
 @RequestMapping(value = "/transfer", method = RequestMethod.POST)
 public ResponseEntity<AccountTransaction> transferCash(@RequestBody MoneyTransferDetails details) {
        
        AccountTransaction transferTransaction=accountTransactionService.transferMoney(details);
 
       if (transferTransaction == null) {
           
            return new ResponseEntity<AccountTransaction>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AccountTransaction>(transferTransaction, HttpStatus.OK);
        
    }
    
    
    
}
