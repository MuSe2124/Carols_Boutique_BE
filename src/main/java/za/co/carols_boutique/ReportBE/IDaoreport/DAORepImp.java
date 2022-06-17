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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import za.co.carols_boutique.models.Customer;
import za.co.carols_boutique.models.Report;
import za.co.carols_boutique.models.Review;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.carols_boutique.StoreBE.IDAOStore.DAOStoreImp;
import za.co.carols_boutique.models.EmpSale;
import za.co.carols_boutique.models.Employee;
import za.co.carols_boutique.models.LineItem;
import za.co.carols_boutique.models.ProdStore;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.ProductReport;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.SaleReport;
import za.co.carols_boutique.models.Store;
import za.co.carols_boutique.models.StoreSale;
import za.co.carols_boutique.models.StoreSales;
import za.co.carols_boutique.properties.CarolsProperties;

/**
 *
 * @author HP
 */
public class DAORepImp implements DAORep {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rowsAffected;
    private DAOStoreImp store;

    public DAORepImp() {
        CarolsProperties cp = new CarolsProperties();
        try {//com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //String URL = "jdbc:mysql://localhost:3306/carolsboutique";       
        try {
            con = (Connection) DriverManager.getConnection(cp.getUrl(), cp.getUsername(), cp.getPassword());
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
                ps = con.prepareStatement("select name, id from store");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    Float total = 0f;
                    ps = con.prepareStatement("select total from lineitem inner join sale on lineitem.sale = sale.id where monthname(date) = ? and sale.storeID = ?");
                    ps.setString(1, month);
                    ps.setString(2, rs.getString("id"));
                    ResultSet rs2 = ps.executeQuery();
                    while (rs2.next()) {
                        total += rs.getFloat("total");
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
                ps = con.prepareStatement("select id, comment, rating, date from review order by rand() limit ? where monthname(date) = ?");
                ps.setInt(1, amount);
                ps.setString(2, month);
                rs = ps.executeQuery();

                while (rs.next()) {
                    reviews.add(new Review(rs.getString("id"),
                            rs.getString("comment"),
                            rs.getInt("rating"),
                            rs.getDate("date")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAORepImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        report.setReviews(rev);
        return report;
    }

    @Override
    public Report viewMonthlySales(String storeID, String month) {
        Report report = new Report();
        List<Sale> sales = new ArrayList<>();

        if (con != null) {
            try {
                ps = con.prepareStatement("select id, employeeID, cutomerEmail, date from sale where storeID = ? and monthname(date) = ?");
                ps.setString(1, storeID);
                ps.setString(2, month);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Sale sale = new Sale();
                    sale.setLineItems(new ArrayList<LineItem>());
                    String saleID = rs.getString("id");
                    sale.setCustomerEmail(rs.getString("customerEmail"));
                    sale.setId(saleID);
                    ps = con.prepareStatement("select name, location, password, target from store where id = ?");
                    ps.setString(1, rs.getString("storeID"));
                    ResultSet rs2 = ps.executeQuery();
                    if (rs2.next()) {
                        Store store = new Store(rs.getString("storeID"),
                                rs2.getString("name"),
                                rs2.getString("location"),
                                rs2.getString("password"),
                                rs2.getFloat("target"));
                        sale.setStore(store);
                    }
                    ps = con.prepareStatement("select name,surname,isManager,password,storeID from employee where id = ?");
                    ps.setString(1, rs.getString("employeeID"));
                    ResultSet rs3 = ps.executeQuery();
                    if (rs.next()) {
                        Employee employee = new Employee(
                                rs.getString("employeeID"),
                                rs3.getString("name"),
                                rs3.getString("surname"),
                                rs3.getString("password"),
                                rs3.getString("storeID"),
                                rs3.getBoolean("isManager")
                        );
                        sale.setEmployee(employee);
                    }
                    ps = con.prepareStatement("select id, product, amount, total, size, sale from lineitem where sale = ?");
                    ps.setString(1, saleID);
                    ResultSet rs4 = ps.executeQuery();
                    while (rs4.next()) {
                        ps = con.prepareStatement("select id, name, description, price from product where id = ?");
                        ps.setString(1, rs4.getString("product"));
                        ResultSet rs5 = ps.executeQuery();
                        Product product = null;
                        if (rs5.next()) {
                            product = new Product(
                                    rs5.getString("id"),
                                    rs5.getString("name"),
                                    rs5.getString("description"),
                                    rs5.getFloat("price"),
                                    rs4.getString("size")
                            );
                        }
                        LineItem li = new LineItem(
                                rs4.getString("id"),
                                rs4.getString("sale"),
                                product,
                                rs4.getInt("amount")
                        );
                        sale.getLineItems().add(li);
                    }
                }
            } catch (SQLException ex) {
                System.out.println("You made a mistake before line 191");
            }
        }
        return report;
    }

    @Override
    public Report viewTopSellingEmployees(String storeID, String month) {
        Report report = new Report();
        report.setEmpSales(new ArrayList<EmpSale>());
        if (con != null) {
            try {
                Float total = 0f;
                ps = con.prepareStatement("select employee.id from employee inner join sale on employee.id = sale.employeeID where employee.storeID = ? and monthname(date) = ?");
                ps.setString(1, storeID);
                ps.setString(2, month);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String employeeID = rs.getString("name");
                    ps = con.prepareStatement("select total from lineitem inner join sale on sale.id = lineitem.sale where employeeID = ? and monthname(date) = ?");
                    ps.setString(1, employeeID);
                    ps.setString(2, month);
                    ResultSet rs2 = ps.executeQuery();
                    while (rs2.next()) {
                        total += rs2.getFloat("total");
                    }
                    report.getEmpSales().add(new EmpSale(employeeID, total, storeID));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        EmpSale es = null;
        for (int i = 0; i < report.getEmpSales().size() - 1; i++) {
            if (report.getEmpSales().get(i).getSaleTotal() < report.getEmpSales().get(i + 1).getSaleTotal()) {
                es = report.getEmpSales().get(i);
                report.getEmpSales().set(i, report.getEmpSales().get(i + 1));
                report.getEmpSales().set(i + 1, es);
                i = 0;
            }
        }

        return report;
    }

    public Report viewTopSellingEmployees(String month) {
        Report report = new Report();
        report.setEmpSales(new ArrayList<EmpSale>());
        if (con != null) {
            try {
                Float total = 0f;
                ps = con.prepareStatement("select employee.id from employee inner join sale on employee.id = sale.employeeID where monthname(date) = ?");
                ps.setString(2, month);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String employeeID = rs.getString("name");
                    ps = con.prepareStatement("select total from lineitem inner join sale on sale.id = lineitem.sale where employeeID = ? and monthname(date) = ?");
                    ps.setString(1, employeeID);
                    ps.setString(2, month);
                    ResultSet rs2 = ps.executeQuery();
                    while (rs2.next()) {
                        total += rs2.getFloat("total");
                    }
                    report.getEmpSales().add(new EmpSale(employeeID, total));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        EmpSale es = null;
        for (int i = 0; i < report.getEmpSales().size() - 1; i++) {
            if (report.getEmpSales().get(i).getSaleTotal() < report.getEmpSales().get(i + 1).getSaleTotal()) {
                es = report.getEmpSales().get(i);
                report.getEmpSales().set(i, report.getEmpSales().get(i + 1));
                report.getEmpSales().set(i + 1, es);
                i = 0;
            }
        }

        return report;
    }

    @Override
    public Report viewStoresThatAchievedTarget(String month) {
        Report report = new Report();
        List<StoreSale> storeSales = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select id from store");
                ResultSet rsTemp = ps.executeQuery();
                while (rsTemp.next()) {
                    store.updateTotal(rsTemp.getString("id"));
                }

                ps = con.prepareStatement("select name, target, total from store where total > target and monthname(date) = ?");
                ps.setString(1, month);
                rs = ps.executeQuery();
                while (rs.next()) {
                    StoreSale ss = new StoreSale(
                            rs.getString("name"),
                            rs.getFloat("total"),
                            rs.getFloat("target"));
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
    public Report viewTopSellingProducts(String month) {
        Report report = new Report();
        List<ProdStore> prodStores = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select id from product");

                rs = ps.executeQuery();
                List<Product> products = new ArrayList<>();
                while (rs.next()) {
                    Product p = new Product(rs.getString("id"));
                    ps = con.prepareStatement("select amount from lineitem where product = ?");
                    ps.setString(1, p.getId());
                    ResultSet rs2 = ps.executeQuery();
                    Integer amount = 0;
                    while (rs2.next()) {
                        amount += rs2.getInt("amount");
                    }
                    ps = con.prepareStatement("select id from store");
                    ResultSet rs3 = ps.executeQuery();
                    String storeID = "";
                    Integer storeTotal = 0;
                    while (rs3.next()) {
                        ps = con.prepareStatement("select amount from lineitem inner join sale on sale.id = lineitem.sale where storeID = ? and monthname(date) = ? and product = ?");
                        ps.setString(1, rs3.getString("id"));
                        ps.setString(2, month);
                        ps.setString(3, p.getId());
                        ResultSet rs4 = ps.executeQuery();
                        Integer storeTotaltemp = 0;
                        while (rs4.next()) {
                            storeTotaltemp += rs4.getInt("amount");
                        }
                        if (storeTotaltemp > storeTotal) {
                            storeID = rs3.getString("id");
                            storeTotal = storeTotaltemp;
                        }
                        ProdStore prod = new ProdStore(storeID, p.getId(), storeTotal);
                        prodStores.add(prod);
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        report.setProdStores(prodStores);
        return report;
    }

    @Override
    public Report viewLeastPerformingStores(String month) {
        Report report = new Report();
        List<StoreSale> storeSales = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select name,id from store");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    Float total = 0f;
                    ps = con.prepareStatement("select total from lineitem inner join sale on lineitem.sale = sale.id where monthname(date) = ? and storeID = ?");
                    ps.setString(1, month);
                    ps.setString(2, rs.getString("id"));
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
        StoreSale ss = null;
        for (int i = 0; i < report.getStoreSales().size() - 1; i++) {
            if (report.getEmpSales().get(i).getSaleTotal() < report.getEmpSales().get(i + 1).getSaleTotal()) {
                ss = report.getStoreSales().get(i);
                report.getStoreSales().set(i, report.getStoreSales().get(i + 1));
                report.getStoreSales().set(i + 1, ss);
                i = 0;
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
                ps = con.prepareStatement("select employeeID from sale inner join on sale.id = lineitem.sale lineitem where lineitem.product = ? and monthaname(date) = ?");
                ps.setString(1, productID);
                ps.setString(2, month);
                rs = ps.executeQuery();
                Integer total = 0;
                String employeeOTM = "";
                while (rs.next()) {
                    ps = con.prepareStatement("select amount from lineitem inner join sale on sale.id = lineitem.sale where sale.employeeID = ? and lineitem.product = ? and monthname(date) = ?");
                    ps.setString(1, rs.getString("employeeID"));
                    ps.setString(2, productID);
                    ps.setString(3, month);
                    ResultSet rs2 = ps.executeQuery();
                    Integer totalTemp = 0;
                    while (rs2.next()) {
                        totalTemp += rs2.getInt("amount");
                    }
                    if (totalTemp > total) {
                        total = totalTemp;
                        employeeOTM = rs.getString("employeeID");
                    }
                }
                ProductReport pr = new ProductReport(productID, employeeOTM, total);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return report;
    }

    @Override
    public Report viewDailySalesReport(String storeID) {
        Report report = new Report();
        List<SaleReport> saleReports = new ArrayList<>();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyyMMdd");
        if (con != null) {
            try {
                ps = con.prepareStatement("select sale from lineitem inner join sale on sale.id = lineitem.sale where date = ? and sale.store = ?");
                ps.setString(1, LocalDate.now().format(date));
                ps.setString(2, storeID);
                rs = ps.executeQuery();
                Float total = 0f;
                while (rs.next()) {
                    ps = con.prepareStatement("select total from lineitem where sale = ?");
                    ps.setString(1, rs.getString("Sale"));
                    ResultSet rs2 = ps.executeQuery();
                    total = 0f;
                    while (rs2.next()) {
                        total += rs.getFloat("total");
                    }
                    SaleReport sr = new SaleReport(rs.getString("sale"), total);
                    saleReports.add(sr);
                }

                report.setSaleReports(saleReports);
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
        return rowsAffected == 1;
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
        return rowsAffected == 1;
    }

}
