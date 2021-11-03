
package restaurante.menu;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import restaurante.utils.Parameters;
import restaurante.utils.TokenUtils;

@Path("/menu")
public class Service {
    @POST
    @Path("/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean insertDish(@PathParam("token")String token, Dish newDish){
        if(TokenUtils.checkJWTandGetUserId(token)){
            Parameters.menu.put(Parameters.id.incrementAndGet(), newDish);
            return true;           
        }
        else return false;
    }
    @GET
    @Path("/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getDishes (@PathParam("token") String token){
        if(TokenUtils.checkJWTandGetUserId(token)){
            return Parameters.menu;
        }
        else return new HashMap();
    }
}