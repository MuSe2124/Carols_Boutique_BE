/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique.EmployeeBE.IDAOEmployee;

import za.co.carols_boutique.models.Employee;

/**
 *
 * @author muaad
 */
public interface DAOEmp {
    Boolean addEmployee(Employee employee);
    
    Employee getEmployee(String employeeID, String password);
    
    Boolean promoteToManager(String employeeID);
    
    Boolean updateEmployee(Employee employee);
    
    Boolean deleteEmployee(String employeeID);
}
