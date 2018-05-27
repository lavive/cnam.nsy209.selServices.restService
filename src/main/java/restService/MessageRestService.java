package restService;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.GetService;
import shared.dto.MessageDto;
import shared.dto.MessagesDto;

/**
 * Class to provide REST services concerning message
 * 
 * @author lavive
 *
 */

@Path("message")
public class MessageRestService {

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(MessageDto message) {
        try {
        	GetService.getServices().createMessage(message);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(201).build();
    	
    }
    
    @GET
	@Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public MessagesDto getMessages() {
    	MessagesDto messagesDto = new MessagesDto();
		List<MessageDto> resultDto = new ArrayList<MessageDto>();
        try {
        	resultDto = GetService.getServices().getMessages();
        	messagesDto.setMessages(resultDto);
        	System.out.println("messages: "+messagesDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return messagesDto;
    }
    
    @PUT//@DELETE
	@Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessagesDto deleteMessage(@PathParam("id") long id) {
        try {
        	GetService.getServices().deleteMessage(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	MessagesDto messagesDto = new MessagesDto();
		List<MessageDto> resultDto = new ArrayList<MessageDto>();
        try {
        	resultDto = GetService.getServices().getMessages();
        	messagesDto.getMessages().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return messagesDto;
    	
    }

}
