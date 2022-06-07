package za.co.carols_boutique.modle.test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import za.co.carols_boutique.models.Category;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Email;
import za.co.carols_boutique.models.EmpSale;
import za.co.carols_boutique.models.Employee;
import za.co.carols_boutique.models.IBT;
import za.co.carols_boutique.models.KeepAside;
import za.co.carols_boutique.models.LineItem;
import za.co.carols_boutique.models.Phone;
import za.co.carols_boutique.models.ProdStore;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.StockItem;
import za.co.carols_boutique.models.Store;
import za.co.carols_boutique.models.StoreSale;

public class ModelsTest {
	
	Category category;
	Customer customer;
	Email email;
	EmpSale empSale;
	Employee employee;
	IBT ibt;
	KeepAside keepAside;
	LineItem lineItem;
	Phone phone;
	ProdStore prodStore;
	Product product;
	Report report;
	Review review;
	Sale sale;
	StockItem stockItem;
	Store store;
	StoreSale storeSale;

	public ModelsTest() {
		category = new Category("CategoryID", "CategoryName", "CategoryDescription");
		customer = new Customer("CustomerID", "CustomerName", "CustomerNumber", "CustomerEmail");
		email = new Email();
		empSale = new EmpSale();
		employee = new Employee("EmployeeID", "EmployeeName", "EmployeeSurname", "EmployeePass", "EmployeeStoreID", false);
		ibt = new IBT();
		keepAside = new KeepAside("KeepAsideID", "KeepAsideStoreID", new Date(), "CustomerID", "ProductID");
		lineItem = new LineItem("LineItemID", "SaleId", "ProductId", 3);
		phone = new Phone();
//		prodStore = new ProdStore("ID", "StoreID", "productID", 3);
		product = new Product("ID", "name", "description", 15.99F);
		report = new Report();
		review = new Review("id", "comment", 9, new Date());
		sale = new Sale("id", "storeID", "employeeID", "lineItemID", "customerID", new Date());
		stockItem = new StockItem();
		store = new Store("id", "name", "location", "password");
		storeSale = new StoreSale();
	}

	@Test
	void testCategory() {
		assertTrue(category.toString().equals("Category{" + "id=" + "CategoryID" + ", name=" + "CategoryName" + ", description=" + "CategoryDescription" + '}'));
	}

	@Test
	void testCustomer() {
		assertTrue(customer.toString().equals("Customer{" + "id=" + "CustomerID" + ", name=" + "CustomerName" + ", phoneNumber=" + "CustomerNumber" + ", email=" + "CustomerEmail" + '}'));
	}

	@Test
	void testEmployee() {
		assertTrue(employee.toString().equals("Employee{" + "id=" + "EmployeeID" + ", name=" + "EmployeeName" + ", surname=" + "EmployeeSurname" + ", password=" + "EmployeePass" + ", storeID=" + "EmployeeStoreID" + ", isManager=" + false + '}'));
	}

	@Test
	void testKeepAside() {
		assertTrue(keepAside.toString().equals("KeepAside{" + "id=" + "KeepAsideID" + ", storeID=" + "KeepAsideStoreID" + ", date=" + new Date() + ", customerID=" + "CustomerID" + ", productID=" + "ProductID" + '}'));
	}

	@Test
	void testLineItem() {
		assertTrue(lineItem.toString().equals("LineItem{" + "id=" + "LineItemID" + ", saleID=" + "SaleId" + ", productID=" + "ProductId" + ", amounnt=" + 3 + '}'));
	}

	@Test
	void testProdStore() {
		assertTrue(prodStore.toString().equals("ProdStore{" + "id=" + "ID" + ", storeID=" + "StoreID" + ", productID=" + "productID" + ", amount=" + 3 + '}'));
	}

	@Test
	void testProduct() {
		assertTrue(product.toString().equals("Product{" + "id=" + "ID" + ", name=" + "name" + ", description=" + "description" + ", price=" + 15.99F + '}'));
	}

	@Test
	void testReview() {
		assertTrue(review.toString().equals("Review{" + "id=" + "id" + ", comment=" + "comment" + ", rating=" + 9 + ", date=" + new Date() + '}'));
	}

	@Test
	void testSale() {
		assertTrue(sale.toString().equals("Sale{" + "id=" + "id" + ", storeID=" + "storeID" + ", employeeID=" + "employeeID" + ", lineItemID=" + "lineItemID" + ", customerID=" + "customerID" + ", date=" + new Date() + '}'));
	}

	@Test
	void testStore() {
		assertTrue(store.toString().equals("Store{" + "id=" + "id" + ", name=" + "name" + ", location=" + "location" + ", password=" + "password" + '}'));
	}
}
