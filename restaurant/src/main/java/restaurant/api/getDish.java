
package restaurant.api;

import restaurant.db.Dish;
import restaurant.utils.Db;
import restaurant.utils.JWTUtils;
import restaurant.utils.Response;
import restaurant.utils.ResponseCodes;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;

public class getDish {
    
    @POST
    @Path("/{QR}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDishes(@PathParam("QR") Integer QR){  
        try{
            Db myDb = new Db();
            Dish newDish = new Dish();
            newDish.setType(QR);
            myDb.connect();
            
            newDish.selectDishes_DB(myDb);
            myDb.disconnect();
            
            Dish userResponse = new Dish(); 
            userResponse.setName(newDish.getName());
            userResponse.setPrice(newDish.getPrice());
            Response r = new Response();
            r.setDish(userResponse);
            r.setResponseCode(ResponseCodes.OK);
            return r;
        }catch(SQLException e){
            Response r = new Response();
            r.setResponseCode(ResponseCodes.ERROR);
            return r;
        }
        
    }    
}

