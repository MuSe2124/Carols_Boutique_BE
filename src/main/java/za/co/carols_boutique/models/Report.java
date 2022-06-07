/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.models;

import java.util.List;
import za.co.carols_boutique.ReportBE.ServiceReport.RepService;
import za.co.carols_boutique.ReportBE.ServiceReport.RepServiceImp;

/**
 *
 * @author muaad
 */
public class Report {
    
    private RepService service;

    public Report() {
        service = new RepServiceImp();
    }

    private List<Review>reviews;
    private List<StoreSale>storeSales;
    private List<EmpSale>empSales;
    private List<ProdStore>prodStores;
    private List<StoreSales>storesSales;
    private List<ProductReport>productReport;

    public List<StoreSales> getStoresSales() {
        return storesSales;
    }

    public List<ProductReport> getProductReport() {
        return productReport;
    }

    public void setProductReport(List<ProductReport> productReport) {
        this.productReport = productReport;
    }
    
    

    public void setStoresSales(List<StoreSales> storesSales) {
        this.storesSales = storesSales;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<StoreSale> getStoreSales() {
        return storeSales;
    }

    public void setStoreSales(List<StoreSale> storeSales) {
        this.storeSales = storeSales;
    }

    public List<EmpSale> getEmpSales() {
        return empSales;
    }

    public void setEmpSales(List<EmpSale> empSales) {
        this.empSales = empSales;
    }

    public List<ProdStore> getProdStores() {
        return prodStores;
    }

    public void setProdStores(List<ProdStore> prodStores) {
        this.prodStores = prodStores;
    }
    
    
    

}
