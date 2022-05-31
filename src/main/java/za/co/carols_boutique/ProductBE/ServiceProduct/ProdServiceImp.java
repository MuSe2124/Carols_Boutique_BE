/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.ProductBE.ServiceProduct;

import za.co.carols_boutique.ProductBE.IDAOProduct.DAOProduct;
import za.co.carols_boutique.ProductBE.IDAOProduct.DAOProductImp;
import za.co.carols_boutique.models.Product;

/**
 *
 * @author muaad
 */
public class ProdServiceImp implements ProdService {

    private DAOProduct dao;

    public ProdServiceImp() {
        dao = new DAOProductImp();
    }

    @Override
    public String getProduct(String productID) {
        Product product = dao.getProduct(productID);

        if (product != null) {
            return product.getDescription() + ": R" + product.getPrice();
        } else {
            return "Product cannot be found.";
        }
    }

    @Override
    public String addProductToInventory(String storeID, String productID, String employeeID, Integer amount) {
        Boolean b = dao.addProductToInventory(storeID, productID, employeeID, amount);
        if (b) {
            return "Product added successfully";
        } else {
            return "Failed to add product, please try again";
        }
    }

    @Override
    public String addNewProduct(Product product) {
        Boolean b = dao.addNewProduct(product);

        if (b) {
            return "New product added successfully.";
        } else {
            return "Failed to add new product, please try again.";
        }
    }

    @Override
    public String removeProductFromInventory(String storeID, String productID, String employeeID, Integer amount) {
        Boolean b = dao.removeProductFromInventory(storeID, productID, employeeID, amount);

        if (b) {
            return "Product removed successfully";
        } else {
            return "Failed to remove product, please try again.";
        }
    }

    @Override
    public String deleteProduct(String productID) {
        Boolean b = dao.deleteProduct(productID);

        if (b) {
            return "Product removed successfully";
        } else {
            return "Failed to remove product, please try again.";
        }
    }

}
