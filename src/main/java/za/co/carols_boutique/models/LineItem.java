/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.models;

/**
 *
 * @author muaad
 */
public class LineItem {
    
    private String id;
    private String saleID;
    private String productID;
    private Integer amounnt;

    public LineItem(String id, String saleID, String productID, Integer amounnt) {
        this.id = id;
        this.saleID = saleID;
        this.productID = productID;
        this.amounnt = amounnt;
    }

    public LineItem(String saleID, String productID, Integer amounnt) {
        this.saleID = saleID;
        this.productID = productID;
        this.amounnt = amounnt;
    }

    public LineItem() {
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getSaleID() {
        return saleID;
    }

    public void setSaleID(String saleID) {
        this.saleID = saleID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Integer getAmounnt() {
        return amounnt;
    }

    public void setAmounnt(Integer amounnt) {
        this.amounnt = amounnt;
    }

    @Override
    public String toString() {
        return "LineItem{" + "id=" + id + ", saleID=" + saleID + ", productID=" + productID + ", amounnt=" + amounnt + '}';
    }
    
    
}
