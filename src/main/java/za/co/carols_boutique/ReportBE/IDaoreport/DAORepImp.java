/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.ReportBE.IDaoreport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;

/**
 *
 * @author HP
 */
public class DAORepImp implements DAORep{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int RowsAffected; 

    @Override
    public Report viewTopAchievingStores(String month) {
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                rs=ps.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report getCustomerReviews(String month, Integer amount) {
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                rs=ps.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report viewMonthlySales(String storeID, String month) {
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                rs=ps.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report viewTopSellingEmployees(String storeID, String month) {
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                rs=ps.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report viewStoresThatAchievedTarget(String month) {
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                rs=ps.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report viewTopSellingProducts(String month) {
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                rs=ps.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report viewLeastPerformingStores(Date starDate, Date endDate) {
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                rs=ps.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report viewProductReport(String productID, String month) {
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                rs=ps.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report viewDailySalesReport(String storeID) {
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                rs=ps.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Boolean addReview(Review review) {
        RowsAffected=0;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                RowsAffected=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(RowsAffected==0){
            return false;
        }else{
        return true;
        }
    }

    @Override
    public Boolean addCustomer(Customer customer) {
        RowsAffected=0;
        if(con!=null){
            try{
                ps = con.prepareStatement("");
                RowsAffected=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(RowsAffected==0){
            return false;
        }else{
        return true;
        }
    }
    
}
