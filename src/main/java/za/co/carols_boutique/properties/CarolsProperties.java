/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.properties;

import java.util.Properties;
import za.co.carols_boutique.EmployeeBE.IDAOEmployee.DaoEmpImp;
import za.co.carols_boutique.models.Employee;

/**
 *
 * @author muaad
 */
public class CarolsProperties {
    private Properties carol_boutique_properties;
    
    public static void main(String[] args) {
        DaoEmpImp imp = new DaoEmpImp();
        Employee emp = imp.getEmployee("emp101", "1", "1");
        
        System.out.println(emp.toString());
    }
    
    public void addToFile(String key, String value){
        carol_boutique_properties.setProperty(key, value);
    }
    
    public void deleteFromFile(String key){
        carol_boutique_properties.remove(key);
    }
    
    public void updateFile(String key, String oldObject, String newObject){
        carol_boutique_properties.replace(key, oldObject, newObject);
    }
    
    public String getSQLUrl(){
        String key = "sqlurl";
        return carol_boutique_properties.get(key).toString();
    }
    
    public String getRestUrl(){
        String key = "resturl";
        return carol_boutique_properties.get(key).toString();
    }
}
