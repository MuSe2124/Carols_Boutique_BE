/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.Utilities;

import java.util.ArrayList;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import za.co.carols_boutique.models.LineItem;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.Stock;
/**
 *
 * @author Jomar
 */

// Keep aside initialized
// Low stock

public class Email extends Thread{
    
    Session newSession = null;
    MimeMessage mimeMessage = null;
    String recipient;
    String action;
    ArrayList<String>recipients;
    Sale sale;
    String productname;
    LineItem preLineItem;
    LineItem postLineItem;
    ArrayList<Stock> products;

    public Email(String action, String recipient){
        this.action = action;
        this.recipient = recipient;
        this.start();
    }
    public Email(String action, String recipient,LineItem lineitem,String productname){
        this.action = action;
        this.recipient = recipient;
        this.preLineItem=lineitem;
        this.productname= productname;
        this.start();
    }
    
    public Email(String action, ArrayList<String> recipients){
        this.action = action;
        this.recipients = recipients;
        this.start();
    }
    
    public Email(String action, String recipient, Sale sale){
        this.action = action;
        this.recipient = recipient;
        this.sale = sale;
        this.start();
    }
    
    public Email(String action, String recipient, LineItem preLineItem){
        this.action = action;
        this.recipient = recipient;
        this.preLineItem = preLineItem;
        this.start();
    }
    
    public Email(String action, String recipient, Sale sale, LineItem preLineItem){
        this.action = action;
        this.recipient = recipient;
        this.sale = sale;
        this.preLineItem = preLineItem;
        this.start();
    }
    
    public Email(String action, String recipient, Sale sale, LineItem preLineItem, LineItem postLineItem){
        this.action = action;
        this.recipient = recipient;
        this.sale = sale;
        this.preLineItem = preLineItem;
        this.postLineItem = postLineItem;
        this.start();
    }
    
    public Email(String action, String recipient, ArrayList<Stock> products){
        this.action = action;
        this.recipient = recipient;
        this.products = products;
        this.start();
    }
    
    
    @Override
    public void run(){
        
        switch(action){
            
            case "sendPromotions":
                try {
                    setupServerProperties();
                    sendPromotions(recipients);
                    sendEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }   
                break;
                
            case "sendReceipt":
                try {
                    setupServerProperties();
                    sendReceipt(recipient, sale);
                    sendEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }   
                break;
                
            case "sendAmendedReceipt":
                try {
                    setupServerProperties();
                    sendAmendedReceipt(recipient, sale, preLineItem, postLineItem);
                    sendEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }   
                break;
                
            case "sendRefund":
                try {
                    setupServerProperties();
                    sendRefund(recipient,sale,preLineItem);
                    sendEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }   
                break;
                
            case "send24hReminder":
                try {
                    setupServerProperties();
                    send24hReminder(recipient, preLineItem);
                    sendEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }   
                break;
                
            case "send36hReminder":
                try {
                    setupServerProperties();
                    send36hReminder(recipient, preLineItem);
                    sendEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }   
                break;
                
            case "send48hReminder":
                try {
                    setupServerProperties();
                    send48hReminder(recipient, preLineItem);
                    sendEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }   
                break;
                
            case "keepAsideCreated":
                try {
                    setupServerProperties();
                    keepAsideCreated(recipient, preLineItem,productname);
                    sendEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }   
                break;
                
            case "lowStockReminder":
                try {
                    setupServerProperties();
                    lowStockReminder(recipient, products);
                    sendEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }   
                break;
        }
        
    }
    

    public void setupServerProperties(){
        String host = "smtp.gmail.com";
        final String username = "carols.boutique.domain@gmail.com";
        //Enter your Gmail password
        final String password = "qfdqfmqeznacwbzl";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.ssl.trust", host);

        newSession = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

    }
    
    public void sendEmail() throws MessagingException {
        String fromUser = "jomarvn@gmail.com";
        String userPassword = "J0hannes";
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost,fromUser,userPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully");
    }
    
    

