
package com.albares.fidelizados.api;

import com.albares.fidelizados.db.Business;
import com.albares.fidelizados.db.User;
import com.albares.fidelizados.utils.Db;
import com.albares.fidelizados.utils.GenericData;
import com.albares.fidelizados.utils.JWTUtils;
import com.albares.fidelizados.utils.Parameters;
import com.albares.fidelizados.utils.Response;
import com.albares.fidelizados.utils.ResponseCodes;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
/*
REQUEST:
    {
	"business":{
		"name":"Pizzeria Manoli",
		"address":"Calle alegría",
		"phone":"12345",
		"vat":"B234324324",
		"ratio_euro_point":2,
	    "login": {
	    	"email":"pizzeria@manoli.com",
	    	"pass":"1234"
	    }
    }

    {
	"user":{
		"name":"juan",
		"birthDate":1642598738000,
		"gender":1,
	    "login": {
	    	"email":"juanito@blablabla.com",
	    	"pass":"1234"
	    }
        }
    }

    RESPONSE:
    {
        "responseCode": 1,
        "genericData": {
            "business": { // "user"
                "name": "Carniceria Pedrito",
                "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhcHAiOjEsImxvZ2luSWQiOjMsImlzcyI6IkZpZGVsaXphZG9zIiwiaWQiOjIsImlhdCI6MTY0MjY3NTU5N30.2hqw7PCs1jIGu3qDQH_L0OqPgIK06lto2bSBQKLOOzg"
            }
        }
    }


}
*/


@Path("/doRegister")
public class doRegister {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response doRegister(GenericData gd) throws SQLException, Exception{
        
        Db myDb = new Db();
        myDb.connect();
        
        if(gd.getUser()!=null){ 
            User user = gd.getUser();
            //Login login = user.getLogin();
            //login.insert_DB(myDb);
            user.getLogin().insert_DB(myDb);
            
            user.insert_DB(myDb);
            user.setToken(JWTUtils.generateToken(user.getId(), user.getLogin().getId(),Parameters.APP_USER));
            User userResponse = new User();
            userResponse.setToken(user.getToken());
            userResponse.setName(user.getName());
            myDb.disconnect();
            
            return (new Response(ResponseCodes.OK, new GenericData(userResponse)));
        }else if (gd.getBusiness()!=null){ 
            Business business = gd.getBusiness();
            //Login login = user.getLogin();
            //login.insert_DB(myDb);
            business.getLogin().insert_DB(myDb);
            
            business.insert_DB(myDb);
            business.setToken(JWTUtils.generateToken(business.getId(), business.getLogin().getId(),Parameters.APP_BUSINESS));
            Business businessResponse = new Business();
            businessResponse.setToken(business.getToken());
            businessResponse.setName(business.getName());
            myDb.disconnect();
            
            return (new Response(ResponseCodes.OK, new GenericData(businessResponse)));
        
        }else{
            throw new Exception();
        }
    }    
    
  
}
