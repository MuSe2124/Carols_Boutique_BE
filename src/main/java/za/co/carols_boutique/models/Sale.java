/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.models;

import java.util.Date;
import java.util.List;

/**
 *
 * @author muaad
 */
public class Sale {

	private String id;
	private Store store;
	private Employee employee;
	private List<LineItem> lineItems;
	private String customerEmail;
	private Date date;
	private Payment payment;
	public Sale(String id, Store store, Employee employee, List<LineItem> lineItems, String customerID, Date date, Payment payment) {
		this.id = id;
		this.store = store;
		this.employee = employee;
		this.lineItems = lineItems;
		this.customerEmail = customerID;
		this.date = date;
		this.payment = payment;
	}

    public Sale(Date date, Payment payment) {
        this.date = date;
        this.payment = payment;
    }
        

        public Sale( List<LineItem> lineItems, Date date, Payment payment) {
            
            this.lineItems = lineItems;
            this.date = date;
            this.payment = payment;
        }
        
	public Sale(Store store, Employee employee, List<LineItem> lineItems, String customerID, Date date) {
		this.store = store;
		this.employee = employee;
		this.lineItems = lineItems;
		this.customerEmail = customerID;
		this.date = date;
	}

	public Sale() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Store getStoreID() {
		return store;
	}

	public void setStoreID(Store storeID) {
		this.store = storeID;
	}

	public Employee getEmployeeID() {
		return employee;
	}

	public void setEmployeeID(Employee employeeID) {
		this.employee = employeeID;
	}

	public List<LineItem> getLineItemID() {
		return lineItems;
	}

	public void setLineItemID(List<LineItem> lineItemID) {
		this.lineItems = lineItemID;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerID) {
		this.customerEmail = customerID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void addLineItem(LineItem lineItem) {
	}

	public Float calculateTotal() {
		Float flo = null;
		for (LineItem lineItem : lineItems) {
			flo += lineItem.getTotal();
		}
		return flo;
	}

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
        

	@Override
	public String toString() {
		return "Sale{" + "id=" + id + ", storeID=" + store + ", employeeID=" + employee + ", lineItems=" + lineItems + ", customerID=" + customerEmail + ", date=" + date + '}';
	}   
}
