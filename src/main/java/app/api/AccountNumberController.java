/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.api;

import app.models.AccountNumber;
import app.service.AccountNumberServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author charles
 */
@RestController(value = "/accountnumbers")
public class AccountNumberController {
@Autowired
AccountNumberServiceImp accountNumberService;


 
//-------------------Retrieve An Account given the account number and pin i.e login--------------------------------------------------------
     
    @RequestMapping(value = "/accountnumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountNumber> getAccountFromLogin(@RequestBody AccountNumber accountNumber) {
        
        AccountNumber accNumber=accountNumberService.login(accountNumber);
        if (accNumber == null) {
            System.out.println("Acc not found " );
            return new ResponseEntity<AccountNumber>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AccountNumber>(accNumber, HttpStatus.OK);
    }
    
    
    
    
}
