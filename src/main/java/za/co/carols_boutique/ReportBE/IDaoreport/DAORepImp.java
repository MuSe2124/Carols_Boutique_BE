/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.ReportBE.IDaoreport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;
import java.util.Iterator;
import java.util.Collections;
/**
 *
 * @author HP
 */
public class DAORepImp implements DAORep{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rowsAffected; 

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
    //shuffle them and return an x amount of them 
    @Override
    public Report getCustomerReviews(String month, Integer amount) {
        List<Review> reviews=null;
        //String id, String comment, Integer rating, Date date
        Report report = null;
        if(con!=null){
            try{
                ps = con.prepareStatement("Select id,comment,rating,date from Review");
                rs=ps.executeQuery();
                reviews = new ArrayList<>();
                while(rs.next()){
                    reviews.add(new Review(rs.getString("id"),rs.getString(""),rs.getInt(""),rs.getDate("")));
                }
                //Iterator it = reviews.iterator();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            
        }
//        Collection col = new Collection();
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
        rowsAffected=0;
        if(con!=null){
            try{
                //String id, String comment, Integer rating, Date date
                ps = con.prepareStatement("insert into Review(id,comment,rating,date) values(?,?,?,?)");
                ps.setString(1, review.getId());
                ps.setString(2, review.getComment());
                ps.setInt(3, review.getRating());
                ps.setDate(4, (java.sql.Date) review.getDate());
                rowsAffected=ps.executeUpdate();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(rowsAffected!=1){
            return false;
        }else{
        return true;
        }
    }

    @Override
    public Boolean addCustomer(Customer customer) {
        rowsAffected=0;
        //String id, String name, String phoneNumber, String email
        if(con!=null){
            try{
                ps = con.prepareStatement("Insert into Customer(id,name,phoneNumber,email) values(?,?,?,?)");
                ps.setString(1, customer.getId());
                ps.setString(2, customer.getName());
                ps.setString(3, customer.getPhoneNumber());
                ps.setString(4, customer.getEmail());
                rowsAffected=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(rowsAffected!=1){
            return false;
        }else{
        return true;
        }
    }
    
}

