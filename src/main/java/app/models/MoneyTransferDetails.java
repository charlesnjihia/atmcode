/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.io.Serializable;

/**
 *
 * @author charles
 */
public class MoneyTransferDetails implements Serializable {
    
    String sourceAccount;
    String destinationAccount;
    float transferAmount;
    
    public MoneyTransferDetails(String source,String destination,float amount){
        
       this.sourceAccount=source;
       this.destinationAccount=destination;
       this.transferAmount=amount;
        
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public float getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(float transferAmount) {
        this.transferAmount = transferAmount;
    }
    
    
}
