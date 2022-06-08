package za.co.carols_boutique.ReportBE.IDaoreport;

import java.util.Date;
import java.util.List;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.EmpSale;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.Store;

public interface DAORep {
    
    Report viewTopAchievingStores(String month);
    Report getCustomerReviews(String month, Integer amount);
    Report viewMonthlySales(Store store, String month);
    Report viewTopSellingEmployees(Store store, String month);
    Report viewStoresThatAchievedTarget(String month);
    Report viewTopSellingProducts(String month);
    Report viewLeastPerformingStores(String month);
    Report viewProductReport(String productID, String month);
    Report viewDailySalesReport(Store store);
    
    Boolean addReview(Review review);  
    Boolean addCustomer(Customer customer);
    
}

