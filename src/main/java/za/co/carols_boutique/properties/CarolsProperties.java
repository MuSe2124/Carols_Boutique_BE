package za.co.carols_boutique.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import za.co.carols_boutique.EmployeeBE.IDAOEmployee.DaoEmpImp;
import za.co.carols_boutique.models.Employee;

public class CarolsProperties {
    private static File file;
    private static File file2;
    private static File file3;
    private static Properties p;

    public CarolsProperties() throws FileNotFoundException {
        file = new File("CarolsDatabase.properties");
        file2 = new File("CarolsPaths.properties");
        file3 = new File("CarolsEndpoints.properties");
        p = new Properties();
    }
    
    public static void main(String[] args) {
        
    }
    
    public static void database() throws FileNotFoundException, IOException{
        
        OutputStream os = new FileOutputStream(file);
        
        p.setProperty("url", "localhost:3306/carolsboutique");
        p.setProperty("username", "root");
        p.setProperty("password", "root");
        
        p.store(os, "Database");
    }
    
    public static void paths() throws FileNotFoundException, IOException{
        
        OutputStream os = new FileOutputStream(file2);
        
        p.setProperty("EmpPath", "/employee");
        p.setProperty("ProdPath", "/product");
        p.setProperty("RepPath", "/report");
        p.setProperty("StorePath", "/store");
        
        p.store(os, "Paths");
    }
    
    public static void endpoints() throws FileNotFoundException{
    
        OutputStream os = new FileOutputStream(file3);
        
        //p.setProperty("EmpEndpoints", "")
    }
}
