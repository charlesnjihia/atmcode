/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author charles
 */
@Entity
@Table(name = "Client_Details")
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="client_id")
    private Long clientId;
    @Column(name="client_name", nullable = false)
    private String name;

    @Column(name="national_id", nullable = false)
    private String nationalId;
    
    @OneToMany(mappedBy="client",targetEntity=AccountNumber.class,
    fetch=FetchType.EAGER)
    private Collection accounts;  
    
    
    public Client(){        
    }
    public Client(String name,String nationalId){
        super();
        this.name=name;
        this.nationalId=nationalId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Collection getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection accounts) {
        this.accounts = accounts;
    }
    
    
    
    
}
