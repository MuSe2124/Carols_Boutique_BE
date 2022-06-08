
import java.util.ArrayList;
import java.util.Properties;
import za.co.carols_boutique.Utilities.Email;
import za.co.carols_boutique.models.Stock;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jomar
 */
public class Test {
//    public static void main(String[] args) {
//        ArrayList<Stock> stock= new ArrayList<Stock>();
//        stock.add(new Stock("prod1","Belt",3));
//        stock.add(new Stock("prod2","Scarf",4));
//        stock.add(new Stock("prod3","Hat",1));
//        
//        Email email8 = new Email("lowStockReminder","jeanpaulalexainaude@gmail.com",stock); 
//        
//    }
    
    public static void main(String[] args) {
        Properties p = new Properties();
        System.out.println(p.get("url"));
    }
}
