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
    LineItem preLineItem;
    LineItem postLineItem;
    ArrayList<Product> products;

    public Email(String action, String recipient){
        this.action = action;
        this.recipient = recipient;
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
    
    public Email(String action, String recipient, ArrayList<Product> products){
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
                    keepAsideCreated(recipient, preLineItem);
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
    
    public MimeMessage keepAsideCreated(String recipient, LineItem lineItem) throws MessagingException {
   
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        String body = keepAside(lineItem);
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    public MimeMessage lowStockReminder(String recipient, ArrayList<Product> products) throws MessagingException {
   
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        String body = lowStockString(products);
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
    }
    
    
    private String receiptString(Sale sale){
        String s = "<!DOCTYPE html>"+
"<html>"+
"<head>"+
"<title>Page Title</title>"+
"<style>"+
"html,body{"+
"background-Image:url(https://lh3.googleusercontent.com/pw/AM-JKLX9gUfGn2zYC3X-UBvRmfukVm_wdTvPHaojWfE0ZDnopA38hHjB7Q5q21Sed48AmSt8W2-SFKERtlGfpDkXe-8BymJNSGEH9JVTJuHeuFyBWCBm2NhI-7Uu3W3azJLSJyZpF2MhXCffoM_G7-8IqkA=w465-h657-no?authuser=0);"+
"}"+
"table{"+
"overflow-y:auto;"+
"height:10px;"+

"position:fixed;"+
"top:120px;"+
"left:20px;"+
"border:1px solid white; "+
"border-collapse: collapse;"+
"}"+
"th {"+
  "border:5px solid white;"+
 " background-color:lightblue;"+
  "border:1px solid white;"+
  "border-collapse: collapse;"+
"}"+
"tr{"+
 "border-bottom:1px solid white;"+
 "text-align:center;"+
"}"+
"td1{"+
 " background-color:lightgrey;"+
 " border:1px solid white;"+
  "border-collapse: collapse;"+
"}"+
"td2{"+
"background-color:grey;"+
 " border:1px solid white;"+
 " border-collapse: collapse;"+
"}"+

"h1{"+

"position: fixed;"+
  "left: 20px;"+
  "top:20px;"+
 " font-size:30px;"+
"}"+
"body{"+
"background-color:white;"+
"}"+
"label8{"+
  
 " position: fixed;"+
  "left: 20px;"+
  "top:90px;"+
  "font-size:30px;"+
  "font-size:13px;"+
"}"+



"label1{"+
"font-size:20px;"+
"position: fixed;"+
"top: 300px;"+
"left: 25px;"+
"}"+

"label2"+
"font-size:15px;"+

"position:fixed;"+
"top: 300px;"+
"left: 25px;"+
"}"+
"label3{"+
"font-size:15px;"+
"position:fixed;"+
"top:340px;"+
"left:25px"+
"}"+

"label4{"+
"font-size:15px;"+
"position:fixed;"+
"top: 380px;"+
"left: 25px;"+
"}"+
"labelpay{"+
"font-size:20px;"+
"position:fixed;"+
"top: 260px;"+
"left: 20px;"+
"}"+
"label5{"+
"font-size:15px;"+
"position:fixed;"+
"top: 300px;"+
"left: 300px;"+
"}"+
"label6{"+
"font-size:15px;"+
"position:fixed;"+
"top: 340px;"+
"left: 300px;"+
"}"+
"div1{"+
"BackGround-color:DarkBlue;"+
"position:fixed;"+
"top: 372px;"+
"left: 290px;"+
"height:30px;"+
"width:70px;"+
"}"+
"div2{"+
"background-color:lightblue;"+
"}"+
"label7{"+

"color:white;"+
"font-size:15px;"+
"position:fixed;"+
"top: 380px;"+
"left: 300px;"+
"}"+
"label9{"+
"font-size:20px;"+
"position:fixed;"+
"top: 430px;"+
"left: 25px;   "+
"}"+
"p1{"+
"font-size:13px;"+
"position:fixed;"+
"top: 460px;"+
"left: 25px;"+
"}"+
"p2{"+
"font-size:16px;"+
"position:fixed;"+
"top:480px;"+
"left: 25px;"+
"}"+



"</style>"+
"</head>"+
"<body>"+
"<h1>Carol's Boutique</h1>"+
"<label8>Receipt of purchase on:</label8>"+

"<table style=\"overflow-x:auto;\" >"+
  "<tr>"+
    "<th style = 'background-color:blue;'>NO:</th>"+
    "<th style ='width:50%;'>Item</th>"+
    "<th>Qty</th>"+
    "<th style ='background-color:blue;'>Amount</th>"+ 
    
  "</tr>"+


  "<tr style='background-color:lightgrey'>"+
    "<td>01</td>"+
    "<td>shirt</td>"+
    "<td>12</td>"+
    "<td>1$</td>"+
    
    
  "</tr>"+
  "<tr style='background-color:rgb(166, 166, 166)'>"+
    "<td>02</td>"+
    "<td>pants</td>"+
    "<td>23</td>"+
    "<td>2$</td>"+
  "</tr>"+
  "<tr style = 'background-color:lightgrey; height: 18px;'>"+
  "<td></td>"+
  "<td></td>"+
  "<td></td>"+
  "<td></td>"+
  "</tr>"+
"</table>"+

"<labelpay><u>Payment info</u></labelpay>"+
"<label2>Cash/Card:<label2>"+
"<label3>Card Number:</label3>"+
"<label4>account type:</label4>"+


"<label5>SubTotal:</label5>"+
"<label6>Tax:</label6>"+
"<div1>"+
"<label7>Total</label7>"+
"</div1>"+
"<div2>"+
"<labeltotalAmount></labeltotalAmount>"+
"</div2>"+

"<label9><u><b>Return policy</b></u></label9>"+
"<p1>You can return any product within 10 days of purchase.</p1>"+
"<p2><u>Please rate our service:</u></p2>"+

"</body>"+
"</html>"
                ;
        return s;
    }
    
    private String amendedReceiptString(Sale sale){
        String s = "<h1>Carols Boutique</h1>"+
                "Thank you for your purhace "+sale.getCustomerID()+
                "<br><br><table>"+
                "<tr>"+
                "<th>"+"Item"+"</th>"+
                "<th>"+"Value"+"</th>"+
                "</tr>"+
                "<tr>"+
                "<td>"+"Item1"+"</td>"+
                "<td>"+"$20.5"+"</td>"+
                "</tr>"+
                "<tr>"+
                "<td>"+"Item2"+"</td>"+
                "<td>"+"$31.6"+"</td>"+
                "</tr>"+
                "</table>"+
                "<br><p>Your total is "+"$52.1"+"</p>"+
                "<br><p> Return policy:<br>You cannot return this item.</p>"+
                "<br><p>Please rate us at: www.please_rate_us.co.za</p>"
                ;
        return s;
    }
    
    private String refundString(Sale sale, LineItem lineItem){
        return "";
    }
    
    private String promoString(){
        return "";
    }
    
    private String reminder24hString(LineItem lineItem){
        return "";
    }
    
    private String reminder36hString(LineItem lineItem){
        return "";
    }
    
    private String reminder48hString(LineItem lineItem){
        return "";
    }
    
    private String keepAside(LineItem lineItem){
        return "";
    }
    
    private String lowStockString(ArrayList<Product> products){
        return "";
    }

}
