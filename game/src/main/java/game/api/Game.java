
package game.api;

import game.utils.JWTUtils;
import game.utils.Parameters;
import static game.utils.Parameters.assignedId;
import static game.utils.Parameters.visibleGamers;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;


@Path("/gamer")
public class Game {
    

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createGamer(Gamer newGamer){
        newGamer.setAssignedToken(JWTUtils.generateToken(Parameters.assignedId));
        newGamer.setId(assignedId);
        Parameters.assignedId++;
        newGamer.setScore(0);
        Parameters.gamers.add(newGamer);
        return newGamer.getAssignedToken();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map showGamers (){
        for(int i=0; i<Parameters.gamers.size(); i++){
            visibleGamers.put(Parameters.gamers.get(i).getNickname(), Parameters.gamers.get(i).getScore());
        }
        return visibleGamers;
    }
    
    
}
