package restService;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.GetService;
import shared.dto.SuppliesDemandsDto;
import shared.dto.SupplyDemandDto;

/**
 * Class to provide REST services concerning supply and demand
 * 
 * @author lavive
 *
 */

@Path("/supplyDemand")
public class SupplyDemandRESTService {

    @GET
	@Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public SuppliesDemandsDto getAllSuppliesDemands(){
    	SuppliesDemandsDto suppliesDemandsDto = new SuppliesDemandsDto();
		List<SupplyDemandDto> resultDto = new ArrayList<SupplyDemandDto>();
        try {
        	resultDto = GetService.getServices().getAllSupplyDemand();
        	suppliesDemandsDto.getSuppliesDemands().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return suppliesDemandsDto;
    }
    
    @PUT
	@Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSupplyDemand(SupplyDemandDto supplyDemandDto) {
        try {
        	GetService.getServices().updateSupplyDemand(supplyDemandDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(Response.Status.OK).build();
    }
    
    @POST
	@Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSupplyDemand(SupplyDemandDto supplyDemandDto) {
        try {
        	GetService.getServices().createSupplyDemand(supplyDemandDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(201).build();
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response deleteSupplyDemand(@PathParam("id") long id) {
        try {
        	GetService.getServices().deleteSupplyDemand(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(Response.Status.OK).build();
    }
    

    @GET
    @Path("/get/type/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public SuppliesDemandsDto getSuppliesDemands(@PathParam("type") String type) {
    	SuppliesDemandsDto suppliesDemandsDto = new SuppliesDemandsDto();
		List<SupplyDemandDto> resultDto = new ArrayList<SupplyDemandDto>();
        try {
        	resultDto = GetService.getServices().getSuppliesDemands(type);
        	suppliesDemandsDto.getSuppliesDemands().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return suppliesDemandsDto;
    	
    }
    
    @PUT
    @Path("/delete/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SuppliesDemandsDto deleteGetSupplyDemand(@PathParam("id") long id) {
        try {
        	GetService.getServices().deleteSupplyDemand(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	SuppliesDemandsDto suppliesDemandsDto = new SuppliesDemandsDto();
		List<SupplyDemandDto> resultDto = new ArrayList<SupplyDemandDto>();
        try {
        	resultDto = GetService.getServices().getAllSupplyDemand();
        	suppliesDemandsDto.getSuppliesDemands().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return suppliesDemandsDto;
    	
    }
    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SupplyDemandDto getSupplyDemand(@PathParam("id") long id) {
    	SupplyDemandDto resultDto = new SupplyDemandDto();
        try {
        	resultDto = GetService.getServices().getSupplyDemand(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return resultDto;
    	
    }
}
