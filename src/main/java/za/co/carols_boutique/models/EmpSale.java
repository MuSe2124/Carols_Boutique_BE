/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.models;

/**
 *
 * @author muaad
 */
public class EmpSale {

    private String employeeID;
    private Integer saleTotal;
    private String storeID;

    public EmpSale(String employeeID, Integer saleTotal, String storeID) {
        this.employeeID = employeeID;
        this.saleTotal = saleTotal;
        this.storeID = storeID;
    }

    public EmpSale(Integer saleTotal, String storeID) {
        this.saleTotal = saleTotal;
        this.storeID = storeID;
    }

    public EmpSale() {
    }
    
    

    public String getEmployee() {
        return employeeID;
    }

    public void setEmployee(String employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Integer saleTotal) {
        this.saleTotal = saleTotal;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }
       
}
