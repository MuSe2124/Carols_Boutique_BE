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
import za.co.carols_boutique.models.Sale;
/**
 *
 * @author Jomar
 */
public class Email extends Thread{
    
    Session newSession = null;
    MimeMessage mimeMessage = null;
    String recipient;
    String action;
    ArrayList<String>recipients;
    Sale sale;
    LineItem preLineItem;
    LineItem postLineItem;

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
    
    
    
    private String receiptString(Sale sale){
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

}
