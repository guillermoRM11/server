
package com.albares.fidelizados.api;

import com.albares.fidelizados.db.Business;
import com.albares.fidelizados.db.Login;
import com.albares.fidelizados.db.User;
import com.albares.fidelizados.utils.Db;
import com.albares.fidelizados.utils.GenericData;
import com.albares.fidelizados.utils.JWTUtils;
import com.albares.fidelizados.utils.Response;
import com.albares.fidelizados.utils.ResponseCodes;
import com.albares.fidelizados.utils.Parameters;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
/*
REQUEST:
{
    "login":{
        "email":"aasdasddsa",
        "pass":"2123132"
    },
    "user":{} //"business":{}
}
RESPONSE:
{
    "responseCode":-1 //Mal la pass
                    0 //No existe login con ese email
                    1 //Existe email y coincide la pass
}

*/
@Path("/doLogin")
public class doLogin {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response doLogin(GenericData gd) throws SQLException, Exception{
        
        Db myDb = new Db();
        myDb.connect();
        Login login = gd.getLogin();
        String pass = login.getPass();
        
        if(gd.getUser()!=null){ // Se está haciendo login en la app user
            User user = gd.getUser();
            user.setLogin(login);
            if(login.checkEmailAndGetIdPass(myDb)){
                if(login.checkPass(pass)){
                    user.getIdAndNamebyLogin(myDb);
                    user.setLogin(null);
                    user.setToken(JWTUtils.generateToken(user.getId(), login.getId(),Parameters.APP_USER));
                    myDb.disconnect();
                    return new Response(ResponseCodes.OK, new GenericData(user));
                }else{
                    myDb.disconnect();
                    return new Response(ResponseCodes.ERROR); 
                }
            }else{
                myDb.disconnect();
                return new Response(ResponseCodes.NO_USER); 
            }
        }else if (gd.getBusiness()!=null){ // Se está haciendo login en la app business
            Business business = gd.getBusiness();
            business.setLogin(login);
            if(login.checkEmailAndGetIdPass(myDb)){
                if(login.checkPass(pass)){
                    business.getIdAndNamebyLogin(myDb);
                    business.setLogin(null);
                    business.setToken(JWTUtils.generateToken(business.getId(), login.getId(),Parameters.APP_BUSINESS));
                    myDb.disconnect();
                    return new Response(ResponseCodes.OK, new GenericData(business));
                }else{
                    myDb.disconnect();
                    return new Response(ResponseCodes.ERROR); 
                }
            }else{
                myDb.disconnect();
                return new Response(ResponseCodes.NO_USER); 
            }
        
        }else{
            throw new Exception();
        }
    }    
    
  
}
