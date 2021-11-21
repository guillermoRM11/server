
package ahorcado.api;

import ahorcado.utiils.Parameters;
import ahorcado.utiils.TokenUtils;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.lang.reflect.Array;
import java.util.Objects;


@Path("/play")

public class Game {
    
    @POST
    @Path("/{token}/{word}")
    @Produces(MediaType.TEXT_PLAIN)
    public String[] tryToSolve(@PathParam("token") String token, @PathParam("word") String word){
        do {
            Parameters.turn=1; 
        }while (Parameters.turn>Parameters.players.size());
        Integer checkFullWord = 1;
        Integer score = Parameters.players.get(TokenUtils.checkJWTandGetUserId(token)).getScore();
        if(Objects.equals(Parameters.turn, TokenUtils.checkJWTandGetUserId(token))){
            Integer cnt=0;          
            if(word.length()==1){
                for(int i =0; i<=Parameters.myWord.length; i++){
                    if(word.equals(Parameters.myWord[i])){
                        Parameters.myHiddenWord[i] = Parameters.myWord[i];
                        cnt++;
                    }
                }
            Parameters.turn++;
            Parameters.players.get(TokenUtils.checkJWTandGetUserId(token)).setScore(score+cnt*20);
            return(Parameters.myHiddenWord);
            }
            else {
                for(int j=0; j<=Parameters.myWord.length-1;j++){
                    String wordToCheck = (""+word.charAt(j)+"");
                    if(!wordToCheck.equals(Parameters.myWord[j])){
                        checkFullWord =0;
                        break;
                    }  
                }
                if(checkFullWord == 0){
                    Parameters.players.get(TokenUtils.checkJWTandGetUserId(token)).setScore(score-50);
                    Parameters.turn++;
                    return(Parameters.myHiddenWord);
                }
                else{
                    Parameters.players.get(TokenUtils.checkJWTandGetUserId(token)).setScore(score+100);
                    Parameters.turn++;
                    return(Parameters.myWord);
                }
            }    
        }
        Parameters.players.get(TokenUtils.checkJWTandGetUserId(token)).setScore(score-100);
        String cheater[]={"No te cueles"};
        return(cheater);
    }    
  
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String playerTurn(){
        do {
            Parameters.turn=1; 
        }while (Parameters.turn>Parameters.players.size());
        return("Le toca al jugador: "+Parameters.players.get(Parameters.turn).getNick()+", que corresponde al turno: "+Parameters.turn);
    }
}
    
