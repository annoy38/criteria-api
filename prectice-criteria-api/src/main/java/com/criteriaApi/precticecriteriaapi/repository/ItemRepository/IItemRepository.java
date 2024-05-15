package com.criteriaApi.precticecriteriaapi.repository.ItemRepository;

import com.criteriaApi.precticecriteriaapi.model.ItemClass;
import com.criteriaApi.precticecriteriaapi.repository.customerRepository.ICustomerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<ItemClass, Integer>{

}
