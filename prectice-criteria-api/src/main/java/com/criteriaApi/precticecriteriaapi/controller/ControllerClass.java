package com.criteriaApi.precticecriteriaapi.controller;

import com.criteriaApi.precticecriteriaapi.repository.customerRepository.CustomerDTOClass;
import com.criteriaApi.precticecriteriaapi.repository.customerRepository.CustomerSearchProperties;
import com.criteriaApi.precticecriteriaapi.service.ServiceClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerClass {

    private static final Logger log = LoggerFactory.getLogger(ControllerClass.class);
    @Autowired
    private ServiceClass service;

    @GetMapping("/save")
    public ResponseEntity<String> saveData() {
        service.saveData();
        return ResponseEntity.ok("SAVE");
    }

    @GetMapping("/")
    public ResponseEntity<String> printX() {

        return ResponseEntity.ok("Success");
    }

    @GetMapping("/search")
    public List<CustomerDTOClass> searchCustomer(CustomerSearchProperties customerSearchProperties) throws JsonProcessingException {
        List<CustomerDTOClass> customerList = new ArrayList<>();
        customerList = service.search(customerSearchProperties);
        return customerList;
    }

//   @GetMapping("/search-by-employee-type")
//   public List<CustomerDTOClass> searchCustomerByEmployeeType(){
//       return service.searchByCustomerEmployeeType("Teacher");
//   }
//
//   @GetMapping("/between-total-purchase")
//   public List<CustomerDTOClass> findCustomerBetweenTotalPurchase(){
//       return service.findBetweenTotalPurchase(150000, 200000);
//   }

//    @GetMapping("/grater")
//    public ResponseEntity<List<ItemClass>> graterPrice(){
//        return ResponseEntity.ok(service.getGraterPrice(2000));
//    }

}
