package restService;

import java.math.BigDecimal;
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
import shared.dto.MemberDto;
import shared.dto.MembersDto;
import shared.dto.NotificationDto;
import shared.dto.NotificationsDto;
import shared.dto.TransactionsDto;
import shared.dto.WealthSheetDto;

@Path("/member")
public class MemberRESTService {
	
	@GET
	@Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public MembersDto getAllMembers() {
		MembersDto membersDto = new MembersDto();
		List<MemberDto> resultDto = new ArrayList<MemberDto>();
        try {
        	resultDto = GetService.getServices().getAllMembers();
        	membersDto.getMembers().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return membersDto;
    }
	
	@GET
	@Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest() {
		
        
        return "test";
    }
	
	@GET
	@Path("get/{mobileId}/{cellNumber}")
	public Long getMyId(@PathParam("mobileId") String mobileId,@PathParam("cellNumber")String cellNumber) {
		Long result = 0l;
        try {
        	result = GetService.getServices().getId(mobileId,cellNumber);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return result;		
	}
	
	@GET
	@Path("get/{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    public RestListString checkUpdates(@PathParam("id") long id){
		RestListString result = new RestListString();
		List<String> resultString = new ArrayList<String>();
        try {
        	resultString = GetService.getServices().checkForUpdate(id);
        	for(String string:resultString) {
        		result.getListString().add(string);
        	}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return result;
	}
	
	@GET
	@Path("get/{id}/member")
    @Produces(MediaType.APPLICATION_JSON)
    public MemberDto getProfile(@PathParam("id") long id) {

		MemberDto resultDto = new MemberDto();
        try {
        	resultDto = GetService.getServices().getMember(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return resultDto;	
	}
	
	@GET
    @Path("get/{id}/wealthSheet")
    @Produces(MediaType.APPLICATION_JSON)
    public WealthSheetDto getWealthSheet(@PathParam("id") long id) {
		WealthSheetDto resultDto = new WealthSheetDto();
        try {
        	resultDto = GetService.getServices().getWealthSheet(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return resultDto;		
    }
	
	@GET
    @Path("get/{id}/transaction")
    @Produces(MediaType.APPLICATION_JSON)
    public TransactionsDto getTransactions(@PathParam("id") long id) {
		TransactionsDto resultDto = new TransactionsDto();
        try {
        	resultDto.setTransactions(GetService.getServices().getWealthSheet(id).getTransactions());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return resultDto;		
    }
	
	@GET
    @Path("get/{id}/notification")
    @Produces(MediaType.APPLICATION_JSON)
    public NotificationsDto getNotifications(@PathParam("id") long id) {
		NotificationsDto notificationDto = new NotificationsDto();
		List<NotificationDto> resultDto = new ArrayList<NotificationDto>();
        try {
        	List<Long> ids = GetService.getServices().getMember(id).getNotificationIds();
        	long[] idsArray = new long[ids.size()];
        	for(int i = 0; i< ids.size();i++) {
        		idsArray[i] = ids.get(i);
        	}
        	resultDto = GetService.getServices().getNotifications(idsArray);
        	notificationDto.getNotifications().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return notificationDto;	
    }
	
	@PUT
	@Path("/put")
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateProfile(MembersDto membersDto) {
        try {
        	for(MemberDto memberDto:membersDto.getMembers()) {
        		GetService.getServices().updateMember(memberDto);
        	}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(Response.Status.OK).build();
	}
	
	@PUT
	@Path("/put/{id}/dateLastUpdate")
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateLastDateUpdate(@PathParam("id") long id) {
        try {
        	GetService.getServices().updateDateLastUpdate(id);
        		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(Response.Status.OK).build();
	}
    
    @PUT//@DELETE
    @Path("/delete/{id}/notification")
    public Response deleteNotificationFromMember(@PathParam("id") long id,NotificationsDto notificationsDto) {
        try {
        	GetService.getServices().deleteNotificationsFromMember(id, notificationsDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(Response.Status.OK).build();
    }


    @GET
    @Path("/get/last/{number}")
	@Produces(MediaType.APPLICATION_JSON)
    public MembersDto getLastMembers(@PathParam("number") int number) {
		MembersDto membersDto = new MembersDto();
		List<MemberDto> resultDto = new ArrayList<MemberDto>();
        try {
        	resultDto = GetService.getServices().getListLastMember(number);
        	membersDto.getMembers().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return membersDto;
    	
    }
    
    @POST
    @Path("/get/attributes")
	@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public MembersDto getMembers(MemberDto attributes) {
    	System.out.println(attributes+":"+attributes.getAddress());
		MembersDto membersDto = new MembersDto();
		List<MemberDto> resultDto = new ArrayList<MemberDto>();
        try {
        	resultDto = GetService.getServices().getMembers(attributes);
        	membersDto.getMembers().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	System.out.println("members: "+membersDto);
        return membersDto;
    	
    }
    
    @DELETE
    @Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public MembersDto  deleteMember(@PathParam("id") long id) {
        try {
        	GetService.getServices().deleteMember(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MembersDto membersDto = new MembersDto();
		List<MemberDto> resultDto = new ArrayList<MemberDto>();
        try {
        	resultDto = GetService.getServices().getAllMembers();
        	membersDto.getMembers().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return membersDto;
    	
    }
    
	//public List<MemberDto> delete(MemberDto member, MemberDto attributes) throws DoNotExistException;
	//public List<MemberDto> deleteLastMember(MemberDto member,int numberToDisplay) throws DoNotExistException;
    
    @POST
    @Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
    public Response create(MemberDto member) {
    	BigDecimal initialAccount = new BigDecimal(member.getWealthSheet().getInitialAccount());
        try {
	        GetService.getServices().createMember(member,initialAccount);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(201).build();
    	
    }
    
    @PUT
    @Path("/put/member")
	@Produces(MediaType.APPLICATION_JSON)
    public MemberDto update(MemberDto member) {
        try {
        	GetService.getServices().updateMember(member);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MemberDto resultDto = new MemberDto();
        try {
        	resultDto = GetService.getServices().getMember(member.getId());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return resultDto;	
    	
    }

    @GET
    @Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public MemberDto getMember(@PathParam("id") long id) {

		MemberDto resultDto = new MemberDto();
        try {
        	resultDto = GetService.getServices().getMember(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return resultDto;	
    }

}
