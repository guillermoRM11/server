
package marsattack.api;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import marsattack.db.Score;
import marsattack.utils.Db;
import marsattack.utils.Response;
import marsattack.utils.ResponseCodes;

public class getScores {
    
    @Path("") //Hay que especificar que se quiere una ruta aunque no se ponga nada
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getScores() throws Exception{  
        try{
            Db myDb = new Db();
            
            myDb.connect();           
            List<Score> scoresResponse = Score.selectScores_DB(myDb);
            myDb.disconnect();
            
            Response r = new Response();
            r.setScore(scoresResponse);
            r.setResponseCode(ResponseCodes.OK);
            return r;
        }catch(SQLException e){
            Response r = new Response();
            r.setResponseCode(ResponseCodes.ERROR);
            return r;
        }
        
    }    
}
