package za.co.carols_boutique.models;

public class StoreSale implements Comparable<Integer>{
    
    private String storeName;
    private Integer saleTotal;
    private Float target;

    public StoreSale(String storeID, Integer saleTotal) {
        this.storeName = storeID;
        this.saleTotal = saleTotal;
    }

    public StoreSale(String storeID, Integer saleTotal, Float target) {
        this.storeName = storeID;
        this.saleTotal = saleTotal;
        this.target = target;
    }

    public Float getTarget() {
        return target;
    }

    public void setTarget(Float target) {
        this.target = target;
    }

   
    public String getStoreID() {
        return storeName;
    }

    public void setStoreID(String storeID) {
        this.storeName = storeID;
    }

    public Integer getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Integer saleTotal) {
        this.saleTotal = saleTotal;
    }

    @Override
    public int compareTo(Integer salTotal) {
        return saleTotal.compareTo(getSaleTotal());
    }
    
    
}
