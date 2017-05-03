/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author charles
 */
@Entity
@Table(name = "Account_Transactions")
public class AccountTransaction implements Serializable {
    
    public static int DEPOSIT=1;
    public static int WITHDRAW=2;
    public static int TRANSFER=3;
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="transaction_id")
    private Long transactionId;
    
    @Column(name="account_id")
    private Long accountId;
    @Column(name="transaction_type")
    private int transactionType;
    @Column(name="transaction_amount")
    private float transactionAmount;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="account_id",referencedColumnName="account_id")
    private AccountNumber accountNumber;
    
    
    public AccountTransaction(){
        
    }
    public AccountTransaction(int transactionType,float transactionAmount,AccountNumber accountNumber){
        
        this.transactionType=transactionType;
        this.transactionAmount=transactionAmount;
        this.accountNumber=accountNumber;
        
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    
    
    
    
    
}
