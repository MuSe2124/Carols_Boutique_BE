package za.co.carols_boutique.dao.test;

import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.co.carols_boutique.ReportBE.IDaoreport.DAORep;
import za.co.carols_boutique.ReportBE.IDaoreport.DAORepImp;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Review;

public class ReportDAOTest {
	
	DAORep dao;

	public ReportDAOTest() {
		dao = new DAORepImp();
	}

	@Test
	void testViewTopAchievingStores() {
		String month = "";
		assertNotNull(dao.viewTopAchievingStores(month));
	}

	@Test
	void testGetCustomerReviews() {
		Integer noOfReviews = 2;
		String month = "";
		assertNotNull(dao.getCustomerReviews(month, noOfReviews));
	}

	@Test
	void testViewMonthlySales() {
		String storeID = "";
		String month = "";
		assertNotNull(dao.viewMonthlySales(storeID, month));

	}

	@Test
	void testViewTopSellingEmployees() {
		String storeID = "";
		String month = "";
		assertNotNull(dao.viewTopSellingEmployees(storeID, month));

	}

	@Test
	void testViewStoresThatAcievedtTarger() {
		String month = "";

		assertNotNull(dao.viewStoresThatAchievedTarget(month));

	}

	@Test
	void testViewTopSellingProducts() {
		String month = "";
		assertNotNull(dao.viewTopSellingProducts(month));

	}

	@Test
	void testViewLeastPerformingStores() {
		Date starDate = null;
		Date endDate = null;
		assertNotNull(dao.viewLeastPerformingStores(starDate, endDate));

	}

	@Test
	void testViewProductReport() {
		String productID = "";
		String month = "";
		assertNotNull(dao.viewProductReport(productID, month));

	}

	@Test
	void testViewDailySalesReport() {
		assertNotNull(dao.viewDailySalesReport("Store"));

	}

	@Test
	void testAddReview() {
		String id = "";
		String comment = "";
		Integer rating = 9;
		Date date = null;
		Review review = new Review(id, comment, rating, date);
		assertNotNull(dao.addReview(review));

	}

	@Test
	void testAddCustomer() {
		String id = "";
		String name = "";
		String phoneNumber = "";
		String email = "";
		Customer customer = new Customer(id, name, phoneNumber, email);
		assertNotNull(dao.addCustomer(customer));

	}
}
