package com.criteriaApi.precticecriteriaapi.repository.TransactionRepository;

import com.criteriaApi.precticecriteriaapi.model.TransactionRecordClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<TransactionRecordClass, Long> {
}
