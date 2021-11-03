
package examen_renfe;

import static examen_renfe.Parametros.horarios;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/admin")
public class TrainServices {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createTrain(Train newTrain){
        Parametros.horarios.put(Parametros.id.incrementAndGet(),newTrain);
        return TokenUtils.generateToken(Parametros.id.get()); 
    }   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{token}")
    public Train getTrain(@PathParam("token") String token){ 
        return horarios.get(TokenUtils.checkJWTandGetUserId(token));
    } 
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    @Path("/{token}/{newOrigen}/{newDestino}/{newPromotion}/{newHora}/{newPrecio}")
    public Boolean editTrain(@PathParam("token") String token, @PathParam("newOrigen") String newOrigen, @PathParam("newDestino") String newDestino, @PathParam("newPromotion") String newPromotion, @PathParam("newHora") String newHora, @PathParam("newPrecio") String newPrecio){     
        Train trainToEdit = horarios.get(TokenUtils.checkJWTandGetUserId(token));
        if(trainToEdit == null){
            return false;            
        }else{
            trainToEdit.setOrigen(newOrigen);
            trainToEdit.setDestino(newDestino);
            trainToEdit.setPromotion(newPromotion);
            trainToEdit.setHora(newHora);
            trainToEdit.setPrecio(newPrecio);
            
            return true;
        }        
    }   
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{token}")
    public Boolean deleteTrain(@PathParam("token") String token){
        if(horarios.remove(TokenUtils.checkJWTandGetUserId(token))!=null){
            return true;
        }else{
            return false;
        }
    }
}