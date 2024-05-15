package com.criteriaApi.precticecriteriaapi.service;

import com.criteriaApi.precticecriteriaapi.model.CustomerClass;
import com.criteriaApi.precticecriteriaapi.model.ItemClass;
import com.criteriaApi.precticecriteriaapi.model.TransactionRecordClass;
import com.criteriaApi.precticecriteriaapi.repository.ItemRepository.IItemRepository;
import com.criteriaApi.precticecriteriaapi.repository.TransactionRepository.ITransactionRepository;
import com.criteriaApi.precticecriteriaapi.repository.customerRepository.CustomerDAOClass;
import com.criteriaApi.precticecriteriaapi.repository.customerRepository.CustomerDTOClass;
import com.criteriaApi.precticecriteriaapi.repository.customerRepository.CustomerSearchProperties;
import com.criteriaApi.precticecriteriaapi.repository.customerRepository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ServiceClass {

    @Autowired
    private IItemRepository iItemRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private ITransactionRepository iTransactionRepository;
    @Autowired
    private CustomerDAOClass customerDAOClass;

    public void saveData() {
        saveDataInitiallyToDatabase();
    }

    public List<CustomerDTOClass> search(CustomerSearchProperties customerSearchProperties) {
        return customerDAOClass.searchCustomer(customerSearchProperties);
    }

//    public List<CustomerDTOClass> searchByCustomerName(String customerName){
//        return customerDAOClass.findCustomerByName(customerName);
//    }
//
//    public List<CustomerDTOClass> searchByCustomerEmployeeType(String employeeType){
//        return customerDAOClass.findCustomerByEmployeeType(employeeType);
//    }
//
//    public List<CustomerDTOClass> findBetweenTotalPurchase(int startTotalPurchase, int endTotalPurchase){
//        return customerDAOClass.findCustomerByTotalPurchaseRange(startTotalPurchase, endTotalPurchase);
//    }
//
//    public List<CustomerDTOClass> searchByCustomerNameAndCustomerTotalPurchaseBetween(String customerName, int startTotalPurchase, int endTotalPurchase){
//        return customerDAOClass.findByCustomerNameAndBetweenCustomerTotalPurchase(customerName, startTotalPurchase, endTotalPurchase);
//    }
//
//    public List<CustomerDTOClass> searchByCustomerNameAndCustomerEmployeeType(String customerName, String customerEmployeeType){
//        return customerDAOClass.findByCustomerNameAndCustomerEmployeeType(customerName, customerEmployeeType);
//    }
//
//    public List<CustomerDTOClass> searchBetweenStartTotalPurchaseAndEndTotalPurchaseAndCustomerEmployeeType(int startTotalPurchase, int endTotalPurchase, String employeeType){
//        return customerDAOClass.findBetweenStartTotalPurchaseAndEndTotalPurchaseAndCustomerEmployeeType(startTotalPurchase, endTotalPurchase, employeeType);
//    }


    private void saveDataInitiallyToDatabase() {
        CustomerClass abdul = new CustomerClass();
        abdul.setCustomerId(1001);
        abdul.setCustomerName("Abdul");
        abdul.setCustomerEmployeeStatus("Software Engineer");
        HashSet<ItemClass> abdulItems = new HashSet<>();

        ItemClass book = new ItemClass();
        book.setItemId(1);
        book.setItemName("Clean Code");
        book.setItemDescription("Software Engineering Book");
        book.setItemQuantity(1);
        book.setItemPrice(1500);
        iItemRepository.save(book);
        abdulItems.add(book);

        ItemClass mobile = new ItemClass();
        mobile.setItemId(3);
        mobile.setItemName("Realme 5i");
        mobile.setItemDescription("Android Mobile");
        mobile.setItemQuantity(1);
        mobile.setItemPrice(13000);
        iItemRepository.save(mobile);
        abdulItems.add(mobile);

        abdul.setCustomerItems(abdulItems);
        abdul.setCustomerTotalPurchase(calculateTotalPurchase(abdulItems));

        TransactionRecordClass abdulTransaction = new TransactionRecordClass();
        abdulTransaction.setTransactionId(500100);
        abdulTransaction.setCustomer(abdul);
        iTransactionRepository.save(abdulTransaction);

        abdul.setCustomerTransactionRecords(abdulTransaction);
        iCustomerRepository.save(abdul);


        CustomerClass fahim = new CustomerClass();
        fahim.setCustomerId(1002);
        fahim.setCustomerName("Fahim");
        fahim.setCustomerEmployeeStatus("Student");
        HashSet<ItemClass> fahimItems = new HashSet<>();
        fahimItems.add(book);

        ItemClass laptop = new ItemClass();
        laptop.setItemId(2);
        laptop.setItemName("Macbook pro");
        laptop.setItemDescription("Apple laptop");
        laptop.setItemQuantity(1);
        laptop.setItemPrice(160000);
        iItemRepository.save(laptop);
        fahimItems.add(laptop);

        fahim.setCustomerItems(fahimItems);
        fahim.setCustomerTotalPurchase(calculateTotalPurchase(fahimItems));

        iCustomerRepository.save(fahim);

        TransactionRecordClass fahimTransaction = new TransactionRecordClass();
        fahimTransaction.setTransactionId(500200);
        fahimTransaction.setCustomer(fahim);
        iTransactionRepository.save(fahimTransaction);


        CustomerClass salman = new CustomerClass();
        salman.setCustomerId(1003);
        salman.setCustomerName("Salman");
        salman.setCustomerEmployeeStatus("Teacher");
        HashSet<ItemClass> salmanItems = new HashSet<>();
        salmanItems.add(laptop);

        ItemClass tv = new ItemClass();
        tv.setItemId(4);
        tv.setItemName("Hisense");
        tv.setItemDescription("LED Smart TV");
        tv.setItemQuantity(1);
        tv.setItemPrice(27000);
        iItemRepository.save(tv);
        salmanItems.add(tv);

        salman.setCustomerItems(salmanItems);
        salman.setCustomerTotalPurchase(calculateTotalPurchase(salmanItems));
        iCustomerRepository.save(salman);

        TransactionRecordClass salmanTransaction = new TransactionRecordClass();
        salmanTransaction.setTransactionId(500300);
        salmanTransaction.setCustomer(salman);
        iTransactionRepository.save(salmanTransaction);

        CustomerClass fahimBhuiyan = new CustomerClass();
        fahimBhuiyan.setCustomerId(1004);
        fahimBhuiyan.setCustomerName("Fahim Bhuiyan");
        fahimBhuiyan.setCustomerEmployeeStatus("Doctor");
        HashSet<ItemClass> fahimBhuiyanItems = new HashSet<>();
        fahimBhuiyanItems.add(laptop);

        ItemClass chair = new ItemClass();
        chair.setItemId(5);
        chair.setItemName("Chair");
        chair.setItemDescription("Gaming Chair");
        chair.setItemQuantity(2);
        chair.setItemPrice(8000);
        iItemRepository.save(chair);
        fahimBhuiyanItems.add(chair);

        fahimBhuiyan.setCustomerItems(fahimBhuiyanItems);
        fahimBhuiyan.setCustomerTotalPurchase(calculateTotalPurchase(fahimBhuiyanItems));
        iCustomerRepository.save(fahimBhuiyan);

        TransactionRecordClass fahimBhuiyanTransactionRecord = new TransactionRecordClass();
        fahimBhuiyanTransactionRecord.setTransactionId(500400);
        fahimBhuiyanTransactionRecord.setCustomer(fahimBhuiyan);
        iTransactionRepository.save(fahimBhuiyanTransactionRecord);
    }

    private int calculateTotalPurchase(HashSet<ItemClass> items) {
        int totalAmount = 0;
        for (ItemClass i : items) {
            totalAmount += i.getItemQuantity() * i.getItemPrice();
        }
        return totalAmount;
    }
}
