/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.Utilities;

import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import za.co.carols_boutique.models.Sale;
/**
 *
 * @author Jomar
 */
public class Email extends Thread{
    
    Session newSession = null;
    MimeMessage mimeMessage = null;
    String recipient;

    public Email(String recipient){
        this.recipient = recipient;
        this.start();
    }
    
    @Override
    public void run(){
        try {
            setupServerProperties();
            draftEmail(recipient);
            sendEmail();
        } catch (MessagingException e) {
            e.printStackTrace();
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

    public MimeMessage draftEmails(String[] emailRecipients) throws MessagingException {
        String emailSubject = "Test Email";
        String emailBody = "This is a test email from Carol's Boutique. Please let me know when you get this\n-@ jomarvn@gmail.com";
        mimeMessage = new MimeMessage(newSession);
        for (int i = 0; i < emailRecipients.length; i++) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipients[i]));
        }
        mimeMessage.setSubject(emailSubject);

        //CREATE MIMEMESSAGE
        //CREATE MESSAGE BODY PARTS
        //CREATE MESSAGE MULTIPART
        //ADD MESSAGE BODY PARTS ------> MULTIPART
        //FINALLY ADD MULTIPART TO MESSAGECONTENT i.e.mimeMessage object

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody,"html/text");
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);
        mimeMessage.setContent(multipart);
        return mimeMessage;
    }
    
    public MimeMessage draftEmail(String recipient) throws AddressException, MessagingException{
    String emailSubject = "Test Email";
        String emailBody = "This is a test email from Carol's Boutique. Please let me know when you get this\n-@ jomarvn@gmail.com";
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        mimeMessage.setSubject(emailSubject);

        //CREATE MIMEMESSAGE
        //CREATE MESSAGE BODY PARTS
        //CREATE MESSAGE MULTIPART
        //ADD MESSAGE BODY PARTS ------> MULTIPART
        //FINALLY ADD MULTIPART TO MESSAGECONTENT i.e.mimeMessage object

//        MimeBodyPart bodyPart = new MimeBodyPart();
//        bodyPart.setContent(emailBody,"html/text");
//        MimeMultipart multipart = new MimeMultipart();
//        multipart.addBodyPart(bodyPart);
        String body = receiptString(new Sale("Sandton","Osman","Line3","Jean-Paul",new Date()));
        mimeMessage.setSubject("Carol's Boutique receipt");
        mimeMessage.setContent(body,"text/html");
        return mimeMessage;
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
    
    public String receiptString(Sale sale){
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
}
