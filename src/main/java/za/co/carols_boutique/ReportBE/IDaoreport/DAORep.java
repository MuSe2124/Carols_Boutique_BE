package za.co.carols_boutique.ReportBE.IDaoreport;

import java.util.Date;
import java.util.List;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.EmpSale;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;
import za.co.carols_boutique.models.Sale;

public interface DAORep {
    
    Report viewTopAchievingStores(String month);
    Report getCustomerReviews(String month, Integer amount);
    Report viewMonthlySales(String storeID, String month);
    Report viewTopSellingEmployees(String storeID, String month);
    Report viewStoresThatAchievedTarget(String month);
    Report viewTopSellingProducts(String month);
    Report viewLeastPerformingStores(String month);
    Report viewProductReport(String productID, String month);
    Report viewDailySalesReport(String storeID);
    
    Boolean addReview(Review review);  
    Boolean addCustomer(Customer customer);
    
}

