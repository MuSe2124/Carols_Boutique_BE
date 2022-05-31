/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.StoreBE.IDAOStore;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.carols_boutique.models.Employee;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.Store;

/**
 *
 * @author HP
 */
public class DAOStoreImp implements DAOStore{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs; 
    private int RowsAffected;

    public DAOStoreImp() {
        
    }
    
    
    //String id, String name, String location, String password

    @Override
    public Boolean addStore(Store store) {
        RowsAffected = 0;
        if(con!=null){
            try{
                //con.setAutoCommit(false);
                ps = con.prepareStatement("insert into Store(id,name,location,password) values(?,?,?,?)");
                ps.setString(0,store.getId() );
                ps.setString(1,store.getName() );
                ps.setString(2,store.getLocation() );
                ps.setString(3,store.getPassword() );
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
    public Store getStore(String storeID, String password) {
        Store store = null;
        if(con!=null){
            try {
                ps = con.prepareStatement("Select StoreID,name,location,password from Store where password= ? and where storeID =?");
                ps.setString(0, password);
                rs= ps.executeQuery();
                while(rs.next()){
                    store =new Store(rs.getString("StoreID"),rs.getString("name"),rs.getString("location"),rs.getString("password"));
                }
               
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return store;
    }

    /*@Override
    public Boolean DeleteStore(Integer storeID) {
        if(con!=null){
            try {
                ps = con.prepareStatement("delete from Store where id = ?");
                ps.setInt(0, storeID);
                ps.executeQuery();
                
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }*/
    //missing class or variables?
   //
    @Override
    public Boolean addEmployeeToStore(Employee employee) {
        if(con!= null){
            try{
                ps = con.prepareStatement("insert into StoreEmployee EmpId = ");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    //missing class or variables?
    @Override
    public Boolean addSale(Sale sale) {
        //String id, String storeID, String employeeID, String lineItemID, String customerID, Date date
        RowsAffected =0;
        if(con!= null){
            try{
                ps = con.prepareStatement("insert into Sale set id =?,storeID=?,employeeID=?,lineItemID=?,customerID =?,date =?");
                ps.setString(0, sale.getId());
                ps.setString(1, sale.getStoreID());
                ps.setString(2, sale.getEmployeeID());
                ps.setString(3, sale.getLineItemID());
                ps.setString(4, sale.getCustomerID());
                ps.setDate(5, (Date) sale.getDate());
                RowsAffected =ps.executeUpdate();
                
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
    public Boolean deleteStore(String storeID) {
        RowsAffected = 0; 
       if(con!=null){
           try{
           ps = con.prepareStatement("delete Store where id =?");
           ps.setString(0,storeID);
           RowsAffected =ps.executeUpdate();
           
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
    public Boolean deleteEmployeeFromStore(String employeeID) {
        RowsAffected = 0; 
       if(con!=null){
           try{
           ps = con.prepareStatement("delete Store where id =?");
           ps.setString(0,employeeID);
           RowsAffected =ps.executeUpdate();
           
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
