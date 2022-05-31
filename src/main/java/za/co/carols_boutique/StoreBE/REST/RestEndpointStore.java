/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.StoreBE.REST;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import za.co.carols_boutique.StoreBE.ServiceStore.StoreService;
import za.co.carols_boutique.StoreBE.ServiceStore.StoreServiceImp;
import za.co.carols_boutique.models.Store;

/**
 *
 * @author Jomar
 */
@Path("/store")
public class RestEndpointStore {
    
    private StoreService service = new StoreServiceImp();
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Store store){
        return Response.status(Response.Status.OK).entity(service.loginStore(store.getId(),store.getPassword())).build();
    }
    
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(Store store){
        return Response.status(Response.Status.OK).entity(service.registerStore(store)).build();
    }
    
    
    
}
