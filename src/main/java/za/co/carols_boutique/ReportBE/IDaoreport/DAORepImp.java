/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.ReportBE.IDaoreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;
import java.util.Iterator;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.carols_boutique.models.EmpSale;
import za.co.carols_boutique.models.ProdStore;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.ProductReport;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.StoreSale;
import za.co.carols_boutique.models.StoreSales;

/**
 *
 * @author HP
 */
public class DAORepImp implements DAORep {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rowsAffected;

    public DAORepImp() {
        try {//com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String URL = "jdbc:mysql://localhost:3306/carolsboutique";
        try {
            con = (Connection) DriverManager.getConnection(URL, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Report viewTopAchievingStores(String month) {
        Report report = new Report();
        List<StoreSale> storeSales = new ArrayList<StoreSale>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select name,id from store");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    Integer total = 0;
                    ps = con.prepareStatement("select total from lineitem inner join sale on lineitem.sale = sale.id where monthname(date) = ?");
                    ps.setString(1, month);
                    ResultSet rs2 = ps.executeQuery();
                    while (rs2.next()) {
                        total += rs.getInt("total");
                    }
                    StoreSale ss = new StoreSale(name, total);
                    storeSales.add(ss);
                }
                report.setStoreSales(storeSales);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return report;
    }

    //shuffle them and return an x amount of them 
    @Override
    public Report getCustomerReviews(String month, Integer amount) {
        Report report = new Report();
        List<Review> reviews = new ArrayList<Review>();
        List<Review> rev = new ArrayList<>();

        if (con != null) {
            try {
                ps = con.prepareStatement("select * from review where monthname(date) = ?");
                ps.setString(1, month);
                rs = ps.executeQuery();

                while (rs.next()) {
                    reviews.add(new Review(rs.getString("comment"), rs.getInt("rating")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAORepImp.class.getName()).log(Level.SEVERE, null, ex);
            }
            Collections.shuffle(reviews);
            for (int i = 0; i < amount; i++) {
                rev.add(reviews.get(i));
            }
        }
        report.setReviews(rev);
        return report;
    }

    @Override
    public Report viewMonthlySales(String storeID, String month) {
        Report report = new Report();
        List<StoreSales> storeSales = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select name,id from store");
                rs = ps.executeQuery();
                while (rs.next()) {
                    List<Sale> sales = new ArrayList<>();
                    String name = rs.getString("name");
                    Integer total = 0;
                    ps = con.prepareStatement("select * from sale inner join lineitem on sale.id = lineitem.sale where storeID = ? and monthname(date) = ?");
                    ps.setString(1, storeID);
                    ps.setString(2, month);
                    ResultSet rs2 = ps.executeQuery();
                    while (rs2.next()) {
                        total += rs.getInt("total");
                        sales.add(new Sale(storeID, rs.getString("id")));
                    }
                    StoreSales ss = new StoreSales(name, sales);
                    storeSales.add(ss);
                }
                report.setStoresSales(storeSales);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return report;
    }

    @Override
    public Report viewTopSellingEmployees(String storeID, String month) {
        Report report = new Report();
        List<EmpSale> empSales = new ArrayList<>();
        if (con != null) {
            try {
                    Integer total = 0;
                    ps = con.prepareStatement("select * from sale inner join employee on employee.id = sale.employeeID where employee.storeID = ? and monthname(date) = ?");           
                ps.setString(1, storeID);
                ps.setString(2, month);
                rs = ps.executeQuery();
                String name;                   
                    while (rs.next()) {
                        total++;
                        name = rs.getString("name");
                        empSales.add(new EmpSale(total, storeID));
                    }       
                report.setEmpSales(empSales);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report viewStoresThatAchievedTarget(String month) {
        Report report = new Report();
        List<StoreSales> storeSales = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from store where total > target and monthname(date) = ?");
                ps.setString(1, month);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    Float target = rs.getFloat("target");
                    StoreSales ss = new StoreSales(name, target);
                    storeSales.add(ss);
                }
                report.setStoresSales(storeSales);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return report;
    }

    @Override
    public Report viewTopSellingProducts(String month) {
        Report report = new Report();
        List<ProdStore> prodStores = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from product");
               
                rs = ps.executeQuery();
                List<Product>products = new ArrayList<>();
                while (rs.next()) {                    
                    products.add(new Product(rs.getString("id")));
                }
                
                for(Product p:products) {
                    ps = con.prepareStatement("select total from lineitem inner join sale on lineitem.sale = sale.id where monthname(date) = ? and product = ?");
                    ps.setString(1, month);
                    ps.setString(2, p.getId());                    
                    prodStores.add(new ProdStore(rs.getString("storeID"), rs.getString("productID"), rs.getInt("amount")));
                }
                report.setProdStores(prodStores);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return report;
    }

    @Override
    public Report viewLeastPerformingStores(String month) {
        Report report = new Report();
        List<StoreSale> storeSales = new ArrayList<StoreSale>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select name,id from store");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    Integer total = 0;
                    ps = con.prepareStatement("select total from lineitem inner join sale on lineitem.sale = sale.id where monthname(date) = ?");
                    ps.setString(1, month);
                    ResultSet rs2 = ps.executeQuery();
                    while (rs2.next()) {
                        total += rs.getInt("total");
                    }
                    StoreSale ss = new StoreSale(name, total);
                    storeSales.add(ss);
                }
                report.setStoreSales(storeSales);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return report;
    }

    @Override
    public Report viewProductReport(String productID, String month) {
        Report report = new Report();
        List<ProductReport> products = new ArrayList<>();
        
        if (con != null) {
            try {
                ps = con.prepareStatement("select name,description from product where productID = ?");
                ps.setString(1, productID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    Integer total = 0;
                    ps = con.prepareStatement("select productID from lineitem inner join sale on lineitem.sale = sale.id and employee.id = sale.employeeID where monthname(date) = ?");
                    ps.setString(1, month);
                    ResultSet rs2 = ps.executeQuery();
                    while (rs2.next()) {
                        total += rs.getInt("total");
                    }
                    ProductReport pr = new ProductReport(rs2.getString("name"), rs2.getString("employeeID"), rs2.getString("amount"));
                    products.add(pr);
                }
                report.setProductReport(products);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return report;
    }

    @Override
    public Report viewDailySalesReport(String storeID) {
        Report report = new Report();
        List<StoreSale> storeSales = new ArrayList<>();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyyMMdd");
        if (con != null) {
            try {
                
                ps = con.prepareStatement("select * from sale where date = ? and storeID = ?");
                ps.setString(1, LocalDate.now().format(date));
                ps.setString(2, storeID);
                rs = ps.executeQuery();
                PreparedStatement ps2;
                ps2 = con.prepareStatement("select * from store where id = ?");
                ps2.setString(1, storeID);
                ResultSet rs2;
                rs2 = ps2.executeQuery();
                while (rs.next()) {
                    
                  storeSales.add(new StoreSale(rs2.getString("Name"), rs2.getInt("total"), rs2.getFloat("target") ));
                }
                report.setStoreSales(storeSales);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return report;
    }

    @Override
    public Boolean addReview(Review review) {
        rowsAffected = 0;
        if (con != null) {
            try {
                //String id, String comment, Integer rating, Date date
                ps = con.prepareStatement("insert into Review(id,comment,rating,date) values(?,?,?,?)");
                ps.setString(1, review.getId());
                ps.setString(2, review.getComment());
                ps.setInt(3, review.getRating());
                ps.setDate(4, (java.sql.Date) review.getDate());
                rowsAffected = ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rowsAffected != 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean addCustomer(Customer customer) {
        rowsAffected = 0;
        //String id, String name, String phoneNumber, String email
        if (con != null) {
            try {
                ps = con.prepareStatement("Insert into Customer(id,name,phoneNumber,email) values(?,?,?,?)");
                ps.setString(1, customer.getId());
                ps.setString(2, customer.getName());
                ps.setString(3, customer.getPhoneNumber());
                ps.setString(4, customer.getEmail());
                rowsAffected = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rowsAffected != 1) {
            return false;
        } else {
            return true;
        }
    }

}
