package za.co.carols_boutique.ReportBE.IDaoreport;

import java.util.Date;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;

public interface DAORep {
    
    Report viewTopAchievingStores(String month);
    Report getCustomerReviews(String month, Integer amount);
    Report viewMonthlySales(String storeID, String month);
    Report viewTopSellingEmployees(String storeID, String month);
    Report viewStoresThatAchievedTarget(String month);
    Report viewTopSellingProducts(String month);
    Report viewLeastPerformingStores(Date starDate, Date endDate);
    Report viewProductReport(String productID, String month);
    Report viewDailySalesReport(String storeID);
    
    Boolean addReview(Review review);  
    Boolean addCustomer(Customer customer);
    
}
