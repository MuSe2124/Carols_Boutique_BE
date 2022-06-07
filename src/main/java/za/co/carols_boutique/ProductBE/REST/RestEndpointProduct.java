/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.ProductBE.REST;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import za.co.carols_boutique.ProductBE.IDAOProduct.DAOProductImp;
import za.co.carols_boutique.ProductBE.ServiceProduct.ProdService;
import za.co.carols_boutique.ProductBE.ServiceProduct.ProdServiceImp;
import za.co.carols_boutique.models.ProdCat;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.Refund;
import za.co.carols_boutique.models.Stock;

/**
 *
 * @author Jomar
 */
@Path("/product")
public class RestEndpointProduct {
    
    private ProdService service = new ProdServiceImp(new DAOProductImp());
    
    @GET
    @Path("/getProduct/productID")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("productID")String productID){
        return Response.status(Response.Status.OK).entity(service.getProduct(productID)).build();
    }
    
    @POST
    @Path("/addProductToInventory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProductToInventory(Stock stock){
        return Response.status(Response.Status.OK).entity(service.addProductToInventory(stock.getStoreID(), stock.getProductID(), stock.getEmployeeID(), stock.getAmount(),stock.getSizeID())).build();
    }
    
    @POST
    @Path("/addNewProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewProduct(ProdCat prodCat){
        return Response.status(Response.Status.OK).entity(service.addNewProduct(prodCat.getProduct(), prodCat.getCatID())).build();
    }
    
    @POST
    @Path("/addProductToInventory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeProductFromInventory(Stock stock){
        return Response.status(Response.Status.OK).entity(service.removeProductFromInventory(stock.getStoreID(), stock.getProductID(), stock.getEmployeeID(), stock.getAmount(), stock.getSizeID())).build();
    }
    
    @POST
    @Path("/deleteProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(ProdCat prodCat){
        return Response.status(Response.Status.OK).entity(service.deleteProduct(prodCat.getProductID(), prodCat.getCatID())).build();
    }
//    
    @POST
    @Path("/refund")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response refund(Refund refund){
        return Response.status(Response.Status.OK).entity(service.refund(refund)).build();
    }
    
}
