/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.ProductBE.IDAOProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.Report;

/**
 *
 * @author HP
 */
public class DAOProductImp implements DAOProduct{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int RowsAffected; 
//String id, String name, String description, Float price
    @Override
    public Product getProduct(String productID) {
       Product product = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("Select id,name,description,price from Product where id = ?");
                ps.setString(0, productID);
                rs=ps.executeQuery();
                while(rs.next()){
                    product= new Product(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getFloat("price"));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public Boolean addProductToInventory(String storeID, String productID, String employeeID, Integer amount) {
        RowsAffected=0;
        if(con!=null){
            try{
                //do i have to include id
                //String id, String storeID, String productID, Integer amount
                ps = con.prepareStatement("insert into ProdStore(storeID,productID,employeeID,amount) values(?)");
                ps.setString(0, storeID);
                ps.setString(1, productID);
                ps.setString(2, employeeID);
                ps.setInt(3, amount);
                RowsAffected=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(RowsAffected==0){
            return false;
        }else{
        return true;
        }
    }
    //String id, String name, String description, Float price

    @Override
    public Boolean addNewProduct(Product Product) {
       RowsAffected=0;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                RowsAffected=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(RowsAffected==0){
            return false;
        }else{
        return true;
        }
    }

    @Override
    public Boolean removeProductFromInventory(String storeID, String productID, String employeeID, Integer amount) {
        RowsAffected=0;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                RowsAffected=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(RowsAffected==0){
            return false;
        }else{
        return true;
        }
    }

    @Override
    public Boolean deleteProduct(String productID) {
        RowsAffected=0;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                RowsAffected=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(RowsAffected==0){
            return false;
        }else{
        return true;
        }
    }
    
}
