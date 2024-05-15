package com.criteriaApi.precticecriteriaapi.repository.customerRepository;

public class CustomerSearchProperties {
    private String customerName;
    private Integer customerLowerTotalPurchase;
    private Integer customerUpperTotalPurchase;
    private String customerEmployeeType;

    public CustomerSearchProperties(String customerName, Integer customerLowerTotalPurchase, Integer customerUpperTotalPurchase, String customerEmployeeType) {
        this.customerName = customerName;
        this.customerLowerTotalPurchase = customerLowerTotalPurchase;
        this.customerUpperTotalPurchase = customerUpperTotalPurchase;
        this.customerEmployeeType = customerEmployeeType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerLowerTotalPurchase() {
        return customerLowerTotalPurchase;
    }

    public void setCustomerLowerTotalPurchase(Integer customerLowerTotalPurchase) {
        this.customerLowerTotalPurchase = customerLowerTotalPurchase;
    }

    public Integer getCustomerUpperTotalPurchase() {
        return customerUpperTotalPurchase;
    }

    public void setCustomerUpperTotalPurchase(Integer customerUpperTotalPurchase) {
        this.customerUpperTotalPurchase = customerUpperTotalPurchase;
    }

    public String getCustomerEmployeeType() {
        return customerEmployeeType;
    }

    public void setCustomerEmployeeType(String customerEmployeeType) {
        this.customerEmployeeType = customerEmployeeType;
    }
}