    public MimeMessage sendPromotions(ArrayList<String> emailRecipients) throws MessagingException {
        
        mimeMessage = new MimeMessage(newSession);
        for (int i = 0; i < emailRecipients.size(); i++) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipients.get(i)));
        }
        mimeMessage.setSubject("Carol's Boutique promotion");
        String body = promoString();
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    public MimeMessage sendReceipt(String recipient, Sale sale) throws AddressException, MessagingException{

        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        String body = receiptString(new Sale("Sandton","Osman","Line3","Jean-Paul",new Date()));
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    public MimeMessage sendAmendedReceipt(String recipient, Sale sale, LineItem pre, LineItem post) throws AddressException, MessagingException{
        String emailSubject = "Test Email";
        String emailBody = "This is a test email from Carol's Boutique. Please let me know when you get this\n-@ jomarvn@gmail.com";
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        mimeMessage.setSubject(emailSubject);

        String body = amendedReceiptString(new Sale("Sandton","Osman","Line3","Jean-Paul",new Date()));
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    public MimeMessage sendRefund(String recipient, Sale sale, LineItem lineItem) throws AddressException, MessagingException{
        String emailSubject = "Test Email";
        String emailBody = "This is a test email from Carol's Boutique. Please let me know when you get this\n-@ jomarvn@gmail.com";
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        mimeMessage.setSubject(emailSubject);

        String body = refundString(sale, lineItem);
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    public MimeMessage send24hReminder(String recipient, LineItem lineItem) throws MessagingException {
        
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        String body = reminder24hString(lineItem);
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    public MimeMessage send36hReminder(String recipient, LineItem lineItem) throws MessagingException {
        
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        String body = reminder36hString(lineItem);
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    public MimeMessage send48hReminder(String recipient, LineItem lineItem) throws MessagingException {
   
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        String body = reminder48hString(lineItem);
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    

    
    public MimeMessage keepAsideCreated(String recipient, LineItem lineItem,String prodname) throws MessagingException {
   
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        String body = keepAside(lineItem,prodname);
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    public MimeMessage lowStockReminder(String recipient, ArrayList<Stock> products) throws MessagingException {
   
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        String body = lowStockString(products);
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    private String receiptString(Sale sale){
        Integer total = 0;
        String s = "<!DOCTYPE html>\n" +
"<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>receipt</title>\n" +
"</head>\n" +
"<body style=\"background-Image:url(https://lh3.googleusercontent.com/pw/AM-JKLX9gUfGn2zYC3X-UBvRmfukVm_wdTvPHaojWfE0ZDnopA38hHjB7Q5q21Sed48AmSt8W2-SFKERtlGfpDkXe-8BymJNSGEH9JVTJuHeuFyBWCBm2NhI-7Uu3W3azJLSJyZpF2MhXCffoM_G7-8IqkA=w465-h657-no?authuser=0);\" >\n" +
"\n" +
"<h1><br><br>Carol's Boutique</h1>\n" +
"<h3>Receipt of purchase on: ??Date??</h3>\n" +
"\n" +
"<table style=\"width:400px\">\n" +
"  <tr>\n" +
"    <th style = \"background-color:blue;\">NO:</th>\n" +
"    <th style =\"width:50%;background-color:lightblue\">Item</th>\n" +
"    <th style =\"background-color:lightblue;\">Qty</th>\n" +
"    <th style =\"background-color:blue;\">Amount</th> \n" +
"    \n" +
"  </tr>\n" +
"\n" +
"\n" +
"  <tr style=\"background-color:lightgrey\">\n" +
"    <td>01</td>\n" +
"    <td>shirt</td>\n" +
"    <td>12</td>\n" +
"    <td>1$</td>\n" +
"    \n" +
"    \n" +
"  </tr>\n" +
"  <tr style=\"background-color:rgb(166, 166, 166)\">\n" +
"    <td>02</td>\n" +
"    <td>pants</td>\n" +
"    <td>23</td>\n" +
"    <td>2$</td>\n" +
"  </tr>\n" +
"  <tr style = \"background-color:lightgrey; height: 18px;\">\n" +
"  <td></td>\n" +
"  <td></td>\n" +
"  <td></td>\n" +
"  <td></td>\n" +
"  </tr>\n" +
"</table>\n" +
"<br>\n" +
"<table style=\"width:400px\">\n" +
"  <tr style=\"text-align:left\">\n" +
"    <th >Payment Info</th>\n" +
"    <th ></th>\n" +
"    <th></th>\n" +
"    <th ></th> \n" +
"    \n" +
"  </tr>\n" +
"\n" +
"\n" +
"  <tr>\n" +
"    <td>Cash/Card</td>\n" +
"    <td>?cash/card?</td>\n" +
"    <td>SubTotal:</td>\n" +
"    <td>?subTotal?</td>\n" +
"    \n" +
"    \n" +
"  </tr>\n" +
"  <tr >\n" +
"    <td>Number:</td>\n" +
"    <td>?Number?</td>\n" +
"    <td>Tax</td>\n" +
"    <td>?tax?</td>\n" +
"  </tr>\n" +
"  <tr>\n" +
"  <td>Account type:</td>\n" +
"  <td>?Account type?</td>\n" +
"  <td>Total</td>\n" +
"  <td>?total?</td>\n" +
"  </tr>\n" +
"</table>\n" +
"<h4><u><b>Return policy</b></u></h4>\n" +
"<h5>You can return any product within 10 days of purchase.</h5>\n" +
"<h6><u>Please rate our service:?Link?</u></h6>\n" +
"</body>\n" +
"</html>"
                ;
        return s;
    }
    
    
    private String amendedReceiptString(Sale sale){
        String s = "<h1>Carols Boutique</h1>"+
                "<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>Page Title</title>\n" +
"</head>\n" +
"<body>\n" +
"<h1><br><br>Carol's Boutique</h1>\n" +
"<h3>Receipt of purchase on: ??Date??</h3>\n" +
"\n" +
"<table style=\"width:400px\">\n" +
"  <tr>\n" +
"    <th style = \"background-color:blue;\">NO:</th>\n" +
"    \n" +
"    <th style =\"width:50%;background-color:lightblue\">Item</th>\n" +
"    <th style =\"background-color:lightblue;\">Qty</th>\n" +
"    <th style =\"background-color:blue;\">Amount</th> \n" +
"    \n" +
"    \n" +
"    \n" +
"  </tr>\n" +
"\n" +
"\n" +
"  <tr style=\"background-color:lightgrey\">\n" +
"    <td>01</td>\n" +
"    <td>shirt</td>\n" +
"    <td>12</td>\n" +
"    <td>1$</td>\n" +
"    \n" +
"    \n" +
"  </tr>\n" +
"  <tr style=\"background-color:rgb(166, 166, 166)\">\n" +
"    <td>02</td>\n" +
"    <td>pants</td>\n" +
"    <td>23</td>\n" +
"    <td>2$</td>\n" +
"  </tr>\n" +
"  <tr style=\"background-color:rgb(255, 77, 77);\">\n" +
"  <td>03</td>\n" +
"  <td style=\"background-color:rgb(255, 77, 77);\">-gloves</td>\n" +
"  <td>2</td>\n" +
"  <td>2$</td>\n" +
"  </tr>\n" +
"  <tr style=\"background-color:lightgreen\">\n" +
"  <td>04</td>\n" +
"  <td style=\"background-color:lightgreen;\">+gloves</td>\n" +
"  <td>20</td>\n" +
"  <td>$30</td>\n" +
"  </tr>\n" +
"  <tr style = \"background-color:lightgrey; height: 18px;\">\n" +
"  <td></td>\n" +
"  <td></td>\n" +
"  <td></td>\n" +
"  <td></td>\n" +
"  </tr>\n" +
"</table>\n" +
"<br>\n" +
"<table style=\"width:400px\">\n" +
"  <tr style=\"text-align:left\">\n" +
"    <th >Payment Info</th>\n" +
"    <th ></th>\n" +
"    <th></th>\n" +
"    <th ></th> \n" +
"    \n" +
"  </tr>\n" +
"\n" +
"\n" +
"  <tr>\n" +
"    <td>Cash/Card</td>\n" +
"    <td>??Cash/Card??</td>\n" +
"    <td>SubTotal:</td>\n" +
"    <td>??subTotal??</td>\n" +
"    \n" +
"    \n" +
"  </tr>\n" +
"  <tr >\n" +
"    <td>Number:</td>\n" +
"    <td>??Number??</td>\n" +
"    <td>Tax</td>\n" +
"    <td>??tax??</td>\n" +
"  </tr>\n" +
"  <tr>\n" +
"  <td>Account type:</td>\n" +
"  <td>??Account type??</td>\n" +
"  <td>Total</td>\n" +
"  <td>??total??</td>\n" +
"  </tr>\n" +
"</table>\n" +
"<h4><u><b>Return policy</b></u></h4>\n" +
"<h5>You can return any product within 10 days of purchase.</h5>\n" +
"<h6 Style = \"font-size:15px\"><u>Please rate our service:??link??</u></h6>\n" +
"</body>\n" +
"</html>"
                ;
        return s;
    }
    
    private String refundString(Sale sale, LineItem lineItem){
        String s ="<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>Page Title</title>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<h1 style =\"font-size:40px;\">Carols Boutique</h1>\n" +
"<h2>Your refund has been processed.<br><br>??account?? has been refunded on this ??date??.</h3>\n" +
"\n" +
"\n" +
"</body>\n" +
"</html>";
        return s;
    }
    
    private String promoString(){
        return "<html>\n" +
"<head>\n" +
"<title>Page Title</title>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<h1><u>Carol's Boutique</u></h1>\n" +
"<p1>At carol's Boutique we have great deals</p1><br>\n" +
"\n" +
"<p2>Save 20% off on your next purchase with this Promocode<br><p2><br>\n" +
"<table style=\"font-size:20px\">\n" +
"<tr>\n" +
"<th>PromoCode:</th>\n" +
"<th Style =\"border-style:solid;border-width:6px;border-color:black;\">??PromoCode??</th>\n" +
"</tr>\n" +
"</table>\n" +
"</body>\n" +
"</html>";
    }
    
    private String reminder24hString(LineItem lineItem){
        return "<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>remind me</title>\n" +
"</head>\n" +
"<body>\n" +
"<h1>Carol's Boutique</h1>\n" +
"<p1>Dear valued customer</p1><br><br>\n" +
"<p2>You have ??amount?? of ??product?? waiting for you at our store.<br>Please pick it up within 24 hours before it gets removed from keep aside.<br></p2>\n" +
"\n" +
"</body>\n" +
"</html>";
    }
    
    private String reminder36hString(LineItem lineItem){
        return "<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>remind me</title>\n" +
"</head>\n" +
"<body>\n" +
"<h1>Carol's Boutique</h1>\n" +
"<p1>Dear valued customer</p1><br><br>\n" +
"<p2>You have ??amount?? of ??product?? waiting for you at our store.<br>Please pick it up within 12 hours before it gets removed from keep aside.<br></p2>\n" +
"\n" +
"</body>\n" +
"</html>";
    }
    
    private String reminder48hString(LineItem lineItem){
        return "<html>\n" +
"<head>\n" +
"<title>latereminder</title>\n" +
"</head>\n" +
"<body>\n" +
"<h1>Carol's Boutique</h1>\n" +
"<p1>Dear valued customer<br><br></p1>\n" +
"<p2>24 hours has passed, your product has been placed back on the rack. If you are still in interested in this product, please visit any of our stores.<p2>\n" +
"</body>\n" +
"</html>";
    }
    
    private String keepAside(LineItem lineItem,String prodname){
        String s ="<html>\n" +
"<head>\n" +
"<title>Page Title</title>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<h1>Carol's Boutique</h1>\n" +
"\n" +
"<p>Dear valued customer<br><br>??Number?? of ??Product?? has been kept-aside for your retrieval.<br>Please fetch it within 48 hours at our store before the product will be placed back on the rack.</p>\n" +
"\n" +
"<h2>This is your id.</h2>\n" +
"<h3 style=\"border-width:1px;border-style:solid;width: 200px;border-width:3px\">??ID??<h3>\n" +
"<p>Please do not lose it as it is needed for retreival of the product.<p>\n" +
"\n" +
"</body>\n" +
"</html>";
        s=s.replace("??Number??",""+ lineItem.getAmounnt());
        s=s.replace("??Product??", prodname);
        return s;
    }
    
    private String lowStockString(ArrayList<Stock> stocks){
        String table= "";
        for(Stock stock:stocks){
            table=table+"<tr>"+
            "<td>"+stock.getProductID()+"</td>"+
            "<td>"+stock.getProductName()+"</td>"+
            "<td>"+stock.getAmount()+"</td>"+"</tr>";
        }
        String s ="<html>\n" +
"<head>\n" +
"<title>remind me</title>\n" +
"</head>\n" +
"<body>\n" +
"<h1>Carol's Boutique<h1>\n" +
"<p style=\"font-size:20px;\">Dear store manager:</p>\n" +
"<p style=\"font-size:20px;\">The following products are running low.</p>\n" +
"<table style =\"width:300px;text-align:center;font-size:20px;background-color:lightblue;\">\n" +
"<tr>\n" +
"<th>ID</th>\n" +
"<th><u>product:<u></th>\n" +
"<th><u>amount:<u></th>\n" +
"</tr>\n"+table+
"</table>\n" +
"</body>\n" +
"</html>";
        return s;
    }

}
