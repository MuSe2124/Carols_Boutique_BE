
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import za.co.carols_boutique.Utilities.Email;
import za.co.carols_boutique.models.CardPayment;
import za.co.carols_boutique.models.LineItem;
import za.co.carols_boutique.models.Payment;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.Stock;
import za.co.carols_boutique.properties.CarolsProperties;

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
    
    public static void main(String[] args) throws FileNotFoundException {
//        Properties p = CarolsProperties.readInProperties("CarolsDatabase.properties");   
        System.out.println(CarolsProperties.getUrl());
//        //String id, Store store, Employee employee, List<LineItem> lineItems, String customerID, Date date, Payment payment
//        /*(List<LineItem> lineitems = new ArrayList<LineItem>();
//        LineItem prelineitem=new LineItem("21","34",new Product("2","some cheese","not decent",1f),66);
//        LineItem postlineitem=new LineItem("27","32",new Product("5","juice","its bad",1f),36);
//        //String id, String saleID, Product product, Integer amounnt
//        //String id, String name, String description, Float price
//        lineitems.add(new LineItem("239","1234",new Product("23","cheese","its decent",1f),20));
//        lineitems.add(new LineItem("23","3214",new Product("33","more cheese","its also decent",1f),23));
//        Date date = new Date(System.currentTimeMillis());
//        
//        //List<LineItem> lineItems, Date date, Payment payment
//        Payment payment = new CardPayment("051902","debit");
//        Sale sale = new Sale(lineitems,date,payment);
//        Sale salerefund = new Sale(date,payment);
//        //Email email2= new Email("sendReceipt","jeanpaulalexainaude@gmail.com",sale);
//        //Email email1 = new Email("sendAmendedReceipt","jeanpaulalexainaude@gmail.com",sale,prelineitem,postlineitem);
//        ArrayList<String> emails = new ArrayList<String>();
//        emails.add("jeanpaulalexainaude@gmail.com");
//        //Email email2 = new Email("sendPromotions",emails,"324897");*/
//        ArrayList<Stock> stocks = new ArrayList<Stock>();
//        stocks.add(new Stock("243","cheese",3));
//        stocks.add(new Stock("23","another cheese",4));
//        LineItem lineitem = new LineItem("239","1234",new Product("23","cheese","its decent",1f),20);
//        Email email2 = new Email("send48hReminder","jeanpaulalexainaude@gmail.com");
//        Email email1= new Email("send24hReminder","jeanpaulalexainaude@gmail.com",lineitem);
//        
//        //Email email2 = new Email("keepAsideCreated","jeanpaulalexainaude@gmail.com",lineitem,"2wge");
//        //String productID, String productName, Integer amount
//          Date date = new Date(System.currentTimeMillis());
//          
//          Email email = new Email("newsLetterPromotion","jeanpaulalexainaude@gmail.com","t2oij",date);
    }
}
