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
import shared.dto.CategoriesDto;
import shared.dto.CategoryDto;

@Path("category")
public class CategoryRESTService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriesDto getAllCategories(){
    	CategoriesDto categories = new CategoriesDto();
		List<CategoryDto> resultDto = new ArrayList<CategoryDto>();
        try {
        	resultDto = GetService.getServices().getCategories();
        	categories.getCategories().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return categories;
    }
    

    
    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCategory(CategoryDto categoryDto) {
        try {
        	GetService.getServices().createCategory(categoryDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return Response.status(201).build();
    	
    }
    
    @PUT//@DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriesDto deleteCategory(@PathParam("id") long id) {
    	CategoriesDto categories = new CategoriesDto();
		List<CategoryDto> resultDto = new ArrayList<CategoryDto>();
        try {
        	GetService.getServices().deleteCategory(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
        	resultDto = GetService.getServices().getCategories();
        	categories.getCategories().addAll(resultDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return categories;
    }
}
