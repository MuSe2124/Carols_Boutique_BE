package za.co.carols_boutique.ProductBE.IDAOProduct;


import java.util.Date;
import java.util.List;
import za.co.carols_boutique.models.ProdStore;
import za.co.carols_boutique.models.Product;

public interface DAOProduct {
    
    Product getProduct(String productID);
    //this is an update for adding in an amount, has addTransaction
    Boolean addProductToInventory(String storeID, String productID, String employeeID, Integer amount,Integer Size,String TransactionID);
    Boolean addNewProduct(Product product,String catid,String categoryproduct);
    //String id, String storeID, String productID, Integer amount,Integer Size
    //this is an insert
    Boolean CreateProductInInventory(String id,String storeId,String ProductID,Integer amount,Integer Size);
    //this is a delete
    Boolean deleteProductInInventory(String StoreId,String ProductID);
    //this is an update for subtracting an amount, has addTransaction
    Boolean removeProductFromInventory(String storeID, String productID, String employeeID, Integer amount,Integer Size,String TransactionID);
    
    Boolean deleteProduct(String productID,String catid);
    Boolean addCatagory(String catID,String name,String description); 
    Boolean deleteCategory(String CategoryID);
    
        
    
}
