/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique.ReportBE.ServiceReport;

import java.util.Date;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;
import za.co.carols_boutique.models.Store;

/**
 *
 * @author muaad
 */
public interface RepService {
    
    Report viewTopAchievingStores(String month);
    Report getCustomerReviews(String month, Integer amount);
    Report viewMonthlySales(Store store, String month);
    Report viewTopSellingEmployees(Store store, String month);
    Report viewStoresThatAchievedTarget(String month);
    Report viewTopSellingProducts(String month);
    Report viewLeastPerformingStores(String month);
    Report viewProductReport(String productID, String month);
    Report viewDailySalesReport(Store store);
    
    String addReview(Review review);  
    String addCustomer(Customer customer);
    
}
