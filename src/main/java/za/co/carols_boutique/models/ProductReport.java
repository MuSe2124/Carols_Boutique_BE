/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.models;

/**
 *
 * @author muaad
 */
public class ProductReport {
    
    private String productID;
    private String employeeID;
    private String amountsSold;

    public ProductReport(String productID, String employeeID, String amountsSold) {
        this.productID = productID;
        this.employeeID = employeeID;
        this.amountsSold = amountsSold;
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

    public String getAmountsSold() {
        return amountsSold;
    }

    public void setAmountsSold(String amountsSold) {
        this.amountsSold = amountsSold;
    }
    
    
}
