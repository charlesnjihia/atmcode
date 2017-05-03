/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;
import app.models.AccountTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author charles
 */
public interface AccountTransactionRepository  extends PagingAndSortingRepository<AccountTransaction, Long>{
    
 
  @Query(value = "select sum(transaction_amount) from Account_Transactions where account_id = ? ", nativeQuery = true)
  public float findSumOfTransaction(long accountId);
    
}
