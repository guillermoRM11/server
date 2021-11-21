
package ahorcado.api;

import ahorcado.utiils.Parameters;
import ahorcado.utiils.TokenUtils;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;

public class User {
    @Path("/user")
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addUSer(Player newPlayer){
        Parameters.players.put(Parameters.assignedId.incrementAndGet(), newPlayer);
        Parameters.players.get(Parameters.assignedId.get()).setScore(100);
        return TokenUtils.generateToken(Parameters.assignedId.get());
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map getUsers (){
        return Parameters.players;
    }
    
}
