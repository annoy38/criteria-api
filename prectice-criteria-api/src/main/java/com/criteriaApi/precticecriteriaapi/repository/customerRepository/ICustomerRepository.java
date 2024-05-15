package com.criteriaApi.precticecriteriaapi.repository.customerRepository;

import com.criteriaApi.precticecriteriaapi.model.CustomerClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<CustomerClass, Integer> {


}
