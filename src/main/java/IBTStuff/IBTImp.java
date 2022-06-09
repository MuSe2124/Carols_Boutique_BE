/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IBTStuff;

/**
 *
 * @author Mustafaa Osman
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.IBT;
import za.co.carols_boutique.models.LineItem;
import za.co.carols_boutique.Utilities.Phone;
import za.co.carols_boutique.models.Store;

public class IBTImp implements IBTInt {

	private String id;
	private LineItem lineItem;
	private Customer customer;
	private Store store;
	
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	private int rowsAffected;
	
	IBT ibt;

	public IBTImp(String id, LineItem lineItem, Customer customer, Store store) {
		this.id = id;
		this.lineItem = lineItem;
		this.customer = customer;
		this.store = store;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String URL = "jdbc:mysql://localhost:3306/carolsboutique";
		try {
			con = (Connection) DriverManager.getConnection(URL, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ibt = new IBT(id, lineItem, customer);
	}

	@Override
	public boolean createIBT() {
		rowsAffected = 0;
		if (con != null) {
			try {

				//con.setAutoCommit(false);
				ps = con.prepareStatement("insert into ibt(id, lineItem, customer) values(?,?,?)");
				ps.setString(1, ibt.getId());
				ps.setString(2, ibt.getLineItem().getID());
				ps.setString(3, ibt.getCustomer().getId());
				rowsAffected = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsAffected == 1;
	}

	@Override
	public boolean sendMessageToOtherStore() {
		return false;
	}

	@Override
	public boolean sendCustomerMessage() {
		Phone phone = new Phone(lineItem, customer.getPhoneNumber(), store);
		return phone != null;
	}

	public boolean removeKeepAside() {
		if (con != null) {
			try {
				ps = con.prepareStatement("insert into ibtArchive(id, lineItem, customer) select id, lineItem, customr from ibt where ibt.id = ?");
				ps.setString(1, ibt.getId());

				rowsAffected = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsAffected == 1;
	}
}
