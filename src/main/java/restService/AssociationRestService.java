package restService;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.GetService;
import shared.dto.AssociationDto;
import shared.dto.MemberDto;
import shared.dto.MembersDto;

@Path("association")
public class AssociationRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AssociationDto getAssociation() {
    	AssociationDto resultDto = new AssociationDto();
        try {
        	resultDto = GetService.getServices().getAssociation();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return resultDto;
    }

    @GET
    @Path("authentication/{login}/{password}/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public MembersDto checkIds(@PathParam("login") String login, @PathParam("password") String password,@PathParam("number") int number) {
		MembersDto membersDto = new MembersDto();
		List<MemberDto> resultDto = new ArrayList<MemberDto>();
        try {
        	resultDto = GetService.getServices().checkIdAssociation(login, password, number);
        	membersDto.getMembers().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return membersDto;
    	
    }
    
    @PUT
    @Path("put")
    @Produces(MediaType.APPLICATION_JSON)
    public Response upDateAssociation( AssociationDto associationDto) {    	
        try {
        	AssociationDto result = GetService.getServices().getAssociation();
        	if(associationDto.getName() != null && !associationDto.getName().equals("")) {
        		result.setName(associationDto.getName());
        	}
        	if(associationDto.getAddress() != null && !associationDto.getAddress().equals("")) {
        		result.setAddress(associationDto.getAddress());
        	}
        	if(associationDto.getPostalCode() != null && !associationDto.getPostalCode().equals("")) {
        		result.setPostalCode(associationDto.getPostalCode());
        	}
        	if(associationDto.getTown() != null && !associationDto.getTown().equals("")) {
        		result.setTown(associationDto.getTown());
        	}
        	if(associationDto.getEmail() != null && !associationDto.getEmail().equals("")) {
        		result.setEmail(associationDto.getEmail());
        	}
        	if(associationDto.getCellNumber() != null && !associationDto.getCellNumber().equals("")) {
        		result.setCellNumber(associationDto.getCellNumber());
        	}
        	if(associationDto.getPhoneNumber() != null && !associationDto.getPhoneNumber().equals("")) {
        		result.setPhoneNumber(associationDto.getPhoneNumber());
        	}
        	if(associationDto.getWebsite() != null && !associationDto.getWebsite().equals("")) {
        		result.setWebsite(associationDto.getWebsite());
        	}
        	if(associationDto.getPassword() != null && !associationDto.getPassword().equals("")) {
        		result.setPassword(associationDto.getPassword());
        	}
        	GetService.getServices().updateAssociation(result);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return Response.status(Response.Status.OK).build();
    }
}
