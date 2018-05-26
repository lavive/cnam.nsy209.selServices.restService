package main;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.remote.ServicesDao;

/**
 * Class to get service from server
 * 
 * @author lavive
 *
 */

public class GetService {
	
	public static ServicesDao getServices() throws NamingException {		

    	InitialContext context =  new InitialContext() ;
	   	ServicesDao services = (ServicesDao)context.lookup("services.remote.ServicesDao") ;
	   	
	   	return services;
	}

}
