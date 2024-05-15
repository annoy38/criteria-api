package com.criteriaApi.precticecriteriaapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class CustomerClass {
    @Id
    private int customerId;
    private String customerName;
    private String customerEmployeeStatus;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "customer_item_table",
            joinColumns = {@JoinColumn(name = "customerId")},
            inverseJoinColumns = {@JoinColumn(name = "itemId")}
    )
    private Set<ItemClass> customerItems = new HashSet<>();
    private long customerTotalPurchase;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private TransactionRecordClass customerTransactionRecords;

    public CustomerClass() {
    }

    public CustomerClass(int customerId, String customerName, String customerEmployeeStatus, Set<ItemClass> customerItems, long customerTotalPurchase,TransactionRecordClass customerTransactionRecords) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmployeeStatus = customerEmployeeStatus;
        this.customerItems = customerItems;
        this.customerTotalPurchase = customerTotalPurchase;
        this.customerTransactionRecords = customerTransactionRecords;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmployeeStatus() {
        return customerEmployeeStatus;
    }

    public void setCustomerEmployeeStatus(String customerEmployeeStatus) {
        this.customerEmployeeStatus = customerEmployeeStatus;
    }

    public Set<ItemClass> getCustomerItems() {
        return customerItems;
    }

    public void setCustomerItems(Set<ItemClass> customerItems) {
        this.customerItems = customerItems;
    }

    public long getCustomerTotalPurchase() {
        return customerTotalPurchase;
    }

    public void setCustomerTotalPurchase(long customerTotalPurchase) {
        this.customerTotalPurchase = customerTotalPurchase;
    }

    public TransactionRecordClass getCustomerTransactionRecords() {
        return customerTransactionRecords;
    }

    public void setCustomerTransactionRecords(TransactionRecordClass customerTransactionRecords) {
        this.customerTransactionRecords = customerTransactionRecords;
    }
}
