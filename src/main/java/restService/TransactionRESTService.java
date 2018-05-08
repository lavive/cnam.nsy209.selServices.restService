package restService;

import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.GetService;
import shared.dto.TransactionDto;

@Path("/transaction")
public class TransactionRESTService {

	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTransaction(TransactionDto transactionDto) {	
		
        try {
        	GetService.getServices().addTransaction(transactionDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(201).build();
	}
    
	@POST
	@Path("/post/get")
    @Produces(MediaType.APPLICATION_JSON)
	public TransactionDto buildTransaction(TransactionDto transactionDto) {
		TransactionDto result = null;
        try {
        	result = GetService.getServices().buildTransaction(transactionDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return result;
	}
}
