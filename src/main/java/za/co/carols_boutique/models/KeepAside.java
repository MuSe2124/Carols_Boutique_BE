/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.models;

import java.util.Date;

/**
 *
 * @author muaad
 */
public class KeepAside {
    private String id;
    private String storeID;
    private Date date;
    private Integer customerID;
    private String productID;

    public KeepAside(String id, String storeID, Date date, Integer customerID, String productID) {
        this.id = id;
        this.storeID = storeID;
        this.date = date;
        this.customerID = customerID;
        this.productID = productID;
    }

    public KeepAside(String storeID, Date date, Integer customerID, String productID) {
        this.storeID = storeID;
        this.date = date;
        this.customerID = customerID;
        this.productID = productID;
    }

    public KeepAside() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    public void sendReminder24H(){}
    
    public void sendReminder36H(){}
    
    public void removeItem(){}
    
    public void addItem(){}
    
    public void has24HPassed(){}
    
    public void has36HPassed(){}
    
    public void has48HPassed(){}

    @Override
    public String toString() {
        return "KeepAside{" + "id=" + id + ", storeID=" + storeID + ", date=" + date + ", customerID=" + customerID + ", productID=" + productID + '}';
    }
    
    
    
}
