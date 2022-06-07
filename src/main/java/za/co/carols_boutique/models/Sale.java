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
public class Sale {
    
    private String id;
    private String storeID;
    private String employeeID;
    private String lineItemID;
    private String customerID;
    private Date date;

    public Sale(String id, String storeID, String employeeID, String lineItemID, String customerID, Date date) {
        this.id = id;
        this.storeID = storeID;
        this.employeeID = employeeID;
        this.lineItemID = lineItemID;
        this.customerID = customerID;
        this.date = date;
    }

    public Sale(String storeID, String employeeID, String lineItemID, String customerID, Date date) {
        this.storeID = storeID;
        this.employeeID = employeeID;
        this.lineItemID = lineItemID;
        this.customerID = customerID;
        this.date = date;
    }

    public Sale(String storeID, String lineItemID) {
        this.storeID = storeID;
        this.lineItemID = lineItemID;
    }

    public Sale() {
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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(String lineItemID) {
        this.lineItemID = lineItemID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void addLineItem(LineItem lineItem){}
    
    public Float calculateTotal(){
    return null;
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", storeID=" + storeID + ", employeeID=" + employeeID + ", lineItemID=" + lineItemID + ", customerID=" + customerID + ", date=" + date + '}';
    }
    
    
}
