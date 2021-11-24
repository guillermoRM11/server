
package restaurant.api;

import restaurant.db.Dish;
import restaurant.utils.Db;
import restaurant.utils.Response;
import restaurant.utils.ResponseCodes;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/admin/addDish")
public class addDish {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer addDishes(Dish dish){  
        try{
            Db myDb = new Db();
            
            myDb.connect();
            dish.insertDishes_DB(myDb);
            myDb.disconnect();
            
            Response r = new Response();
            r.setResponseCode(ResponseCodes.OK);
            return r.getResponseCode();   
        }catch(Exception e){
            Response r = new Response();
            r.setResponseCode(ResponseCodes.ERROR);
            return r.getResponseCode();   
        }
    }    
}

