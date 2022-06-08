/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.StoreBE.IDAOStore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.carols_boutique.models.Employee;
import za.co.carols_boutique.models.LineItem;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.Store;
import za.co.carols_boutique.properties.CarolsProperties;

/**
 *
 * @author HP
 */
public class DAOStoreImp implements DAOStore{
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private int rowsAffected;

	public DAOStoreImp() {
		Properties p = CarolsProperties.readInProperties("CarolsDatabase.properties");       
        try{//com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        //String URL = "jdbc:mysql://localhost:3306/carolsboutique";       
        try{
            con = (Connection)DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
        }catch(SQLException e){
            e.printStackTrace();
        }
	}

	//String id, String name, String location, String password
	@Override
	public Boolean addStore(Store store) {
		rowsAffected = 0;
		if (con != null) {
			try {
				//con.setAutoCommit(false);
				ps = con.prepareStatement("insert into Store(id,name,location,password) values(?,?,?,?)");
				ps.setString(1, store.getId());
				ps.setString(2, store.getName());
				ps.setString(3, store.getLocation());
				ps.setString(4, store.getPassword());
				rowsAffected = ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		if (rowsAffected != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Store getStore(String storeID, String password) {
		Store store = null;
		if (con != null) {
			try {
				ps = con.prepareStatement("Select ID,name,location,password from Store where password= ? and ID =?");
				ps.setString(1, password);
				ps.setString(2, storeID);
				rs = ps.executeQuery();
				while (rs.next()) {
					store = new Store(rs.getString("StoreID"), rs.getString("name"), rs.getString("location"), rs.getString("password"));
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
	/*@Override
    public Boolean addEmployeeToStore(Employee employee) {
        if(con!= null){
            try{
                ps = con.prepareStatement("insert into StoreEmployee(EmpId) values(?)");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }*/
	//missing class or variables?
	@Override
	public Boolean addSale(Sale sale) {
		//String id, String storeID, String employeeID, String lineItemID, String customerID, Date date
		rowsAffected = 0;
		if (con != null) {
			try {
				ps = con.prepareStatement("insert into Sale(id,storeID,employeeID,customerEmail,date) values(?,?,?,?,?)");
				ps.setString(1, sale.getId());
				ps.setString(2, sale.getStoreID().getId());
				ps.setString(3, sale.getEmployeeID().getId());
				ps.setString(4, sale.getCustomerEmail());
				ps.setDate(5, (Date) sale.getDate());
				rowsAffected = ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rowsAffected != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Boolean deleteStore(String storeID) {
		rowsAffected = 0;
		if (con != null) {
			try {
				ps = con.prepareStatement("delete from Store where id =?");
				ps.setString(1, storeID);
				rowsAffected = ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rowsAffected != 1) {
			return false;
		} else {
			return true;
		}
	}

	/*@Override
    public Boolean deleteEmployeeFromStore(String employeeID,String StoreID) {
        rowsAffected = 0; 
       if(con!=null){
           try{
           ps = con.prepareStatement("delete EmpStore where id =?");
           ps.setString(1,employeeID);
           rowsAffected =ps.executeUpdate();
           
           }catch(SQLException e){
               e.printStackTrace();
           }
       }
        if(rowsAffected!=1){
       return false;
       }else{
           return true;
       }
    }*/
	private Integer getStoresTotal(List<String> sales, String storeID) {
		Integer total = 0;
		for (String sale : sales) {
			if (con != null) {
				try {
					ps = con.prepareStatement("select total from lineitem where sale = ?");
					ps.setString(1, sale);
					rs = ps.executeQuery();
					while (rs.next()) {
						total += rs.getInt("total");
					}
				} catch (SQLException ex) {
					Logger.getLogger(DAOStoreImp.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}

		return total;
	}

	private List<String> getStoreSales(String storeID) {
		List<String> sales = new ArrayList<>();
		if (con != null) {
			try {
				ps = con.prepareStatement("Select id from sale where storeid = ?");
				ps.setString(1, storeID);
				rs = ps.executeQuery();
				while (rs.next()) {
					sales.add(rs.getString("id"));
				}
			} catch (SQLException ex) {
				Logger.getLogger(DAOStoreImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return sales;
	}

	@Override
	public Boolean updateTotal(String storeID) {

		//String id, String storeID, String employeeID, String lineItemID, String customerID, Date date
		rowsAffected = 0;
		Integer total = getStoresTotal(getStoreSales(storeID), storeID);
		if (con != null) {
			try {
				ps = con.prepareStatement("update store set total = ? where storeID = ?");
				ps.setInt(1, total);
				ps.setString(2, storeID);

				rowsAffected = ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rowsAffected != 1) {
			return false;
		} else {
			return true;
		}
	}
}