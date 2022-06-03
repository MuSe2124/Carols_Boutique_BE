/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique.ProductBE.ServiceProduct;

import za.co.carols_boutique.models.Exchange;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.Refund;

/**
 *
 * @author muaad
 */
public interface ProdService {
    
    Product getProduct(String productID);
    
    String addProductToInventory(String storeID, String productID, String employeeID, Integer amount);
    String addNewProduct(Product product);

    String removeProductFromInventory(String storeID, String productID, String employeeID, Integer amount);
    String deleteProduct(String productID);

    String refund(Refund refund);
    String exchange(Exchange exchange);
    
}
