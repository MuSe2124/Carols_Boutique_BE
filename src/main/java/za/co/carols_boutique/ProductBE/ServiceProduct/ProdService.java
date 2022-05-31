/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique.ProductBE.ServiceProduct;

import za.co.carols_boutique.models.Product;

/**
 *
 * @author muaad
 */
public interface ProdService {
    
    String getProduct(String productID);
    
    String addProductToInventory(String storeID, String productID, String employeeID, Integer amount);
    String addNewProduct(Product product);

    String removeProductFromInventory(String storeID, String productID, String employeeID, Integer amount);
    String deleteProduct(String productID);
    
}
