package game.api;

import game.utils.JWTUtils;
import game.utils.Parameters;
import static game.utils.Parameters.generateNumber;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/play")
public class GameServices {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{token}/{number}")
    public String gamerTurn(@PathParam("token") String token, @PathParam("number") int number){
        int players = Parameters.gamers.size();
        int check = Parameters.turn;
        do {
            Parameters.turn=0; 
        }while (check >= players);
        Integer tokenId = JWTUtils.checkJWTandGetUserId(token);
        if(tokenId.equals(Parameters.turn)){
            Gamer newGamer = Parameters.gamers.get(Parameters.turn);
            int hiddenNumber = generateNumber();
            if(number == hiddenNumber){
                newGamer.setScore(newGamer.getScore()+1);
                Parameters.turn++;
                return("Acierto! El jugador: "+newGamer.getNickname()+(" ahora tiene una puntuacion de "+newGamer.getScore()));    
            }
            else{
                Parameters.turn++;
                return("Fallo! El jugador: "+newGamer.getNickname()+(" ahora tiene una puntuacion de "+newGamer.getScore()));
            }
        }
        else{
            Gamer newGamerCheater = Parameters.gamers.get(tokenId);
            newGamerCheater.setScore(newGamerCheater.getScore()-1);
            return("No te cueles! EL jugador: "+newGamerCheater.getNickname()+" ahora tiene un score de: "+newGamerCheater.getScore());
            }
        }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String gamerToPlay(){
        int players = Parameters.gamers.size();
        int check = Parameters.turn;
        if(check > players){
            Parameters.turn=0;
        }
        Gamer newGamer = null;
        for(int i=0; i<=Parameters.gamers.size(); i++){
            newGamer = Parameters.gamers.get(i);
            if(newGamer.getId().equals(Parameters.turn)){
                break;
            }
        }
        return("Le toca al jugador: "+newGamer.getNickname()+", con id: "+newGamer.getId());
    }
    
}
