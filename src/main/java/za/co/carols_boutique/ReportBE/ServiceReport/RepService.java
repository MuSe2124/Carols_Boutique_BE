/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique.ReportBE.ServiceReport;

import java.util.Date;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;

/**
 *
 * @author muaad
 */
public interface RepService {
    
    Report viewTopAchievingStores(String month);
    Report getCustomerReviews(String month, Integer amount);
    Report viewMonthlySales(String storeID, String month);
    Report viewTopSellingEmployees(String storeID, String month);
    Report viewStoresThatAchievedTarget(String month);
    Report viewTopSellingProducts(String month);
    Report viewLeastPerformingStores(Date startDate, Date endDate);
    Report viewProductReport(String productID, String month);
    Report viewDailySalesReport(String storeID);
    
    String addReview(Review review);  
    String addCustomer(Customer customer);
    
}
