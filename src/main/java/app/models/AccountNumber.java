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
@Table(name = "Account_Numbers")
public class AccountNumber implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="account_id")
    private Long accountId;
    @Column(name="account_name")
     private String accountName;
    @Column(name="account_no", nullable = false)
    private String accountNo;
    @Column(name="account_pin")
    private long accountPin;
    @Column(name = "client_id")
    private long clientId;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="client_id",referencedColumnName="client_id")
    private Client client;
    
    public AccountNumber(){
        
    }
    public AccountNumber(long accountId){
     this.accountId=accountId;   
    }
    public AccountNumber(String accountName,String accountNo,long accountPin){
        
        this.accountName=accountName;
        this.accountNo=accountNo;
        this.accountPin=accountPin;
       
        
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public long getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(long accountPin) {
        this.accountPin = accountPin;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
    
    
    
}
