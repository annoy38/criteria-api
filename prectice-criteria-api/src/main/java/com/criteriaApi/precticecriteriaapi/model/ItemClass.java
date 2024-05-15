package com.criteriaApi.precticecriteriaapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ItemClass implements Serializable {
    @Id
    private int itemId;
    private String itemName;
    private String itemDescription;
    private int itemQuantity;
    private int itemPrice;
    @ManyToMany(mappedBy = "customerItems")
    private Set<CustomerClass> customers = new HashSet<>();

    public ItemClass(){}

    public ItemClass(int itemId, String itemName, String itemDescription, int itemQuantity, int itemPrice, Set<CustomerClass> customers) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.customers = customers;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Set<CustomerClass> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomerClass> customers) {
        this.customers = customers;
    }
}
