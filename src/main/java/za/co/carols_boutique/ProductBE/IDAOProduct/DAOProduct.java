package za.co.carols_boutique.ProductBE.IDAOProduct;


import za.co.carols_boutique.models.Product;

public interface DAOProduct {
    
    Product getProduct(String productID);
    
    Boolean addProductToInventory(String storeID, String productID, String employeeID, Integer amount);
    Boolean addNewProduct(Product Product);
    
    Boolean removeProductFromInventory(String storeID, String productID, String employeeID, Integer amount);
    Boolean deleteProduct(String productID);
    
}
