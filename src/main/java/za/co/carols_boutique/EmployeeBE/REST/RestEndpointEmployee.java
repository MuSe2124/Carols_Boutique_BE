/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.EmployeeBE.REST;

import java.io.FileNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import za.co.carols_boutique.EmployeeBE.ServiceEmployee.EmpService;
import za.co.carols_boutique.EmployeeBE.ServiceEmployee.EmpServiceImp;
import za.co.carols_boutique.Utilities.Email;
import za.co.carols_boutique.models.Employee;
import za.co.carols_boutique.properties.CarolsProperties;
import za.co.carols_boutique.yaml.CarolsYAML;


/**
 *
 * @author Jomar
 */
@Path("/employee")
public class RestEndpointEmployee {
    
    private EmpService service = new EmpServiceImp();
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee employee){
        return Response.status(Response.Status.OK).entity(service.login(employee.getId(),employee.getPassword(),employee.getStoreID())).build();
    }
    
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(Employee employee){
        return Response.status(Response.Status.OK).entity(service.register(employee)).build();
    }
    
    @POST
    @Path("/promoteToManager")
    @Produces(MediaType.APPLICATION_JSON)
    public Response promoteToManager(String employeeID){
        return Response.status(Response.Status.OK).entity(service.promoteToManager(employeeID)).build();
    }
    
    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Employee employee){
        return Response.status(Response.Status.OK).entity(service.updateEmployee(employee)).build();
    }
    
    @POST
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(String employeeID){
        return Response.status(Response.Status.OK).entity(service.deleteEmployee(employeeID)).build();
    }
    
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "I'm here";
    }
}
