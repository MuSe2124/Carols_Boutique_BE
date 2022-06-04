/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.models;

/**
 *
 * @author Jomar
 */
public class Stock {
    
    private String storeID;
    private String productID;
    private String employeeID;
    private Integer amount;

    public Stock() {
    }

    public Stock(String storeID, String productID, String employeeID, Integer amount) {
        this.storeID = storeID;
        this.productID = productID;
        this.employeeID = employeeID;
        this.amount = amount;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    
}
