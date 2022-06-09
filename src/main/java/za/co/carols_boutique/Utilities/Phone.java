
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.Utilities;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import za.co.carols_boutique.models.LineItem;
import za.co.carols_boutique.models.Store;

/**
 *
 * @author Mustafaa Osman
 */
public class Phone extends Thread {

	private LineItem lineItem;
	private String phoneNumber;
	private Store store;

	public Phone(LineItem lineItem, String phoneNumber, Store store) {
		this.lineItem = lineItem;
		this.phoneNumber = phoneNumber;
		this.store = store;
		this.start();
	}
	
	
	@Override
	public void run() {
		String head = "<smsreq>";
		String dateTime = "<datetime>2022/05/20,10:10:00< / datetime >";
		String user = " <user>GROUP1</user >";
		String pass = "<pass>group1</pass>";
		String number = "<msisdn>" + phoneNumber + "</msisdn >";
		String message = "<message>" + "Your order of " + lineItem.getAmounnt() + lineItem.getProduct().getName() + " is ready for pickup from " + store.getName() + "\nSincerely Carols Boutique</message >";
		String foot = "</smsreq>";
		

		String stuff = head + dateTime + user + pass + number + message + foot;

		String url = "http://196.41.180.157:8080/sms/sms_request";
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);
		Response response = webTarget.request(MediaType.APPLICATION_XML).post(Entity.xml(stuff));
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.Utilities;

import za.co.carols_boutique.models.LineItem;
import za.co.carols_boutique.models.Store;

/**
 *
 * @author Mustafaa Osman
 */
public class Phone extends Thread {

	private LineItem lineItem;
	private String phoneNumber;
	private Store store;

	public Phone(LineItem lineItem, String phoneNumber, Store store) {
		this.lineItem = lineItem;
		this.phoneNumber = phoneNumber;
		this.store = store;
		this.start();
	}

	public Phone() {
		this.start();
	}

	@Override
	public void run() {
		String head = "<smsreq>";
		String dateTime = "<datetime>2022/05/20,10:10:00< / datetime >";
		String user = " <user>GROUP1</user >";
		String pass = "<pass>group1</pass>";
		String number = "<msisdn>0748035093</msisdn >";
		String message = "<message>\nSincerely Carols Boutique</message >";
		String foot = "</smsreq>";
	}
}

