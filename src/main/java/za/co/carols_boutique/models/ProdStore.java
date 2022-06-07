package za.co.carols_boutique.models;

public class ProdStore implements Comparable<Object>{
   
    private String id;
    private String storeID;
    private String productID;
    private Integer amount;
    private Integer size;

    public ProdStore(String id, String storeID, String productID, Integer amount,Integer size) {
        this.id = id;
        this.storeID = storeID;
        this.productID = productID;
        this.amount = amount;
    }

    public ProdStore(String storeID, String productID, Integer amount) {
        this.storeID = storeID;
        this.productID = productID;
        this.amount = amount;
    }

    public ProdStore() {
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

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProdStore{" + "id=" + id + ", storeID=" + storeID + ", productID=" + productID + ", amount=" + amount + '}';
    }

    @Override
    public int compareTo(Object arg0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
