package com.criteriaApi.precticecriteriaapi.model;

import javax.persistence.*;

@Entity
public class TransactionRecordClass {
    @Id
    private long transactionId;
    @OneToOne
    @JoinColumn(name = "customerId")
    private CustomerClass customer;

    public TransactionRecordClass() {
    }

    public TransactionRecordClass(long transactionId, CustomerClass customer) {
        this.transactionId = transactionId;
        this.customer = customer;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public CustomerClass getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerClass customer) {
        this.customer = customer;
    }
}
