package za.co.carols_boutique.service.test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import za.co.carols_boutique.ReportBE.ServiceReport.RepService;
import za.co.carols_boutique.ReportBE.ServiceReport.RepServiceImp;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Review;

public class ReportServiceTest {
	
	RepService service;

	public ReportServiceTest() {
		service = new RepServiceImp();
	}

	@Test
	void testViewTopAchievingStores() {
		String month = "";
		assertNotNull(service.viewTopAchievingStores(month));
	}

	@Test
	void testViewTopAchievingStoresSuccess() {
		String month = "";
		assertTrue(service.viewTopAchievingStores(month).equals(""));
	}

	@Test
	void testGetCustomerReviews() {
		Integer noOfReviews = 2;
		String month = "";
		assertNotNull(service.getCustomerReviews(month, noOfReviews));
	}

	@Test
	void testGetCustomerReviewsSuccess() {
		Integer noOfReviews = 2;
		String month = "";
		assertTrue(service.getCustomerReviews(month, noOfReviews).equals(""));
	}

	@Test
	void testViewMonthlySales() {
		String storeID = "";
		String month = "";
		assertNotNull(service.viewMonthlySales(storeID, month));
	}

	@Test
	void testViewMonthlySalesSuccess() {
		String storeID = "";
		String month = "";
		assertTrue(service.viewMonthlySales(storeID, month).equals(""));
	}

	@Test
	void testViewTopSellingEmployees() {
		String storeID = "";
		String month = "";
		assertNotNull(service.viewTopSellingEmployees(storeID, month));
	}

	@Test
	void testViewTopSellingEmployeesSuccess() {
		String storeID = "";
		String month = "";
		assertTrue(service.viewTopSellingEmployees(storeID, month).equals(""));
	}

	@Test
	void testViewStoresThatAcievedtTarger() {
		String month = "";
		assertNotNull(service.viewStoresThatAchievedTarget(month));
	}

	@Test
	void testViewStoresThatAcievedtTargerSuccess() {
		String month = "";
		assertTrue(service.viewStoresThatAchievedTarget(month).equals(""));
	}

	@Test
	void testViewTopSellingProducts() {
		String month = "";
		assertNotNull(service.viewTopSellingProducts(month));
	}

	@Test
	void testViewTopSellingProductsSuccess() {
		String month = "";
		assertTrue(service.viewTopSellingProducts(month).equals(""));
	}

	@Test
	void testViewLeastPerformingStores() {
		Date starDate = null;
		Date endDate = null;
		assertNotNull(service.viewLeastPerformingStores(starDate, endDate));
	}

	@Test
	void testViewLeastPerformingStoresSuccess() {
		Date starDate = null;
		Date endDate = null;
		assertTrue(service.viewLeastPerformingStores(starDate, endDate).equals(""));
	}

	@Test
	void testViewProductReport() {
		String productID = "";
		String month = "";
		assertNotNull(service.viewProductReport(productID, month));
	}

	@Test
	void testViewProductReportSuccess() {
		String productID = "";
		String month = "";
		assertTrue(service.viewProductReport(productID, month).equals(""));
	}

	@Test
	void testViewDailySalesReport() {
		assertNotNull(service.viewDailySalesReport("Store"));
	}

	@Test
	void testViewDailySalesReportSuccess() {
		assertTrue(service.viewDailySalesReport("Store").equals(""));
	}

	@Test
	void testAddReview() {
		String id = "";
		String comment = "";
		Integer rating = 9;
		Date date = null;
		Review review = new Review(id, comment, rating, date);
		assertNotNull(service.addReview(review));
	}

	@Test
	void testAddReviewSuccess() {
		String id = "";
		String comment = "";
		Integer rating = 9;
		Date date = null;
		Review review = new Review(id, comment, rating, date);
		assertTrue(service.addReview(review).equals(""));
	}

	@Test
	void testAddCustomer() {
		String id = "";
		String name = "";
		String phoneNumber = "";
		String email = "";
		Customer customer = new Customer(id, name, phoneNumber, email);
		assertNotNull(service.addCustomer(customer));
	}

	@Test
	void testAddCustomerSuccess() {
		String id = "";
		String name = "";
		String phoneNumber = "";
		String email = "";
		Customer customer = new Customer(id, name, phoneNumber, email);
		assertTrue(service.addCustomer(customer).equals(""));
	}
}
