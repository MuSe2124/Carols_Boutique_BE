/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.ProductBE.REST;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import za.co.carols_boutique.ProductBE.ServiceProduct.ProdService;
import za.co.carols_boutique.ProductBE.ServiceProduct.ProdServiceImp;
import za.co.carols_boutique.models.Product;

/**
 *
 * @author Jomar
 */
@Path("product")
public class RestEndpointProduct {
    
    private ProdService service = new ProdServiceImp();
    
    @GET
    @Path("/getProduct/productID")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("productID")String productID){
        return Response.status(Response.Status.OK).entity(service.getProduct(productID)).build();
    }
    
    @POST
    @Path("/addProductToInventory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProductToInventory(String storeID, String productID, String employeeID, Integer amount){
        return Response.status(Response.Status.OK).entity(service.addProductToInventory(storeID, productID, employeeID, amount)).build();
    }
    
    @POST
    @Path("/addNewProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewProduct(Product product){
        return Response.status(Response.Status.OK).entity(service.addNewProduct(product)).build();
    }
    
    
    
}
