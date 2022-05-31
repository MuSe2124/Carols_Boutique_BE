/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.EmployeeBE.IDAOEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.carols_boutique.models.Employee;

/**
 *
 * @author HP
 */
public class DaoEmpImp implements DAOEmp {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private int RowsAffected;

    //String id, String name, String surname, Boolean isManager
    @Override
    public Boolean addEmployee(Employee employee) {
        if (con != null) {
            try {
                //con.setAutoCommit(false);
                ps = con.prepareStatement("insert into Store(id,name,surname,isManager,password) values(?,?,?,?)");
                ps.setString(0, employee.getId());
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getSurname());
                ps.setBoolean(3, employee.getIsManager());

                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();

            } finally {
                if (con != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (true) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public Employee getEmployee(String employeeID, String password) {
        if (con != null) {
            try {
                ps = con.prepareStatement("select id,name,surname,isManager,password from Employee where id = ? and password =");
                ps.setString(0, employeeID);
                ps.setString(1, password);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return new Employee(rs.getString("id"), rs.getString("name"), rs.getString("surname"), rs.getString("password"), rs.getBoolean("isManager"));
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return null;
    }

    @Override
    public Boolean promoteToManager(String employeeID) {
        if (con != null) {
            try {
                ps = con.prepareStatement("Update Employee set isManager = true where id = ?");
                ps.setString(0, employeeID);
                ps.executeQuery();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Boolean deleteEmployee(String employeeID) {
        if (con != null) {
            try {
                ps = con.prepareStatement("delete from Employee where id = ?");
                ps.setString(0, employeeID);
                ps.executeQuery();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //fix this method tomorrow
    @Override
    public Boolean updateEmployee(Employee employee) {
        if (con != null) {
            try {
                ps = con.prepareStatement("Update Employee set id =?,name =?,surname =?,isManager=?,password =? where id =?");
                ps.setString(0, employee.getId());
                ps.setString(0, employee.getName());
                ps.setString(0, employee.getSurname());
                ps.setBoolean(0, employee.getIsManager());
                ps.setString(0, employee.getPassword());
                ps.executeQuery();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
