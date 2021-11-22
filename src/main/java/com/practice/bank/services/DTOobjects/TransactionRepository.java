package com.practice.bank.services.DTOobjects;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer>{
	
	@Query("select t from TransactionEntity t where t.id=?1")
	public List<TransactionEntity> getTransactionList(int accnum);

	
//	@Query("select t from TransacEntity t where t.customerEntity.accnum=?1")
//	public List<TransacEntity> getTransactionList(int accnum);
//

}
