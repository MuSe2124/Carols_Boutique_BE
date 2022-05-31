/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.StoreBE.ServiceStore;

import za.co.carols_boutique.StoreBE.IDAOStore.DAOStore;
import za.co.carols_boutique.StoreBE.IDAOStore.DAOStoreImp;
import za.co.carols_boutique.models.Employee;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.Store;

/**
 *
 * @author muaad
 */
public class StoreServiceImp implements StoreService{
    
    private DAOStore dao;

    public StoreServiceImp() {
        dao = new DAOStoreImp();
    }
           
    @Override
    public String loginStore(String storeID, String password) {
        Store store = dao.getStore(storeID, password);
        
        if (store != null) {
            return store.getName() + " had been logged in successfully.";
        }else{
            return "Failed to login, store ID or password incorrect. Please try again.";
        }
    }

    @Override
    public String registerStore(Store store) {
        Boolean b = dao.addStore(store);
        
        if (b) {
            return "Store registered successfully.";
        }else{
            return "Failed to register store, please try again.";
        }
    }

    @Override
    public String addEmployeeToStore(Employee employee) {
        Boolean b = dao.addEmployeeToStore(employee);
        
        if (b) {
            return "Employee added to store successfully.";
        }else{
            return "Failed to add employee to store, please try again.";
        }
    }

    @Override
    public String addSale(Sale sale) {
        Boolean b = dao.addSale(sale);
        
        if (b) {
            return "Sale added successfully.";
        }else{
            return "Failed to add sale, please try again.";
        }
    }

    @Override
    public String deleteStore(String storeID) {
        Boolean b = dao.deleteStore(storeID);
        
        if (b) {
            return "Store deleted successfully.";
        }else{
            return "Failed to delete store, please try again.";
        }
    }

    @Override
    public String deleteEmployeeFromStore(String employeeID) {
        Boolean b = dao.deleteEmployeeFromStore(employeeID);
        
        if (b) {
            return "Employee deleted from store successfully.";
        }else{
            return "Failed to delete employee from store, please try again.";
        }
    }
    
}
