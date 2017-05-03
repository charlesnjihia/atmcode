/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.models.AccountNumber;
import app.repositories.AccountNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author charles
 */

@Service
public class AccountNumberServiceImp implements  AccountNumberService{
    AccountNumber accountNumber=null;
    @Autowired
    AccountNumberRepository accountNumberRepository;
    
    
    @Override
     public AccountNumber login(AccountNumber accountNumber){         
      this.accountNumber=accountNumberRepository.findByAccountNoAndAccountPin(accountNumber.getAccountNo(), accountNumber.getAccountPin());
      return   this.accountNumber;
     }
    
}
